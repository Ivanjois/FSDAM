import java.sql.Connection
import java.sql.SQLException

/**
 * DAO encargado de gestionar la tabla 'jugadores'.
 */
object JugadorDAO {

    /**
     * Inserta un nuevo jugador en la base de datos.
     */
    fun insertarJugador(jugador: Jugador): Boolean {
        val sql = "INSERT INTO jugadores(nombre, email) VALUES (?, ?)"
        return try {
            ConexionBD.getConnection()?.use { conn ->
                conn.prepareStatement(sql).use { stmt ->
                    stmt.setString(1, jugador.nombre)
                    stmt.setString(2, jugador.email)
                    if (stmt.executeUpdate() > 0) {
                        println("Jugador '${jugador.nombre}' creado con éxito.")
                        true
                    } else {
                        false
                    }
                }
            } ?: false
        } catch (e: SQLException) {
            println("Error al insertar el jugador (verifica que el email no esté duplicado): ${e.message}")
            false
        }
    }

    /**
     * Elimina un jugador por ID respetando la integridad referencial mediante una transacción:
     * borra primero los videojuegos asociados a sus listas, después sus listas y por último el jugador.
     */
    fun eliminarJugador(id: Int): Boolean {
        var conn: Connection? = null
        return try {
            conn = ConexionBD.getConnection() ?: return false
            conn.autoCommit = false

            // 1. Eliminar las relaciones de las listas que pertenecen al jugador
            val sqlRelaciones = """
                DELETE FROM listas_videojuegos
                WHERE id_lista IN (SELECT id_lista FROM listas WHERE id_jugador = ?)
            """.trimIndent()
            conn.prepareStatement(sqlRelaciones).use { stmt ->
                stmt.setInt(1, id)
                stmt.executeUpdate()
            }

            // 2. Eliminar las listas asociadas al jugador
            conn.prepareStatement("DELETE FROM listas WHERE id_jugador = ?").use { stmt ->
                stmt.setInt(1, id)
                stmt.executeUpdate()
            }

            // 3. Eliminar al propio jugador
            val filasJugador = conn.prepareStatement("DELETE FROM jugadores WHERE id = ?").use { stmt ->
                stmt.setInt(1, id)
                stmt.executeUpdate()
            }

            if (filasJugador > 0) {
                conn.commit()
                println("Jugador con ID $id y sus listas asociadas eliminados correctamente.")
                true
            } else {
                conn.rollback()
                println("No se encontró ningún jugador con ID $id para eliminar.")
                false
            }
        } catch (e: SQLException) {
            println("Error al eliminar el jugador con ID $id. Se revierten los cambios: ${e.message}")
            try {
                conn?.rollback()
            } catch (_: SQLException) {
            }
            false
        } finally {
            try {
                conn?.autoCommit = true
                conn?.close()
            } catch (_: SQLException) {
            }
        }
    }

    /**
     * Comprueba si existe un jugador con el ID indicado.
     */
    fun existeJugador(id: Int): Boolean {
        val sql = "SELECT 1 FROM jugadores WHERE id = ?"
        return try {
            ConexionBD.getConnection()?.use { conn ->
                conn.prepareStatement(sql).use { stmt ->
                    stmt.setInt(1, id)
                    stmt.executeQuery().use { rs -> rs.next() }
                }
            } ?: false
        } catch (e: SQLException) {
            println("Error al comprobar la existencia del jugador $id: ${e.message}")
            false
        }
    }

    /**
     * Lista todos los jugadores registrados ordenados por ID.
     */
    fun listarJugadores(): List<Jugador> {
        val lista = mutableListOf<Jugador>()
        val sql = "SELECT id, nombre, email FROM jugadores ORDER BY id"
        try {
            ConexionBD.getConnection()?.use { conn ->
                conn.prepareStatement(sql).use { stmt ->
                    stmt.executeQuery().use { rs ->
                        while (rs.next()) {
                            lista.add(
                                Jugador(
                                    id = rs.getInt("id"),
                                    nombre = rs.getString("nombre"),
                                    email = rs.getString("email")
                                )
                            )
                        }
                    }
                }
            }
        } catch (e: SQLException) {
            println("Error al listar jugadores: ${e.message}")
        }
        return lista
    }
}

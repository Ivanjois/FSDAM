import java.sql.Connection
import java.sql.SQLException

/**
 * DAO encargado de gestionar la tabla 'listas'.
 */
object ListaDAO {

    /**
     * Inserta una nueva lista asociada a un jugador.
     * Comprueba previamente que el jugador exista; si no existe, no crea la lista.
     */
    fun insertarLista(lista: Lista): Boolean {
        if (!JugadorDAO.existeJugador(lista.idJugador)) {
            println("Error: No existe ningún jugador con ID ${lista.idJugador}. No se creará la lista.")
            return false
        }
        val sql = "INSERT INTO listas(nombre, id_jugador) VALUES (?, ?)"
        return try {
            ConexionBD.getConnection()?.use { conn ->
                conn.prepareStatement(sql).use { stmt ->
                    stmt.setString(1, lista.nombre)
                    stmt.setInt(2, lista.idJugador)
                    if (stmt.executeUpdate() > 0) {
                        println("Lista '${lista.nombre}' creada con éxito para el jugador con ID ${lista.idJugador}.")
                        true
                    } else {
                        false
                    }
                }
            } ?: false
        } catch (e: SQLException) {
            println("Error al insertar la lista: ${e.message}")
            false
        }
    }

    /**
     * Elimina una lista por su ID junto con sus asociaciones en 'listas_videojuegos'.
     */
    fun eliminarLista(idLista: Int): Boolean {
        var conn: Connection? = null
        return try {
            conn = ConexionBD.getConnection() ?: return false
            conn.autoCommit = false

            conn.prepareStatement("DELETE FROM listas_videojuegos WHERE id_lista = ?").use { stmt ->
                stmt.setInt(1, idLista)
                stmt.executeUpdate()
            }

            val filas = conn.prepareStatement("DELETE FROM listas WHERE id_lista = ?").use { stmt ->
                stmt.setInt(1, idLista)
                stmt.executeUpdate()
            }

            if (filas > 0) {
                conn.commit()
                println("Lista con ID $idLista eliminada correctamente.")
                true
            } else {
                conn.rollback()
                println("No se encontró ninguna lista con ID $idLista para eliminar.")
                false
            }
        } catch (e: SQLException) {
            println("Error al eliminar la lista con ID $idLista. Se revierten los cambios: ${e.message}")
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
     * Comprueba si existe una lista con el ID indicado.
     */
    fun existeLista(idLista: Int): Boolean {
        val sql = "SELECT 1 FROM listas WHERE id_lista = ?"
        return try {
            ConexionBD.getConnection()?.use { conn ->
                conn.prepareStatement(sql).use { stmt ->
                    stmt.setInt(1, idLista)
                    stmt.executeQuery().use { rs -> rs.next() }
                }
            } ?: false
        } catch (e: SQLException) {
            println("Error al comprobar la existencia de la lista $idLista: ${e.message}")
            false
        }
    }

    /**
     * Devuelve todas las listas ordenadas por su ID.
     */
    fun listarListas(): List<Lista> {
        val listas = mutableListOf<Lista>()
        val sql = "SELECT id_lista, nombre, id_jugador FROM listas ORDER BY id_lista"
        try {
            ConexionBD.getConnection()?.use { conn ->
                conn.prepareStatement(sql).use { stmt ->
                    stmt.executeQuery().use { rs ->
                        while (rs.next()) {
                            listas.add(
                                Lista(
                                    idLista = rs.getInt("id_lista"),
                                    nombre = rs.getString("nombre"),
                                    idJugador = rs.getInt("id_jugador")
                                )
                            )
                        }
                    }
                }
            }
        } catch (e: SQLException) {
            println("Error al listar las listas: ${e.message}")
        }
        return listas
    }
}

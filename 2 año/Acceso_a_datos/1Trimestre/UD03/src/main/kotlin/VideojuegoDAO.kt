import java.sql.ResultSet
import java.sql.SQLException

/**
 * DAO encargado de las operaciones CRUD sobre la tabla 'videojuegos'.
 */
object VideojuegoDAO {

    /**
     * Convierte la fila actual de un ResultSet en un objeto Videojuego.
     */
    internal fun mapearVideojuego(rs: ResultSet): Videojuego {
        return Videojuego(
            id = rs.getInt("id"),
            titulo = rs.getString("titulo"),
            genero = rs.getString("genero"),
            anio = rs.getInt("anio"),
            nota = rs.getDouble("nota")
        )
    }

    /**
     * Devuelve la lista completa de videojuegos ordenados por su ID.
     */
    fun listarVideojuegos(): List<Videojuego> {
        val lista = mutableListOf<Videojuego>()
        val sql = "SELECT id, titulo, genero, anio, nota FROM videojuegos ORDER BY id"
        try {
            ConexionBD.getConnection()?.use { conn ->
                conn.prepareStatement(sql).use { stmt ->
                    stmt.executeQuery().use { rs ->
                        while (rs.next()) {
                            lista.add(mapearVideojuego(rs))
                        }
                    }
                }
            }
        } catch (e: SQLException) {
            println("Error al listar videojuegos: ${e.message}")
        }
        return lista
    }

    /**
     * Busca un videojuego concreto por su ID. Devuelve null si no existe.
     */
    fun consultarPorId(id: Int): Videojuego? {
        var videojuego: Videojuego? = null
        val sql = "SELECT id, titulo, genero, anio, nota FROM videojuegos WHERE id = ?"
        try {
            ConexionBD.getConnection()?.use { conn ->
                conn.prepareStatement(sql).use { stmt ->
                    stmt.setInt(1, id)
                    stmt.executeQuery().use { rs ->
                        if (rs.next()) {
                            videojuego = mapearVideojuego(rs)
                        }
                    }
                }
            }
        } catch (e: SQLException) {
            println("Error al consultar el videojuego con ID $id: ${e.message}")
        }
        return videojuego
    }

    /**
     * Inserta un nuevo videojuego en la base de datos.
     */
    fun insertarVideojuego(videojuego: Videojuego): Boolean {
        val sql = "INSERT INTO videojuegos(titulo, genero, anio, nota) VALUES (?, ?, ?, ?)"
        return try {
            ConexionBD.getConnection()?.use { conn ->
                conn.prepareStatement(sql).use { stmt ->
                    stmt.setString(1, videojuego.titulo)
                    stmt.setString(2, videojuego.genero)
                    stmt.setInt(3, videojuego.anio)
                    stmt.setDouble(4, videojuego.nota)
                    if (stmt.executeUpdate() > 0) {
                        println("${videojuego.titulo} insertado con éxito.")
                        true
                    } else {
                        false
                    }
                }
            } ?: false
        } catch (e: SQLException) {
            println("Error al insertar el videojuego: ${e.message}")
            false
        }
    }

    /**
     * Actualiza los datos de un videojuego existente identificado por su ID.
     */
    fun actualizarVideojuego(videojuego: Videojuego): Boolean {
        if (videojuego.id == null) {
            println("Error: No se puede actualizar un videojuego sin ID.")
            return false
        }
        val sql = "UPDATE videojuegos SET titulo = ?, genero = ?, anio = ?, nota = ? WHERE id = ?"
        return try {
            ConexionBD.getConnection()?.use { conn ->
                conn.prepareStatement(sql).use { stmt ->
                    stmt.setString(1, videojuego.titulo)
                    stmt.setString(2, videojuego.genero)
                    stmt.setInt(3, videojuego.anio)
                    stmt.setDouble(4, videojuego.nota)
                    stmt.setInt(5, videojuego.id)
                    if (stmt.executeUpdate() > 0) {
                        println("Videojuego con ID ${videojuego.id} actualizado.")
                        true
                    } else {
                        println("No se encontró ningún videojuego con ID ${videojuego.id} para actualizar.")
                        false
                    }
                }
            } ?: false
        } catch (e: SQLException) {
            println("Error al actualizar el videojuego con ID ${videojuego.id}: ${e.message}")
            false
        }
    }

    /**
     * Elimina un videojuego por su ID.
     */
    fun eliminarVideojuego(id: Int): Boolean {
        val sql = "DELETE FROM videojuegos WHERE id = ?"
        return try {
            ConexionBD.getConnection()?.use { conn ->
                conn.prepareStatement(sql).use { stmt ->
                    stmt.setInt(1, id)
                    if (stmt.executeUpdate() > 0) {
                        println("Videojuego con ID $id eliminado.")
                        true
                    } else {
                        println("No se encontró ningún videojuego con ID $id para eliminar.")
                        false
                    }
                }
            } ?: false
        } catch (e: SQLException) {
            println("Error al eliminar el videojuego con ID $id: ${e.message}")
            false
        }
    }
}

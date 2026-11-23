import java.sql.Connection
import java.sql.SQLException

/**
 * DAO encargado de gestionar la tabla intermedia 'listas_videojuegos' mediante transacciones.
 */
object ListaVideojuegoDAO {

    /**
     * Añade un videojuego a una lista dentro de una única transacción ACID:
     * 1. Comprueba mediante SELECT que el videojuego y la lista existan.
     * 2. Inserta la relación en 'listas_videojuegos'.
     * Si cualquiera de los pasos falla, ejecuta rollback y no modifica ningún dato.
     */
    fun anyadirALista(idLista: Int, idVideojuego: Int, fecha: String): Boolean {
        var conn: Connection? = null
        return try {
            conn = ConexionBD.getConnection() ?: return false
            conn.autoCommit = false // Iniciar transacción manual

            // Paso 1: Comprobar que el videojuego existe
            conn.prepareStatement("SELECT id FROM videojuegos WHERE id = ?").use { stmt ->
                stmt.setInt(1, idVideojuego)
                stmt.executeQuery().use { rs ->
                    if (!rs.next()) {
                        throw SQLException("No existe ningún videojuego con ID $idVideojuego.")
                    }
                }
            }

            // Paso 2: Comprobar que la lista existe
            conn.prepareStatement("SELECT id_lista FROM listas WHERE id_lista = ?").use { stmt ->
                stmt.setInt(1, idLista)
                stmt.executeQuery().use { rs ->
                    if (!rs.next()) {
                        throw SQLException("No existe ninguna lista con ID $idLista.")
                    }
                }
            }

            // Paso 3: Insertar la relación en la tabla intermedia
            val sqlInsert = "INSERT INTO listas_videojuegos(id_lista, id_videojuego, fecha_anadido) VALUES (?, ?, ?)"
            conn.prepareStatement(sqlInsert).use { stmt ->
                stmt.setInt(1, idLista)
                stmt.setInt(2, idVideojuego)
                stmt.setString(3, fecha)
                stmt.executeUpdate()
            }

            conn.commit() // Confirmar la transacción completa
            println("Transacción completada: videojuego $idVideojuego añadido a la lista $idLista.")
            true
        } catch (e: SQLException) {
            println("Error en la transacción (se aplica rollback): ${e.message}")
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
     * Obtiene todos los videojuegos contenidos en una lista concreta.
     */
    fun obtenerVideojuegosDeLista(idLista: Int): List<Videojuego> {
        val videojuegos = mutableListOf<Videojuego>()
        val sql = """
            SELECT v.id, v.titulo, v.genero, v.anio, v.nota
            FROM videojuegos v
            INNER JOIN listas_videojuegos lv ON v.id = lv.id_videojuego
            WHERE lv.id_lista = ?
            ORDER BY v.id
        """.trimIndent()
        try {
            ConexionBD.getConnection()?.use { conn ->
                conn.prepareStatement(sql).use { stmt ->
                    stmt.setInt(1, idLista)
                    stmt.executeQuery().use { rs ->
                        while (rs.next()) {
                            videojuegos.add(VideojuegoDAO.mapearVideojuego(rs))
                        }
                    }
                }
            }
        } catch (e: SQLException) {
            println("Error al consultar los videojuegos de la lista $idLista: ${e.message}")
        }
        return videojuegos
    }
}

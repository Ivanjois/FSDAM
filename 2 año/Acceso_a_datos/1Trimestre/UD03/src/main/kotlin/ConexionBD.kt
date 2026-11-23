import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

/**
 * Gestor Singleton de la conexión JDBC contra PostgreSQL.
 */
object ConexionBD {
    private const val HOST = "localhost"
    private const val PORT = 5432
    private const val DATABASE = "videojuegos"
    private const val USER = "postgres"

    // Contraseña local en Windows ("qwerty2"). En el equipo de clase es "admin" si no se unifica.
    private const val PASSWORD = "qwerty2"

    private val url = "jdbc:postgresql://$HOST:$PORT/$DATABASE"

    /**
     * Abre y devuelve una nueva conexión activa a PostgreSQL, o null si ocurre un error.
     */
    fun getConnection(): Connection? {
        return try {
            DriverManager.getConnection(url, USER, PASSWORD)
        } catch (e: SQLException) {
            println("Error al conectar con PostgreSQL ($url): ${e.message}")
            null
        }
    }

    /**
     * Comprueba que la conexión contra la base de datos funciona correctamente.
     */
    fun testConnection(): Boolean {
        return try {
            getConnection()?.use {
                println("Conexión establecida con éxito con PostgreSQL ($DATABASE en $HOST:$PORT).")
                true
            } ?: false
        } catch (e: SQLException) {
            println("Error durante la prueba de conexión: ${e.message}")
            false
        }
    }

    /**
     * Cierra manualmente una conexión cuando no se emplea un bloque .use {}.
     */
    fun closeConnection(conn: Connection?) {
        try {
            conn?.close()
        } catch (e: SQLException) {
            println("Error al cerrar la conexión: ${e.message}")
        }
    }
}

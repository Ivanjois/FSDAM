/**
 * Entidad de dominio con compatibilidad para deserializacion XML mediante Jackson Dataformat XML.
 */
package actividad04

data class Videojuego(
    val id: Int,
    val titulo: String,
    val genero: String,
    val anio: Int,
    val nota: Double
)

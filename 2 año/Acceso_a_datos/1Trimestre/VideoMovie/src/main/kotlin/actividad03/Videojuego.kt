/**
 * Modelo de datos que representa un videojuego para el almacenamiento en ficheros de texto plano CSV.
 */
package actividad03

data class Videojuego(
    val id: Int,
    val titulo: String,
    val genero: String,
    val anio: Int,
    val nota: Double
)

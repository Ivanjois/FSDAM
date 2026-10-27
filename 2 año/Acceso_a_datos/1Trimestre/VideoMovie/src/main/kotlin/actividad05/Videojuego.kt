/**
 * Modelo de datos anotado con @Serializable para la serializacion y deserializacion en formato JSON con kotlinx.serialization.
 */
package actividad05

import kotlinx.serialization.Serializable

@Serializable
data class Videojuego(
    val id: Int,
    val titulo: String,
    val genero: String,
    val anio: Int,
    val nota: Double
)

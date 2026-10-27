/**
 * Modelo de datos unificado compatible con todos los formatos de intercambio soportados por la aplicacion (CSV, XML y JSON).
 */
package actividad06

import kotlinx.serialization.Serializable

@Serializable
data class Videojuego(
    val id: Int,
    val titulo: String,
    val genero: String,
    val anio: Int,
    val nota: Double
)

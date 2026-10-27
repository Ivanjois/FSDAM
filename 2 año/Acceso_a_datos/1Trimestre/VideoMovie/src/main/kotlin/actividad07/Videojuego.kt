/**
 * Entidad de negocio para la serializacion en estructuras binarias de tamano fijo en memoria y disco.
 */
package actividad07

data class Videojuego(
    val id: Int,
    var titulo: String,
    var genero: String,
    var anio: Int,
    var nota: Double
)

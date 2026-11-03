// Fichero: Planta.kt
data class Planta(
    val id: Int? = null, // Nulable, ya que es autogenerado por la BD
    val nombreComun: String,
    val nombreCientifico: String,
    val stock: Int,
    val precio: Double
)
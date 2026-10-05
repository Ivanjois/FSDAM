/**
 * Representa la entidad de un vehículo con sus especificaciones básicas.
 *
 * Al ser una `data class`, Kotlin genera automáticamente métodos estándar como
 * `equals()`, `hashCode()`, `toString()` y `copy()`.
 *
 * @property marca Nombre del fabricante o marca del coche (ej. "Toyota").
 * @property modelo Modelo comercial del vehículo (ej. "Corolla").
 * @property anio Año de fabricación o matriculación del vehículo (ej. "2020").
 */
data class Coche(var marca: String, var modelo: String, var anio: String)

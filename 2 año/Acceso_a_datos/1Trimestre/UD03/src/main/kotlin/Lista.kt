/**
 * Modelo que representa un registro de la tabla 'listas', asociada a un jugador.
 */
data class Lista(
    val idLista: Int? = null,
    val nombre: String,
    val idJugador: Int
)

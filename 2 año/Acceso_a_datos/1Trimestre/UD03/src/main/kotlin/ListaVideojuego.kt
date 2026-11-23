/**
 * Modelo que representa la relación en la tabla intermedia 'listas_videojuegos'.
 */
data class ListaVideojuego(
    val idLista: Int,
    val idVideojuego: Int,
    val fechaAnadido: String
)

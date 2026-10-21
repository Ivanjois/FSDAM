/**
 * Representa una coordenada bidimensional (x, y) en el plano cartesiano.
 *
 * @property x Coordenada en el eje horizontal (abscisas).
 * @property y Coordenada en el eje vertical (ordenadas).
 */
class Punto(var x: Int, var y: Int) {

    /**
     * Determina en qué cuadrante del plano cartesiano se encuentra el punto
     * según los signos de sus coordenadas [x] e [y].
     *
     * @return Cadena que indica el cuadrante ("Cuadrante 1", "Cuadrante 2", "Cuadrante 3",
     *         "Cuadrante 4") o "Esta en 0,0" si coincide con los ejes o el origen.
     */
    fun donde(): String {
        when {
            x > 0 && y > 0 -> return "Cuadrante 1"
            x < 0 && y > 0 -> return "Cuadrante 2"
            x < 0 && y < 0 -> return "Cuadrante 3"
            x > 0 && y < 0 -> return "Cuadrante 4"
            else -> return "Esta en 0,0"
        }
    }
}

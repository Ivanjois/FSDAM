class Punto(var x: Int, var y: Int) {
    fun donde(): String {
        when {
            x > 0 && y > 0 -> return "Cuadrante 1"
            x < 0 && y > 0 -> return "Cuadrante 2"
            x < 0 && y < 0-> return "Cuadrante 3"
            x > 0 && y < 0 -> return "Cuadrante 4"
           else -> return "Esta en 0,0"
        }
    }
}
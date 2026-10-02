class Punto(var x: Int, var y: Int) { //Aqui definimos la clase punto que tiene el metodo que dependiendo la x y la sera cuadrante 1,2,3,4 y si no es niguno de esos estara en 0.0.
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
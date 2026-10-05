/**
 * Punto de entrada principal para evaluar la posición de varios puntos en el plano cartesiano.
 * Instancia coordenadas representativas de cada uno de los 4 cuadrantes y del origen.
 */
fun main() {
    // Inicialización de puntos de prueba para cada cuadrante y el origen
    val punto1 = Punto(1, 1)    // Cuadrante 1 (+, +)
    val punto2 = Punto(-1, 1)   // Cuadrante 2 (-, +)
    val punto3 = Punto(-1, -1)  // Cuadrante 3 (-, -)
    val punto4 = Punto(1, -1)   // Cuadrante 4 (+, -)
    val punto5 = Punto(0, 0)    // Origen de coordenadas

    // Muestra por consola la ubicación resultante de cada punto
    println(punto1.donde())
    println(punto2.donde())
    println(punto3.donde())
    println(punto4.donde())
    println(punto5.donde())
}

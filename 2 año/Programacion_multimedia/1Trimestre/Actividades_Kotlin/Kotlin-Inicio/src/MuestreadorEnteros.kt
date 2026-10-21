/**
 * Clase que gestiona un array de números enteros generados de forma aleatoria,
 * permitiendo consultar el contenido completo, el valor máximo y el valor mínimo.
 */
class MuestreadorEnteros {

    /** Array privado que almacena 5 enteros aleatorios entre 0 y 10. */
    private val numeros = IntArray(5)

    /**
     * Bloque inicializador que se ejecuta automáticamente al instanciar la clase,
     * rellenando el array con números aleatorios.
     */
    init {
        cargarNumeros()
    }

    /**
     * Genera enteros aleatorios en el rango [0, 10] para cada posición del array.
     */
    private fun cargarNumeros() {
        for (i in numeros.indices) {
            numeros[i] = (0..10).random()
        }
    }

    /**
     * Representa los elementos del array como una cadena de texto legible.
     *
     * @return Representación en formato `[e1, e2, e3, e4, e5]`.
     */
    fun mostrarArreglo(): String {
        return "${numeros.contentToString()}"
    }

    /**
     * Obtiene el valor más alto almacenado en el array.
     *
     * @return El número entero de mayor valor.
     */
    fun mostrarMayor(): Int {
        var mayor: Int = numeros[0]
        for (i in numeros.indices) {
            if (numeros[i] > mayor) {
                mayor = numeros[i]
            }
        }
        return mayor
    }

    /**
     * Obtiene el valor más bajo (mínimo) almacenado en el array.
     *
     * @return El número entero de menor valor.
     */
    fun mostrarMenos(): Int {
        var menos: Int = numeros[0]
        for (i in numeros.indices) {
            if (numeros[i] < menos) {
                menos = numeros[i]
            }
        }
        return menos
    }
}

/**
 * Punto de entrada para probar la generación aleatoria y los métodos de [MuestreadorEnteros].
 */
fun main() {
    val muestreador = MuestreadorEnteros()
    println(muestreador.mostrarArreglo())
    println(muestreador.mostrarMayor())
    println(muestreador.mostrarMenos())
}

import kotlin.random.Random

class MuestreadorEnteros {
    // Propiedad privada de tipo array de 5 enteros
    private val numeros = IntArray(5)

    init {
        // En el bloque init llamamos al método privado para cargar los números
        cargarNumeros()
    }

    // Método privado que carga valores aleatorios comprendidos entre 0 y 10
    private fun cargarNumeros() {
        for (i in numeros.indices) {
            numeros[i] = Random.nextInt(0, 11) // 0..10 inclusive
        }
    }

    // Método público que muestra el array resultante
    fun mostrarArreglo() {
        println("Array: ${numeros.joinToString(", ")}")
    }

    // Método público que muestra el mayor elemento
    fun mostrarMayor() {
        println("El mayor elemento es: ${numeros.maxOrNull()}")
    }

    // Método público que muestra el menor elemento
    fun mostrarMenor() {
        println("El menor elemento es: ${numeros.minOrNull()}")
    }
}

fun main() {
    val muestreador = MuestreadorEnteros()
    muestreador.mostrarArreglo()
    muestreador.mostrarMayor()
    muestreador.mostrarMenor()
}

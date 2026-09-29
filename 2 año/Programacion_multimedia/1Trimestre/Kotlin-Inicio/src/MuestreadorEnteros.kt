class MuestreadorEnteros {
    private val numeros = IntArray(5)

    init {
        cargarNumeros()
    }

    private fun cargarNumeros() {
        for (i in numeros.indices) {
            numeros[i] = (0..10).random()
        }
    }

    fun mostrarArreglo(): String {
        return "${numeros.contentToString()}"
    }

    fun mostrarMayor(): Int {
        var mayor: Int = numeros[0]
        for (i in numeros.indices) {
            if (numeros[i] > mayor) {
                mayor = numeros[i]
            }
        }
        return mayor
    }

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

fun main() {
    val muestreador = MuestreadorEnteros()
    println(muestreador.mostrarArreglo())
    println(muestreador.mostrarMayor())
    println(muestreador.mostrarMenos())
}

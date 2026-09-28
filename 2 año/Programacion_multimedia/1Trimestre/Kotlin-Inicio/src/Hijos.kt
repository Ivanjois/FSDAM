class Hijos {
    val edad = IntArray(5)
    fun cargarEdad() {
        println("Dime cinco edades")
        for (i in edad.indices) {
            edad[i] = readLine()!!.toInt()
        }
        mayorEdad()
        promedio()

    }
    fun mayorEdad() {
        var mayor = edad[0]
        for (i in edad.indices) {
            if (edad[i] > mayor) {
                mayor = edad[i]
            }
            println("El hijo con mayor edad es $mayor")
        }
    }
    fun promedio() {
        var suma = 0
        for (i in edad.indices) {
            suma += edad[i]
            val promedio = suma /edad.size
            println("La edad promedio $promedio")
        }

    }
}
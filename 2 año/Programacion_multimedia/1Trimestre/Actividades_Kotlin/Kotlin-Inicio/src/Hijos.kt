/**
 * Clase encargada de registrar las edades de 5 hijos y calcular estadísticas
 * básicas: edad máxima y edad promedio.
 */
class Hijos {

    /** Array de 5 posiciones enteras para almacenar las edades leídas. */
    val edad = IntArray(5)

    /**
     * Solicita por teclado las cinco edades, las almacena en el array [edad]
     * y ejecuta automáticamente los métodos de cálculo [mayorEdad] y [promedio].
     */
    fun cargarEdad() {
        println("Dime cinco edades")
        for (i in edad.indices) {
            edad[i] = readLine()!!.toInt()
        }
        mayorEdad()
        promedio()
    }

    /**
     * Recorre el array para determinar la edad más alta e informa por consola.
     */
    fun mayorEdad() {
        var mayor = edad[0]
        for (i in edad.indices) {
            if (edad[i] > mayor) {
                mayor = edad[i]
            }
            // NOTA: Si este println está dentro del bucle se repite en cada iteración;
            // muévelo fuera del bucle 'for' si solo deseas ver el resultado definitivo.
            println("El hijo con mayor edad es $mayor")
        }
    }

    /**
     * Suma las edades del array y calcula la media aritmética.
     */
    fun promedio() {
        var suma = 0
        for (i in edad.indices) {
            suma += edad[i]
            // NOTA: El cálculo y print dentro del bucle muestran el progreso en cada paso;
            // muévelos fuera del bucle 'for' para mostrar solo la media final.
            val promedio = suma / edad.size
            println("La edad promedio $promedio")
        }
    }
}

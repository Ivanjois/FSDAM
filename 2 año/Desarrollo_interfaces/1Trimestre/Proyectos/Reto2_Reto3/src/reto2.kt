import kotlin.random.Random

/**
 * Reto 2 - Ejercicios de introducción a Kotlin (Sprint 1 - Desarrollo de Interfaces).
 * Cada ejercicio está encapsulado en su propia función y se ejecuta desde main().
 */
fun main() {
    println("===== RETO 2 =====")
    println("\n--- Ejercicio 1 ---")
    ejercicio1()

    println("\n--- Ejercicio 2 ---")
    ejercicio2()

    println("\n--- Ejercicio 3 ---")
    ejercicio3()

    println("\n--- Ejercicio 4 ---")
    ejercicio4()

    println("\n--- Ejercicio 5 ---")
    ejercicio5()

    println("\n--- Ejercicio 6 ---")
    ejercicio6()

    println("\n--- Ejercicio 7 ---")
    ejercicio7()
}

/**
 * Ejercicio 1:
 * Faltaba completar el código dentro de main() para imprimir exactamente
 * "Mary is 20 years old" usando las variables name y age.
 * Se resuelve mediante plantillas de cadena (string templates) con $name y $age.
 */
fun ejercicio1() {
    val name = "Mary"
    val age = 20
    println("$name is $age years old")
}

/**
 * Ejercicio 2:
 * En el código inicial solo la variable 'a' tenía tipo explícito (Int).
 * Faltaba declarar explícitamente el tipo de b, c, d, e y f:
 * String, Double, Long (por superar el rango de Int), Boolean y Char.
 */
fun ejercicio2() {
    val a: Int = 1000
    val b: String = "log message"
    val c: Double = 3.14
    val d: Long = 100_000_000_000
    val e: Boolean = false
    val f: Char = '\n'

    println("a (Int) = $a")
    println("b (String) = $b")
    println("c (Double) = $c")
    println("d (Long) = $d")
    println("e (Boolean) = $e")
    print("f (Char salto de línea) = [inicio]$f[fin]\n")
}

/**
 * Ejercicio 3:
 * Faltaba calcular e imprimir la cantidad total de números sumando el tamaño
 * de las dos listas (greenNumbers y redNumbers) usando .count() o .size.
 */
fun ejercicio3() {
    val greenNumbers = listOf(1, 4, 23)
    val redNumbers = listOf(17, 2)
    val total = greenNumbers.count() + redNumbers.count()
    println("Total de números: $total")
}

/**
 * Ejercicio 4:
 * Faltaba completar la variable booleana isSupported comprobando si 'requested'
 * pertenece al conjunto SUPPORTED sin importar mayúsculas/minúsculas.
 * Nota: la pista menciona .upperCase(), cuyo equivalente actual en Kotlin es .uppercase(),
 * combinado con el operador 'in'.
 */
fun ejercicio4() {
    val SUPPORTED = setOf("HTTP", "HTTPS", "FTP")
    val requested = "smtp"
    val isSupported = requested.uppercase() in SUPPORTED
    println("Support for $requested: $isSupported")
}

/**
 * Ejercicio 5:
 * No había código inicial; se solicita crear un mapa mutable (MutableMap)
 * que almacene el nombre de tres alumnos como clave y su nota como valor.
 */
fun ejercicio5() {
    val notasAlumnos: MutableMap<String, Double> = mutableMapOf(
        "Ana" to 8.5,
        "Carlos" to 7.0,
        "Lucía" to 9.2
    )
    println("Notas de los alumnos: $notasAlumnos")
}

/**
 * Ejercicio 6:
 * Partiendo de las dos tiradas aleatorias con Random.nextInt(6) (valores de 0 a 5),
 * faltaba comparar ambos resultados para indicar si el jugador gana o pierde.
 */
fun ejercicio6() {
    val firstResult = Random.nextInt(6)
    val secondResult = Random.nextInt(6)

    println("Dado 1: $firstResult | Dado 2: $secondResult")
    if (firstResult == secondResult) {
        println("¡Has ganado! Ambos dados muestran el mismo número.")
    } else {
        println("Has perdido. Los números son distintos.")
    }
}

/**
 * Ejercicio 7:
 * Faltaba completar la expresión 'when' dentro de println(...) para devolver
 * la acción correspondiente según el valor de 'button' (A, B, X, Y u otro).
 */
fun ejercicio7() {
    val button = "A"

    println(
        when (button) {
            "A" -> "Yes"
            "B" -> "No"
            "X" -> "Menu"
            "Y" -> "Nothing"
            else -> "There is no such button"
        }
    )
}

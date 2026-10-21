// =============================================================================
// EJERCICIO 7: Funciones de extensión (Extension Functions)
// =============================================================================

/**
 * Función de extensión sobre la clase [String] para comprobar si es un palíndromo
 * (se lee igual de izquierda a derecha que de derecha a izquierda).
 *
 * @receiver Cadena de texto sobre la que se invoca la función.
 * @return `true` si el texto es palíndromo, `false` en caso contrario.
 */
fun String.esPalindromo(): Boolean {
    val minuscula = this.lowercase()
    return minuscula == this.reversed()
}

/** Palabra de prueba para verificar la función [esPalindromo]. */
val palabra = "oso"


// =============================================================================
// EJERCICIO 8: Null Safety (Manejo de nulos)
// =============================================================================

/**
 * Variable nullable (`String?`) inicializada a null.
 * Demuestra la seguridad frente a nulos de Kotlin frente a NullPointerException.
 */
val myFavouriteSong: String? = null


// =============================================================================
// EJERCICIO 9: Operador de llamada segura (?.) y operador Elvis (?:)
// =============================================================================

/**
 * Obtiene la longitud de un texto de forma segura.
 * Si el parámetro es `null`, el operador Elvis (`?:`) retorna el valor por defecto `0`.
 *
 * @param texto Cadena de texto que puede ser nula (`String?`).
 * @return Longitud del texto o 0 si [texto] es nulo.
 */
fun longitudOCero(texto: String?): Int = texto?.length ?: 0


// =============================================================================
// EJERCICIO 10: Funciones anónimas / Expresiones Lambda
// =============================================================================

/**
 * Variable de tipo función `(Int, Int) -> Int` que almacena una expresión lambda
 * para calcular el producto de dos números enteros.
 */
val multiplicar: (Int, Int) -> Int = { a, b -> a * b }


// =============================================================================
// EJERCICIO 11: Funciones de orden superior (Higher-Order Functions)
// =============================================================================

/**
 * Función de orden superior que recibe dos números enteros y una función (lambda)
 * como tercer parámetro para aplicar dicha operación sobre ellos.
 *
 * @param a Primer operando.
 * @param b Segundo operando.
 * @param operacion Función o lambda `(Int, Int) -> Int` que define la operación a ejecutar.
 * @return Resultado de ejecutar la operación recibida.
 */
fun operar(a: Int, b: Int, operacion: (Int, Int) -> Int): Int {
    return operacion(a, b)
}


// =============================================================================
// EJERCICIO 12: Programación funcional con Colecciones (filter y map)
// =============================================================================

/** Lista inmutable de números enteros base. */
val numeros = listOf(3, 8, 15, 22, 7, 40, 11)

/** Filtra los números de la lista quedándose únicamente con los mayores a 10. */
val mayorDiez = numeros.filter { it > 10 }

/** Transforma cada elemento de la lista multiplicándolo por 2. */
val doble = numeros.map { it * 2 }


// =============================================================================
// EJERCICIO 13: Expresión 'when' y rangos ('in ..')
// =============================================================================

/**
 * Clasifica una etapa vital en base a la edad facilitada.
 * Utiliza el operador Elvis para tratar nulos como 0, y rangos (`in ..`) dentro de un `when`.
 *
 * @param edad Edad en años (puede ser `null`).
 * @return Cadena descriptiva de la etapa ("Bebé", "Niño/a", "Adolescente" o "Adulto/a").
 */
fun describirEdad(edad: Int?): String = when (edad ?: 0) {
    in 0..2 -> "Bebé"
    in 3..12 -> "Niño/a"
    in 13..17 -> "Adolescente"
    else -> "Adulto/a"
}


// =============================================================================
// FUNCIÓN PRINCIPAL: Pruebas de ejecución
// =============================================================================

/**
 * Punto de entrada para probar los ejercicios del 7 al 13 por consola.
 */
fun main() {
    // Ejercicio 7: Comprobación de palíndromo
    // println(palabra.esPalindromo())

    // Ejercicio 8: Comprobación de nulos con expresión if tradicional
    // println(if (myFavouriteSong != null) myFavouriteSong else "No")

    // Ejercicio 9: Longitud segura con operador Elvis
    // println(longitudOCero("Hola Mundo"))

    // Ejercicio 10: Ejecución de la lambda de multiplicación
    // println(multiplicar(3, 4))

    // Ejercicio 11: Invocación de función de orden superior pasando una lambda sumatoria
    // println(operar(2, 5) { a, b -> a + b })

    // Ejercicio 12: Resultados de filter y map sobre listas
    // println(mayorDiez)
    // println(doble)

    // Ejercicio 13: Clasificación con when y rangos
    println(describirEdad(3))
}

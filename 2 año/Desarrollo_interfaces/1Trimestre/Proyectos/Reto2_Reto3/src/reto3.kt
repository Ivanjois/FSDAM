import kotlin.math.abs

/**
 * Reto 3 - Ejercicios avanzados de Kotlin (Sprint 1 - Desarrollo de Interfaces).
 * Incluye lectura interactiva por consola en los ejercicios 1 y 2, y null safety en el 3.
 */
fun main() {
    println("===== RETO 3 =====")
    println("\n--- Ejercicio 1: Validador de contraseña ---")
    ejercicio1()

    println("\n--- Ejercicio 2: Análisis de temperaturas ---")
    ejercicio2()

    println("\n--- Ejercicio 3: Null safety con ?.let y ?: ---")
    ejercicio3()
}

/**
 * Ejercicio 1:
 * Lee contraseñas desde consola con readlnOrNull() hasta introducir una válida.
 * Comprueba todos los requisitos de forma independiente y los acumula en una lista
 * para informar de todos los fallos a la vez, no solo del primero.
 */
fun ejercicio1() {
    while (true) {
        print("Introduce una contraseña: ")
        val password = readlnOrNull() ?: run {
            println("\nFin de entrada alcanzado.")
            return
        }

        // Acumulamos cada requisito incumplido en lugar de salir en el primer fallo.
        val errores = mutableListOf<String>()

        if (password.length < 8) {
            errores.add("Debe tener al menos 8 caracteres.")
        }
        if (!password.any { it.isUpperCase() }) {
            errores.add("Falta una letra mayúscula.")
        }
        if (!password.any { it.isLowerCase() }) {
            errores.add("Falta una letra minúscula.")
        }
        if (!password.any { it.isDigit() }) {
            errores.add("Falta un número.")
        }
        if (password.any { it.isWhitespace() }) {
            errores.add("No puede contener espacios.")
        }

        if (errores.isEmpty()) {
            println("Contraseña válida.")
            break
        } else {
            val detalle = errores.joinToString(" ") { "- $it" }
            println("Contraseña no válida: $detalle")
        }
    }
}

/**
 * Ejercicio 2:
 * Lee temperaturas por consola hasta que el usuario escribe "fin".
 * Calcula máxima, mínima, media, cuántas superan la media, la mayor variación
 * absoluta entre mediciones consecutivas y la tendencia entre cada par de datos.
 */
fun ejercicio2() {
    val temperaturas = mutableListOf<Double>()

    println("Introduce temperaturas una a una (escribe 'fin' para terminar):")
    while (true) {
        print("Temperatura: ")
        val entrada = readlnOrNull()?.trim() ?: break

        if (entrada.equals("fin", ignoreCase = true)) {
            break
        }

        val valor = entrada.replace(',', '.').toDoubleOrNull()
        if (valor == null) {
            println("Valor no reconocido. Introduce un número válido o 'fin'.")
        } else {
            temperaturas.add(valor)
        }
    }

    if (temperaturas.isEmpty()) {
        println("No se introdujeron temperaturas.")
        return
    }

    val maxima = temperaturas.max()
    val minima = temperaturas.min()
    val media = temperaturas.average()
    val porEncimaDeMedia = temperaturas.count { it > media }

    // Calculamos la diferencia máxima entre mediciones consecutivas y registramos cada variación.
    var mayorVariacion = 0.0
    val tendencias = mutableListOf<String>()

    for (i in 1 until temperaturas.size) {
        val anterior = temperaturas[i - 1]
        val actual = temperaturas[i]
        val diferencia = abs(actual - anterior)
        if (diferencia > mayorVariacion) {
            mayorVariacion = diferencia
        }

        val estado = when {
            actual > anterior -> "Subió"
            actual < anterior -> "Bajó"
            else -> "Se mantuvo"
        }
        tendencias.add("Medición $i -> ${i + 1} (${formatearNumero(anterior)} -> ${formatearNumero(actual)}): $estado")
    }

    println("\nResultados:")
    println("Máxima: ${formatearNumero(maxima)}")
    println("Mínima: ${formatearNumero(minima)}")
    println("Media: ${formatearNumero(media)}")
    println("Por encima de la media: $porEncimaDeMedia")
    println("Mayor variación consecutiva: ${formatearNumero(mayorVariacion)}")

    if (tendencias.isEmpty()) {
        println("Evolución entre mediciones: se necesitan al menos 2 temperaturas para comparar.")
    } else {
        println("Evolución entre mediciones:")
        tendencias.forEach { println("  - $it") }
    }
}

/**
 * Formatea un Double eliminando ".0" si representa un número entero exacto.
 */
private fun formatearNumero(valor: Double): String {
    return if (valor % 1.0 == 0.0) valor.toLong().toString() else valor.toString()
}

/**
 * Ejercicio 3:
 * Demuestra el manejo seguro de nulos con una variable 'correo' de tipo String?.
 * ?.let ejecuta el bloque únicamente cuando correo no es null; en caso contrario,
 * el operador Elvis (?:) ejecuta el mensaje alternativo.
 */
fun ejercicio3() {
    var correo: String? = "alumno@correo.com"
    correo?.let {
        println("Enviando mensaje a $it")
    } ?: println("No se ha indicado ningún correo")

    // Comprobación con valor nulo para verificar la rama del operador Elvis (?:).
    correo = null
    correo?.let {
        println("Enviando mensaje a $it")
    } ?: println("No se ha indicado ningún correo")
}

//7
fun String.esPalindromo(): Boolean {
    val minuscula = this.lowercase()
    return minuscula == this.reversed()
}

val palabra = "oso"

//8
val myFavouriteSong: String? = null

//9
fun longitudOCero(texto: String?): Int = texto?.length ?: 0

//10
val multiplicar: (Int, Int) -> Int = { a, b -> a * b }

//11
fun operar(a: Int, b: Int, operacion: (Int, Int) -> Int): Int {
    return operacion(a, b)
}

//12
val numeros = listOf(3, 8, 15, 22, 7, 40, 11)
val mayorDiez = numeros.filter { it > 10 }
val doble = numeros.map { it * 2 }

//13
fun describirEdad(edad: Int?): String = when (edad ?: 0) {
    in 0..2 -> "Bebé"
    in 3..12 -> "Niño/a"
    in 13..17 -> "Adolescente"
    else -> "Adulto/a"
}

fun main() {
//    println(palabra.esPalindromo())//7
//    println(if (myFavouriteSong != null) myFavouriteSong else "No")//8
//    println(longitudOCero("Hola Mundo"))//9
//    println(multiplicar(3, 4))//10
//    println(operar(2, 5) { a, b -> a + b })//11
//    println(mayorDiez)//12
//    println(doble)//12
    println(describirEdad(3))//13

}
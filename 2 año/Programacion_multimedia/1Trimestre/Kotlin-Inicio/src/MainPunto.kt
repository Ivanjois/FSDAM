fun main() { //Estw es el main donde inicializas la clase dando le lo que vale x he y, luego printeo su metodo que devuelve una frase de donde esta situado.
    val punto1 = Punto(1, 1)
    val punto2 = Punto(-1, 1)
    val punto3 = Punto(-1, -1)
    val punto4 = Punto(1, -1)
    val punto5 = Punto(0, 0)

    println(punto1.donde())
    println(punto2.donde())
    println(punto3.donde())
    println(punto4.donde())
    println(punto5.donde())
}
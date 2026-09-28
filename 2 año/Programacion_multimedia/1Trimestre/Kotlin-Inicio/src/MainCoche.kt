fun main() {
    val concesionario = Concesionario("AutoOcasión")

    val coche1 = Coche("Toyota", "Corolla", "2020")
    val coche2 = Coche("Ford", "Focus", "2018")

    concesionario.agregar(coche1)
    concesionario.agregar(coche2)


    println("Coches disponibles en ${concesionario.nombre}:")
    for (c in concesionario.coches) {
        println("- Marca: ${c.marca}, Modelo: ${c.modelo}, Año: ${c.anio}")
    }
    print(coche1) //prueba usando el data en la clase coche antes
}

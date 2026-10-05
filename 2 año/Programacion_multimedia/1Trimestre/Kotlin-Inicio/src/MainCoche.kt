/**
 * Punto de entrada principal para la gestión de concesionarios y coches.
 * Demuestra la creación de concesionarios, instanciación de coches,
 * registro en la lista y visualización por consola.
 */
fun main() {
    // 1. Instanciamos el concesionario con su nombre comercial
    val concesionario = Concesionario("AutoOcasión")

    // 2. Creamos instancias de prueba de la clase Coche
    val coche1 = Coche("Toyota", "Corolla", "2020")
    val coche2 = Coche("Ford", "Focus", "2018")

    // 3. Añadimos los vehículos al inventario del concesionario
    concesionario.agregar(coche1)
    concesionario.agregar(coche2)

    // 4. Mostramos el listado recorriendo los coches registrados
    println("Coches disponibles en ${concesionario.nombre}:")
    for (c in concesionario.coches) {
        println("- Marca: ${c.marca}, Modelo: ${c.modelo}, Año: ${c.anio}")
    }

    // 5. Prueba del método toString() autogenerado por ser data class
    print(coche1)
}

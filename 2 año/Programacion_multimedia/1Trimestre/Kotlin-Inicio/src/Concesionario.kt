class Concesionario (var nombre: String) {//
    val coches = mutableListOf<Coche>()

    fun agregar(coche: Coche) {
        coches.add(coche)
    }
}

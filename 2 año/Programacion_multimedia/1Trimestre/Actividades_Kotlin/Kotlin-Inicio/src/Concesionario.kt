/**
 * Gestiona un concesionario y su catálogo de vehículos en stock.
 *
 * @property nombre Nombre comercial identificativo del concesionario.
 */
class Concesionario(var nombre: String) {

    /** Lista mutable interna que almacena el inventario de coches disponibles. */
    val coches = mutableListOf<Coche>()

    /**
     * Agrega un nuevo vehículo al inventario del concesionario.
     *
     * @param coche Instancia de [Coche] que se desea registrar.
     */
    fun agregar(coche: Coche) {
        coches.add(coche)
    }
}

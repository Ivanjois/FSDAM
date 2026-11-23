import java.time.LocalDate

/**
 * Punto de entrada de la aplicación de gestión del Catálogo de Videojuegos con PostgreSQL.
 */
fun main() {
    println("Iniciando Catálogo de Videojuegos...")
    if (!ConexionBD.testConnection()) {
        println(
            "Aviso: No se pudo conectar con PostgreSQL. Comprueba que el servicio esté arrancado, " +
                "que exista la base de datos 'videojuegos' y que la contraseña en ConexionBD.kt sea correcta."
        )
    }

    var salir = false
    while (!salir) {
        mostrarMenu()
        when (leerEntero("Escoge una opción: ")) {
            1 -> verTodosLosVideojuegos()
            2 -> buscarVideojuegoPorId()
            3 -> anadirVideojuego()
            4 -> modificarVideojuego()
            5 -> eliminarVideojuego()
            6 -> crearJugador()
            7 -> eliminarJugador()
            8 -> crearLista()
            9 -> eliminarLista()
            10 -> anadirVideojuegoALista()
            11 -> verVideojuegosDeLista()
            0 -> {
                println("Saliendo del catálogo. ¡Hasta pronto!")
                salir = true
            }
            else -> println("Opción no válida. Escoge un número del 0 al 11.")
        }
        println()
    }
}

private fun mostrarMenu() {
    println("===== CATÁLOGO DE VIDEOJUEGOS =====")
    println("--- VIDEOJUEGOS ---")
    println("1. Ver todos los videojuegos")
    println("2. Buscar videojuego por ID")
    println("3. Añadir videojuego")
    println("4. Modificar videojuego")
    println("5. Eliminar videojuego")
    println("--- JUGADORES ---")
    println("6. Crear jugador")
    println("7. Eliminar jugador")
    println("--- LISTAS ---")
    println("8. Crear lista")
    println("9. Eliminar lista")
    println("10. Añadir videojuego a una lista")
    println("11. Ver videojuegos de una lista")
    println("0. Salir")
    println("====================================")
}

private fun verTodosLosVideojuegos() {
    val videojuegos = VideojuegoDAO.listarVideojuegos()
    if (videojuegos.isEmpty()) {
        println("No hay videojuegos registrados en la base de datos.")
        return
    }
    println("Lista de videojuegos:")
    videojuegos.forEach { imprimirVideojuego(it) }
}

private fun buscarVideojuegoPorId() {
    val id = leerEntero("Introduce el ID del videojuego: ")
    val videojuego = VideojuegoDAO.consultarPorId(id)
    if (videojuego != null) {
        imprimirVideojuego(videojuego)
    } else {
        println("No se encontró ningún videojuego con ID $id.")
    }
}

private fun anadirVideojuego() {
    val titulo = leerTextoNoVacio("Título: ")
    val genero = leerTextoNoVacio("Género: ")
    val anio = leerEntero("Año de lanzamiento: ")
    val nota = leerNota("Nota (0.0 - 10.0): ")
    VideojuegoDAO.insertarVideojuego(Videojuego(titulo = titulo, genero = genero, anio = anio, nota = nota))
}

private fun modificarVideojuego() {
    val id = leerEntero("Introduce el ID del videojuego a modificar: ")
    val actual = VideojuegoDAO.consultarPorId(id)
    if (actual == null) {
        println("No se encontró ningún videojuego con ID $id.")
        return
    }

    println("Datos actuales:")
    imprimirVideojuego(actual)

    val titulo = leerTextoOpcional("Nuevo título (Enter para mantener '${actual.titulo}'): ", actual.titulo)
    val genero = leerTextoOpcional("Nuevo género (Enter para mantener '${actual.genero}'): ", actual.genero)
    val anio = leerEnteroOpcional("Nuevo año (Enter para mantener ${actual.anio}): ", actual.anio)
    val nota = leerNotaOpcional("Nueva nota 0.0-10.0 (Enter para mantener ${actual.nota}): ", actual.nota)

    VideojuegoDAO.actualizarVideojuego(
        Videojuego(id = actual.id, titulo = titulo, genero = genero, anio = anio, nota = nota)
    )
}

private fun eliminarVideojuego() {
    val id = leerEntero("Introduce el ID del videojuego a eliminar: ")
    VideojuegoDAO.eliminarVideojuego(id)
}

private fun crearJugador() {
    val nombre = leerTextoNoVacio("Nombre del jugador: ")
    val email = leerTextoNoVacio("Email del jugador: ")
    JugadorDAO.insertarJugador(Jugador(nombre = nombre, email = email))
}

private fun eliminarJugador() {
    mostrarJugadoresDisponibles()
    val id = leerEntero("Introduce el ID del jugador a eliminar: ")
    JugadorDAO.eliminarJugador(id)
}

private fun crearLista() {
    mostrarJugadoresDisponibles()
    val idJugador = leerEntero("ID del jugador propietario de la lista: ")
    val nombre = leerTextoNoVacio("Nombre de la nueva lista: ")
    ListaDAO.insertarLista(Lista(nombre = nombre, idJugador = idJugador))
}

private fun eliminarLista() {
    mostrarListasDisponibles()
    val idLista = leerEntero("Introduce el ID de la lista a eliminar: ")
    ListaDAO.eliminarLista(idLista)
}

private fun anadirVideojuegoALista() {
    mostrarListasDisponibles()
    val idLista = leerEntero("ID de la lista: ")
    val idVideojuego = leerEntero("ID del videojuego: ")
    val hoy = LocalDate.now().toString()
    val fecha = leerTextoOpcional("Fecha (Enter para usar hoy '$hoy'): ", hoy)
    ListaVideojuegoDAO.anyadirALista(idLista, idVideojuego, fecha)
}

private fun verVideojuegosDeLista() {
    mostrarListasDisponibles()
    val idLista = leerEntero("Introduce el ID de la lista: ")
    if (!ListaDAO.existeLista(idLista)) {
        println("No existe ninguna lista con ID $idLista.")
        return
    }
    val videojuegos = ListaVideojuegoDAO.obtenerVideojuegosDeLista(idLista)
    if (videojuegos.isEmpty()) {
        println("La lista con ID $idLista no tiene videojuegos todavía.")
        return
    }
    println("Videojuegos de la lista $idLista:")
    videojuegos.forEach { imprimirVideojuego(it) }
}

private fun mostrarJugadoresDisponibles() {
    val jugadores = JugadorDAO.listarJugadores()
    if (jugadores.isNotEmpty()) {
        println("Jugadores actuales:")
        jugadores.forEach { println(" - [${it.id}] ${it.nombre} (${it.email})") }
    }
}

private fun mostrarListasDisponibles() {
    val listas = ListaDAO.listarListas()
    if (listas.isNotEmpty()) {
        println("Listas actuales:")
        listas.forEach { println(" - [${it.idLista}] ${it.nombre} (Jugador ID: ${it.idJugador})") }
    }
}

private fun imprimirVideojuego(videojuego: Videojuego) {
    println(" - [${videojuego.id}] ${videojuego.titulo} (${videojuego.genero}), año: ${videojuego.anio}, nota: ${videojuego.nota}")
}

private fun leerTextoNoVacio(mensaje: String): String {
    while (true) {
        print(mensaje)
        val entrada = readlnOrNull()?.trim() ?: ""
        if (entrada.isNotEmpty()) return entrada
        println("El campo no puede estar vacío. Inténtalo de nuevo.")
    }
}

private fun leerTextoOpcional(mensaje: String, valorPorDefecto: String): String {
    print(mensaje)
    val entrada = readlnOrNull()?.trim() ?: ""
    return entrada.ifEmpty { valorPorDefecto }
}

private fun leerEntero(mensaje: String): Int {
    while (true) {
        print(mensaje)
        val numero = readlnOrNull()?.trim()?.toIntOrNull()
        if (numero != null) return numero
        println("Introduce un número entero válido.")
    }
}

private fun leerEnteroOpcional(mensaje: String, valorPorDefecto: Int): Int {
    while (true) {
        print(mensaje)
        val entrada = readlnOrNull()?.trim() ?: ""
        if (entrada.isEmpty()) return valorPorDefecto
        val numero = entrada.toIntOrNull()
        if (numero != null) return numero
        println("Introduce un número entero válido o pulsa Enter para mantener el actual.")
    }
}

private fun leerNota(mensaje: String): Double {
    while (true) {
        print(mensaje)
        val nota = readlnOrNull()?.trim()?.replace(",", ".")?.toDoubleOrNull()
        if (nota != null && nota in 0.0..10.0) return nota
        println("Introduce una nota válida entre 0.0 y 10.0.")
    }
}

private fun leerNotaOpcional(mensaje: String, valorPorDefecto: Double): Double {
    while (true) {
        print(mensaje)
        val entrada = readlnOrNull()?.trim() ?: ""
        if (entrada.isEmpty()) return valorPorDefecto
        val nota = entrada.replace(",", ".").toDoubleOrNull()
        if (nota != null && nota in 0.0..10.0) return nota
        println("Introduce una nota válida entre 0.0 y 10.0 o pulsa Enter para mantener la actual.")
    }
}

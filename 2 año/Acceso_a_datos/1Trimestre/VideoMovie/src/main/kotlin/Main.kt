import java.nio.file.Files
import java.nio.file.Path

/**
 * Aplicacion unificada del Catalogo de Videojuegos (Unidad 2 - Persistencia en Ficheros).
 * Integra la persistencia en CSV, XML, JSON, motores de conversion y ficheros binarios de acceso aleatorio.
 */
fun main() {
    // 1. Inicializacion y verificacion de rutas segun Practica 2
    val rutaDatos = Path.of("datos")
    val dirIni = rutaDatos.resolve("datos_ini")
    val dirFin = rutaDatos.resolve("datos_fin")
    Files.createDirectories(dirIni)
    Files.createDirectories(dirFin)

    // Visualizacion de la jerarquia con calculo de profundidad (Practica 2)
    mostrarEstructuraDirectorios(rutaDatos)

    val rutaCSV = dirIni.resolve("videojuegos.csv")
    val rutaXML = dirIni.resolve("videojuegos.xml")
    val rutaJSON = dirIni.resolve("videojuegos.json")
    val rutaBIN = dirFin.resolve("videojuegos_aleatorio.dat")

    val repo = VideojuegoRepository()
    val repoBin = VideojuegoRandomAccessRepository()

    // Catalogo en memoria cargado inicialmente desde el CSV
    val catalogo = repo.leerDatosCSV(rutaCSV).toMutableList()

    var opcionPrincipal: Int?
    do {
        println("\n===== CATALOGO DE VIDEOJUEGOS =====")
        println("1. Gestion CSV")
        println("2. Leer catalogo desde XML")
        println("3. Leer catalogo desde JSON")
        println("4. Conversiones entre formatos")
        println("5. Gestion fichero BIN")
        println("0. Salir")
        println("====================================")
        print("Elige una opcion: ")

        opcionPrincipal = readlnOrNull()?.trim()?.toIntOrNull()

        when (opcionPrincipal) {
            1 -> submenuCSV(catalogo, repo, rutaCSV)
            2 -> {
                println("\n--- Importando desde XML: $rutaXML ---")
                val juegosXML = repo.leerVideojuegosXML(rutaXML)
                integrarCatalogo(catalogo, juegosXML, repo, rutaCSV, "XML")
            }
            3 -> {
                println("\n--- Importando desde JSON: $rutaJSON ---")
                val juegosJSON = repo.leerVideojuegosJSON(rutaJSON)
                integrarCatalogo(catalogo, juegosJSON, repo, rutaCSV, "JSON")
            }
            4 -> submenuConversiones(dirIni, dirFin, repo)
            5 -> submenuBIN(catalogo, repoBin, rutaBIN)
            0 -> println("¡Hasta pronto!")
            else -> println("Opcion no valida. Prueba de nuevo.")
        }
    } while (opcionPrincipal != 0)
}

/**
 * Integra nuevos elementos en el catalogo filtrando duplicados por ID y sincronizando el CSV.
 */
fun integrarCatalogo(
    catalogo: MutableList<Videojuego>,
    nuevosJuegos: List<Videojuego>,
    repo: VideojuegoRepository,
    rutaCSV: Path,
    formato: String
) {
    if (nuevosJuegos.isEmpty()) {
        println("No se han encontrado datos que importar de $formato.")
        return
    }

    println("Videojuegos leidos desde $formato:")
    for (j in nuevosJuegos) {
        println("  [$formato] ID: ${j.id} | ${j.titulo} (${j.anio}) - Nota: ${j.nota}")
    }

    val idsExistentes = catalogo.map { it.id }.toSet()
    val paraIntegrar = nuevosJuegos.filter { it.id !in idsExistentes }

    if (paraIntegrar.isNotEmpty()) {
        catalogo.addAll(paraIntegrar)
        repo.escribirCSV(rutaCSV, catalogo)
        println("\n¡Exito! Se han integrado ${paraIntegrar.size} videojuegos nuevos desde $formato en el catalogo.")
    } else {
        println("\nAviso: Todos los videojuegos del $formato ya existian en el catalogo (0 duplicados anadidos).")
    }
}

/**
 * Submenu para la gestion CRUD sobre ficheros CSV.
 */
fun submenuCSV(catalogo: MutableList<Videojuego>, repo: VideojuegoRepository, rutaCSV: Path) {
    var opcion: Int?
    do {
        println("\n--- Gestion CSV ---")
        println("1. Listar todos los videojuegos")
        println("2. Buscar videojuego por ID")
        println("3. Anadir nuevo videojuego")
        println("4. Modificar nota de un videojuego")
        println("5. Eliminar videojuego")
        println("0. Volver al menu principal")
        print("Elige una opcion: ")

        opcion = readlnOrNull()?.trim()?.toIntOrNull()

        when (opcion) {
            1 -> {
                println("\n--- LISTA DE VIDEOJUEGOS (CSV) ---")
                if (catalogo.isEmpty()) {
                    println("El catalogo esta vacio.")
                } else {
                    for (j in catalogo) {
                        println("ID: ${j.id} | ${j.titulo} | Genero: ${j.genero} | Anio: ${j.anio} | Nota: ${j.nota}")
                    }
                }
            }
            2 -> {
                print("Introduce el ID a buscar: ")
                val id = readlnOrNull()?.trim()?.toIntOrNull()
                val juego = catalogo.find { it.id == id }
                if (juego != null) {
                    println("Encontrado: $juego")
                } else {
                    println("No se encontro ningun videojuego con ID $id")
                }
            }
            3 -> {
                val nuevoId = (catalogo.maxOfOrNull { it.id } ?: 0) + 1
                print("Titulo: ")
                val titulo = readlnOrNull()?.trim() ?: "Sin titulo"
                print("Genero: ")
                val genero = readlnOrNull()?.trim() ?: "General"
                print("Anio: ")
                val anio = readlnOrNull()?.trim()?.toIntOrNull() ?: 2024
                print("Nota (0.0 - 10.0): ")
                val nota = readlnOrNull()?.trim()?.replace(',', '.')?.toDoubleOrNull() ?: 5.0

                catalogo.add(Videojuego(nuevoId, titulo, genero, anio, nota))
                repo.escribirCSV(rutaCSV, catalogo)
                println("¡Videojuego anadido y guardado en CSV!")
            }
            4 -> {
                print("Introduce el ID del juego a modificar: ")
                val id = readlnOrNull()?.trim()?.toIntOrNull()
                val indice = catalogo.indexOfFirst { it.id == id }
                if (indice != -1) {
                    print("Nueva nota (0.0 - 10.0): ")
                    val nuevaNota = readlnOrNull()?.trim()?.replace(',', '.')?.toDoubleOrNull()
                    if (nuevaNota != null && nuevaNota in 0.0..10.0) {
                        val juegoAntiguo = catalogo[indice]
                        catalogo[indice] = juegoAntiguo.copy(nota = nuevaNota)
                        repo.escribirCSV(rutaCSV, catalogo)
                        println("¡Nota modificada y guardada en CSV!")
                    } else {
                        println("Nota invalida.")
                    }
                } else {
                    println("ID no encontrado.")
                }
            }
            5 -> {
                print("Introduce el ID del juego a eliminar: ")
                val id = readlnOrNull()?.trim()?.toIntOrNull()
                val juego = catalogo.find { it.id == id }
                if (juego != null) {
                    print("¿Seguro que deseas eliminar '${juego.titulo}'? (s/n): ")
                    val confirma = readlnOrNull()?.trim()?.lowercase()
                    if (confirma == "s") {
                        catalogo.remove(juego)
                        repo.escribirCSV(rutaCSV, catalogo)
                        println("¡Videojuego eliminado y guardado en CSV!")
                    } else {
                        println("Operacion cancelada.")
                    }
                } else {
                    println("ID no encontrado.")
                }
            }
            0 -> println("Volviendo al menu principal...")
            else -> println("Opcion no valida.")
        }
    } while (opcion != 0)
}

/**
 * Submenu para conversiones bidireccionales entre CSV, XML y JSON.
 */
fun submenuConversiones(dirIni: Path, dirFin: Path, repo: VideojuegoRepository) {
    var opcion: Int?
    do {
        println("\n--- Conversiones entre formatos ---")
        println("1. CSV  -> JSON")
        println("2. CSV  -> XML")
        println("3. JSON -> CSV")
        println("4. JSON -> XML")
        println("5. XML  -> CSV")
        println("6. XML  -> JSON")
        println("0. Volver")
        print("Elige una opcion: ")

        opcion = readlnOrNull()?.trim()?.toIntOrNull()

        when (opcion) {
            1 -> repo.convertir(dirIni.resolve("videojuegos.csv"), dirFin.resolve("videojuegos.json"), repo::leerDatosCSV, repo::escribirJSON)
            2 -> repo.convertir(dirIni.resolve("videojuegos.csv"), dirFin.resolve("videojuegos.xml"), repo::leerDatosCSV, repo::escribirXML)
            3 -> repo.convertir(dirIni.resolve("videojuegos.json"), dirFin.resolve("videojuegos.csv"), repo::leerVideojuegosJSON, repo::escribirCSV)
            4 -> repo.convertir(dirIni.resolve("videojuegos.json"), dirFin.resolve("videojuegos.xml"), repo::leerVideojuegosJSON, repo::escribirXML)
            5 -> repo.convertir(dirIni.resolve("videojuegos.xml"), dirFin.resolve("videojuegos.csv"), repo::leerVideojuegosXML, repo::escribirCSV)
            6 -> repo.convertir(dirIni.resolve("videojuegos.xml"), dirFin.resolve("videojuegos.json"), repo::leerVideojuegosXML, repo::escribirJSON)
            0 -> println("Volviendo al menu principal...")
            else -> println("Opcion no valida.")
        }
    } while (opcion != 0)
}

/**
 * Submenu para la gestion del fichero binario de acceso aleatorio (.dat).
 */
fun submenuBIN(catalogo: List<Videojuego>, repoBin: VideojuegoRandomAccessRepository, rutaBIN: Path) {
    var opcion: Int?
    do {
        println("\n===== CRUD fichero BIN =====")
        println("1. Importar informacion de un fichero de intercambio")
        println("2. Leer informacion del fichero binario")
        println("3. Anadir un registro nuevo")
        println("4. Modificar un registro existente (por ID)")
        println("5. Eliminar un registro existente (por ID)")
        println("0. Volver")
        print("Elige una opcion: ")

        opcion = readlnOrNull()?.trim()?.toIntOrNull()

        when (opcion) {
            1 -> {
                println("\n--- Importando datos al fichero binario ---")
                repoBin.importarDesdeLista(catalogo, rutaBIN)
                val tamano = if (Files.exists(rutaBIN)) Files.size(rutaBIN) else 0L
                println("Fichero binario creado en: $rutaBIN")
                println("Tamano en disco: $tamano bytes (${catalogo.size} registros * 76 bytes = ${catalogo.size * 76} bytes)")
            }
            2 -> {
                println("\n1. Listar todos los registros")
                println("2. Buscar un videojuego por ID (Acceso directo O(1))")
                print("Elige una opcion: ")
                when (readlnOrNull()?.trim()?.toIntOrNull()) {
                    1 -> {
                        println("\n--- LISTA DE VIDEOJUEGOS EN FICHERO BINARIO ---")
                        val todos = repoBin.listarTodos(rutaBIN)
                        if (todos.isEmpty()) {
                            println("El fichero binario esta vacio o no existe.")
                        } else {
                            todos.forEach { j ->
                                println("ID: ${j.id.toString().padStart(2)} | Titulo: ${j.titulo.padEnd(30)} | Genero: ${j.genero.padEnd(15)} | Anio: ${j.anio} | Nota: ${j.nota}")
                            }
                        }
                    }
                    2 -> {
                        print("Introduce el ID del videojuego a buscar: ")
                        val id = readlnOrNull()?.trim()?.toIntOrNull()
                        if (id != null && id > 0) {
                            val tInicio = System.nanoTime()
                            val juego = repoBin.leerPorId(id, rutaBIN)
                            val tFin = System.nanoTime()
                            val tiempoMs = (tFin - tInicio) / 1_000_000.0

                            if (juego != null) {
                                println("Encontrado en $tiempoMs ms (Acceso O(1)):")
                                println("ID: ${juego.id} | Titulo: ${juego.titulo} | Genero: ${juego.genero} | Anio: ${juego.anio} | Nota: ${juego.nota}")
                            } else {
                                println("No se encontro ningun videojuego activo con el ID $id.")
                            }
                        } else {
                            println("ID no valido.")
                        }
                    }
                    else -> println("Opcion no valida.")
                }
            }
            3 -> {
                print("Introduce el ID del nuevo videojuego: ")
                val id = readlnOrNull()?.trim()?.toIntOrNull()
                if (id == null || id <= 0) {
                    println("ID invalido.")
                } else if (repoBin.leerPorId(id, rutaBIN) != null) {
                    println("Aviso: Ya existe un videojuego activo con el ID $id.")
                } else {
                    print("Titulo: ")
                    val titulo = readlnOrNull()?.trim() ?: "Sin titulo"
                    print("Genero: ")
                    val genero = readlnOrNull()?.trim() ?: "General"
                    print("Anio: ")
                    val anio = readlnOrNull()?.trim()?.toIntOrNull() ?: 2024
                    print("Nota (0.0 - 10.0): ")
                    val nota = readlnOrNull()?.trim()?.replace(',', '.')?.toDoubleOrNull() ?: 5.0

                    repoBin.guardar(Videojuego(id, titulo, genero, anio, nota), rutaBIN)
                    println("¡Videojuego anadido al fichero binario con exito!")
                }
            }
            4 -> {
                print("Introduce el ID del videojuego a modificar: ")
                val id = readlnOrNull()?.trim()?.toIntOrNull()
                val actual = if (id != null) repoBin.leerPorId(id, rutaBIN) else null

                if (actual != null) {
                    println("Datos actuales: $actual")
                    print("Nuevo titulo (Enter para mantener '${actual.titulo}'): ")
                    val nuevoTitulo = readlnOrNull()?.takeIf { it.isNotBlank() } ?: actual.titulo

                    print("Nuevo genero (Enter para mantener '${actual.genero}'): ")
                    val nuevoGenero = readlnOrNull()?.takeIf { it.isNotBlank() } ?: actual.genero

                    print("Nuevo anio (Enter para mantener '${actual.anio}'): ")
                    val nuevoAnio = readlnOrNull()?.toIntOrNull() ?: actual.anio

                    print("Nueva nota (Enter para mantener '${actual.nota}'): ")
                    val nuevaNota = readlnOrNull()?.replace(',', '.')?.toDoubleOrNull() ?: actual.nota

                    val actualizado = Videojuego(id!!, nuevoTitulo, nuevoGenero, nuevoAnio, nuevaNota)
                    repoBin.actualizar(actualizado, rutaBIN)
                    println("Videojuego con ID $id actualizado in situ con exito.")
                } else {
                    println("Videojuego no encontrado en el fichero binario.")
                }
            }
            5 -> {
                print("Introduce el ID del videojuego a eliminar (borrado logico): ")
                val id = readlnOrNull()?.trim()?.toIntOrNull()
                if (id != null) {
                    val exito = repoBin.eliminarLogico(id, rutaBIN)
                    if (exito) {
                        println("Videojuego con ID $id marcado como borrado (ID = -1).")
                    } else {
                        println("No se pudo borrar: videojuego no encontrado.")
                    }
                }
            }
            0 -> println("Volviendo al menu principal...")
            else -> println("Opcion no valida.")
        }
    } while (opcion != 0)
}

/**
 * Muestra la jerarquia de directorios y ficheros calculando la profundidad con java.nio.file (Practica 2).
 */
fun mostrarEstructuraDirectorios(rutaBase: Path) {
    if (!Files.exists(rutaBase)) return
    println("--- ESTRUCTURA DE DIRECTORIOS Y FICHEROS ---")
    try {
        Files.walk(rutaBase).use { stream ->
            stream.sorted().forEach { path ->
                // Calculo matematico de la profundidad: diferencia de niveles entre el fichero y la raiz
                val profundidad = path.nameCount - rutaBase.nameCount
                val indentacion = "  ".repeat(profundidad)
                val etiqueta = if (Files.isDirectory(path)) "[DIR]" else "[FILE]"
                println("$indentacion$etiqueta ${path.fileName}")
            }
        }
        println("--------------------------------------------")
    } catch (e: Exception) {
        println("Error al recorrer directorios: ${e.message}")
    }
}

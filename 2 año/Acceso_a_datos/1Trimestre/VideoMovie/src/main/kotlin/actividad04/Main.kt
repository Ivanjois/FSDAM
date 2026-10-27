/**
 * Actividad 04 - Interfaz de consola que incorpora la importacion y mezcla de registros desde ficheros XML sin duplicar IDs.
 */
package actividad04

import java.nio.file.Path

fun main() {
    val rutaCSV = Path.of("datos", "datos_ini", "videojuegos.csv")
    val rutaXML = Path.of("datos", "datos_ini", "videojuegos.xml")
    val repo = VideojuegoRepository()

    // Carga de la coleccion en memoria desde el fichero CSV
    val catalogo = repo.leerDatosCSV(rutaCSV).toMutableList()

    var opcionPrincipal: Int?
    do {
        println("\n===== CATALOGO DE VIDEOJUEGOS (ACTIVIDAD 4 - XML) =====")
        println("1. Gestion CSV")
        println("2. Leer catalogo desde XML")
        println("0. Salir")
        println("=======================================================")
        print("Elige una opcion: ")

        opcionPrincipal = readlnOrNull()?.trim()?.toIntOrNull()

        when (opcionPrincipal) {
            1 -> submenuCSV(catalogo, repo, rutaCSV)
            2 -> {
                println("\n--- Importando desde XML: $rutaXML ---")
                val juegosDesdeXML = repo.leerVideojuegosXML(rutaXML)

                if (juegosDesdeXML.isNotEmpty()) {
                    println("Videojuegos encontrados en XML:")
                    for (j in juegosDesdeXML) {
                        println("  [XML] ID: ${j.id} | ${j.titulo} (${j.anio}) - Nota: ${j.nota}")
                    }

                    // Filtrado de registros existentes para evitar colisiones de clave primaria
                    val idsExistentes = catalogo.map { it.id }.toSet()
                    val nuevos = juegosDesdeXML.filter { it.id !in idsExistentes }

                    if (nuevos.isNotEmpty()) {
                        catalogo.addAll(nuevos)
                        repo.escribirCSV(rutaCSV, catalogo)
                        println("\n¡Exito! Se han integrado ${nuevos.size} videojuegos nuevos en el catalogo y se ha actualizado el CSV.")
                    } else {
                        println("\nAviso: Todos los videojuegos del XML ya estaban registrados en el catalogo (0 duplicados anadidos).")
                    }
                }
            }
            0 -> println("¡Hasta pronto!")
            else -> println("Opcion no valida. Prueba de nuevo.")
        }
    } while (opcionPrincipal != 0)
}

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
                println("\n--- LISTA DE VIDEOJUEGOS ---")
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

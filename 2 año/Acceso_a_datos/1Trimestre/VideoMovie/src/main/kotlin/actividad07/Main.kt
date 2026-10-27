/**
 * Actividad 07 - Interfaz de demostracion de acceso directo O(1), modificacion in situ y borrado logico en ficheros binarios.
 */
package actividad07

import java.nio.file.Files
import java.nio.file.Path

fun main() {
    val repo = VideojuegoRandomAccessRepository()
    val rutaDat = Path.of("datos", "datos_fin", "videojuegos_aleatorio.dat")

    var opcion: Int?
    do {
        println("\n===== ACTIVIDAD 7: FICHEROS DE ACCESO ALEATORIO (FileChannel & ByteBuffer) =====")
        println("1. Inicializar fichero binario con datos de prueba")
        println("2. Buscar videojuego por ID (Acceso directo O(1))")
        println("3. Listar todos los videojuegos del fichero binario")
        println("4. Modificar videojuego existente (sobrescritura in situ)")
        println("5. Borrar videojuego (Borrado logico ID = -1)")
        println("6. Prueba defensiva: Insertar titulo de mas de 40 caracteres")
        println("0. Salir")
        println("================================================================================")
        print("Elige una opcion: ")

        opcion = readlnOrNull()?.toIntOrNull()

        when (opcion) {
            1 -> {
                println("\n--- Inicializando fichero binario con 5 videojuegos ---")
                val juegosIniciales = listOf(
                    Videojuego(1, "The Legend of Zelda: BotW", "Aventura", 2017, 9.7),
                    Videojuego(2, "Super Mario Odyssey", "Plataformas", 2017, 9.5),
                    Videojuego(3, "The Witcher 3: Wild Hunt", "RPG", 2015, 9.8),
                    Videojuego(4, "Cyberpunk 2077", "Accion RPG", 2020, 8.6),
                    Videojuego(5, "Red Dead Redemption 2", "Mundo Abierto", 2018, 9.9)
                )
                juegosIniciales.forEach { repo.guardar(it, rutaDat) }
                val tamanioBytes = Files.size(rutaDat)
                println("Fichero creado en: $rutaDat")
                println("Tamano en disco: $tamanioBytes bytes (5 registros * 76 bytes = ${5 * 76} bytes)")
            }

            2 -> {
                print("\nIntroduce el ID del videojuego a buscar: ")
                val id = readlnOrNull()?.toIntOrNull()
                if (id != null && id > 0) {
                    val tInicio = System.nanoTime()
                    val juego = repo.leerPorId(id, rutaDat)
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

            3 -> {
                println("\n--- Lista de Videojuegos en el Fichero Binario ---")
                val todos = repo.listarTodos(rutaDat)
                if (todos.isEmpty()) {
                    println("El archivo esta vacio o no contiene registros activos.")
                } else {
                    todos.forEach { j ->
                        println("ID: ${j.id.toString().padStart(2)} | Titulo: ${j.titulo.padEnd(30)} | Genero: ${j.genero.padEnd(15)} | Anio: ${j.anio} | Nota: ${j.nota}")
                    }
                }
            }

            4 -> {
                print("\nIntroduce el ID del videojuego a modificar: ")
                val id = readlnOrNull()?.toIntOrNull()
                val actual = if (id != null) repo.leerPorId(id, rutaDat) else null

                if (actual != null) {
                    println("Datos actuales: $actual")
                    print("Nuevo titulo (Enter para mantener '${actual.titulo}'): ")
                    val nuevoTitulo = readlnOrNull()?.takeIf { it.isNotBlank() } ?: actual.titulo

                    print("Nuevo genero (Enter para mantener '${actual.genero}'): ")
                    val nuevoGenero = readlnOrNull()?.takeIf { it.isNotBlank() } ?: actual.genero

                    print("Nuevo anio (Enter para mantener '${actual.anio}'): ")
                    val nuevoAnio = readlnOrNull()?.toIntOrNull() ?: actual.anio

                    print("Nueva nota (Enter para mantener '${actual.nota}'): ")
                    val nuevaNota = readlnOrNull()?.toDoubleOrNull() ?: actual.nota

                    val actualizado = Videojuego(id!!, nuevoTitulo, nuevoGenero, nuevoAnio, nuevaNota)
                    repo.actualizar(actualizado, rutaDat)
                    println("Videojuego con ID $id actualizado in situ con exito.")
                } else {
                    println("Videojuego no encontrado.")
                }
            }

            5 -> {
                print("\nIntroduce el ID del videojuego a eliminar (borrado logico): ")
                val id = readlnOrNull()?.toIntOrNull()
                if (id != null) {
                    val exito = repo.eliminarLogico(id, rutaDat)
                    if (exito) {
                        println("Videojuego con ID $id marcado como borrado (ID = -1).")
                    } else {
                        println("No se pudo borrar: videojuego no encontrado.")
                    }
                }
            }

            6 -> {
                println("\n--- Prueba Defensiva: Titulo gigante ---")
                println("Vamos a guardar un videojuego cuyo titulo mide 65 caracteres:")
                val tituloLargo = "The Legend of Zelda: Tears of the Kingdom Collector's Limited Edition"
                println("Titulo original (${tituloLargo.length} caracteres): '$tituloLargo'")

                val juegoTest = Videojuego(99, tituloLargo, "Aventura", 2023, 9.8)
                repo.guardar(juegoTest, rutaDat)
                println("Guardado en ID 99 sin desbordar el buffer ni lanzar excepciones.")

                val recuperado = repo.leerPorId(99, rutaDat)
                if (recuperado != null) {
                    println("Recuperado desde el disco:")
                    println("Titulo recortado limpiamente (${recuperado.titulo.length} caracteres): '${recuperado.titulo}'")
                }
            }

            0 -> println("Saliendo de la Actividad 7...")
            else -> println("Opcion no valida.")
        }
    } while (opcion != 0)
}

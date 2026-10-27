/**
 * Actividad 06 - Motor de conversion universal que permite transformar ficheros bidireccionalmente entre CSV, XML y JSON.
 */
package actividad06

import java.nio.file.Files
import java.nio.file.Path

fun main() {
    val dirIni = Path.of("datos", "datos_ini")
    val dirFin = Path.of("datos", "datos_fin")
    Files.createDirectories(dirFin) // Aseguramos que datos_fin exista

    val repo = VideojuegoRepository()
    val rutaCSV = dirIni.resolve("videojuegos.csv")
    val catalogo = repo.leerDatosCSV(rutaCSV).toMutableList()

    var opcionPrincipal: Int?
    do {
        println("\n===== CATALOGO DE VIDEOJUEGOS (ACTIVIDAD 6 - CONVERSIONES) =====")
        println("1. Gestion CSV")
        println("2. Leer catalogo desde XML")
        println("3. Leer catalogo desde JSON")
        println("4. Conversiones entre formatos")
        println("0. Salir")
        println("================================================================")
        print("Elige una opcion: ")

        opcionPrincipal = readlnOrNull()?.trim()?.toIntOrNull()

        when (opcionPrincipal) {
            1 -> println("Gestion CSV activa...")
            2 -> {
                val xmlJuegos = repo.leerVideojuegosXML(dirIni.resolve("videojuegos.xml"))
                println("Videojuegos leidos desde XML: ${xmlJuegos.size}")
            }
            3 -> {
                val jsonJuegos = repo.leerVideojuegosJSON(dirIni.resolve("videojuegos.json"))
                println("Videojuegos leidos desde JSON: ${jsonJuegos.size}")
            }
            4 -> submenuConversiones(dirIni, dirFin, repo)
            0 -> println("¡Hasta pronto!")
            else -> println("Opcion no valida.")
        }
    } while (opcionPrincipal != 0)
}

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
            1 -> convertir(dirIni.resolve("videojuegos.csv"), dirFin.resolve("videojuegos.json"), repo::leerDatosCSV, repo::escribirJSON)
            2 -> convertir(dirIni.resolve("videojuegos.csv"), dirFin.resolve("videojuegos.xml"), repo::leerDatosCSV, repo::escribirXML)
            3 -> convertir(dirIni.resolve("videojuegos.json"), dirFin.resolve("videojuegos.csv"), repo::leerVideojuegosJSON, repo::escribirCSV)
            4 -> convertir(dirIni.resolve("videojuegos.json"), dirFin.resolve("videojuegos.xml"), repo::leerVideojuegosJSON, repo::escribirXML)
            5 -> convertir(dirIni.resolve("videojuegos.xml"), dirFin.resolve("videojuegos.csv"), repo::leerVideojuegosXML, repo::escribirCSV)
            6 -> convertir(dirIni.resolve("videojuegos.xml"), dirFin.resolve("videojuegos.json"), repo::leerVideojuegosXML, repo::escribirJSON)
            0 -> println("Volviendo al menu principal...")
            else -> println("Opcion no valida.")
        }
    } while (opcion != 0)
}

/**
 * Funcion generica de conversion de datos entre distintos formatos de almacenamiento.
 */
fun convertir(
    origen: Path,
    destino: Path,
    leer: (Path) -> List<Videojuego>,
    escribir: (Path, List<Videojuego>) -> Unit
) {
    if (!Files.isReadable(origen)) {
        println("Aviso: El archivo origen no existe o no se puede leer: $origen")
        return
    }
    val datos = leer(origen)
    escribir(destino, datos)
    println("¡Conversion completada con exito! Se han convertido ${datos.size} registros hacia: $destino")
}

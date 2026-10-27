/**
 * Repositorio de acceso a datos para operaciones de lectura y escritura en ficheros CSV delimitados por ';'.
 */
package actividad03

import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import com.github.doyaaaaaken.kotlincsv.dsl.csvWriter
import java.io.File
import java.nio.file.Files
import java.nio.file.Path

class VideojuegoRepository {

    fun leerDatosCSV(ruta: Path): List<Videojuego> {
        var videojuegos: List<Videojuego> = emptyList()

        if (!Files.isReadable(ruta)) {
            println("Error: No se puede leer el fichero en la ruta: $ruta")
        } else {
            val filas: List<List<String>> = csvReader {
                delimiter = ';'
            }.readAll(ruta.toFile())

            videojuegos = filas.mapNotNull { columnas ->
                if (columnas.size >= 5) {
                    try {
                        val id = columnas[0].trim().toInt()
                        val titulo = columnas[1].trim()
                        val genero = columnas[2].trim()
                        val anio = columnas[3].trim().toInt()
                        val nota = columnas[4].trim().toDouble()

                        Videojuego(id, titulo, genero, anio, nota)
                    } catch (e: Exception) {
                        println("Fila invalida ignorada: $columnas -> Error: ${e.message}")
                        null
                    }
                } else {
                    println("Fila con formato incompleto ignorada: $columnas")
                    null
                }
            }
        }
        println("--- Informacion leida con exito de: $ruta (${videojuegos.size} videojuegos cargados) ---")
        return videojuegos
    }

    fun escribirCSV(ruta: Path, videojuegos: List<Videojuego>) {
        try {
            val fichero: File = ruta.toFile()

            csvWriter {
                delimiter = ';'
            }.writeAll(
                videojuegos.map { juego ->
                    listOf(
                        juego.id.toString(),
                        juego.titulo,
                        juego.genero,
                        juego.anio.toString(),
                        juego.nota.toString()
                    )
                },
                fichero
            )
            println("--- Fichero CSV actualizado con exito en: $fichero ---")
        } catch (e: Exception) {
            println("Error al escribir el fichero CSV: ${e.message}")
        }
    }
}

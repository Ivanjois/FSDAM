/**
 * Repositorio de datos que combina la persistencia en CSV con la lectura y procesamiento de catalogos en formato XML.
 */
package actividad04

import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import com.github.doyaaaaaken.kotlincsv.dsl.csvWriter
import java.io.File
import java.nio.file.Files
import java.nio.file.Path

class VideojuegoRepository {

    // 1. Lectura de CSV
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
        return videojuegos
    }

    // 2. Escritura de CSV
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

    // 3. Lectura y deserializacion XML
    fun leerVideojuegosXML(ruta: Path): List<Videojuego> {
        var videojuegos: List<Videojuego> = emptyList()

        if (!Files.isReadable(ruta)) {
            println("Error: No se puede leer el archivo XML en: $ruta")
        } else {
            try {
                val fichero = ruta.toFile()
                val xmlMapper = XmlMapper().registerKotlinModule()
                val wrapper: VideojuegosWrapper = xmlMapper.readValue(fichero, VideojuegosWrapper::class.java)
                videojuegos = wrapper.listaVideojuegos
                println("--- XML leido con exito de: $ruta (${videojuegos.size} videojuegos encontrados) ---")
            } catch (e: Exception) {
                println("Error al procesar el archivo XML: ${e.message}")
            }
        }
        return videojuegos
    }
}

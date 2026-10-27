/**
 * Repositorio simetrico con metodos de lectura y escritura independientes para cada uno de los tres formatos (CSV, XML, JSON).
 */
package actividad06

import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import com.github.doyaaaaaken.kotlincsv.dsl.csvWriter
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File
import java.nio.file.Files
import java.nio.file.Path

class VideojuegoRepository {

    // --- 1. CSV ---
    fun leerDatosCSV(ruta: Path): List<Videojuego> {
        var videojuegos: List<Videojuego> = emptyList()
        if (!Files.isReadable(ruta)) {
            println("Error: No se puede leer el fichero CSV en: $ruta")
        } else {
            val filas = csvReader { delimiter = ';' }.readAll(ruta.toFile())
            videojuegos = filas.mapNotNull { col ->
                if (col.size >= 5) {
                    try {
                        Videojuego(col[0].trim().toInt(), col[1].trim(), col[2].trim(), col[3].trim().toInt(), col[4].trim().toDouble())
                    } catch (e: Exception) { null }
                } else null
            }
        }
        return videojuegos
    }

    fun escribirCSV(ruta: Path, videojuegos: List<Videojuego>) {
        try {
            csvWriter { delimiter = ';' }.writeAll(
                videojuegos.map { listOf(it.id.toString(), it.titulo, it.genero, it.anio.toString(), it.nota.toString()) },
                ruta.toFile()
            )
            println("--- Fichero CSV guardado con exito en: $ruta ---")
        } catch (e: Exception) {
            println("Error al escribir CSV: ${e.message}")
        }
    }

    // --- 2. XML ---
    fun leerVideojuegosXML(ruta: Path): List<Videojuego> {
        var videojuegos: List<Videojuego> = emptyList()
        if (!Files.isReadable(ruta)) {
            println("Error: No se puede leer el archivo XML en: $ruta")
        } else {
            try {
                val xmlMapper = XmlMapper().registerKotlinModule()
                val wrapper: VideojuegosWrapper = xmlMapper.readValue(ruta.toFile(), VideojuegosWrapper::class.java)
                videojuegos = wrapper.listaVideojuegos
            } catch (e: Exception) {
                println("Error al procesar XML: ${e.message}")
            }
        }
        return videojuegos
    }

    fun escribirXML(ruta: Path, videojuegos: List<Videojuego>) {
        try {
            val xmlMapper = XmlMapper().registerKotlinModule()
            val wrapper = VideojuegosWrapper(videojuegos)
            val xmlTexto = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(wrapper)
            Files.writeString(ruta, xmlTexto)
            println("--- Fichero XML guardado con exito en: $ruta ---")
        } catch (e: Exception) {
            println("Error al escribir XML: ${e.message}")
        }
    }

    // --- 3. JSON ---
    fun leerVideojuegosJSON(ruta: Path): List<Videojuego> {
        var videojuegos: List<Videojuego> = emptyList()
        if (!Files.isReadable(ruta)) {
            println("Error: No se puede leer el archivo JSON en: $ruta")
        } else {
            try {
                val jsonTexto = Files.readString(ruta)
                videojuegos = Json.decodeFromString<List<Videojuego>>(jsonTexto)
            } catch (e: Exception) {
                println("Error al procesar JSON: ${e.message}")
            }
        }
        return videojuegos
    }

    fun escribirJSON(ruta: Path, videojuegos: List<Videojuego>) {
        try {
            val jsonConfig = Json { prettyPrint = true }
            val jsonTexto = jsonConfig.encodeToString(videojuegos)
            Files.writeString(ruta, jsonTexto)
            println("--- Fichero JSON guardado con exito en: $ruta ---")
        } catch (e: Exception) {
            println("Error al escribir JSON: ${e.message}")
        }
    }
}

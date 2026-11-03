import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import com.github.doyaaaaaken.kotlincsv.dsl.csvWriter
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File
import java.nio.file.Files
import java.nio.file.Path

/**
 * Repositorio de acceso a datos que unifica la persistencia y lectura en los tres formatos
 * de intercambio del proyecto: CSV (kotlin-csv), XML (Jackson) y JSON (kotlinx.serialization).
 */
class VideojuegoRepository {

    // ==========================================
    // 1. FORMATO CSV
    // ==========================================

    fun leerDatosCSV(ruta: Path): List<Videojuego> {
        var videojuegos: List<Videojuego> = emptyList()

        if (!Files.isReadable(ruta)) {
            println("Aviso: No se puede leer el fichero CSV en: $ruta")
        } else {
            val filas = csvReader { delimiter = ';' }.readAll(ruta.toFile())
            videojuegos = filas.mapNotNull { col ->
                if (col.size >= 5) {
                    try {
                        val id = col[0].trim().toInt()
                        val titulo = col[1].trim()
                        val genero = col[2].trim()
                        val anio = col[3].trim().toInt()
                        val nota = col[4].trim().replace(',', '.').toDouble()
                        Videojuego(id, titulo, genero, anio, nota)
                    } catch (e: Exception) {
                        null
                    }
                } else null
            }
        }
        return videojuegos
    }

    fun escribirCSV(ruta: Path, videojuegos: List<Videojuego>) {
        try {
            if (ruta.parent != null) Files.createDirectories(ruta.parent)
            csvWriter { delimiter = ';' }.writeAll(
                videojuegos.map { listOf(it.id.toString(), it.titulo, it.genero, it.anio.toString(), it.nota.toString()) },
                ruta.toFile()
            )
            println("--- Fichero CSV guardado con exito en: $ruta ---")
        } catch (e: Exception) {
            println("Error al escribir CSV: ${e.message}")
        }
    }

    // ==========================================
    // 2. FORMATO XML (Jackson XML)
    // ==========================================

    fun leerVideojuegosXML(ruta: Path): List<Videojuego> {
        var videojuegos: List<Videojuego> = emptyList()
        if (!Files.isReadable(ruta)) {
            println("Aviso: No se puede leer el archivo XML en: $ruta")
        } else {
            try {
                val xmlMapper = XmlMapper().registerKotlinModule()
                val wrapper: VideojuegosWrapper = xmlMapper.readValue(ruta.toFile(), VideojuegosWrapper::class.java)
                videojuegos = wrapper.listaVideojuegos
                println("--- XML leido con exito de: $ruta (${videojuegos.size} videojuegos) ---")
            } catch (e: Exception) {
                println("Error al procesar XML: ${e.message}")
            }
        }
        return videojuegos
    }

    fun escribirXML(ruta: Path, videojuegos: List<Videojuego>) {
        try {
            if (ruta.parent != null) Files.createDirectories(ruta.parent)
            val xmlMapper = XmlMapper().registerKotlinModule()
            val wrapper = VideojuegosWrapper(videojuegos)
            val xmlTexto = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(wrapper)
            Files.writeString(ruta, xmlTexto)
            println("--- Fichero XML guardado con exito en: $ruta ---")
        } catch (e: Exception) {
            println("Error al escribir XML: ${e.message}")
        }
    }

    // ==========================================
    // 3. FORMATO JSON (Kotlinx Serialization)
    // ==========================================

    fun leerVideojuegosJSON(ruta: Path): List<Videojuego> {
        var videojuegos: List<Videojuego> = emptyList()
        if (!Files.isReadable(ruta)) {
            println("Aviso: No se puede leer el archivo JSON en: $ruta")
        } else {
            try {
                val jsonTexto = Files.readString(ruta)
                videojuegos = Json.decodeFromString<List<Videojuego>>(jsonTexto)
                println("--- JSON leido con exito de: $ruta (${videojuegos.size} videojuegos) ---")
            } catch (e: Exception) {
                println("Error al procesar JSON: ${e.message}")
            }
        }
        return videojuegos
    }

    fun escribirJSON(ruta: Path, videojuegos: List<Videojuego>) {
        try {
            if (ruta.parent != null) Files.createDirectories(ruta.parent)
            val jsonConfig = Json { prettyPrint = true }
            val jsonTexto = jsonConfig.encodeToString(videojuegos)
            Files.writeString(ruta, jsonTexto)
            println("--- Fichero JSON guardado con exito en: $ruta ---")
        } catch (e: Exception) {
            println("Error al escribir JSON: ${e.message}")
        }
    }

    // ==========================================
    // 4. MOTOR GENERICO DE CONVERSION
    // ==========================================

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
}

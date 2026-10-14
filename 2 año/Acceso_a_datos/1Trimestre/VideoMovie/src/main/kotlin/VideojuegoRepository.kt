import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import java.nio.file.Files
import java.nio.file.Path

class VideojuegoRepository() {
    fun printearInfo() {

        val entradaCSV = Path.of("datos", "datos_ini", "videojuego.csv")
        val salidaCSV = Path.of("datos", "datos_ini", "videojuego.csv")

        // Leer los datos estructurados del CSV y guardarlos en una lista de objetos Planta
        val datos: List<Videojuego> = leerDatosCSV(entradaCSV)

        // Mostrar por consola la información deserializada
        println("--- Información de la lista de objetos Planta")
        for (dato in datos) {
            println("  - ID: ${dato.id}, Titulo: ${dato.titulo}, Genero: ${dato.genero}, Año: ${dato.anio}, Nota: ${dato.nota}")
        }

        // Guardar una copia procesada en un nuevo fichero CSV
        escribirCSV(salidaCSV, datos)

    }

    fun leerDatosCSV(ruta: Path): List<Videojuego> {
        var plantas: List<Videojuego> = emptyList()

        if (!Files.isReadable(ruta)) {
            println("Error: No se puede leer el fichero en la ruta: $ruta")
        } else {
            val reader = csvReader {
                delimiter = ';'
            }

            // Leemos todas las filas del CSV (devuelve List<List<String>>)
            val filas: List<List<String>> = reader.readAll(ruta.toFile())

            // Convertimos las filas de texto en objetos Planta válidos
            plantas = filas.mapNotNull { columnas ->
                if (columnas.size >= 5) {
                    try {
                        val idPlanta = columnas[0].toInt()
                        val nombreComun = columnas[1]
                        val nombreCientifico = columnas[2]
                        val stock = columnas[3].toInt()
                        val precio = columnas[4].toDouble()
                        Planta(idPlanta, nombreComun, nombreCientifico, stock, precio)
                    } catch (e: Exception) {
                        println("Fila inválida ignorada: $columnas -> Error: ${e.message}")
                        null
                    }
                } else {
                    println("Fila con formato incompleto ignorada: $columnas")
                    null
                }
            }
        }
        println("--- Información leída con éxito de: $ruta")
        return plantas
    }

    fun escribirCSV(ruta: Path, datos: List<Videojuego>) {
        try {
            val fichero: File = ruta.toFile()
            csvWriter {
                delimiter = ';'
            }.writeAll(
                plantas.map { planta ->
                    listOf(
                        planta.idPlanta.toString(),
                        planta.nombreComun,
                        planta.nombreCientifico,
                        planta.stock.toString(),
                        planta.precio.toString()
                    )
                },
                fichero
            )
            println("--- Información guardada con éxito en: $fichero")
        } catch (e: Exception) {
            println("Error al escribir el fichero CSV: ${e.message}")
        }
    }
}

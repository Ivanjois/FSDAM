package org.example

import java.nio.file.Files
import java.nio.file.Path

fun main() {
    val rutaDatos = Path.of("datos")
    val rutaDatosIni = rutaDatos.resolve("datos_ini")
    val rutaDatosFin = rutaDatos.resolve("datos_fin")

    println("CREACIÓN DE RUTAS PROYECTO")

    if (Files.notExists(rutaDatosIni)) {
        println("Creando rutas...")
        println("Creación de ruta para DATOS_INI")
        Files.createDirectories(rutaDatosIni)
    }
    if (Files.notExists(rutaDatosFin)) {
        println("Creando ruta para DATOS_FIN")
        Files.createDirectories(rutaDatosFin)
    }

    println("MOSTRANDO ESTRUCTURA DE DIRECTORIOS Y FICHEROS")
    try {
        Files.walk(rutaDatos).use { stream ->
            stream.sorted().forEach { path ->
                val profundidad = path.nameCount - rutaDatos.nameCount
                val indentacion = " ".repeat(path.nameCount)
                val tipoArchivo = if (Files.isDirectory(path)) { ("[DIR] ${path.fileName}") } else { ("[FILE] ${path.fileName}") }
                if (profundidad >= 0){
                    println("$indentacion$tipoArchivo")
                }

            }
        }
    } catch (e: Exception) {
        println("Ocurrió un error al leer la estructura de directorios: ${e.message}")
    }
}
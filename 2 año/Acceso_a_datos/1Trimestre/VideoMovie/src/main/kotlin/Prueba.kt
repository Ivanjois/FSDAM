package org.example

import java.nio.file.Files
import java.nio.file.Path

fun main() {
    // 1. Definición de rutas base y subdirectorios
    val rutaDatos = Path.of("datos")
    val rutaDatosIni = rutaDatos.resolve("datos_ini")
    val rutaDatosFin = rutaDatos.resolve("datos_fin")

    println("CREACIÓN DE RUTAS PROYECTO")
    println("Creando rutas...")

    // 2. Comprobación de directorios: Si no existen, se crean con Files.createDirectories
    if (Files.notExists(rutaDatosIni)) {
        println("Creación de ruta para DATOS_INI")
        Files.createDirectories(rutaDatosIni)
    }

    if (Files.notExists(rutaDatosFin)) {
        println("Creación de ruta para DATOS_FIN")
        Files.createDirectories(rutaDatosFin)
    }

    // 3. Comprobación y listado de la estructura de directorios y ficheros con Files.walk
    println("MOSTRANDO ESTRUCTURA DE DIRECTORIOS Y FICHEROS")
    try {
        Files.walk(rutaDatos).use { stream ->
            stream.sorted().forEach { path ->
                if (Files.isDirectory(path)) {
                    println("[DIR] ${path.fileName}")
                } else if (Files.isRegularFile(path)) {
                    println("[FILE] ${path.fileName}")
                }
            }
        }
    } catch (e: Exception) {
        println("Ocurrió un error al leer la estructura de directorios: ${e.message}")
    }
}

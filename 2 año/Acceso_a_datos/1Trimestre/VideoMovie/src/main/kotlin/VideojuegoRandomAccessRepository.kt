import java.nio.ByteBuffer
import java.nio.channels.FileChannel
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardOpenOption

/**
 * Repositorio de acceso aleatorio O(1) a ficheros binarios (.dat) con registros fijos de 76 bytes.
 * Gestiona lectura, escritura, actualizacion in situ y borrado logico con FileChannel y ByteBuffer.
 */
class VideojuegoRandomAccessRepository {

    companion object {
        // Estructura fija en disco: ID(4B) + Titulo(40B) + Genero(20B) + Anio(4B) + Nota(8B) = 76 bytes
        const val TAMANIO_REGISTRO = 76L
        const val LONGITUD_TITULO = 40
        const val LONGITUD_GENERO = 20
    }

    private fun stringABytesFijo(texto: String, longitudBytes: Int): ByteArray {
        val bytes = texto.toByteArray(StandardCharsets.UTF_8)
        val resultado = ByteArray(longitudBytes) { ' '.code.toByte() }
        val bytesACopiar = minOf(bytes.size, longitudBytes)
        System.arraycopy(bytes, 0, resultado, 0, bytesACopiar)
        return resultado
    }

    private fun bytesAString(bytes: ByteArray): String {
        return String(bytes, StandardCharsets.UTF_8).trim()
    }

    /**
     * Escribe o sobrescribe un registro en la posicion correspondiente segun su clave primaria (ID).
     * Offset = (id - 1) * 76 bytes.
     */
    fun guardar(videojuego: Videojuego, ruta: Path) {
        if (videojuego.id <= 0) {
            throw IllegalArgumentException("El ID debe ser mayor que 0 para calcular la posicion.")
        }
        if (ruta.parent != null) Files.createDirectories(ruta.parent)

        val offset = (videojuego.id - 1) * TAMANIO_REGISTRO
        val buffer = ByteBuffer.allocate(TAMANIO_REGISTRO.toInt())
        buffer.putInt(videojuego.id)
        buffer.put(stringABytesFijo(videojuego.titulo, LONGITUD_TITULO))
        buffer.put(stringABytesFijo(videojuego.genero, LONGITUD_GENERO))
        buffer.putInt(videojuego.anio)
        buffer.putDouble(videojuego.nota)
        buffer.flip()

        FileChannel.open(
            ruta,
            StandardOpenOption.CREATE,
            StandardOpenOption.READ,
            StandardOpenOption.WRITE
        ).use { canal ->
            canal.position(offset)
            canal.write(buffer)
        }
    }

    /**
     * Lee un videojuego directamente por su ID saltando a la posicion exacta en tiempo O(1).
     */
    fun leerPorId(id: Int, ruta: Path): Videojuego? {
        if (id <= 0 || !Files.exists(ruta)) return null

        val offset = (id - 1) * TAMANIO_REGISTRO

        FileChannel.open(ruta, StandardOpenOption.READ).use { canal ->
            if (canal.size() < offset + TAMANIO_REGISTRO) return null

            canal.position(offset)
            val buffer = ByteBuffer.allocate(TAMANIO_REGISTRO.toInt())
            canal.read(buffer)
            buffer.flip()

            val leidoId = buffer.getInt()
            if (leidoId <= 0) return null // Registro vacio o borrado logico

            val bytesTitulo = ByteArray(LONGITUD_TITULO)
            buffer.get(bytesTitulo)
            val titulo = bytesAString(bytesTitulo)

            val bytesGenero = ByteArray(LONGITUD_GENERO)
            buffer.get(bytesGenero)
            val genero = bytesAString(bytesGenero)

            val anio = buffer.getInt()
            val nota = buffer.getDouble()

            return Videojuego(leidoId, titulo, genero, anio, nota)
        }
    }

    /**
     * Recorre todo el fichero binario de 76 en 76 bytes retornando los videojuegos activos.
     */
    fun listarTodos(ruta: Path): List<Videojuego> {
        if (!Files.exists(ruta)) return emptyList()

        val lista = mutableListOf<Videojuego>()

        FileChannel.open(ruta, StandardOpenOption.READ).use { canal ->
            val buffer = ByteBuffer.allocate(TAMANIO_REGISTRO.toInt())

            while (canal.read(buffer) > 0) {
                buffer.flip()

                val id = buffer.getInt()
                val bytesTitulo = ByteArray(LONGITUD_TITULO)
                buffer.get(bytesTitulo)
                val titulo = bytesAString(bytesTitulo)

                val bytesGenero = ByteArray(LONGITUD_GENERO)
                buffer.get(bytesGenero)
                val genero = bytesAString(bytesGenero)

                val anio = buffer.getInt()
                val nota = buffer.getDouble()

                if (id > 0) {
                    lista.add(Videojuego(id, titulo, genero, anio, nota))
                }
                buffer.clear()
            }
        }
        return lista
    }

    /**
     * Modifica los datos de un videojuego en su posicion existente en disco.
     */
    fun actualizar(videojuego: Videojuego, ruta: Path): Boolean {
        leerPorId(videojuego.id, ruta) ?: return false
        guardar(videojuego, ruta)
        return true
    }

    /**
     * Borrado logico mediante valor centinela (ID = -1) para preservar el esquema de offsets.
     */
    fun eliminarLogico(id: Int, ruta: Path): Boolean {
        leerPorId(id, ruta) ?: return false
        val offset = (id - 1) * TAMANIO_REGISTRO

        val buffer = ByteBuffer.allocate(TAMANIO_REGISTRO.toInt())
        buffer.putInt(-1)
        buffer.put(ByteArray(LONGITUD_TITULO + LONGITUD_GENERO + 4 + 8) { 0 })
        buffer.flip()

        FileChannel.open(ruta, StandardOpenOption.WRITE).use { canal ->
            canal.position(offset)
            canal.write(buffer)
        }
        return true
    }

    /**
     * Opcion IMPORTAR: Vacía o crea el fichero binario y vuelca una coleccion completa.
     */
    fun importarDesdeLista(videojuegos: List<Videojuego>, ruta: Path) {
        if (ruta.parent != null) Files.createDirectories(ruta.parent)
        // Sobrescribimos / creamos vacio
        FileChannel.open(
            ruta,
            StandardOpenOption.CREATE,
            StandardOpenOption.WRITE,
            StandardOpenOption.TRUNCATE_EXISTING
        ).close()

        videojuegos.forEach { guardar(it, ruta) }
    }
}

/**
 * Repositorio de acceso aleatorio O(1) a ficheros binarios (.dat) con registros fijos de 76 bytes usando FileChannel y ByteBuffer.
 */
package actividad07

import java.nio.ByteBuffer
import java.nio.channels.FileChannel
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardOpenOption

/**
 * Repositorio para la persistencia binaria de videojuegos con acceso directo O(1).
 * Utiliza registros de tamano fijo (76 bytes) mediante FileChannel y ByteBuffer.
 */
class VideojuegoRandomAccessRepository {

    companion object {
        // Estructura en disco: ID(4B) + Titulo(40B) + Genero(20B) + Anio(4B) + Nota(8B) = 76B
        const val TAMANIO_REGISTRO = 76L
        const val LONGITUD_TITULO = 40
        const val LONGITUD_GENERO = 20
    }

    /**
     * Normaliza una cadena a un array de bytes de longitud fija mediante padding o truncado.
     */
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
     * Escribe o sobrescribe un registro en la posicion correspondiente segun su clave primaria.
     */
    fun guardar(videojuego: Videojuego, ruta: Path) {
        if (videojuego.id <= 0) {
            throw IllegalArgumentException("El ID debe ser mayor que 0 para calcular la posicion.")
        }

        if (ruta.parent != null) {
            Files.createDirectories(ruta.parent)
        }

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
     * Lee un videojuego directamente por su ID saltando en 0 milisegundos con canal.position(offset).
     */
    fun leerPorId(id: Int, ruta: Path): Videojuego? {
        if (id <= 0 || !Files.exists(ruta)) return null

        val offset = (id - 1) * TAMANIO_REGISTRO

        FileChannel.open(ruta, StandardOpenOption.READ).use { canal ->
            // Si el fichero es más pequeño que el offset, ese ID nunca se ha escrito
            if (canal.size() < offset + TAMANIO_REGISTRO) {
                return null
            }

            canal.position(offset)
            val buffer = ByteBuffer.allocate(TAMANIO_REGISTRO.toInt())
            canal.read(buffer)
            buffer.flip()

            val leidoId = buffer.getInt()
            // Si el ID es -1 o 0 significa que está borrado o vacío
            if (leidoId <= 0) return null

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
     * Recorre todo el archivo de 76 en 76 bytes y devuelve los videojuegos válidos.
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

                // Si el ID es válido (> 0), no es un registro borrado ni vacío
                if (id > 0) {
                    lista.add(Videojuego(id, titulo, genero, anio, nota))
                }

                buffer.clear() // Limpiamos el buffer para la siguiente lectura
            }
        }

        return lista
    }

    /**
     * Modifica los datos de un videojuego en su posición existente en disco.
     */
    fun actualizar(videojuego: Videojuego, ruta: Path): Boolean {
        val existente = leerPorId(videojuego.id, ruta) ?: return false
        guardar(videojuego, ruta)
        return true
    }

    /**
     * Borrado logico mediante valor centinela (ID = -1) para preservar el esquema de offsets.
     */
    fun eliminarLogico(id: Int, ruta: Path): Boolean {
        val juego = leerPorId(id, ruta) ?: return false
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
}

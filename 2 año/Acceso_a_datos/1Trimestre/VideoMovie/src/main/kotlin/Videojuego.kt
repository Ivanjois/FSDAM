import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.serialization.Serializable

/**
 * Modelo de datos unificado que representa un videojuego para todo el proyecto.
 * Compatible con CSV, XML (Jackson), JSON (kotlinx.serialization) y Ficheros Binarios.
 */
@Serializable
data class Videojuego(
    @JsonProperty("id") val id: Int,
    @JsonProperty("titulo") var titulo: String,
    @JsonProperty("genero") var genero: String,
    @JsonProperty("anio") var anio: Int,
    @JsonProperty("nota") var nota: Double
)

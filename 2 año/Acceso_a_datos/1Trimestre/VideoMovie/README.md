# VideoMovie - Catalogo de Videojuegos (Unidad 2: Persistencia en Ficheros)

Proyecto integral de gestion y persistencia de catalogos de videojuegos desarrollado en **Kotlin** con **Gradle** para el modulo de **Acceso a Datos** (2º DAM).

El proyecto abarca desde el manejo basico de rutas con `java.nio.file` hasta la implementacion de acceso aleatorio a ficheros binarios mediante `FileChannel` y `ByteBuffer`, pasando por formatos estructurados de intercambio (**CSV**, **XML** y **JSON**) y motores de conversion cruzada.

---

## 1. Estructura de Datos del Modelo

El modelo de datos central de la aplicacion representa un videojuego con la siguiente estructura:

```kotlin
data class Videojuego(
    val id: Int,
    var titulo: String,
    var genero: String,
    var anio: Int,
    var nota: Double
)
```

---

## 2. Diseno del Registro Binario de Tamano Fijo (76 Bytes)

Para el almacenamiento en ficheros binarios de **acceso aleatorio**, cada registro de videojuego ocupa exactamente **76 bytes**, garantizando un tiempo de acceso directo $O(1)$ sin necesidad de recorrer el archivo secuencialmente.

### Desglose y mapa de memoria:

| Campo | Tipo Kotlin | Tamano en Bytes | Rango de Bytes (Offset relativo) | Descripcion / Empaquetado |
| :--- | :--- | :---: | :---: | :--- |
| `id` | `Int` | **4 bytes** | `0 .. 3` | Identificador numerico (`buffer.putInt(id)`) |
| `titulo` | `String` | **40 bytes** | `4 .. 43` | Texto UTF-8 limitado a 40 bytes, relleno con espacios |
| `genero` | `String` | **20 bytes** | `44 .. 63` | Texto UTF-8 limitado a 20 bytes, relleno con espacios |
| `anio` | `Int` | **4 bytes** | `64 .. 67` | Anio de lanzamiento (`buffer.putInt(anio)`) |
| `nota` | `Double` | **8 bytes** | `68 .. 75` | Puntuacion decimal (`buffer.putDouble(nota)`) |
| **TOTAL** | | **76 bytes** | `0 .. 75` | Tamano total exacto de cada registro |

### Formula matematica de acceso directo:
$$\text{Desplazamiento (Offset)} = (\text{ID} - 1) \times 76\text{ bytes}$$

Para leer o sobrescribir un registro con `ID = 5`, el cabezal del canal salta directamente a la posicion $(5 - 1) \times 76 = 304$ bytes mediante `canal.position(304L)`.

---

## 3. Decisiones de Diseno y Justificaciones Tecnicas

1. **Longitud fija de 40 bytes para el Titulo:**
   * El titulo mas largo del catalogo de prueba (*"The Legend of Zelda: Breath of the Wild"*) contiene 39 caracteres. Reservar 40 bytes cubre holgadamente titulos extensos manteniendo un consumo contenido de almacenamiento.

2. **Longitud fija de 20 bytes para el Genero:**
   * Generos compuestos como *"Mundo Abierto"* o *"Accion RPG"* caben con margen suficiente en 20 bytes.

3. **Estrategia defensiva de tamano fijo (`padEnd` y `minOf` / `take`):**
   * Si una cadena mide menos de la longitud fijada, se rellena con espacios en blanco (`padEnd`) para no descuadrar el offset.
   * Si una cadena supera la longitud fijada, se trunca (`take` / `minOf`) para evitar el desbordamiento del buffer (`BufferOverflowException`) y prevenir la corrupcion de registros adyacentes.
   * Al leer del disco, se aplica `.trim()` para eliminar los espacios residuales.

4. **Uso de `buffer.flip()` y `buffer.clear()`:**
   * Tras volcar los datos en el `ByteBuffer`, se invoca obligatoriamente `buffer.flip()` para resetear la posicion a 0 y fijar el limite en 76 antes de escribir en el `FileChannel`.
   * En lecturas continuadas, se usa `buffer.clear()` para reiniciar el buffer a su capacidad completa.

5. **Borrado Logico vs Borrado Fisico:**
   * En ficheros de acceso aleatorio con tamano fijo, eliminar fisicamente 76 bytes intermedios obligaria a reescribir y desplazar todo el archivo posterior, penalizando el rendimiento.
   * Se opta por el **borrado logico**: se sobrescribe el registro marcando su `ID = -1`. Al listar o buscar, el repositorio descarta aquellos registros cuyo ID sea menor o igual a 0.

---

## 4. Estructura del Proyecto por Actividades

El proyecto esta organizado de forma modular e independiente por paquetes:

```text
src/main/kotlin/
├── actividad01/       --> Practica 1: Verificacion de entorno Gradle y compilador Kotlin.
├── actividad02/       --> Practica 2: Gestion de directorios (datos_ini, datos_fin) y arbol con Files.walk.
├── actividad03/       --> Practica 3: CRUD interactivo sobre ficheros CSV usando kotlin-csv.
├── actividad04/       --> Practica 4: Deserializacion y lectura de ficheros XML con Jackson XML.
├── actividad05/       --> Practica 5: Deserializacion y lectura de ficheros JSON con Kotlinx Serialization.
├── actividad06/       --> Practica 6: Motor de conversion bidireccional entre CSV, XML y JSON.
└── actividad07/       --> Practica 7: CRUD y acceso aleatorio en fichero binario (.dat) con FileChannel.
```

---

## 5. Directorios de Datos

* **`datos/datos_ini/`**: Ficheros fuente de prueba:
  * `videojuegos.csv`: Delimitado por punto y coma (`;`).
  * `videojuegos.xml`: Estructura jerarquica envuelta en `<videojuegos>`.
  * `videojuegos.json`: Array JSON de objetos `@Serializable`.
* **`datos/datos_fin/`**: Ficheros generados por la aplicacion:
  * Ficheros convertidos de la Actividad 6.
  * `videojuegos_aleatorio.dat`: Fichero binario de registros de 76 bytes de la Actividad 7.

---

## 6. Dependencias Utilizadas (`build.gradle.kts`)

```kotlin
plugins {
    kotlin("jvm") version "2.4.10"
    kotlin("plugin.serialization") version "2.4.10"
    application
}

dependencies {
    // 1. kotlin-csv para parsing y escritura rapida de CSV
    implementation("com.github.doyaaaaaken:kotlin-csv-jvm:1.9.1")

    // 2. Jackson Dataformat XML para serializacion/deserializacion XML
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.17.0")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.17.0")

    // 3. Kotlinx Serialization para JSON de alto rendimiento
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")
}
```

---

## 7. Instrucciones de Compilacion y Ejecucion

### Requisitos:
* **JDK 21** o superior instalado y configurado.
* **Gradle Wrapper** (incluido en el repositorio).
* **IntelliJ IDEA** (recomendado).

### Ejecucion desde IntelliJ IDEA:
1. Abrir el proyecto en IntelliJ IDEA y permitir que Gradle sincronice las dependencias.
2. Navegar a cualquier paquete (`actividad01` a `actividad07`).
3. Abrir su archivo `Main.kt` respectivo y pulsar el boton verde **Run ▶️** situado al lado de `fun main()`.

### Ejecucion desde Terminal:
```bash
# Compilar todo el proyecto
./gradlew compileKotlin

# Ejecutar la aplicacion principal
./gradlew run
```

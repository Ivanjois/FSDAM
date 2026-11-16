# Reto 2 y Reto 3 - Sprint 1 (Kotlin)

Subproyecto independiente en Kotlin con las soluciones de los **Retos 2 y 3** de *Desarrollo de Interfaces*.

## Estructura

```text
Reto2_Reto3/
├── src/
│   ├── reto2.kt   # 7 ejercicios de fundamentos de Kotlin
│   └── reto3.kt   # 3 ejercicios (validación de contraseña, temperaturas y null safety)
└── README.md
```

## Compilación y ejecución desde consola (`kotlinc`)

Desde la carpeta raíz `Reto2_Reto3/`:

### Reto 2

```powershell
C:\Users\ivana\kotlinc\bin\kotlinc.BAT src\reto2.kt -include-runtime -d out\reto2.jar
java -jar out\reto2.jar
```

### Reto 3

```powershell
C:\Users\ivana\kotlinc\bin\kotlinc.BAT src\reto3.kt -include-runtime -d out\reto3.jar
java -jar out\reto3.jar
```

> **Nota sobre consola en Windows:** si deseas asegurar caracteres Unicode (`ñ`, tildes) correctamente en PowerShell/CMD, puedes ejecutar `chcp 65001` y pasar `"-Dfile.encoding=UTF-8"` (entre comillas en PowerShell) a `java` (por ejemplo: `java "-Dfile.encoding=UTF-8" -jar out\reto3.jar`).

## Ejecución desde IntelliJ IDEA / Android Studio

1. Abre la carpeta `Reto2_Reto3` como proyecto o abre directamente `src/reto2.kt` y `src/reto3.kt`.
2. Configura el SDK de Java (JDK 17 o superior) y el compilador de Kotlin si el IDE lo solicita.
3. Pulsa el icono verde **Run (`▶`)** junto a `fun main()` en `reto2.kt` o `reto3.kt`.

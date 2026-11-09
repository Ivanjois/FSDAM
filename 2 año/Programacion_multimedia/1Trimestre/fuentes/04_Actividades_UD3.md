# Actividades de la Unidad Didáctica 3: Introducción a Android
**Módulo:** Programación Multimedia y Dispositivos Móviles (PMDM)  
**Curso:** 2º CFGS DAM  

---

## Actividad 0 – Contador de clics
- **Objetivo:** Recrear la aplicación introductoria *Contador de clics* vista a lo largo de los apuntes teóricos para afianzar el uso de `@Composable`, layouts (`Column`), `Text`, `Button`, y la gestión reactiva del estado con `rememberSaveable`.

---

## Actividad 1 – Estadísticas
- **Nombre del proyecto en Android Studio:** `StatisticsTuNombre` (ejemplo: `StatisticsIvan`).
- **Descripción:** Llevar el recuento de personas, patinetes, bicicletas y coches que pasan por una calle.
- **Requisitos funcionales y de UI:**
  1. Título superior: `"Estadísticas TuNombre"`.
  2. Cada categoría (Personas, Patinetes, Bicicletas, Coches) dispone de:
     - Botón para sumar uno (`+1`).
     - Botón para restar uno (`-1`).
     - Botón individual para reiniciar dicho contador.
  3. Visualización del recuento numérico y del porcentaje sobre el total para cada categoría.
  4. Contador del total global acumulado.
  5. Botón general para reiniciar todos los contadores a cero.
  6. Organización mediante composición de `Column` (vertical) y `Row` (filas horizontales).
  7. Personalización de color en botones mediante `ButtonDefaults.buttonColors()` y la clase `Color` (predefinidos o hexadecimales `Color(0xFF...)`).

---

## Actividad 2 – Conversor binario
- **Nombre del proyecto en Android Studio:** `ConversorTuNombre` (ejemplo: `ConversorIvan`).
- **Descripción:** Generador de números decimales aleatorios y conversión a binario y hexadecimal.
- **Requisitos funcionales y de UI:**
  1. Botón generador: al pulsarlo, genera un número decimal aleatorio entero entre 1 y 10.000 y lo muestra por pantalla.
  2. Botón para convertir a **binario**.
  3. Botón para convertir a **hexadecimal**.
  4. Al pulsar uno de estos botones se muestra la representación en la base elegida.
  5. Botón de borrado / reset que limpia todos los números de la pantalla.
  6. Texto en la parte inferior de la pantalla con el nombre del alumno.

---

## Actividad 3 – Contador pádel
- **Nombre del proyecto en Android Studio:** `PadelScoreTuNombre` (ejemplo: `PadelScoreIvan`).
- **Descripción:** Marcador digital de tanteo para un partido de pádel con lógica oficial de puntuación.
- **Requisitos funcionales y de UI:**
  1. **Controles principales:**
     - Botón para sumar puntos al **Equipo A**.
     - Botón para sumar puntos al **Equipo B**.
     - Botón general de reset para reiniciar todo a cero.
  2. **Reglamento del partido:**
     - Se juega al **mejor de 3 sets** (el primer equipo en ganar 2 sets se proclama vencedor).
     - Al ganar un equipo 2 sets, se congela el marcador y no se pueden sumar más puntos hasta pulsar el botón de reinicio.
     - **Puntuación de juego:** Progresión `0 → 15 → 30 → 40`. Si un equipo con 40 gana el siguiente punto, se anota el juego.
     - **Punto de oro:** Si se empata a `40 - 40`, el equipo que gane el siguiente punto se lleva directamente el juego (sin ventajas tradicionales).
     - **Set:** Para ganar un set se deben conseguir 6 juegos con diferencia mínima de 2 juegos (ej. `6 - 4`). En caso de `6 - 5`, el set continúa hasta `7 - 5` o `7 - 6`.
     - **Tie-break:** Si se empata a `6 - 6` juegos, se disputa un tie-break donde los puntos se contabilizan de 1 en 1. Gana el primer equipo en alcanzar **7 puntos** con una diferencia mínima de 2 puntos (ej. `7 - 5`, `8 - 6`).
  3. **Estructura visual:** Combinación anidada de `Column` y `Row`, aplicando alineaciones (`Arrangement.SpaceBetween`, `Alignment.CenterHorizontally`, etc.).
  4. **Internacionalización obligatoria:** La aplicación debe ser **multi-idioma**, soportando:
     - Castellano (`es`)
     - Valenciano / Catalán (`ca` o `va`)
     - Inglés (`en`)

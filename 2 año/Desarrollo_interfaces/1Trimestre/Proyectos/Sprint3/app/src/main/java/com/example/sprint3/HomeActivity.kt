package com.example.sprint3

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sprint3.databinding.ActivityHomeBinding

/**
 * Reto 7 — Pantalla principal (HomeActivity) sobre La Velada de Ibai 2027.
 *
 * PRINCIPIOS DE DISEÑO UI, UX, ACCESIBILIDAD Y BUENAS PRÁCTICAS APLICADOS:
 *
 * 1. Principios de diseño visual (CRAP):
 *    - Contraste (Contrast): Se diferencia claramente la jerarquía visual mediante tamaños,
 *      pesos tipográficos y color. El título principal (26sp, negrita, blanco cálido #F8FAFC)
 *      destaca sobre el fondo oscuro (#0F172A / #1E293B), el subtítulo usa un tono suave
 *      (#CBD5E1) para lectura cómoda y el botón principal ("Reservar entradas") emplea un
 *      degradado cálido de alto contraste frente al botón secundario con borde sutil.
 *    - Repetición (Repetition): Se mantienen radios de esquina consistentes (14dp-20dp),
 *      bordes dorados de acento (#F59E0B) en los elementos destacados (badge, marco de imagen,
 *      botones) y la misma paleta en toda la aplicación (HomeActivity, DetailActivity y MyCard).
 *    - Alineación (Alignment): Los elementos de la tarjeta principal siguen un eje central
 *      coherente con márgenes uniformes (20dp en el contenedor exterior y espaciados regulares)
 *      para transmitir orden visual sin elementos desplazados al azar.
 *    - Proximidad (Proximity): Se agrupa la identidad del evento (etiqueta, ilustración, título,
 *      subtítulo y fecha) dentro de una tarjeta común (@drawable/bg_velada_card) y se separa
 *      con mayor margen superior (24dp) del bloque de acciones interactivas.
 *
 * 2. Principios de experiencia de usuario (UX):
 *    - Ley de Hick: Se reduce la carga cognitiva mostrando solo dos acciones claras (acción
 *      principal de reserva y acceso secundario a cartelera/detalles), evitando saturar la pantalla.
 *    - Ley de Fitts: Los botones ocupan todo el ancho disponible de la tarjeta y tienen altura
 *      generosa (>= 48dp / 52dp), facilitando la pulsación cómoda con el pulgar.
 *    - Ley de Jakob: Se sigue una estructura familiar de pantalla de evento/portada (insignia,
 *      imagen protagonista, título, descripción breve y botón de llamada a la acción abajo).
 *    - Ley de Miller y Efecto Estética-Usabilidad: Información dividida en bloques breves y
 *      agradables a la vista, pero priorizando siempre que cada texto y botón sea legible y claro.
 *
 * 3. Accesibilidad (POUR / WCAG 2.2 AA):
 *    - Perceptible: La imagen temática incluye `android:contentDescription` descriptiva desde
 *      `strings.xml` para TalkBack. El contraste entre texto y fondo supera el mínimo 4.5:1.
 *    - Operable: Todos los controles interactivos usan componentes estándar (`AppCompatButton`
 *      con rol de botón nativo para lectores de pantalla), área táctil mínima >= 48dp y
 *      separación suficiente (12dp) entre botones para evitar pulsaciones accidentales.
 *    - Comprensible: El título principal está marcado con `android:accessibilityHeading="true"`
 *      y el orden en el XML coincide con el flujo lógico de lectura arriba-abajo.
 *    - Robusto: Todos los textos usan unidades escalables `sp` con `layout_height="wrap_content"`
 *      y un `ScrollView` raíz para que, si la persona usuaria aumenta el tamaño de fuente en
 *      Ajustes del dispositivo, nada se corte ni quede inaccesible.
 *
 * 4. Buenas prácticas de desarrollo Android:
 *    - Uso de ViewBinding (`ActivityHomeBinding`) en lugar de `findViewById`.
 *    - Externalización de cadenas en `res/values/strings.xml` y colores en `res/values/colors.xml`.
 *    - Personalización limpia mediante recursos `<shape>` XML en `res/drawable/`
 *      (`bg_velada_card`, `bg_imagen_marco`, `bg_badge_evento`, `bg_boton_principal`, `bg_boton_secundario`).
 *    - Gestión correcta de barras del sistema (`enableEdgeToEdge` + `WindowInsetsCompat`).
 */
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Respetamos las barras del sistema (estado y navegación) sin recortar el scroll
        binding.homeRootScroll.clipToPadding = false
        ViewCompat.setOnApplyWindowInsetsListener(binding.homeRootScroll) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Botón principal (Reto 7): muestra un Toast indicando que todavía no está implementado
        binding.btnEntradas.setOnClickListener {
            Toast.makeText(
                this,
                getString(R.string.toast_no_implementado),
                Toast.LENGTH_SHORT
            ).show()
        }

        // Botón secundario: permite navegar a DetailActivity para probar el componente MyCard (Reto 9)
        binding.btnVerDetalles.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            startActivity(intent)
        }
    }
}

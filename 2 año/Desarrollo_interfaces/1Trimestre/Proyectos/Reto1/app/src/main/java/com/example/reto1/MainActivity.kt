// Paquete principal de la app (debe coincidir con el namespace de build.gradle)
package com.example.reto1

import android.os.Bundle
import android.webkit.WebViewClient
import android.widget.SeekBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.reto1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Permite que la pantalla ocupe hasta los bordes del móvil (debajo de hora y batería)
        enableEdgeToEdge()
        // ViewBinding: conecta directamente los IDs del XML con Kotlin sin usar findViewById
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configuramos el WebView para que muestre la web oficial de Android dentro de la app
        binding.webView.settings.javaScriptEnabled = true // Activa JavaScript para que la web cargue bien
        binding.webView.webViewClient = WebViewClient()   // Mantiene la navegación dentro de la app (no abre Chrome)
        binding.webView.loadUrl("https://developer.android.com") // Dirección web que se carga al abrir la pantalla

        // Funcionalidad 1 (Reto 5): detectamos qué CheckBox marca el usuario en tiempo real
        configurarCheckBoxes()

        // Funcionalidad 2 (Reto 5): actualizamos el texto del nivel al mover la barra SeekBar
        configurarSeekBar()

        // Funcionalidad 3 (Reto 5): al pulsar guardar mostramos todo el resumen en pantalla
        configurarBotonesGuardar()
    }

    /**
     * Conecta los dos botones de guardar para que muestren un Toast y el resumen
     * completo del formulario (nombre, tecnologías, modalidad, notificaciones, curso y nivel).
     */
    private fun configurarBotonesGuardar() {
        listOf(binding.btnGuardar, binding.btnGuardar2).forEach { boton ->
            boton.setOnClickListener {
                mostrarResumenCompleto()
                Toast.makeText(this, "Información guardada", Toast.LENGTH_SHORT).show()
            }
        }
    }

    /**
     * Recoge el estado de todos los controles del formulario mediante ViewBinding
     * y lo pinta en el TextView inferior.
     */
    private fun mostrarResumenCompleto() {
        val nombre = binding.etNombre.text.toString().trim().ifEmpty { "Sin especificar" }
        val tecnologias = obtenerTecnologiasSeleccionadas()
        val modalidad = when (binding.rgModalidad.checkedRadioButtonId) {
            R.id.rbPresencial -> binding.rbPresencial.text.toString()
            R.id.rbOnline -> binding.rbOnline.text.toString()
            R.id.rbMixta -> binding.rbMixta.text.toString()
            else -> "Sin especificar"
        }
        val notificaciones = if (binding.switchNotificaciones.isChecked) "Sí" else "No"
        val curso = binding.spinnerCurso.selectedItem?.toString() ?: "Sin curso"
        val nivel = binding.seekNivel.progress

        binding.txtResultado.text = """
            Nombre: $nombre
            Tecnologías: $tecnologias
            Modalidad: $modalidad
            Notificaciones: $notificaciones
            Curso: $curso
            Nivel: $nivel%
        """.trimIndent()
    }

    /**
     * Configura el listener del SeekBar usando ViewBinding.
     * Cada vez que el usuario desliza la barra, actualiza txtNivel con el porcentaje actual.
     */
    private fun configurarSeekBar() {
        binding.seekNivel.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                binding.txtNivel.text = "Nivel seleccionado: $progress%"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // No hace falta acción al empezar a pulsar la barra
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // No hace falta acción al soltar la barra
            }
        })
    }

    /**
     * Conecta los tres CheckBox de tecnologías con un mismo listener usando ViewBinding.
     * Cada vez que el usuario marca o desmarca una casilla, se actualiza txtResultado.
     */
    private fun configurarCheckBoxes() {
        val checkBoxes = listOf(binding.cbAndroid, binding.cbReact, binding.cbFlutter)

        // Recorremos las tres casillas para no repetir el mismo setOnCheckedChangeListener tres veces
        checkBoxes.forEach { checkBox ->
            checkBox.setOnCheckedChangeListener { _, _ ->
                actualizarTextoTecnologias()
            }
        }
    }

    /**
     * Construye el texto con las tecnologías marcadas y lo muestra en el TextView inferior.
     */
    private fun actualizarTextoTecnologias() {
        binding.txtResultado.text = "Tecnologías seleccionadas: ${obtenerTecnologiasSeleccionadas()}"
    }

    /**
     * Devuelve un texto legible con los CheckBox marcados o "ninguna" si no hay ninguno.
     */
    private fun obtenerTecnologiasSeleccionadas(): String {
        val seleccionadas = mutableListOf<String>()

        if (binding.cbAndroid.isChecked) seleccionadas.add(binding.cbAndroid.text.toString())
        if (binding.cbReact.isChecked) seleccionadas.add(binding.cbReact.text.toString())
        if (binding.cbFlutter.isChecked) seleccionadas.add(binding.cbFlutter.text.toString())

        return if (seleccionadas.isEmpty()) "ninguna" else seleccionadas.joinToString(", ")
    }
}
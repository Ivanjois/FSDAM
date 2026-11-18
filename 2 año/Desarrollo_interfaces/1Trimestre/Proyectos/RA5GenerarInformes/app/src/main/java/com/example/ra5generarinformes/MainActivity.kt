package com.example.ra5generarinformes

import android.content.Intent
import android.graphics.Color
import android.graphics.Paint
import android.graphics.pdf.PdfDocument
import android.net.Uri
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONArray
import kotlin.math.min

/**
 * Actividad principal que carga ofertas desde JSON, permite filtrarlas por ciudad,
 * muestra un informe estadístico con gráfico de barras y lo exporta a PDF.
 */
class MainActivity : AppCompatActivity() {

    // Referencias a los componentes visuales de activity_main.xml
    private lateinit var spinnerCiudad: Spinner
    private lateinit var botonGenerarInforme: Button
    private lateinit var botonExportarPdf: Button
    private lateinit var contenedorInforme: LinearLayout
    private lateinit var textoCiudadSeleccionada: TextView
    private lateinit var textoNumeroOfertas: TextView
    private lateinit var textoSalarioTotal: TextView
    private lateinit var textoSalarioMedio: TextView
    private lateinit var textoSalarioMaximo: TextView
    private lateinit var barraValencia: ProgressBar
    private lateinit var barraMadrid: ProgressBar
    private lateinit var barraAlicante: ProgressBar
    private lateinit var textoCantidadValencia: TextView
    private lateinit var textoCantidadMadrid: TextView
    private lateinit var textoCantidadAlicante: TextView
    private lateinit var contenedorOfertas: LinearLayout

    // Lista completa de ofertas cargadas en memoria y código de petición para crear el PDF
    private val ofertas = ArrayList<Oferta>()
    private val codigoCrearPdf = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Fase 5: enlazamos cada propiedad Kotlin con su componente del XML
        spinnerCiudad = findViewById(R.id.spinnerCiudad)
        botonGenerarInforme = findViewById(R.id.botonGenerarInforme)
        botonExportarPdf = findViewById(R.id.botonExportarPdf)
        contenedorInforme = findViewById(R.id.contenedorInforme)
        textoCiudadSeleccionada = findViewById(R.id.textoCiudadSeleccionada)
        textoNumeroOfertas = findViewById(R.id.textoNumeroOfertas)
        textoSalarioTotal = findViewById(R.id.textoSalarioTotal)
        textoSalarioMedio = findViewById(R.id.textoSalarioMedio)
        textoSalarioMaximo = findViewById(R.id.textoSalarioMaximo)
        barraValencia = findViewById(R.id.barraValencia)
        barraMadrid = findViewById(R.id.barraMadrid)
        barraAlicante = findViewById(R.id.barraAlicante)
        textoCantidadValencia = findViewById(R.id.textoCantidadValencia)
        textoCantidadMadrid = findViewById(R.id.textoCantidadMadrid)
        textoCantidadAlicante = findViewById(R.id.textoCantidadAlicante)
        contenedorOfertas = findViewById(R.id.contenedorOfertas)

        // Fase 6 y 7: inicializamos el selector de ciudades y cargamos las ofertas desde assets
        configurarSpinner()
        ofertas.addAll(cargarOfertas())

        // Fase 8: filtramos y mostramos el informe al pulsar "Generar informe"
        botonGenerarInforme.setOnClickListener {
            val ciudadSeleccionada = spinnerCiudad.selectedItem.toString()
            val ofertasFiltradas = filtrarOfertasPorCiudad(ciudadSeleccionada)
            mostrarResultado(ciudadSeleccionada, ofertasFiltradas)
        }

        // Fase 12: actualizamos el informe y esperamos al layout antes de abrir el selector PDF
        botonExportarPdf.setOnClickListener {
            val ciudadSeleccionada = spinnerCiudad.selectedItem.toString()
            val ofertasFiltradas = filtrarOfertasPorCiudad(ciudadSeleccionada)
            mostrarResultado(ciudadSeleccionada, ofertasFiltradas)
            contenedorInforme.post {
                abrirSelectorParaGuardarPdf()
            }
        }
    }

    /**
     * Fase 13: recibe la Uri elegida por el usuario en el selector del sistema y exporta el PDF.
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == codigoCrearPdf && resultCode == RESULT_OK) {
            val uriPdf = data?.data
            if (uriPdf != null) {
                exportarInformePdf(uriPdf)
            }
        }
    }

    /**
     * Fase 6: configura el Spinner con las opciones de filtrado por ciudad.
     */
    private fun configurarSpinner() {
        val ciudades = arrayOf("Todas", "Valencia", "Madrid", "Alicante")
        val adaptador = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            ciudades
        )
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCiudad.adapter = adaptador
    }

    /**
     * Fase 7: lee app/src/main/assets/ofertas.json y convierte cada objeto JSON en un objeto Oferta.
     */
    private fun cargarOfertas(): ArrayList<Oferta> {
        val listaOfertas = ArrayList<Oferta>()
        val textoJson = assets.open("ofertas.json").bufferedReader().use { it.readText() }
        val arrayJson = JSONArray(textoJson)

        for (i in 0 until arrayJson.length()) {
            val objetoJson = arrayJson.getJSONObject(i)
            val oferta = Oferta(
                objetoJson.getInt("id"),
                objetoJson.getString("puesto"),
                objetoJson.getString("empresa"),
                objetoJson.getString("ciudad"),
                objetoJson.getInt("salario")
            )
            listaOfertas.add(oferta)
        }
        return listaOfertas
    }

    /**
     * Fase 8: devuelve todas las ofertas o únicamente las pertenecientes a la ciudad indicada.
     */
    private fun filtrarOfertasPorCiudad(ciudad: String): List<Oferta> {
        val resultado = if (ciudad == "Todas") {
            ofertas
        } else {
            ofertas.filter {
                it.ciudad == ciudad
            }
        }
        return resultado
    }

    /**
     * Fases 9 y 10: calcula totales, media y máximo, actualiza el gráfico y genera el listado numerado.
     */
    private fun mostrarResultado(ciudad: String, ofertasFiltradas: List<Oferta>) {
        // Cálculos estadísticos sobre la lista filtrada
        val numeroOfertas = ofertasFiltradas.size
        val salarioTotal = ofertasFiltradas.sumOf { it.salario }
        val salarioMedio = if (ofertasFiltradas.size > 0) {
            ofertasFiltradas.map { it.salario }.average()
        } else {
            0.0
        }
        val salarioMaximo = ofertasFiltradas.maxOfOrNull { it.salario } ?: 0

        // Actualizamos los TextView del resumen
        textoCiudadSeleccionada.text = "Ciudad seleccionada: $ciudad"
        textoNumeroOfertas.text = "Numero de ofertas: $numeroOfertas"
        textoSalarioTotal.text = "Salario total: ${formatearSalario(salarioTotal)}"
        textoSalarioMedio.text = "Salario medio: ${formatearSalario(salarioMedio.toInt())}"
        textoSalarioMaximo.text = "Salario maximo: ${formatearSalario(salarioMaximo)}"

        // Actualizamos las barras del gráfico
        mostrarGrafico(ofertasFiltradas)

        // Limpiamos el listado anterior y añadimos cada oferta numerada dinámicamente
        contenedorOfertas.removeAllViews()
        ofertasFiltradas.forEachIndexed { indice, oferta ->
            val textoOferta = TextView(this)
            textoOferta.text = "${indice + 1}. ${oferta.puesto}\n" +
                    "${oferta.empresa} · ${oferta.ciudad} · ${formatearSalario(oferta.salario)}"
            textoOferta.textSize = 16f
            textoOferta.setPadding(0, 0, 0, 24)
            contenedorOfertas.addView(textoOferta)
        }
    }

    /**
     * Fase 12: abre el selector nativo de Android para que el usuario elija dónde guardar el PDF.
     */
    private fun abrirSelectorParaGuardarPdf() {
        val intent = Intent(Intent.ACTION_CREATE_DOCUMENT)
        intent.addCategory(Intent.CATEGORY_OPENABLE)
        intent.type = "application/pdf"
        intent.putExtra(Intent.EXTRA_TITLE, "informe_ofertas.pdf")
        startActivityForResult(intent, codigoCrearPdf)
    }

    /**
     * Fase 14: crea un documento PDF A4, dibuja el título y la vista del informe, y lo guarda en la Uri.
     */
    private fun exportarInformePdf(uriPdf: Uri) {
        val documentoPdf = PdfDocument()
        val pagina = PdfDocument.PageInfo.Builder(595, 842, 1).create()
        val paginaPdf = documentoPdf.startPage(pagina)
        val canvas = paginaPdf.canvas

        // Fondo blanco y título superior del documento PDF
        val pinturaTitulo = Paint()
        pinturaTitulo.color = Color.BLACK
        pinturaTitulo.textSize = 24f
        pinturaTitulo.isFakeBoldText = true

        canvas.drawColor(Color.WHITE)
        canvas.drawText("Informe de ofertas", 32f, 48f, pinturaTitulo)

        // Escalamos contenedorInforme para que quepa completo dentro de la página A4
        val anchoDisponible = 531f
        val altoDisponible = 760f
        val anchoInforme = contenedorInforme.width
        val altoInforme = contenedorInforme.height

        if (anchoInforme > 0 && altoInforme > 0) {
            val escala = min(anchoDisponible / anchoInforme, altoDisponible / altoInforme)
            canvas.save()
            canvas.translate(32f, 72f)
            canvas.scale(escala, escala)
            contenedorInforme.draw(canvas)
            canvas.restore()
        }

        documentoPdf.finishPage(paginaPdf)

        // Escribimos el PDF en el destino elegido por el usuario
        try {
            val salida = contentResolver.openOutputStream(uriPdf)
            if (salida != null) {
                salida.use {
                    documentoPdf.writeTo(salida)
                }
                Toast.makeText(this, "PDF guardado", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "No se pudo guardar el PDF", Toast.LENGTH_LONG).show()
            }
        } catch (e: Exception) {
            Toast.makeText(this, "No se pudo guardar el PDF", Toast.LENGTH_LONG).show()
        } finally {
            documentoPdf.close()
        }
    }

    /**
     * Fase 11: cuenta las ofertas por ciudad y actualiza los tres ProgressBar y sus contadores.
     */
    private fun mostrarGrafico(ofertasFiltradas: List<Oferta>) {
        val ofertasValencia = ofertasFiltradas.count { it.ciudad == "Valencia" }
        val ofertasMadrid = ofertasFiltradas.count { it.ciudad == "Madrid" }
        val ofertasAlicante = ofertasFiltradas.count { it.ciudad == "Alicante" }

        // Evitamos max = 0 usando 1 como mínimo
        val valorMaximo = maxOf(ofertasValencia, ofertasMadrid, ofertasAlicante, 1)
        barraValencia.max = valorMaximo
        barraMadrid.max = valorMaximo
        barraAlicante.max = valorMaximo

        barraValencia.progress = ofertasValencia
        barraMadrid.progress = ofertasMadrid
        barraAlicante.progress = ofertasAlicante

        textoCantidadValencia.text = ofertasValencia.toString()
        textoCantidadMadrid.text = ofertasMadrid.toString()
        textoCantidadAlicante.text = ofertasAlicante.toString()
    }

    /**
     * Formatea un salario entero con separador de miles por punto y el símbolo de euro.
     */
    private fun formatearSalario(salario: Int): String {
        return "%,d".format(salario).replace(",", ".") + " €"
    }
}

package com.example.sprint3

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sprint3.databinding.ActivityDetailBinding

/**
 * Reto 9 — Pantalla de detalle (DetailActivity) que implementa el componente personalizado [MyCard].
 *
 * Configura varias instancias de [MyCard] mediante ViewBinding ([ActivityDetailBinding]),
 * asignando título, subtítulo, descripción, imagen e interacción de forma programática.
 */
class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.detailRootScroll.clipToPadding = false
        ViewCompat.setOnApplyWindowInsetsListener(binding.detailRootScroll) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        configurarTarjetas()

        binding.btnVolverHome.setOnClickListener {
            finish()
        }
    }

    private fun configurarTarjetas() {
        // Tarjeta 1: Combate Estelar (imagen asignada por recurso drawable programáticamente)
        binding.cardCombate.apply {
            titulo = getString(R.string.detail_card1_titulo)
            subtitulo = getString(R.string.detail_card1_subtitulo)
            descripcion = getString(R.string.detail_card1_descripcion)
            textoBoton = getString(R.string.detail_card1_boton)
            setImagenResource(R.drawable.ic_combate_estelar)
            imagenContentDescription = getString(R.string.cd_detail_card1_imagen)
            setOnAccionClickListener {
                Toast.makeText(
                    this@DetailActivity,
                    getString(R.string.detail_card1_toast),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        // Tarjeta 2: Artistas Invitados (imagen asignada mediante Drawable programáticamente)
        binding.cardMusica.apply {
            titulo = getString(R.string.detail_card2_titulo)
            subtitulo = getString(R.string.detail_card2_subtitulo)
            descripcion = getString(R.string.detail_card2_descripcion)
            textoBoton = getString(R.string.detail_card2_boton)
            val drawableMusica = ContextCompat.getDrawable(this@DetailActivity, R.drawable.ic_musica_concierto)
            setImagenDrawable(drawableMusica)
            imagenContentDescription = getString(R.string.cd_detail_card2_imagen)
            setOnAccionClickListener {
                Toast.makeText(
                    this@DetailActivity,
                    getString(R.string.detail_card2_toast),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        // Tarjeta 3: Entradas y Accesos
        binding.cardEntradas.apply {
            titulo = getString(R.string.detail_card3_titulo)
            subtitulo = getString(R.string.detail_card3_subtitulo)
            descripcion = getString(R.string.detail_card3_descripcion)
            textoBoton = getString(R.string.detail_card3_boton)
            setImagenResource(R.drawable.ic_entradas_estadio)
            imagenContentDescription = getString(R.string.cd_detail_card3_imagen)
            setOnAccionClickListener {
                Toast.makeText(
                    this@DetailActivity,
                    getString(R.string.detail_card3_toast),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}

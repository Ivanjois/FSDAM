package com.example.botonredondeado

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.botonredondeado.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Relaciona esta Activity con activity_main.xml.
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.miCard.titulo = "Android Studio"

        binding.miCard.descripcion =
            "Aprende a crear interfaces Android"

        binding.miCard.textoBoton = "Ver curso"

        binding.miCard.setOnAccionClickListener {

            Toast.makeText(
                this,
                "¡Vamos al curso!",
                Toast.LENGTH_SHORT
            ).show()
        }
        binding.mibutton.setOnAccionClickListener {

            Toast.makeText(
                this,
                "¡Vamos al curso!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}

package com.example.botonredondeado

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.botonredondeado.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configuración de la tarjeta
        binding.miCard.titulo = "Android Studio"
        binding.miCard.descripcion = "Aprende a crear interfaces Android"
        binding.miCard.textoBoton = "Ver curso"

        binding.miCard.setOnAccionClickListener {
            Toast.makeText(this, "¡Vamos al curso!", Toast.LENGTH_SHORT).show()
        }

        // Mostramos el valor inicial de Mybutton (0)
        binding.txtContadorMain.text = binding.mibutton.contador.toString()

        // Escuchamos los cambios del componente Mybutton
        binding.mibutton.setOnCambioListener { nuevoValor, accion ->
            binding.txtContadorMain.text = nuevoValor.toString()
            binding.txtMensajeMain.text = accion
        }
    }
}

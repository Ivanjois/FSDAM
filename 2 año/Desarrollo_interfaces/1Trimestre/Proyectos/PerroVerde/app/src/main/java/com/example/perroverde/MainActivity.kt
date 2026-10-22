package com.example.perroverde

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.perroverde.databinding.ActivityMain2Binding

//import com.example.perroverde.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Para que el contenido no quede debajo de la barra superior/inferior
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, insets ->

            val systemBars =
                insets.getInsets(WindowInsetsCompat.Type.systemBars())

            view.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )

            insets
        }
        assignGroups()

    }

    private fun assignGroups() {
        val grupoA = mutableSetOf<String>()
        val grupoB = mutableSetOf<String>()


        binding.btnConfirmarGrupos.setOnClickListener {

            grupoA.clear()
            grupoB.clear()

            if (binding.cbAnaA.isChecked) {
                grupoA.add("Ana")
            }

            if (binding.cbAnaB.isChecked) {
                grupoB.add("Ana")
            }

            if (binding.cbPabloA.isChecked) {
                grupoA.add("Pablo")
            }

            if (binding.cbPabloB.isChecked) {
                grupoB.add("Pablo")
            }

            if (binding.cbLuisA.isChecked) {
                grupoA.add("Luis")
            }

            if (binding.cbLuisB.isChecked) {
                grupoB.add("Luis")
            }

            if (binding.cbMartaA.isChecked) {
                grupoA.add("Marta")
            }

            if (binding.cbMartaB.isChecked) {
                grupoB.add("Marta")
            }

            if (binding.cbLauraA.isChecked) {
                grupoA.add("Laura")
            }

            if (binding.cbLauraB.isChecked) {
                grupoB.add("Laura")
            }

            if (binding.cbCarlosA.isChecked) {
                grupoA.add("Carlos")
            }

            if (binding.cbCarlosB.isChecked) {
                grupoB.add("Carlos")
            }

            if (binding.cbSofiaA.isChecked) {
                grupoA.add("Sofía")
            }

            if (binding.cbSofiaB.isChecked) {
                grupoB.add("Sofía")
            }

            if (binding.cbJorgeA.isChecked) {
                grupoA.add("Jorge")
            }

            if (binding.cbJorgeB.isChecked) {
                grupoB.add("Jorge")
            }

            if (binding.cbElenaA.isChecked) {
                grupoA.add("Elena")
            }

            if (binding.cbElenaB.isChecked) {
                grupoB.add("Elena")
            }

            if (binding.cbDavidA.isChecked) {
                grupoA.add("David")
            }

            if (binding.cbDavidB.isChecked) {
                grupoB.add("David")
            }
            var listaRepetidos = (grupoA intersect grupoB)


            binding.tvGrupoA.text =
                getString(
                    R.string.grupo_a_personas,
                    grupoA.joinToString(", ")
                )

            binding.tvGrupoB.text =
                getString(
                    R.string.grupo_b_personas,
                    grupoB.joinToString(", ")
                )
            binding.tvRepetidos.text =
                getString(
                    R.string.repetidos,
                    listaRepetidos.joinToString(", ")
                )

        }
    }
}
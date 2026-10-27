package com.example.botonredondeado

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.botonredondeado.databinding.ButtonsBinding

class Mybutton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val binding = ButtonsBinding.inflate(
        LayoutInflater.from(context),
        this,
        true
    )

    val minimo = 0
    var contador = 0
        private set

    private var onCambioListener: ((nuevoValor: Int, accion: String) -> Unit)? = null

    init {
        actualizarEstadoBotones()

        binding.btnmas.setOnClickListener {
            contador++
            actualizarEstadoBotones()
            onCambioListener?.invoke(contador, "Has sumado 1")
        }

        binding.btnmenos.setOnClickListener {
            if (contador > minimo) {
                contador--
                actualizarEstadoBotones()
                onCambioListener?.invoke(contador, "Has restado 1")
            }
        }
    }

    private fun actualizarEstadoBotones() {
        binding.btnmenos.isEnabled = contador > minimo
    }

    fun setOnCambioListener(listener: (nuevoValor: Int, accion: String) -> Unit) {
        this.onCambioListener = listener
    }
}

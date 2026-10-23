package com.example.botonredondeado

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.botonredondeado.databinding.ViewMyCardBinding

class MyCard @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val binding = ViewMyCardBinding.inflate(
        LayoutInflater.from(context),
        this,
        true
    )

    var titulo: String
        get() = binding.txtTitulo.text.toString()
        set(value) {
            binding.txtTitulo.text = value
        }

    var descripcion: String
        get() = binding.txtDescripcion.text.toString()
        set(value) {
            binding.txtDescripcion.text = value
        }

    var textoBoton: String
        get() = binding.btnAccion.text.toString()
        set(value) {
            binding.btnAccion.text = value
        }

    fun setOnAccionClickListener(listener: () -> Unit) {
        binding.btnAccion.setOnClickListener {
            listener()
        }
    }
}

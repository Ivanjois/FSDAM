package com.example.sprint3

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.annotation.DrawableRes
import com.example.sprint3.databinding.ViewMyCardBinding

/**
 * Componente reutilizable de tarjeta (Reto 9).
 *
 * Utiliza ViewBinding ([ViewMyCardBinding]) para acceder de forma segura a sus vistas internas
 * y permite configurar título, subtítulo, descripción, imagen, texto de botón y accesibilidad
 * tanto desde atributos XML como de manera programática en Kotlin.
 */
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

    var subtitulo: String
        get() = binding.txtSubtitulo.text.toString()
        set(value) {
            binding.txtSubtitulo.text = value
            binding.txtSubtitulo.visibility = if (value.isBlank()) View.GONE else View.VISIBLE
        }

    var descripcion: String
        get() = binding.txtDescripcion.text.toString()
        set(value) {
            binding.txtDescripcion.text = value
            binding.txtDescripcion.visibility = if (value.isBlank()) View.GONE else View.VISIBLE
        }

    var textoBoton: String
        get() = binding.btnAccion.text.toString()
        set(value) {
            binding.btnAccion.text = value
            if (value.isBlank()) {
                binding.btnAccion.visibility = View.GONE
            }
        }

    var mostrarBoton: Boolean
        get() = binding.btnAccion.visibility == View.VISIBLE
        set(value) {
            binding.btnAccion.visibility = if (value) View.VISIBLE else View.GONE
        }

    var imagenContentDescription: String?
        get() = binding.imgCard.contentDescription?.toString()
        set(value) {
            binding.imgCard.contentDescription = value
        }

    init {
        if (attrs != null) {
            val typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyCard, defStyleAttr, 0)
            try {
                typedArray.getString(R.styleable.MyCard_myCardTitulo)?.let { titulo = it }
                typedArray.getString(R.styleable.MyCard_myCardSubtitulo)?.let { subtitulo = it }
                typedArray.getString(R.styleable.MyCard_myCardDescripcion)?.let { descripcion = it }

                val imagenResId = typedArray.getResourceId(R.styleable.MyCard_myCardImagen, 0)
                if (imagenResId != 0) {
                    setImagenResource(imagenResId)
                }

                typedArray.getString(R.styleable.MyCard_myCardImagenContentDescription)?.let {
                    imagenContentDescription = it
                }

                typedArray.getString(R.styleable.MyCard_myCardTextoBoton)?.let { textoBoton = it }
                mostrarBoton = typedArray.getBoolean(R.styleable.MyCard_myCardMostrarBoton, true)
            } finally {
                typedArray.recycle()
            }
        }
    }

    /**
     * Asigna una imagen a la tarjeta a partir de un recurso drawable de manera programática.
     */
    fun setImagenResource(@DrawableRes resId: Int) {
        binding.imgCard.visibility = View.VISIBLE
        binding.imgCard.setImageResource(resId)
    }

    /**
     * Asigna una imagen a la tarjeta a partir de un objeto [Drawable] de manera programática.
     */
    fun setImagenDrawable(drawable: Drawable?) {
        binding.imgCard.visibility = View.VISIBLE
        binding.imgCard.setImageDrawable(drawable)
    }

    /**
     * Asigna una imagen a la tarjeta a partir de un [Bitmap] de manera programática.
     */
    fun setImagenBitmap(bitmap: Bitmap) {
        binding.imgCard.visibility = View.VISIBLE
        binding.imgCard.setImageBitmap(bitmap)
    }

    /**
     * Permite mostrar u ocultar la imagen si el diseño concreto de la tarjeta lo requiere.
     */
    fun setImagenVisibility(visible: Boolean) {
        binding.imgCard.visibility = if (visible) View.VISIBLE else View.GONE
    }

    /**
     * Configura la acción a ejecutar cuando el usuario pulsa el botón de la tarjeta.
     */
    fun setOnAccionClickListener(listener: () -> Unit) {
        binding.btnAccion.setOnClickListener {
            listener()
        }
    }
}

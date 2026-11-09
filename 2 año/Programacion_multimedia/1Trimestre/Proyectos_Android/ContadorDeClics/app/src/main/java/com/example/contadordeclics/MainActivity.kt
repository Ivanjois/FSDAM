package com.example.contadordeclics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import com.example.contadordeclics.ui.MyAppContent
import com.example.contadordeclics.ui.screens.ClickCounter

/**
 * Actividad 0 - Contador de Clics
 * Aplicación introductoria desarrollada con Jetpack Compose para
 * ilustrar la gestión básica de estado reactivo y recomposición.
 *
 * Alumno: Ivan
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyAppContent { innerPadding ->
                ClickCounter(modifier = Modifier.padding(innerPadding))
            }
        }
    }
}

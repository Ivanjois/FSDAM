package com.example.conversorivan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.conversorivan.ui.theme.ConversorIvanTheme

/**
 * Actividad 2 - Conversor Numérico (ConversorIvan)
 * Aplicación desarrollada con Jetpack Compose para generar números aleatorios
 * del 1 al 10.000 y realizar conversiones a binario y hexadecimal.
 * Incluye gestión de estados con rememberSaveable y opción de reinicio.
 *
 * Alumno: Ivan
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ConversorIvanTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Content(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Content(modifier: Modifier = Modifier) {
    var numeroDecimal by rememberSaveable { mutableStateOf(0) }
    var resultadoConversion by rememberSaveable { mutableStateOf("") }
    var tipoBase by rememberSaveable { mutableStateOf("") }
    val nombreAlumno = "Ivan"

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Conversor Numérico",
            fontSize = 28.sp
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = if (numeroDecimal > 0) "$numeroDecimal" else "---",
                fontSize = 40.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    numeroDecimal = (1..10000).random()
                    resultadoConversion = ""
                    tipoBase = ""
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2196F3))
            ) {
                Text(text = "Generar Número", fontSize = 18.sp)
            }

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = {
                        if (numeroDecimal > 0) {
                            resultadoConversion = Integer.toBinaryString(numeroDecimal)
                            tipoBase = "Binario"
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50))
                ) {
                    Text(text = "Binario", fontSize = 16.sp)
                }

                Button(
                    onClick = {
                        if (numeroDecimal > 0) {
                            resultadoConversion = Integer.toHexString(numeroDecimal).uppercase()
                            tipoBase = "Hexadecimal"
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF9800))
                ) {
                    Text(text = "Hexadecimal", fontSize = 16.sp)
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            if (resultadoConversion.isNotEmpty()) {
                Text(
                    text = "$tipoBase: $resultadoConversion",
                    fontSize = 24.sp
                )
            } else {
                Text(
                    text = "Selecciona una conversión",
                    fontSize = 18.sp,
                    color = Color.Gray
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = {
                    numeroDecimal = 0
                    resultadoConversion = ""
                    tipoBase = ""
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE53935))
            ) {
                Text(text = "Borrar", fontSize = 16.sp)
            }
        }

        Text(
            text = nombreAlumno,
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ContentPreview() {
    ConversorIvanTheme {
        Content()
    }
}

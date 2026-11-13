package com.example.conversorivan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.conversorivan.ui.theme.ConversorIvanTheme

/**
 * Actividad 2 - Conversor v2.0 (ConversorIvan)
 * Aplicación desarrollada con Jetpack Compose que incluye:
 * - Cabecera con foto tipo carnet y nombre del alumno.
 * - Campo de texto numérico para convertir entre decimal y binario.
 * - Interruptor (Switch) para elegir dirección de conversión (Decimal <-> Binario).
 * - Botón para realizar la conversión y validación de errores.
 * - Botón para borrar tanto el campo de texto como el resultado.
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
    var entradaTexto by rememberSaveable { mutableStateOf("") }
    var convertirADecimal by rememberSaveable { mutableStateOf(false) }
    var resultadoConversion by rememberSaveable { mutableStateOf("") }
    var tipoBase by rememberSaveable { mutableStateOf("") }
    var mensajeError by rememberSaveable { mutableStateOf("") }

    val nombreAlumno = "Ivan"

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Cabecera con foto tipo carnet y nombre del alumno
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.foto),
                contentDescription = "Foto tipo carnet de $nombreAlumno",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(width = 72.dp, height = 92.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .border(2.dp, Color(0xFF2196F3), RoundedCornerShape(10.dp))
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = "Conversor v2.0",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Alumno: $nombreAlumno",
                    fontSize = 18.sp,
                    color = Color.DarkGray
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Sección Conversor v2.0: Campo de texto + Interruptor + Botón Convertir
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F7FA))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Conversor Manual",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(12.dp))

                OutlinedTextField(
                    value = entradaTexto,
                    onValueChange = {
                        entradaTexto = it
                        mensajeError = ""
                    },
                    label = {
                        Text(
                            if (convertirADecimal) "Introduce un número binario (0 y 1)"
                            else "Introduce un número decimal"
                        )
                    },
                    placeholder = {
                        Text(if (convertirADecimal) "Ej: 1010" else "Ej: 42")
                    },
                    singleLine = true,
                    isError = mensajeError.isNotEmpty(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Interruptor para elegir dirección de la conversión
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "A Binario",
                        fontSize = 15.sp,
                        fontWeight = if (!convertirADecimal) FontWeight.Bold else FontWeight.Normal,
                        color = if (!convertirADecimal) Color(0xFF2196F3) else Color.Gray
                    )

                    Spacer(modifier = Modifier.width(12.dp))

                    Switch(
                        checked = convertirADecimal,
                        onCheckedChange = { nuevoValor ->
                            convertirADecimal = nuevoValor
                            resultadoConversion = ""
                            tipoBase = ""
                            mensajeError = ""
                        }
                    )

                    Spacer(modifier = Modifier.width(12.dp))

                    Text(
                        text = "A Decimal",
                        fontSize = 15.sp,
                        fontWeight = if (convertirADecimal) FontWeight.Bold else FontWeight.Normal,
                        color = if (convertirADecimal) Color(0xFF2196F3) else Color.Gray
                    )
                }

                Text(
                    text = if (convertirADecimal) "Modo: Binario → Decimal" else "Modo: Decimal → Binario",
                    fontSize = 13.sp,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(14.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(
                        onClick = {
                            val textoLimpio = entradaTexto.trim()
                            if (textoLimpio.isEmpty()) {
                                mensajeError = "Error: El campo de texto está vacío."
                                resultadoConversion = ""
                                tipoBase = ""
                            } else if (!convertirADecimal) {
                                // Decimal -> Binario
                                val numero = textoLimpio.toLongOrNull()
                                if (numero == null || numero < 0) {
                                    mensajeError = "Error: Introduce un número decimal entero positivo."
                                    resultadoConversion = ""
                                    tipoBase = ""
                                } else {
                                    resultadoConversion = java.lang.Long.toBinaryString(numero)
                                    tipoBase = "Binario"
                                    mensajeError = ""
                                }
                            } else {
                                // Binario -> Decimal
                                val esBinarioValido = textoLimpio.all { it == '0' || it == '1' }
                                val numeroDecimalConvertido = if (esBinarioValido) textoLimpio.toLongOrNull(2) else null
                                if (numeroDecimalConvertido == null) {
                                    mensajeError = "Error: Un número binario válido solo contiene 0 y 1."
                                    resultadoConversion = ""
                                    tipoBase = ""
                                } else {
                                    resultadoConversion = numeroDecimalConvertido.toString()
                                    tipoBase = "Decimal"
                                    mensajeError = ""
                                }
                            }
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2196F3))
                    ) {
                        Text(text = "Convertir", fontSize = 16.sp)
                    }

                    Button(
                        onClick = {
                            entradaTexto = ""
                            resultadoConversion = ""
                            tipoBase = ""
                            mensajeError = ""
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE53935))
                    ) {
                        Text(text = "Borrar", fontSize = 16.sp)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Texto donde mostrar el resultado de la conversión (o mensaje de error)
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = if (mensajeError.isNotEmpty()) Color(0xFFFFEBEE) else Color(0xFFE8F5E9)
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                when {
                    mensajeError.isNotEmpty() -> {
                        Text(
                            text = mensajeError,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFFD32F2F),
                            textAlign = TextAlign.Center
                        )
                    }
                    resultadoConversion.isNotEmpty() -> {
                        Text(
                            text = "Resultado ($tipoBase)",
                            fontSize = 14.sp,
                            color = Color.DarkGray
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = resultadoConversion,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF1B5E20),
                            textAlign = TextAlign.Center
                        )
                    }
                    else -> {
                        Text(
                            text = "Introduce un número y pulsa Convertir",
                            fontSize = 16.sp,
                            color = Color.Gray,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContentPreview() {
    ConversorIvanTheme {
        Content()
    }
}

package com.example.stadisticsnombres

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
import com.example.stadisticsnombres.ui.theme.StadisticsNombresTheme

/**
 * Actividad 1 - Estadísticas (StatisticsIvan)
 * Aplicación en Jetpack Compose para registrar el recuento de vehículos y peatones
 * (Personas, Patinetes, Bicicletas y Coches), calculando porcentajes sobre el total
 * y permitiendo reinicios individuales o globales.
 *
 * Alumno: Ivan
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StadisticsNombresTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Content(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Content(modifier: Modifier = Modifier) {
    var conPer by rememberSaveable { mutableStateOf(0) }
    var conPat by rememberSaveable { mutableStateOf(0) }
    var conBic by rememberSaveable { mutableStateOf(0) }
    var conCoch by rememberSaveable { mutableStateOf(0) }
    val nomPer = "Ivan"
    val conTotal = conPer + conPat + conBic + conCoch
    val porcPer = if (conTotal > 0) (conPer * 100) / conTotal else 0
    val porcPat = if (conTotal > 0) (conPat * 100) / conTotal else 0
    val porcBic = if (conTotal > 0) (conBic * 100) / conTotal else 0
    val porcCoch = if (conTotal > 0) (conCoch * 100) / conTotal else 0

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(vertical = 16.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Estadísticas $nomPer", fontSize = 28.sp)

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(text = "Total: $conTotal", fontSize = 24.sp)
            Button(
                onClick = {
                    conPer = 0
                    conPat = 0
                    conBic = 0
                    conCoch = 0
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE53935))
            ) {
                Text(text = "Reiniciar todos", fontSize = 16.sp)
            }
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Personas:", fontSize = 16.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(text = "$conPer", fontSize = 22.sp)
                Button(
                    onClick = { conPer++ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50))
                ) {
                    Text(text = "+1")
                }
                Button(
                    onClick = { if (conPer > 0) conPer-- },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF9800))
                ) {
                    Text(text = "-1")
                }
                Button(
                    onClick = { conPer = 0 },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE53935))
                ) {
                    Text(text = "Reset")
                }
            }
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Patinetes:", fontSize = 16.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(text = "$conPat", fontSize = 22.sp)
                Button(
                    onClick = { conPat++ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50))
                ) {
                    Text(text = "+1")
                }
                Button(
                    onClick = { if (conPat > 0) conPat-- },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF9800))
                ) {
                    Text(text = "-1")
                }
                Button(
                    onClick = { conPat = 0 },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE53935))
                ) {
                    Text(text = "Reset")
                }
            }
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Bicicletas:", fontSize = 16.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(text = "$conBic", fontSize = 22.sp)
                Button(
                    onClick = { conBic++ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50))
                ) {
                    Text(text = "+1")
                }
                Button(
                    onClick = { if (conBic > 0) conBic-- },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF9800))
                ) {
                    Text(text = "-1")
                }
                Button(
                    onClick = { conBic = 0 },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE53935))
                ) {
                    Text(text = "Reset")
                }
            }
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Coches:", fontSize = 16.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(text = "$conCoch", fontSize = 22.sp)
                Button(
                    onClick = { conCoch++ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50))
                ) {
                    Text(text = "+1")
                }
                Button(
                    onClick = { if (conCoch > 0) conCoch-- },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF9800))
                ) {
                    Text(text = "-1")
                }
                Button(
                    onClick = { conCoch = 0 },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE53935))
                ) {
                    Text(text = "Reset")
                }
            }
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Estadísticas", fontSize = 18.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Personas: $porcPer %", fontSize = 15.sp)
            Text(text = "Patinetes: $porcPat %", fontSize = 15.sp)
            Text(text = "Bicicletas: $porcBic %", fontSize = 15.sp)
            Text(text = "Coches: $porcCoch %", fontSize = 15.sp)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ContentPreview() {
    StadisticsNombresTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Content(modifier = Modifier.padding(innerPadding))
        }
    }
}

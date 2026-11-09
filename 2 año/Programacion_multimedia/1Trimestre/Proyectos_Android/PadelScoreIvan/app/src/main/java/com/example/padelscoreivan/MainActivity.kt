package com.example.padelscoreivan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.padelscoreivan.ui.theme.PadelScoreIvanTheme

/**
 * Actividad 3 - Marcador Digital de Pádel (PadelScoreIvan)
 * Aplicación desarrollada con Jetpack Compose para gestionar el marcador de un
 * partido de pádel oficial al mejor de 3 sets.
 * Incorpora tanteo oficial (0, 15, 30, 40), regla de punto de oro (40-40),
 * desempate por tie-break al llegar a 6-6, bloqueo de marcador tras la victoria
 * y soporte multi-idioma (es, ca, en) mediante recursos centralizados en strings.xml.
 *
 * Alumno: Ivan
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PadelScoreIvanTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Content(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Content(modifier: Modifier = Modifier) {
    var setsA by rememberSaveable { mutableStateOf(0) }
    var setsB by rememberSaveable { mutableStateOf(0) }
    var gamesA by rememberSaveable { mutableStateOf(0) }
    var gamesB by rememberSaveable { mutableStateOf(0) }
    var pointsA by rememberSaveable { mutableStateOf(0) }
    var pointsB by rememberSaveable { mutableStateOf(0) }
    var isTieBreak by rememberSaveable { mutableStateOf(false) }
    var winnerTeamKey by rememberSaveable { mutableStateOf("") }

    val blueColor = Color(0xFF03A9F4)
    val greenColor = Color(0xFF8BC34A)
    val orangeColor = Color(0xFFFFA000)
    val redColor = Color(0xFFE53935)

    fun checkSetStatus() {
        if (gamesA == 6 && gamesB <= 4) {
            setsA++
            gamesA = 0
            gamesB = 0
            pointsA = 0
            pointsB = 0
            isTieBreak = false
            if (setsA == 2) winnerTeamKey = "A"
        } else if (gamesB == 6 && gamesA <= 4) {
            setsB++
            gamesA = 0
            gamesB = 0
            pointsA = 0
            pointsB = 0
            isTieBreak = false
            if (setsB == 2) winnerTeamKey = "B"
        } else if (gamesA == 7 && gamesB == 5) {
            setsA++
            gamesA = 0
            gamesB = 0
            pointsA = 0
            pointsB = 0
            isTieBreak = false
            if (setsA == 2) winnerTeamKey = "A"
        } else if (gamesB == 7 && gamesA == 5) {
            setsB++
            gamesA = 0
            gamesB = 0
            pointsA = 0
            pointsB = 0
            isTieBreak = false
            if (setsB == 2) winnerTeamKey = "B"
        } else if (gamesA == 6 && gamesB == 6) {
            isTieBreak = true
            pointsA = 0
            pointsB = 0
        }
    }

    fun addPointA() {
        if (winnerTeamKey.isNotEmpty()) return

        if (isTieBreak) {
            pointsA++
            if (pointsA >= 7 && (pointsA - pointsB) >= 2) {
                setsA++
                gamesA = 0
                gamesB = 0
                pointsA = 0
                pointsB = 0
                isTieBreak = false
                if (setsA == 2) winnerTeamKey = "A"
            }
        } else {
            if (pointsA == 3) {
                gamesA++
                pointsA = 0
                pointsB = 0
                checkSetStatus()
            } else {
                pointsA++
            }
        }
    }

    fun addPointB() {
        if (winnerTeamKey.isNotEmpty()) return

        if (isTieBreak) {
            pointsB++
            if (pointsB >= 7 && (pointsB - pointsA) >= 2) {
                setsB++
                gamesA = 0
                gamesB = 0
                pointsA = 0
                pointsB = 0
                isTieBreak = false
                if (setsB == 2) winnerTeamKey = "B"
            }
        } else {
            if (pointsB == 3) {
                gamesB++
                pointsA = 0
                pointsB = 0
                checkSetStatus()
            } else {
                pointsB++
            }
        }
    }

    fun resetMatch() {
        setsA = 0
        setsB = 0
        gamesA = 0
        gamesB = 0
        pointsA = 0
        pointsB = 0
        isTieBreak = false
        winnerTeamKey = ""
    }

    val tennisPoints = listOf("0", "15", "30", "40")
    val displayPointsA = if (isTieBreak) "$pointsA" else tennisPoints[pointsA]
    val displayPointsB = if (isTieBreak) "$pointsB" else tennisPoints[pointsB]

    val currentSetHeader = when {
        winnerTeamKey.isNotEmpty() -> {
            val winnerName = if (winnerTeamKey == "A") stringResource(R.string.team_a) else stringResource(R.string.team_b)
            stringResource(R.string.winner_message, winnerName)
        }
        isTieBreak -> stringResource(R.string.title_tiebreak)
        else -> stringResource(R.string.title_current_set)
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Sección SETS
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(orangeColor)
                    .padding(vertical = 8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(R.string.title_sets),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF212121)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "$setsA",
                    fontSize = 68.sp,
                    color = blueColor,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "$setsB",
                    fontSize = 68.sp,
                    color = greenColor,
                    textAlign = TextAlign.Center
                )
            }

            // Sección JUEGOS
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(orangeColor)
                    .padding(vertical = 8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(R.string.title_games),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF212121)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "$gamesA",
                    fontSize = 68.sp,
                    color = blueColor,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "$gamesB",
                    fontSize = 68.sp,
                    color = greenColor,
                    textAlign = TextAlign.Center
                )
            }

            // Sección SET ACTUAL / TIE-BREAK
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(orangeColor)
                    .padding(vertical = 8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = currentSetHeader,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF212121)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = displayPointsA,
                    fontSize = 68.sp,
                    color = blueColor,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = displayPointsB,
                    fontSize = 68.sp,
                    color = greenColor,
                    textAlign = TextAlign.Center
                )
            }
        }

        // Bloque de botones inferiores
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = { addPointA() },
                    enabled = winnerTeamKey.isEmpty(),
                    shape = RoundedCornerShape(24.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = blueColor,
                        contentColor = Color(0xFF212121)
                    )
                ) {
                    Text(
                        text = stringResource(R.string.btn_point_a),
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Button(
                    onClick = { addPointB() },
                    enabled = winnerTeamKey.isEmpty(),
                    shape = RoundedCornerShape(24.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = greenColor,
                        contentColor = Color(0xFF212121)
                    )
                ) {
                    Text(
                        text = stringResource(R.string.btn_point_b),
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { resetMatch() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(24.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = redColor,
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = stringResource(R.string.btn_reset),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview(showBackground = true, name = "Español", locale = "es")
@Preview(showBackground = true, name = "Valenciano", locale = "ca")
@Preview(showBackground = true, name = "English", locale = "en")
@Composable
fun ContentPreview() {
    PadelScoreIvanTheme {
        Content()
    }
}

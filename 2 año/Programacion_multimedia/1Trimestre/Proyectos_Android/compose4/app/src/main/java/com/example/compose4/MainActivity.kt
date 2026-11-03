package com.example.compose4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PantallaConText()
        }
    }
}

@Composable
fun PantallaConText() {
    Column {
//        Text(text = "Primer Text",
//             fontFamily = FontFamily(Font(R.font.Beatrica)),
//             fontSize = 50.sp
//        )
        Text(text = "Segundo Text",
             fontFamily = FontFamily(Font(R.font.sewer)),
             fontSize = 50.sp
        )
        Text(text = "Tercer Text",
             fontFamily = FontFamily(Font(R.font.stocky)),
             fontSize = 50.sp
        )
    }
}
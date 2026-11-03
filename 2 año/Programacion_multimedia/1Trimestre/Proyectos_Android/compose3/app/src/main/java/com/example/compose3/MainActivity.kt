package com.example.compose3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MatrizIdentidad()
        }
    }
}

@Composable
fun MatrizIdentidad() {
    Column {
        for (fil in 1..10)
            Row {
                for (col in 1..10) {
                    if (fil == col)
                        Text(text = " 1 ")
                    else
                        Text(text = " 0 ")
                }
            }
    }
}
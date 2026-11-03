package com.example.contadordeclics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import com.example.contadordeclics.ui.MyAppContent
import com.example.contadordeclics.ui.screens.ClickCounter

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() //hace que ocuper todos los margenes
        setContent {
            MyAppContent { innerPadding ->
                ClickCounter(modifier = Modifier.padding(innerPadding))
            }
        }
    }
}

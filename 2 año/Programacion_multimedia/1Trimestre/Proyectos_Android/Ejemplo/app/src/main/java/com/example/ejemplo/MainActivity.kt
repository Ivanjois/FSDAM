package com.example.ejemplo

import android.os.Bundle
// import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
// import androidx.compose.material3.Button
// import androidx.compose.material3.Checkbox
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ejemplo.ui.theme.EjemploTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EjemploTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    /*
                    CheckboxScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                    */
                    RadioButtonScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MyRadioButton(vararg options: String, selected: String, onClick: (String) -> Unit) {
    options.forEach { option ->
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = selected == option,
                onClick = { onClick(option) }
            )
            Text(text = option)
        }
    }
}

@Composable
fun RadioButtonScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        var option by rememberSaveable { mutableStateOf("") }
        MyRadioButton(
            "Opción 1", "Opción 2", "Opción 3",
            selected = option,
            onClick = { option = it }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RadioButtonScreenPreview() {
    EjemploTheme {
        RadioButtonScreen()
    }
}

/*
// Data class para los objetos MyCheckbox
data class Check(
    val title: String,
    var selected: Boolean = false,
    var onCheckedChange: (Boolean) -> Unit
)

// Función que recibe un conjunto de títulos y los convierte en objetos Check
@Composable
fun getChecks(vararg titles: String): List<Check> {
    return titles.map {
        var state by rememberSaveable { mutableStateOf(false) }
        Check(
            title = it,
            selected = state,
            onCheckedChange = { state = it }
        )
    }
}

// Componente Checkbox stateless propio
@Composable
fun MyCheckbox(check: Check) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = check.selected,
            onCheckedChange = { check.onCheckedChange(it) }
        )
        Text(text = check.title)
    }
}

@Composable
fun CheckboxScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        val myOptions = getChecks("Opción 1", "Opción 2", "Opción 3")
        myOptions.forEach {
            MyCheckbox(check = it)
        }

        Button(onClick = {
            // Se recorren las opciones y se puede ver el dato almacenado en cada opción
            myOptions.map { option ->
                Log.i("--->", "${option.title}: ${option.selected}")
            }
        }) {
            Text(text = "Guardar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CheckboxScreenPreview() {
    EjemploTheme {
        CheckboxScreen()
    }
}
*/
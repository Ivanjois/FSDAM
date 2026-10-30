package com.example.contadordeclics.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.contadordeclics.R
import com.example.contadordeclics.ui.MyAppContent

@Composable
fun ClickCounter(modifier: Modifier = Modifier) {
    var times by rememberSaveable { mutableIntStateOf(0) }
    var puntos by rememberSaveable { mutableIntStateOf(0) }
    var name = "Ivan"
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.clics, times),
            fontSize = 25.sp
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            times++
        }) {
            Text(
                text = stringResource(id = R.string.click_me),
                fontSize = dimensionResource(id = R.dimen.button_text).value.sp,
                modifier = Modifier.padding(16.dp)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { times = 0 }) {
            Text(
                text = stringResource(id = R.string.click_reset),
                fontSize = dimensionResource(id = R.dimen.button_text).value.sp,
                modifier = Modifier.padding(16.dp)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = stringResource(R.string.points, name, puntos),
            fontSize = 25.sp
        )
        Button(onClick = { puntos++ }) {
            Text(
                text = stringResource(R.string.m_s_puntos),
                fontSize = dimensionResource(id = R.dimen.button_text).value.sp,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Preview(
    name = "Light Mode",
    showBackground = true,
    showSystemUi = true,
    locale = "es"
)
@Preview(
    name = "Dark Mode",
    showBackground = true,
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    locale = "es"
)
@Preview(
    showBackground = true,
    name = "English",
)
@Preview(
    showBackground = true,
    name = "Spanish",
    group = "locale",
    locale = "es",
)
@Composable
fun ContentPreview() {
    MyAppContent { innerPadding ->
        ClickCounter(modifier = Modifier.padding(innerPadding))
    }
}


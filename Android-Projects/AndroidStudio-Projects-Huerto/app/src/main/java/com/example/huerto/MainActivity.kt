package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.huerto.R
import com.example.huerto.ui.theme.MyApplicationTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                HuertoApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HuertoApp() {
    val estado = rememberSaveable { mutableStateOf(Estado.INICIAL) }
    val pulsaciones = rememberSaveable { mutableStateOf(0) }
    val euros = rememberSaveable { mutableStateOf(0) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(title = { Text("Huerto App") })
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                MostrarImagen(estado.value)
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = { cambiarEstado(estado, pulsaciones, euros) }) {
                    Text("Cambiar Estado")
                }
                Spacer(modifier = Modifier.height(16.dp))
                if (euros.value > 0) {
                    Text("Has ganado ${euros.value} euros")
                }
            }
        }
    )
}

@Composable
fun MostrarImagen(estado: Estado) {
    val imagen: Painter = when (estado) {
        Estado.PLANTAS -> painterResource(id = R.drawable.huerto_plantas)
        Estado.FRUTAS -> painterResource(id = R.drawable.huerto_frutas)
        else -> painterResource(id = R.drawable.huerto_vacio)
    }
    Image(painter = imagen, contentDescription = null, modifier = Modifier.size(500.dp))
}

fun cambiarEstado(estado: MutableState<Estado>, pulsaciones: MutableState<Int>, euros: MutableState<Int>) {
    when (estado.value) {
        Estado.INICIAL -> estado.value = Estado.PLANTAS
        Estado.PLANTAS -> estado.value = Estado.FRUTAS
        Estado.FRUTAS -> {
            pulsaciones.value++
            if (pulsaciones.value == Random.nextInt(1, 6)) {
                euros.value = Random.nextInt(1, 101)
                estado.value = Estado.INICIAL
                pulsaciones.value = 0
            }
        }
    }
}

enum class Estado {
    INICIAL, PLANTAS, FRUTAS
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        HuertoApp()
    }
}

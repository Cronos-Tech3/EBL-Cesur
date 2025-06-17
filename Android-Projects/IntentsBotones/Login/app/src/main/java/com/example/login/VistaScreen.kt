package com.example.login

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun VistaScreen() {
    // Obtiene el contexto local para acceder a SharedPreferences.
    val context = LocalContext.current

    // Obtiene el nombre del usuario desde SharedPreferences.
    val nombre = obtenerNombre(context)

    // Superficie que ocupa toda la pantalla con el color de fondo del tema.
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        // Columna que organiza los elementos verticalmente y los centra.
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Texto de bienvenida con el nombre del usuario.
            Text(
                text = "¡Bienvenido, $nombre!",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(16.dp)
            )
            // Texto de mensaje de bienvenida adicional.
            Text(
                text = "Disfruta de la aplicación.",
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(bottom = 32.dp)
            )
            // Aquí se pueden agregar más elementos de la interfaz de usuario.
        }
    }
}

// Función para obtener el nombre del usuario desde SharedPreferences.
fun obtenerNombre(context: Context): String {
    val sharedPreferences = context.getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE)
    // Obtiene el nombre del usuario o devuelve "Usuario" si no se encuentra.
    return sharedPreferences.getString("nombre", "") ?: "Usuario"
}

// Vista previa de la pantalla VistaScreen.
@Preview(showBackground = true)
@Composable
fun VistaScreenPreview() {
    VistaScreen()
}
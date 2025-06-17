package com.example.login // Define el paquete de la aplicación.

import android.os.Bundle // Importa la clase Bundle para guardar datos de estado.
import androidx.activity.ComponentActivity // Importa ComponentActivity, la base para actividades Compose.
import androidx.activity.compose.setContent // Importa setContent para configurar el contenido de la actividad con Compose.
import androidx.compose.foundation.layout.fillMaxSize // Importa fillMaxSize para que un componente ocupe toda la pantalla.
import androidx.compose.material.MaterialTheme // Importa MaterialTheme para aplicar el tema de Material Design.
import androidx.compose.material.Surface // Importa Surface para crear una superficie de dibujo.
import androidx.compose.ui.Modifier // Importa Modifier para modificar componentes Compose.
import androidx.navigation.compose.NavHost // Importa NavHost para configurar la navegación.
import androidx.navigation.compose.composable // Importa composable para definir destinos de navegación.
import androidx.navigation.compose.rememberNavController // Importa rememberNavController para crear y recordar el controlador de navegación.

class MainActivity : ComponentActivity() { // Define la clase MainActivity, que hereda de ComponentActivity.
    override fun onCreate(savedInstanceState: Bundle?) { // Sobrescribe el método onCreate para inicializar la actividad.
        super.onCreate(savedInstanceState) // Llama al onCreate de la superclase.
        setContent { // Establece el contenido de la actividad con Compose.
            MaterialTheme { // Aplica el tema de Material Design.
                Surface(modifier = Modifier.fillMaxSize()) { // Crea una Surface que ocupa toda la pantalla.
                    val navController = rememberNavController() // Crea y recuerda un controlador de navegación.
                    NavHost(navController = navController, startDestination = "registro") { // Configura el NavHost con el controlador y la pantalla de inicio.
                        composable("registro") { RegistroScreen(navController) } // Define la ruta "registro" y su contenido (RegistroScreen).
                        composable("login") { LoginScreen(navController) } // Define la ruta "login" y su contenido (LoginScreen).
                        composable("vista") { VistaScreen() } // Define la ruta "vista" y su contenido (VistaScreen).
                    }
                }
            }
        }
    }
}
package com.example.login

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip

@Composable
fun LoginScreen(navController: NavController) {
    // Obtiene el contexto local para mostrar Toast y acceder a SharedPreferences.
    val context = LocalContext.current

    // Declara variables de estado para almacenar el email y la contraseña.
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    // Columna principal que organiza los elementos de la pantalla.
    Column(
        modifier = Modifier
            .fillMaxSize() // Ocupa toda la pantalla.
            .padding(24.dp), // Agrega un padding de 24dp alrededor de la columna.
        verticalArrangement = Arrangement.Center, // Centra los elementos verticalmente.
        horizontalAlignment = Alignment.CenterHorizontally // Centra los elementos horizontalmente.
    ) {
        // Título de la pantalla.
        Text(
            text = "Iniciar Sesión",
            style = TextStyle(fontSize = 28.sp, fontWeight = FontWeight.Bold, color = Color(0xFF333333)),
            modifier = Modifier.padding(bottom = 32.dp) // Agrega un padding inferior de 32dp.
        )

        // Campo de texto para el email.
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email", color = Color.Gray) },
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp), // Ocupa todo el ancho y agrega un padding inferior de 16dp.
            shape = RoundedCornerShape(12.dp), // Aplica bordes redondeados.
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFF6200EE), // Color del borde cuando está enfocado.
                unfocusedBorderColor = Color.LightGray, // Color del borde cuando no está enfocado.
                focusedLabelColor = Color(0xFF6200EE), // Color del label cuando está enfocado.
                unfocusedLabelColor = Color.Gray // Color del label cuando no está enfocado.
            )
        )

        // Campo de texto para la contraseña.
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña", color = Color.Gray) },
            modifier = Modifier.fillMaxWidth().padding(bottom = 24.dp), // Ocupa todo el ancho y agrega un padding inferior de 24dp.
            shape = RoundedCornerShape(12.dp), // Aplica bordes redondeados.
            visualTransformation = PasswordVisualTransformation(), // Oculta la contraseña.
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFF6200EE),
                unfocusedBorderColor = Color.LightGray,
                focusedLabelColor = Color(0xFF6200EE),
                unfocusedLabelColor = Color.Gray
            )
        )

        // Botón para iniciar sesión.
        Button(
            onClick = {
                // Obtiene los datos almacenados desde SharedPreferences.
                val (storedEmail, storedPassword) = obtenerDatos(context)

                // Verifica si el email y la contraseña coinciden.
                if (email == storedEmail && password == storedPassword) {
                    // Navega a la pantalla "vista" si las credenciales son correctas.
                    navController.navigate("vista")
                } else {
                    // Muestra un Toast si las credenciales son incorrectas.
                    Toast.makeText(context, "Correo o contraseña incorrectos", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(24.dp)), // Ocupa todo el ancho y aplica bordes redondeados.
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF6200EE), contentColor = Color.White), // Personaliza los colores del botón.
            contentPadding = PaddingValues(16.dp) // Agrega un padding interno de 16dp.
        ) {
            // Texto del botón.
            Text("Iniciar Sesión", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
        }

        // Botón de texto para registrarse.
        TextButton(onClick = { navController.navigate("registro") }) {
            //Texto del botón de registro.
            Text("Registrarse", color = Color.Gray)
        }
    }
}

// Función para obtener los datos almacenados desde SharedPreferences.
fun obtenerDatos(context: Context): Pair<String?, String?> {
    val sharedPreferences = context.getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE)
    val storedEmail = sharedPreferences.getString("email", "")
    val storedPassword = sharedPreferences.getString("password", "")
    return Pair(storedEmail, storedPassword)
}

// Vista previa de la pantalla LoginScreen.
@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(navController = rememberNavController())
}
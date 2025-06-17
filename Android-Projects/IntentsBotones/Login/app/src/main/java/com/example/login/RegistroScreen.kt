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
fun RegistroScreen(navController: NavController) {
    // Obtiene el contexto local para mostrar Toast y acceder a SharedPreferences.
    val context = LocalContext.current

    // Declara variables de estado para almacenar los datos del formulario.
    var nombre by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    // Columna principal que organiza los elementos de la pantalla.
    Column(
        modifier = Modifier
            .fillMaxSize() // Ocupa toda la pantalla.
            .padding(32.dp), // Agrega un padding de 32dp alrededor de la columna.
        verticalArrangement = Arrangement.Center, // Centra los elementos verticalmente.
        horizontalAlignment = Alignment.CenterHorizontally // Centra los elementos horizontalmente.
    ) {
        // Título de la pantalla.
        Text(
            text = "Crear Cuenta",
            style = TextStyle(fontSize = 28.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF333333)),
            modifier = Modifier.padding(bottom = 32.dp) // Agrega un padding inferior de 32dp.
        )

        // Campo de texto para el nombre.
        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre", color = Color.Gray) },
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp), // Ocupa todo el ancho y agrega un padding inferior de 16dp.
            shape = RoundedCornerShape(12.dp), // Aplica bordes redondeados.
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFF6200EE), // Color del borde cuando está enfocado.
                unfocusedBorderColor = Color.LightGray, // Color del borde cuando no está enfocado.
                focusedLabelColor = Color(0xFF6200EE), // Color del label cuando está enfocado.
                unfocusedLabelColor = Color.Gray // Color del label cuando no está enfocado.
            )
        )

        // Campo de texto para el email.
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email", color = Color.Gray) },
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
            shape = RoundedCornerShape(12.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFF6200EE),
                unfocusedBorderColor = Color.LightGray,
                focusedLabelColor = Color(0xFF6200EE),
                unfocusedLabelColor = Color.Gray
            )
        )

        // Campo de texto para la contraseña.
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña", color = Color.Gray) },
            modifier = Modifier.fillMaxWidth().padding(bottom = 24.dp),
            shape = RoundedCornerShape(12.dp),
            visualTransformation = PasswordVisualTransformation(), // Oculta la contraseña.
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFF6200EE),
                unfocusedBorderColor = Color.LightGray,
                focusedLabelColor = Color(0xFF6200EE),
                unfocusedLabelColor = Color.Gray
            )
        )

        // Botón para registrarse.
        Button(
            onClick = {
                // Verifica que todos los campos estén llenos.
                if (nombre.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
                    // Guarda los datos en SharedPreferences.
                    guardarDatos(context, nombre, email, password)
                    // Navega a la pantalla de login.
                    navController.navigate("login")
                } else {
                    // Muestra un Toast si algún campo está vacío.
                    Toast.makeText(context, "Por favor, complete todos los campos.", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(24.dp)), // Ocupa todo el ancho y aplica bordes redondeados.
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF6200EE), contentColor = Color.White), // Personaliza los colores del botón.
            contentPadding = PaddingValues(16.dp) // Agrega un padding interno de 16dp.
        ) {
            // Texto del botón.
            Text("Registrarse", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
        }
    }
}

// Función para guardar los datos en SharedPreferences.
fun guardarDatos(context: Context, nombre: String, email: String, password: String) {
    val sharedPreferences = context.getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.putString("nombre", nombre)
    editor.putString("email", email)
    editor.putString("password", password)
    editor.apply()
}

// Vista previa de la pantalla RegistroScreen.
@Preview(showBackground = true)
@Composable
fun RegistroScreenPreview() {
    RegistroScreen(navController = rememberNavController())
}
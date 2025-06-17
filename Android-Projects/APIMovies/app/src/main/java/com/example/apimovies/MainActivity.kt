package com.example.moviesapp

import MovieViewModel // Importa la clase MovieViewModel definida en otro archivo.
import android.os.Bundle // Importa la clase Bundle para guardar y restaurar el estado de la actividad.
import androidx.activity.ComponentActivity // Importa la clase base para actividades que usan Compose UI.
import androidx.activity.compose.setContent // Importa la función para definir el contenido de la actividad con Compose UI.
import androidx.activity.enableEdgeToEdge // Importa la función para habilitar el diseño "edge-to-edge".
import androidx.compose.foundation.layout.* // Importa varios layouts de Compose como Column, Row, Spacer.
import androidx.compose.foundation.lazy.LazyColumn // Importa el Composable LazyColumn para mostrar listas eficientes.
import androidx.compose.foundation.lazy.items // Importa la función items para iterar sobre listas en LazyColumn.
import androidx.compose.material3.* // Importa varios componentes de Material Design 3 como Scaffold, Text, TextField, Button, Card, CircularProgressIndicator.
import androidx.compose.runtime.* // Importa varios elementos de estado de Compose como remember, mutableStateOf, collectAsState.
import androidx.compose.ui.Alignment // Importa la clase Alignment para alinear elementos en layouts.
import androidx.compose.ui.Modifier // Importa la clase Modifier para personalizar la apariencia y el comportamiento de los Composables.
import androidx.compose.ui.unit.dp // Importa la unidad de medida dp (density-independent pixels).
import androidx.compose.ui.unit.sp // Importa la unidad de medida sp (scaled pixels) para tamaños de fuente.
import androidx.compose.runtime.Composable // Importa la anotación @Composable para definir funciones de UI.
import androidx.lifecycle.viewmodel.compose.viewModel // Importa la función viewModel para obtener una instancia del ViewModel.
import com.example.moviesapp.ui.theme.MoviesAppTheme // Importa el tema definido para la aplicación.

class MainActivity : ComponentActivity() {
    // Clase principal de la actividad
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // Llama al onCreate de la clase padre (ComponentActivity).
        enableEdgeToEdge() // Habilita el modo de aristas redondeadas para esta actividad, permitiendo que la UI se extienda detrás de las barras del sistema.

        setContent { // Establece el contenido de la actividad utilizando Jetpack Compose.
            MoviesAppTheme { // Aplica el tema personalizado definido en ui.theme.MoviesAppTheme.
                val viewModel: MovieViewModel = viewModel() // Obtiene una instancia del MovieViewModel utilizando la función viewModel de Compose.
                val movieList by viewModel.movies.collectAsState()  // Recopila el estado del Flow 'movies' del ViewModel como un State. Cuando 'viewModel.movies' emite un nuevo valor, 'movieList' se actualiza y la UI se recompondrá.
                val movieById by viewModel.movieById.collectAsState() // Recopila el estado del Flow 'movieById' del ViewModel como un State, representando la película buscada por ID.
                val isLoading by viewModel.isLoading.collectAsState() // Recopila el estado del Flow 'isLoading' del ViewModel como un State, indicando si los datos se están cargando.
                val errorMessage by viewModel.errorMessage.collectAsState() // Recopila el estado del Flow 'errorMessage' del ViewModel como un State, almacenando cualquier mensaje de error.

                var searchId by remember { mutableStateOf("") } // Crea un estado mutable 'searchId' que se recuerda a través de las recomposiciones. Se utiliza para almacenar el ID de la película a buscar.

                var showMovieList by remember { mutableStateOf(true) } // Crea un estado mutable 'showMovieList' que se recuerda. Controla si se muestra la lista completa de películas o los detalles de una película por ID.

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding -> // Proporciona la estructura visual básica de la pantalla. 'innerPadding' es un PaddingValues que debe aplicarse al contenido del Scaffold.
                    Column(
                        modifier = Modifier
                            .padding(innerPadding) // Aplica el padding proporcionado por el Scaffold al contenido de la Columna.
                            .fillMaxSize() /* Hace que la Columna ocupe todo el espacio disponible dentro del Scaffold.*/
                            .padding(16.dp), // Añade un padding adicional de 16 dp alrededor de la Columna.
                        horizontalAlignment = Alignment.CenterHorizontally, // Centra los elementos hijos horizontalmente dentro de la Columna.
                        verticalArrangement = Arrangement.spacedBy(16.dp) // Distribuye los elementos hijos verticalmente con un espacio de 16 dp entre ellos.
                    ) {
                        Text("Buscar Película por ID", style = MaterialTheme.typography.headlineSmall) // Muestra un texto como título para la sección de búsqueda por ID, utilizando un estilo predefinido del tema.

                        TextField(
                            value = searchId, // Vincula el valor del TextField al estado 'searchId'.
                            onValueChange = { searchId = it }, // Llama a esta lambda cuando el texto del TextField cambia, actualizando el estado 'searchId'.
                            label = { Text("Ingrese el ID") }, // Muestra una etiqueta dentro del TextField cuando está vacío.
                            modifier = Modifier.fillMaxWidth() // Hace que el TextField ocupe todo el ancho disponible dentro de su contenedor.
                        )

                        Button(
                            onClick = { // Llama a esta lambda cuando se hace clic en el botón.
                                if (searchId.isNotEmpty()) { // Si el campo de búsqueda no está vacío.
                                    viewModel.fetchMovieById(searchId.toInt()) // Llama a la función del ViewModel para buscar una película por el ID ingresado.
                                    showMovieList = false // Oculta la lista completa de películas al mostrar los detalles de una película por ID.
                                } else { // Si el campo de búsqueda está vacío.
                                    viewModel.fetchMovies() // Llama a la función del ViewModel para obtener o recargar la lista completa de películas.
                                    showMovieList = true // Muestra la lista completa de películas.
                                }
                            },
                            enabled = !isLoading // Deshabilita el botón mientras los datos se están cargando.
                        ) {
                            Text("Buscar por ID") // Muestra el texto del botón.
                        }

                        Spacer(modifier = Modifier.height(16.dp)) // Añade un espacio vertical de 16 dp entre los elementos.

                        if (isLoading) { // Si el estado de carga es verdadero.
                            CircularProgressIndicator() // Muestra un indicador de carga circular.
                        } else if (errorMessage != null) { // Si hay un mensaje de error.
                            Text("Error: $errorMessage", color = MaterialTheme.colorScheme.error) // Muestra el mensaje de error con el color de error definido en el tema.
                        } else if (movieById != null) { // Si el estado de la película por ID no es nulo (se ha encontrado una película).
                            // Mostrar la película por ID
                            Text("Película Encontrada:", style = MaterialTheme.typography.titleMedium) // Muestra un título para la película encontrada.
                            Card(modifier = Modifier.fillMaxWidth()) { // Muestra la información de la película en una tarjeta.
                                Column(modifier = Modifier.padding(16.dp)) { // Organiza los detalles de la película verticalmente dentro de la tarjeta.
                                    Text("ID: ${movieById?.id}", style = MaterialTheme.typography.bodyLarge) // Muestra el ID de la película.
                                    Text("Título: ${movieById?.movie_name}", style = MaterialTheme.typography.bodyLarge) // Muestra el título de la película.
                                    // Muestra aquí más detalles de la película si los tienes
                                }
                            }
                            Button(onClick = { // Llama a esta lambda cuando se hace clic en el botón.
                                viewModel.fetchMovies() // Vuelve a cargar la lista completa de películas.
                                viewModel._movieById.value = null // Limpia el estado de la película individual para que no se muestre más.
                                searchId = "" // Limpia el campo de búsqueda.
                                showMovieList = true // Vuelve a mostrar la lista completa de películas.
                            }) {
                                Text("Volver a la Lista") // Muestra el texto del botón para volver a la lista.
                            }
                        } else if (searchId.isNotEmpty()) { // Si el campo de búsqueda no está vacío pero no se encontró ninguna película por ID.
                            Text("Película con ID $searchId no encontrada.", color = MaterialTheme.colorScheme.error) // Muestra un mensaje de que no se encontró la película.
                        } else if (showMovieList) { // Si se debe mostrar la lista completa de películas.
                            // Mostrar la lista completa de películas
                            Text("Lista de Películas:", style = MaterialTheme.typography.titleMedium) // Muestra un título para la lista de películas.
                            if (movieList.isEmpty()) { // Si la lista de películas está vacía.
                                Text("No hay películas disponibles.") // Muestra un mensaje indicando que no hay películas.
                            } else { // Si la lista de películas no está vacía.
                                MovieList(peliculas = movieList) // Llama al Composable MovieList para mostrar la lista de películas.
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MovieList(peliculas: List<Movie>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(peliculas) { movie ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = "${movie.id}: ${movie.movie_name}", fontSize = 20.sp)
                }
            }
        }
    }
}
package com.example.myapplication

import com.example.moviesapp.Movie // Importa la clase Movie desde el paquete com.example.moviesapp.
import retrofit2.Call // Importa la clase Call de Retrofit para representar una llamada HTTP
// en curso.
import retrofit2.http.GET // Importa la anotación GET de Retrofit para definir solicitudes HTTP GET.
import retrofit2.http.Path // Importa la anotación Path de Retrofit para especificar parámetros de
// ruta dinámicos.

interface MovieApi {
    @GET("/movies") // Define una solicitud HTTP GET a la ruta "/movies" del servidor.
    fun getMovies(): Call<List<Movie>> // Declara una función llamada getMovies que realiza la solicitud GET y devuelve un objeto Call que contendrá una lista de objetos Movie cuando la respuesta sea recibida.

    @GET("/movies/{id}") // Define una solicitud HTTP GET a la ruta "/movies/{id}", donde {id} será reemplazado por un valor dinámico.
    fun getMovieById(
            @Path("id") movieId: Int // Utiliza la anotación Path para indicar que el parámetro movieId de tipo Int se corresponde con el segmento {id} en la URL.
    ): Call<Movie> // Declara una función llamada getMovieById que realiza la solicitud GET y devuelve un objeto Call que contendrá un objeto Movie cuando la respuesta sea recibida.

    @GET("/movies/title/{title}") // Define una solicitud HTTP GET a la ruta "/movies/title/{title}", donde {title} será reemplazado por un valor dinámico.
    fun getMoviesByTitle(
            @Path("title") movieTitle: String
            // Utiliza la anotación Path para indicar que el parámetro movieTitle de tipo String se corresponde con el segmento {title} en la URL.
    ): Call<List<Movie>> // Declara una función llamada getMoviesByTitle que realiza la solicitud GET y devuelve un objeto Call que contendrá una lista de objetos Movie cuando la respuesta sea recibida.
}

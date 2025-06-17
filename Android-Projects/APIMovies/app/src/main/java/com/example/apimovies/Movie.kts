package com.example.moviesapp

import com.google.gson.annotations.SerializedName

// Define una clase de datos llamada Movie. Las data classes en Kotlin se utilizan para almacenar datos y proporcionan automáticamente métodos como equals(), hashCode(), toString(), copy(), y componentN().
data class Movie(
    // Anota la propiedad 'id' con @SerializedName("id"). Esto indica a Gson (la biblioteca de serialización/deserialización de JSON de Google) que al convertir desde o hacia JSON, esta propiedad Kotlin corresponde al campo JSON con el nombre "id".
    @SerializedName("id") var id: Int? = null,
    // Anota la propiedad 'movie_name' con @SerializedName("movie_name"). Esto indica a Gson que esta propiedad Kotlin corresponde al campo JSON con el nombre "movie_name".
    var movie_name: String? = null
)
-- Crear la base de datos (si no existe)
CREATE DATABASE IF NOT EXISTS portfolio;

-- Usar la base de datos
USE portfolio;

-- Crear la tabla 'proyectos'
CREATE TABLE proyectos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT,
    imagen VARCHAR(255),
    url VARCHAR(255)
);

-- Crear la tabla 'lenguaje'
CREATE TABLE lenguaje (
    id INT AUTO_INCREMENT PRIMARY KEY,
    imagen VARCHAR(255),
    nombre VARCHAR(255) NOT NULL
);

-- Crear la tabla de unión 'proyectos_lenguajes'
CREATE TABLE proyectos_lenguajes (
    proyecto_id INT,
    lenguaje_id INT,
    PRIMARY KEY (proyecto_id, lenguaje_id),
    FOREIGN KEY (proyecto_id) REFERENCES proyectos(id),
    FOREIGN KEY (lenguaje_id) REFERENCES lenguaje(id)
);

-- Insertar datos en la tabla 'proyectos'
INSERT INTO proyectos (nombre, descripcion, imagen, url)
VALUES
    ("Trivial", "Juego clásico del trivial con registro de jugadores y puntuación con lado cliente y servidor", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQbQoVKwdsFY3lPTPnC2JR6Lwj8kUyQR4GIYw&s", "https://gitlab.com/cronos5952007/trivialmaster.git"),
    ("Login", "Login de una app móvil que guarda en shared preferences los correos, nombres y contraseñas", "https://www.videojuegosydesarrollo.com/wp-content/uploads/2020/01/login-blue-tones.jpg", "https://gitlab.com/grupo3144306/login.git"),
    ("Pokedex", "Aplicación móvil que se conecta a una API rest para cargar una lista de Pokemon y mostrarlos como si se tratase de una pokedex", "https://user-images.githubusercontent.com/84812552/233459737-46aa426a-7c0a-439c-8ebc-b0a6ca89ba01.png", "https://gitlab.com/grupo3144306/pokedex.git"),
    ("APIPokemon", "API rest que contiene un listado de los 151 primeros pokemon", "https://images.wikidexcdn.net/mwuploads/wikidex/thumb/5/56/latest/20200307023245/Charmander.png/800px-Charmander.png", "https://gitlab.com/grupo3144306/apipokemon.git");

-- Insertar datos en la tabla 'lenguaje'
INSERT INTO lenguaje (imagen, nombre) VALUES
    ("https://proximahost.es/blog/wp-content/uploads/2022/01/java.jpg", "java"),
    ("https://cms-assets.tutsplus.com/uploads/users/1499/posts/29820/preview_image/kotlin.jpg", "Kotlin");

-- Insertar datos en la tabla 'proyectos_lenguajes'
INSERT INTO proyectos_lenguajes (proyecto_id, lenguaje_id) VALUES
    (1, 1),
    (2, 2),
    (3, 2),
    (4, 1);
CREATE DATABASE TRIVIAL_DB;
 
USE TRIVIAL_DB;
 
-- Tabla para almacenar los jugadores
CREATE TABLE Jugadores (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    puntuacion INT DEFAULT 0,
    fechaRegistro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
ALTER TABLE Jugadores ADD COLUMN contrasena VARCHAR(255) NOT NULL;
 
 
-- Tabla para almacenar a los administradores
CREATE TABLE Administradores (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario VARCHAR(50) NOT NULL UNIQUE DEFAULT 'default_usuario',
    contrasena VARCHAR(255) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100)
);
-- NOTAS DE MODIFICACIÓNES EN CODIGO JAVA -- 
ALTER TABLE nombre_de_la_tabla ADD COLUMN email VARCHAR(255);
ALTER TABLE administradores ALTER COLUMN usuario SET DEFAULT 'default_usuario';
 
 
 
-- Tabla para almacenar las preguntas del trivial
CREATE TABLE Preguntas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    texto VARCHAR(255) NOT NULL,
    opcionA VARCHAR(100) NOT NULL,
    opcionB VARCHAR(100) NOT NULL,
    opcionC VARCHAR(100) NOT NULL,
    correcta ENUM('A', 'B', 'C') NOT NULL
);
-- preguntas de prueba--
INSERT INTO Preguntas (pregunta, opcion_a, opcion_b, opcion_c, correcta) VALUES
('¿Cuál es el Pokémon inicial tipo fuego de la primera generación?', 'Charmander', 'Squirtle', 'Bulbasaur', 'A'),
('¿Qué tipo es Pikachu?', 'Eléctrico', 'Fuego', 'Agua', 'A'),
('¿Cómo se llama la evolución de Eevee tipo agua?', 'Vaporeon', 'Jolteon', 'Flareon', 'A'),
('¿Qué objeto necesitas para evolucionar a Pikachu en Raichu?', 'Piedra Trueno', 'Piedra Fuego', 'Piedra Agua', 'A'),
('¿Cuál es el nombre del equipo villano en Pokémon Rojo y Azul?', 'Team Rocket', 'Team Magma', 'Team Aqua', 'A');
 
-- Ajustes hechos para funcionalidad del codigo-- 
ALTER TABLE Preguntas CHANGE texto pregunta VARCHAR(255) NOT NULL;
ALTER TABLE Preguntas CHANGE opcionA opcion_a VARCHAR(100) NOT NULL;
ALTER TABLE Preguntas CHANGE opcionB opcion_b VARCHAR(100) NOT NULL;
ALTER TABLE Preguntas CHANGE opcionC opcion_c VARCHAR(100) NOT NULL;
 
-- Tabla para almacenar las puntuaciones de los jugadores
CREATE TABLE Puntuaciones (
    id INT AUTO_INCREMENT PRIMARY KEY,
    jugadorId INT NOT NULL,
    puntos INT NOT NULL,
    fechaActualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (jugadorId) REFERENCES Jugadores(id) ON DELETE CASCADE
);
 
-- Tabla para registrar las sesiones de juego
CREATE TABLE Juegos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    adminId INT NOT NULL,
    jugadorId INT NOT NULL,
    fechaJuego TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    puntuacionFinal INT NOT NULL,
    FOREIGN KEY (adminId) REFERENCES Administradores(id) ON DELETE CASCADE,
    FOREIGN KEY (jugadorId) REFERENCES Jugadores(id) ON DELETE CASCADE
);
 
CREATE TABLE partidas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    puntuacion INT NOT NULL,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
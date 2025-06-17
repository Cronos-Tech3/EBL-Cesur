-- Crear base de datos
CREATE DATABASE usersTrivial;
USE usersTrivial;

-- Crear tabla User
CREATE TABLE User (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL
);

-- Crear tabla Player
CREATE TABLE Player (
    id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES User(id)
);

-- Crear tabla Admin
CREATE TABLE Admin (
    id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES User(id)
);

-- Crear tabla Pregunta
CREATE TABLE Pregunta (
    id INT AUTO_INCREMENT PRIMARY KEY,
    texto VARCHAR(255) NOT NULL
);

-- Crear tabla Partida
CREATE TABLE Partida (
    id INT AUTO_INCREMENT PRIMARY KEY,
    player_id INT,
    puntuacion INT NOT NULL,
    FOREIGN KEY (player_id) REFERENCES Player(id)
);
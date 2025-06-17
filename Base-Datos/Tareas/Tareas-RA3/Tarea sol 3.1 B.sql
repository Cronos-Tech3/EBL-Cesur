-- 1.	Crea una esquema de Entidad – Relación de una biblioteca con las siguientes características:
-- •	De los libros se guarda un número de identificación, el título, el autor, descripción del libro, la fecha de publicación y número de ejemplares.
-- •	De los socios, se tiene el carnet de socio, el nombre, el apellido y la fecha de alta.
-- •	Un libro se puede prestar a varios socios, y un socio puede tener varios libros prestados. Es necesario conocer la fecha de préstamo de cada libro a cada socio. 
/*
  --------            /     \                ----------
 | libro | (0,N)____/ prestar \ ______(0,N) | socio  |
  --------           \       /               ----------
*/

-- 2.	Pasa la estructura anterior a un modelo relacional.
/*
Libro (IDLibro, título, autor, descripción, FechaPublicacion)
Socio (CarnetSocio, nombre, apellido, FechaAlta)
Prestar (IDPrestamo, IDLibro, CarnetSocio, FechaPrestamo)
*/

-- 3.	Crea la base de datos y tablas obtenidas en el del punto anteriormente en mySQL, usando los datos que consideré más adecuados.
CREATE DATABASE Biblioteca;
USE Biblioteca;

CREATE TABLE Libros (
    IDLibro INT,
    Titulo VARCHAR(100),
    Autor VARCHAR(100),
    Descripcion TEXT,
    FechaPublicacion DATE
);

CREATE TABLE Socios (
    CarnetSocio INT,
    Nombre VARCHAR(50),
    Apellido VARCHAR(50),
    FechaAlta DATE
);

CREATE TABLE Prestamos (
    IDPrestamo INT,
    IDLibro INT,
    CarnetSocio INT,
    FechaPrestamo DATE
);



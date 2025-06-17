create database startrek;
use startrek;

create TABLE Actores(
Codigo integer,
Nombre varchar(50) NOT NULL,
Fecha DATE NOT NULL,
Nacionalidad varchar(20) 
);

CREATE TABLE Personajes(
Codigo integer,
Nombre varchar(50) NOT NULL,
Raza varchar(20) NOT NULL,
Grado varchar(20) NOT NULL,
CodigoActor integer NOT NULL,
CodigoSuperior integer NULL
);

CREATE TABLE Planetas(
Codigo integer,
Galaxia varchar(50) NULL,
Nombre varchar(50) NOT NULL
);

CREATE TABLE Capitulos(
Temporada integer,
Orden integer,
Titulo varchar(50) NOT NULL,
Fecha date NOT NULL
);

CREATE TABLE Peliculas(
Codigo integer,
Titulo varchar(50) NOT NULL,
Director varchar(50) NOT NULL,
Anyo Date NOT NULL
);

CREATE TABLE PersonajesCapitulos(
CodigoPersonaje integer,
Temporada integer NOT NULL,
Orden integer NOT NULL
);

CREATE TABLE PersonajesPeliculas(
CodigoPersonaje integer,
CodigoPelicula integer 
);

CREATE TABLE Naves(
Codigo integer,
NTripulantes integer NULL,
Nombre varchar(50) NOT NULL
);

CREATE TABLE Visitas(
CodigoNave integer,
CodigoPlaneta integer,
Temporada integer NOT NULL,
Orden integer NOT NULL
);



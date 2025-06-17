-- DDL: create, alter, drop

-- base de datos

create database animales;
create database animales2;
create database ANIMALES;
SHOW DATABASES;
drop database ANIMALES;

use animales;
-- perro (nombre, edad, peso, fechaConsulta)
create table perro (
	nombre varchar(10), 
    edad int, 
    peso decimal (5,2), -- float, double
    fechaConsulta date
    );
    
-- DROP TABLE perro;

-- restricciones PRIMARY KEY
create table perro2 (
	id int auto_increment primary key,
	nombre varchar(10), 
    edad int, 
    peso decimal (5,2), -- float, double
    fechaConsulta date
    );

-- DROP TABLE perro2;


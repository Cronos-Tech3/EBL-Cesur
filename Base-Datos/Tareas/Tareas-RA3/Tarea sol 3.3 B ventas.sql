
DROP DATABASE IF EXISTS ventas;
CREATE DATABASE ventas CHARACTER SET latin1;

USE ventas;
CREATE TABLE cliente (
id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(25),
primer_apellido VARCHAR(15) NOT NULL,
ciudad VARCHAR(100),
categoria INT UNSIGNED
);
CREATE TABLE comercial (
id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(100) NOT NULL,
apellido1 VARCHAR(100) NOT NULL,
apellido2 VARCHAR(100),
ciudad VARCHAR(100),
comision FLOAT
);

alter database ventas character set utf8mb4;

alter table cliente 
modify nombre varchar(100) not null;

describe  cliente;

alter table cliente rename column primer_apellido to ape1;
alter table cliente modify ape1 varchar(100) null;

alter table cliente add column apellido2 varchar(100) null after ape1;

alter table cliente drop column categoria;

alter table comercial modify comision float default (10); 


create database mascotas;
-- tabla con restricciones
-- Clave primaria (PRIMARY KEY)​
-- Claves alternativas (UNIQUE)​
-- Campos no nulos (NOT NULL)​
-- Valores por defecto (DEFAULT)​
-- Comprobación de valores válidos (CHECK)​
-- Claves ajenas (FOREIGN KEY)​
use mascotas;
create table perros (
chip int primary key,
nombre varchar(20) not null,
email varchar(100) unique,
ciudad varchar(50) default ('Madrid'),
fecha_alta datetime default now(),
edad int check (edad > 0 and edad <= 25)
);

create table perros2 (
chip int,
nombre varchar(20) not null,
email varchar(100),
ciudad varchar(50) default ('Madrid'),
fecha_alta datetime default now(),
edad int,
constraint pkChipPerros2 primary key (chip),
constraint unEmailPerros2 UNIQUE (email),
constraint chkEdadPerros2 CHECK (edad > 0 and edad <= 25),
constraint chkFecha_altaPerros2 CHECK (fecha_alta >= '2000-01-01')
);

create table amos (
dni varchar(10) primary key,
nombre varchar(30) not null,
direccion varchar(50) 
);

create table cuidadores (
dni varchar(10) primary key,
nombre varchar(30) not null
);

create table perrosUltimate (
chip int,
nombre varchar(20) not null,
email varchar(100),
ciudad varchar(50) default ('Madrid'),
fecha_alta datetime default now(),
edad int,
dni_amo varchar(19), -- ojo! aquí le he puesto varchar(19) es más grande que el de la tabla amos, pero como es el mismo tipo de datos lo permite
dni_cuidador varchar(10),
constraint pkChipPerrUltimate primary key (chip),
constraint unEmailPerrUltimate UNIQUE (email),
constraint chkEdadPerrUltimate CHECK (edad > 0 and edad <= 25),
constraint chkFecha_altaPerrUltimate CHECK (fecha_alta >= '2000-01-01'),
constraint foreign key (dni_amo) references amos(dni) on delete cascade on update cascade,
constraint foreign key (dni_cuidador) references cuidadores(dni) on delete set null on update cascade
);
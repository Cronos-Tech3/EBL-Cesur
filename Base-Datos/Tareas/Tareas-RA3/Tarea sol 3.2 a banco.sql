/*
1.	Crea una base de datos con el nombre BANCO
*/
create database banco;
/* 
2.	En la base de datos anterior, cree la tabla EMPLEADO con los siguientes campos:
Id: Número entero 
Nombre: Texto de 25 caracteres
Fecha_Nacimiento: Fecha
Salario: Número de 8 cifras de ellas 2 decimales
Peso: Número entero
Telefono: Texto de 9 caracteres
*/
use banco;
CREATE TABLE empleado (
id int,
nombre VARCHAR (25),
fecha_nacimiento DATE,
salario decimal (8,2), -- también float 
peso int,
telefono CHAR (9) -- varchar(9)
);

/* 
3.	En la base de da
tos anterior, cree la siguientes tablas, con los tipos de datos que considere más adecuado 
y con las restricciones que se indican:

Cliente (idC, dni, nombre, direcciónCli)
•	Clave Primaria: IdC
•	Valor único: Dni 
*/
CREATE TABLE Cliente(
idC INT  PRIMARY KEY,
dni char (10)  UNIQUE, -- también varchar, int no puede ser porque tiene también letras
nombre VARCHAR (50),
direccionCli VARCHAR (50)
);
/* 
Sucursal (NumSuc, dirección, Provincia)
•	Clave Primaria: NumSuc 
•	Valor por defecto de provincia es Madrid
*/
CREATE TABLE Sucursal (
NumSuc int PRIMARY KEY,
direccion VARCHAR (50),
provincia VARCHAR (25) DEFAULT 'Madrid' -- santa cruz de tenerife
);

/*
Cuenta (NumCuenta, Saldo)
•	Clave Primaria: NumCuenta de Cuenta
*/
CREATE TABLE cuenta(
NumCuenta int PRIMARY KEY,
Saldo decimal (9,2) -- 1234567.89
);
/*
Transacción (NumTran, fecha, cantidad, numcuenta)
•	Clave Primaria: NumTran 
•	Comprobar que el valor cantidad está entre -2000 y 3000
•	El campo numcuenta de transacción está relacionado con el campo numCuenta de Cuenta con la opción de borrado en cascada
*/
CREATE TABLE transaccion(
NumTran int PRIMARY KEY,
Fecha DATE,
cantidad decimal (7,2) CONSTRAINT ch_cantidad CHECK (cantidad >-2000 AND cantidad< 3000), 
numCuenta int,
-- , CONSTRAINT ch_cantidad CHECK (cantidad >-2000 AND cantidad< 3000),
constraint fk_tran FOREIGN KEY (NUMCUENTA) REFERENCES cuenta (numCuenta)
);

/*ClienteCuenta (Cliente, numSuc, NumCuenta)
•	Clave Primaria: Cliente y numcuenta 
•	No permitir valor nulos en el campo numSuc de ClienteCuenta
•	Los campos de cliente y numCuenta de ClienteCuenta, se relacionan con los campos idC de Cliente y con el campo NumCuenta de cuenta, respectivamente. 
*/
CREATE TABLE ClienteCuenta(
cliente int,
numSuc int NOT NULL,
numCuenta int ,
CONSTRAINT pk_ClienteCuenta PRIMARY KEY (cliente, numCuenta),
CONSTRAINT fk_Client foreign key(CLIENTE) REFERENCES Cliente (idC),
CONSTRAINT fk_CL_CU foreign key(NUMCuenta) REFERENCES cuenta (numCuenta)
);

show tables;




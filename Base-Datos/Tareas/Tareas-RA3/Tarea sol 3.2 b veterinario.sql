/*
Crea en la base de datos Veterinario las tablas:
•	Clientes (serán los dueños de los animales), se indicará su nombre y datos de contacto 
•	Mascotas, que contiene el nombre de la mascota, la fecha de nacimiento, 
    el nombre del amo y el nº de la historia (es diferente para cada animal)
•	Vacunas, que contiene la fecha y hora en la que se ha vacunado a cada mascota.

Si un cliente solicita que se borren sus datos, también se borraran los datos de su animal,
 y  si cambia su DNI este cambio también se debe reflejar en toda la base de datos

Si un animal cambia su identificación, esto se transmitirá en todos los datos de la base de datos; pero si es baja, 
la vacuna con su fecha y hora no se debe borrar (aunque no tenga el identificador del animal)
Nota: puede añadir los campos y las restricciones que considere adecuadas.

*/
create  DATABASE Veterinario;
USE Veterinario;

create table clientes(
dni varchar(10) PRIMARY KEY,
nombre varchar(50),
dirección varchar(60),
telefono varchar(10)
);

CREATE TABLE Mascotas (
nHistoria int primary key, 
Nombre VARCHAR(15),
raza varchar(50),
FechaNacim DATE,
Amo VARCHAR(10) REFERENCES clientes (dni) ON UPDATE CASCADE ON DELETE CASCADE 
-- , CONSTRAINT FP_MA_CL FOREIGN KEY (AMO) REFERENCES clientes (dni) ON UPDATE CASCADE ON DELETE CASCADE 
) ;

CREATE TABLE vacunas (
id int auto_increment primary key,
fecha date,
hora time,
-- FECHA_HORA timestamp,
animal int,  -- references mascotas (nHistoria) ON DELETE SET NULL ON UPDATE CASCADE 
CONSTRAINT FP_MA_VA FOREIGN KEY (animal) references mascotas (nHistoria) ON DELETE SET NULL ON UPDATE CASCADE 
);








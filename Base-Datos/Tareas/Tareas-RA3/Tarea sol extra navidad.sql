
/*1.	Crea una base de datos con el nombre AmigoInvisible*/

-- drop database AmigoInvisible;
create database AmigoInvisible;
use AmigoInvisible;

/*2.	En esa base de datos crea las siguientes tablas (los tipos de datos los puedes ver en el squema)
*/
-- Es importante el orden de creación, para poner las claves foráneas

/*Regalos (id_regalo, nombre_regalo, descripción, precio)
•	Clave Primaria: id_regalo
•	El nombre y el precio son datos obligatorios
•	El precio tiene que ser entre 15 y 30 euros
*/
CREATE TABLE Regalos (
    ID_Regalo INT PRIMARY KEY,
    Nombre_Regalo VARCHAR(100) NOT NULL,
    Descripcion VARCHAR(255),
    Precio DECIMAL(4, 2) NOT NULL CHECK (precio>= 15 AND precio<= 30)
);

/*
Personas (id_Persona, nombre, edad, dirección)
•	Clave Primaria: id_Persona
•	El nombre es un dato obligatorio
•	Comprobar que la edad está entre 15  y 100
•	Valor por defecto de dirección es C/ Mayor, 3. Madrid
*/

CREATE TABLE Personas (
    ID_Persona INT PRIMARY KEY,
    Nombre VARCHAR(50) NOT NULL,
    Edad INT CHECK (edad>=15 and edad<100), 
    Direccion VARCHAR(150) DEFAULT 'C/ Mayor, 3. Madrid'
);

/* 
Intercambioregalos (idRelación, id_Persona_Origen, id_Persona_Destino, id_Regalo)
•	Clave Primaria: idRelación
•	Valor único: id_Persona_Origen, id_Persona_Destino
•	id_Persona_Origen tiene que hacer referencia a una persona
•	id_Persona_ Destino tiene que hacer referencia a una persona
•	id_Regalo tiene que hacer referencia a un regalo

*/
CREATE TABLE IntercambioRegalos (
    ID_Relacion INT PRIMARY KEY,
    ID_Persona_Origen INT,
    ID_Persona_Destino INT,
    ID_Regalo INT,
    FOREIGN KEY (ID_Persona_Origen) REFERENCES Personas(ID_Persona),
    FOREIGN KEY (ID_Persona_Destino) REFERENCES Personas(ID_Persona),
    FOREIGN KEY (ID_Regalo) REFERENCES Regalos(ID_Regalo),
    UNIQUE (ID_Persona_Origen,ID_Persona_Destino)
);

/*3.	Visualiza el esquema de la tabla, debe ser igual al siguiente:*/
-- menú database - reverse engineer

/*4.	Introduce varios datos donde se comprueben que se cumplen todas las restricciones*/

insert into Regalos (ID_Regalo, Nombre_Regalo, Descripcion,Precio)
values 	(1, 'guantes', 'Sirven para abrigarte las manos', 20.5),
		(2, 'perfume', 'para oler muy bien', 25.9);

insert into Personas (ID_Persona, Nombre, Edad, Direccion)
values 	(101, 'Juan', 25, 'C/ Osa, 6. Madrid'),
		(102, 'Ana', 26, 'C/ León, 10. Getafe');

insert into IntercambioRegalos (ID_Relacion, ID_Persona_Origen, ID_Persona_Destino, ID_Regalo)
values 	(1000, 101, 102, 1),
		(1001, 102, 101, 2);
        
--
/* Comprobación de restricciones de regalos*/
-- Clave Primaria: id_regalo
insert into Regalos (ID_Regalo, Nombre_Regalo, Descripcion,Precio)
values 	(1, 'bufanda', 'te abriga el cuello', 15.5);

-- El nombre y el precio son datos obligatorios
insert into Regalos (ID_Regalo, Descripcion,Precio)
values 	(3, 'te abriga el cuello', 15.5);

insert into Regalos (ID_Regalo, Nombre_Regalo, Descripcion)
values 	(3, 'bufanda', 'te abriga el cuello');

-- El precio tiene que ser entre 15 y 30 euros
insert into Regalos (ID_Regalo, Nombre_Regalo, Descripcion,Precio)
values 	(3, 'bufanda', 'te abriga el cuello', 10.5);

insert into Regalos (ID_Regalo, Nombre_Regalo, Descripcion,Precio)
values 	(3, 'bufanda', 'te abriga el cuello', 40.5);

/* Comprobación de restricciones de personas*/

-- 	Clave Primaria: id_Persona

insert into Personas (ID_Persona, Nombre, Edad, Direccion)
values 	(101, 'Eva', 21, 'C/ Oca, 16. Parla');

-- El nombre es un dato obligatorio

insert into Personas (ID_Persona, Edad, Direccion)
values 	(103, 21, 'C/ Oca, 16. Parla');

-- Comprobar que la edad está entre 15  y 100

insert into Personas (ID_Persona, Nombre, Edad, Direccion)
values 	(103, 'Eva', 14, 'C/ Oca, 16. Parla');

insert into Personas (ID_Persona, Nombre, Edad, Direccion)
values 	(103, 'Eva', 101, 'C/ Oca, 16. Parla');

-- 	Valor por defecto de dirección es C/ Mayor, 3. Madrid

insert into Personas (ID_Persona, Nombre, Edad)
values 	(103, 'Eva', 21); -- ESTO FUNCIONA BIEN, SE VE EL RESULTADO EN LA SIGUIENTE SENTENCIA

select * from Personas;

/* Comprobación de restricciones de  IntercambioRegalos */
-- Clave Primaria: idRelación
insert into IntercambioRegalos (ID_Relacion, ID_Persona_Origen, ID_Persona_Destino, ID_Regalo)
values 	(1000, 102, 103, 2);

-- Valor único: id_Persona_Origen, id_Persona_Destino (una persona no puede hacer dos regalos que vayan destinados a la otra persona)
insert into IntercambioRegalos (ID_Relacion, ID_Persona_Origen, ID_Persona_Destino, ID_Regalo)
values 	(1003, 101, 102, 2);

insert into IntercambioRegalos (ID_Relacion, ID_Persona_Origen, ID_Persona_Destino, ID_Regalo)
values 	(1003, 101, 103, 2); -- Esta funciona bien

insert into IntercambioRegalos (ID_Relacion, ID_Persona_Origen, ID_Persona_Destino, ID_Regalo)
values 	(1004, 103, 102, 2); -- Esta funciona bien

-- id_Persona_Origen tiene que hacer referencia a una persona
insert into IntercambioRegalos (ID_Relacion, ID_Persona_Origen, ID_Persona_Destino, ID_Regalo)
values 	(1005, 104, 102, 1);

-- 	id_Persona_ Destino tiene que hacer referencia a una persona

insert into IntercambioRegalos (ID_Relacion, ID_Persona_Origen, ID_Persona_Destino, ID_Regalo)
values 	(1005, 101, 104, 1);

-- 	id_Regalo tiene que hacer referencia a un regalo
insert into IntercambioRegalos (ID_Relacion, ID_Persona_Origen, ID_Persona_Destino, ID_Regalo)
values 	(1005, 103, 101, 4);

select * from IntercambioRegalos;

-- --------------------------ACTIVIDAD B------------------------------------------------------

/*1.	Crea una base de datos con el nombre AmigoInvisible2*/

-- drop database AmigoInvisible2;
create database AmigoInvisible2;
use AmigoInvisible2;

/*2.	En esa base de datos crea las siguientes tablas, solo con un campo
Intercambioregalos (idRelación)
Personas (id_Persona)
Regalos (id_regalo)
*/
CREATE TABLE Regalos ( ID_Regalo INT  );
CREATE TABLE Personas ( ID_Persona INT );
CREATE TABLE IntercambioRegalos (   ID_Relacion INT  );

/*3.	Modifica las tablas anteriores, en el caso de restricciones ponles un nombre cuando sea posible (Consejo: hacer una instrucción por cada uno de los puntos):
En la tabla Regalos:
•	Inserta el campo nombre de regalo
•	Inserta el campo descripción
•	Inserta el campo precio*/

ALTER TABLE Regalos ADD COLUMN Nombre_Regalo VARCHAR(100);
ALTER TABLE Regalos ADD COLUMN Descripcion VARCHAR(255);
ALTER TABLE Regalos ADD COLUMN Precio DECIMAL(4, 2);

/*En la tabla Personas:
•	Inserta el campo nombre
•	Inserta el campo edad
•	Inserta el campo dirección*/
ALTER TABLE Personas ADD COLUMN Nombre VARCHAR(50);
ALTER TABLE Personas ADD COLUMN  Edad INT ;
ALTER TABLE Personas ADD COLUMN  Direccion VARCHAR(150)  ;
 
/*En la tabla Intercambioregalos:
•	Inserta el campo id de la persona de origen
•	Inserta el campo id de la persona de destino
•	Inserta el campo id de regalo*/
ALTER TABLE IntercambioRegalos ADD COLUMN ID_Persona_Origen INT;
ALTER TABLE IntercambioRegalos ADD COLUMN ID_Persona_Destino INT;
ALTER TABLE IntercambioRegalos ADD COLUMN ID_Regalo INT;

/*En la tabla Regalos:
•	Añade la restricción de clave primaria el campo id de regalo
•	El campo nombre es obligatorio
•	El campo precio es obligatorio
•	El campo precio tiene que estar entre 15 y 30 euros*/
ALTER TABLE Regalos ADD PRIMARY KEY (ID_Regalo);
ALTER TABLE Regalos MODIFY COLUMN  Nombre_Regalo VARCHAR(100) NOT NULL;
ALTER TABLE Regalos MODIFY COLUMN  Precio DECIMAL(4, 2) NOT NULL;
ALTER TABLE Regalos ADD CONSTRAINT ch_precio CHECK (precio>= 15 AND precio<= 30);
  
/*En la tabla Personas:
•	Añade la restricción de clave primaria el campo id de persona
•	El campo nombre es obligatorio
•	El campo edad tiene que estar entre 15 y 100 euros
•	El campo dirección tiene que tener un valor por defecto de ‘C/ Mayor, 3. Madrid’*/
ALTER TABLE Personas ADD PRIMARY KEY (ID_Persona);
ALTER TABLE Personas MODIFY COLUMN  Nombre VARCHAR(50) NOT NULL;
ALTER TABLE Personas ADD CONSTRAINT ch_edad CHECK (edad>=15 and edad<100);
ALTER TABLE Personas MODIFY COLUMN  Direccion VARCHAR(150) DEFAULT 'C/ Mayor, 3. Madrid';

/*En la tabla Intercambioregalos:
•	Añade la restricción de clave primaria el campo id de relación
•	El id_Persona_Origen y el  id_Persona_Destino no se puede repetir
•	id_Persona_Origen tiene que hacer referencia a una persona
•	id_Persona_ Destino tiene que hacer referencia a una persona
•	id_Regalo tiene que hacer referencia a un regalo*/
ALTER TABLE IntercambioRegalos ADD PRIMARY KEY (ID_Relacion);
ALTER TABLE IntercambioRegalos ADD CONSTRAINT un_orides 
	UNIQUE (ID_Persona_Origen,ID_Persona_Destino)    ;
ALTER TABLE IntercambioRegalos ADD CONSTRAINT fk_origen 
	FOREIGN KEY (ID_Persona_Origen) REFERENCES Personas(ID_Persona);
ALTER TABLE IntercambioRegalos ADD CONSTRAINT fk_destino
	FOREIGN KEY (ID_Persona_Destino) REFERENCES Personas(ID_Persona);
ALTER TABLE IntercambioRegalos ADD CONSTRAINT fk_regalo 
	FOREIGN KEY (ID_Regalo) REFERENCES Regalos(ID_Regalo);
    
/*	Visualiza el esquema de la tabla
4.	Introduce varios datos donde se comprueben que se cumplen todas las restricciones*/

insert into Regalos (ID_Regalo, Nombre_Regalo, Descripcion,Precio)
values 	(1, 'guantes', 'Sirven para abrigarte las manos', 20.5),
		(2, 'perfume', 'para oler muy bien', 25.9);
insert into Personas (ID_Persona, Nombre, Edad, Direccion)
values 	(101, 'Juan', 25, 'C/ Osa, 6. Madrid'),
		(102, 'Ana', 26, 'C/ León, 10. Getafe');
insert into IntercambioRegalos (ID_Relacion, ID_Persona_Origen, ID_Persona_Destino, ID_Regalo)
values 	(1000, 101, 102, 1),
		(1001, 102, 101, 2);
        
/* Comprobación de restricciones de regalos*/
-- Clave Primaria: id_regalo
insert into Regalos (ID_Regalo, Nombre_Regalo, Descripcion,Precio)
values 	(1, 'bufanda', 'te abriga el cuello', 15.5);

-- El nombre y el precio son datos obligatorios
insert into Regalos (ID_Regalo, Descripcion,Precio)
values 	(3, 'te abriga el cuello', 15.5);

insert into Regalos (ID_Regalo, Nombre_Regalo, Descripcion)
values 	(3, 'bufanda', 'te abriga el cuello');

-- El precio tiene que ser entre 15 y 30 euros
insert into Regalos (ID_Regalo, Nombre_Regalo, Descripcion,Precio)
values 	(3, 'bufanda', 'te abriga el cuello', 10.5);

insert into Regalos (ID_Regalo, Nombre_Regalo, Descripcion,Precio)
values 	(3, 'bufanda', 'te abriga el cuello', 40.5);

/* Comprobación de restricciones de personas*/

-- 	Clave Primaria: id_Persona

insert into Personas (ID_Persona, Nombre, Edad, Direccion)
values 	(101, 'Eva', 21, 'C/ Oca, 16. Parla');

-- El nombre es un dato obligatorio

insert into Personas (ID_Persona, Edad, Direccion)
values 	(103, 21, 'C/ Oca, 16. Parla');

-- Comprobar que la edad está entre 15  y 100

insert into Personas (ID_Persona, Nombre, Edad, Direccion)
values 	(103, 'Eva', 14, 'C/ Oca, 16. Parla');

insert into Personas (ID_Persona, Nombre, Edad, Direccion)
values 	(103, 'Eva', 101, 'C/ Oca, 16. Parla');

-- 	Valor por defecto de dirección es C/ Mayor, 3. Madrid

insert into Personas (ID_Persona, Nombre, Edad)
values 	(103, 'Eva', 21); -- funciona bien

select * from Personas;

/* Comprobación de restricciones de  IntercambioRegalos */
-- Clave Primaria: idRelación
insert into IntercambioRegalos (ID_Relacion, ID_Persona_Origen, ID_Persona_Destino, ID_Regalo)
values 	(1000, 102, 103, 2);

-- Valor único: id_Persona_Origen, id_Persona_Destino (una persona no puede hacer dos regalos que vayan destinados a la otra persona)
insert into IntercambioRegalos (ID_Relacion, ID_Persona_Origen, ID_Persona_Destino, ID_Regalo)
values 	(1003, 101, 102, 2);

insert into IntercambioRegalos (ID_Relacion, ID_Persona_Origen, ID_Persona_Destino, ID_Regalo)
values 	(1003, 101, 103, 2); -- Esta funciona bien

insert into IntercambioRegalos (ID_Relacion, ID_Persona_Origen, ID_Persona_Destino, ID_Regalo)
values 	(1004, 103, 102, 2); -- Esta funciona bien

-- id_Persona_Origen tiene que hacer referencia a una persona
insert into IntercambioRegalos (ID_Relacion, ID_Persona_Origen, ID_Persona_Destino, ID_Regalo)
values 	(1005, 104, 102, 1);

-- 	id_Persona_ Destino tiene que hacer referencia a una persona

insert into IntercambioRegalos (ID_Relacion, ID_Persona_Origen, ID_Persona_Destino, ID_Regalo)
values 	(1005, 101, 104, 1);

-- 	id_Regalo tiene que hacer referencia a un regalo
insert into IntercambioRegalos (ID_Relacion, ID_Persona_Origen, ID_Persona_Destino, ID_Regalo)
values 	(1005, 103, 101, 4);

select * from IntercambioRegalos;

/*5.	Borrar las restricciones que has añadido en el punto 3. Comprueba el esquema de la tabla */

ALTER TABLE IntercambioRegalos DROP PRIMARY KEY ;
ALTER TABLE IntercambioRegalos DROP FOREIGN KEY fk_origen ;
ALTER TABLE IntercambioRegalos DROP FOREIGN KEY fk_destino;
ALTER TABLE IntercambioRegalos DROP FOREIGN KEY fk_regalo ;
ALTER TABLE IntercambioRegalos DROP INDEX un_orides   ;


ALTER TABLE Regalos DROP PRIMARY KEY;
ALTER TABLE Regalos MODIFY COLUMN  Nombre_Regalo VARCHAR(100)  NULL;
ALTER TABLE Regalos MODIFY COLUMN  Precio DECIMAL(4, 2)  NULL ;
ALTER TABLE Regalos DROP CHECK ch_precio;

ALTER TABLE Personas DROP PRIMARY KEY;
ALTER TABLE Personas MODIFY COLUMN  Nombre VARCHAR(50)  NULL;
ALTER TABLE Personas DROP CHECK ch_edad;
ALTER TABLE Personas ALTER Direccion DROP DEFAULT ;

/*6.	Vuelve a intentar introducir los datos que han dado error en el punto 5, y comprueba si siguen dando errores.*/

-- Clave Primaria: id_regalo
insert into Regalos (ID_Regalo, Nombre_Regalo, Descripcion,Precio)
values 	(1, 'bufanda', 'te abriga el cuello', 15.5);

-- El nombre y el precio son datos obligatorios
insert into Regalos (ID_Regalo, Descripcion,Precio)
values 	(3, 'te abriga el cuello', 15.5);

insert into Regalos (ID_Regalo, Nombre_Regalo, Descripcion)
values 	(3, 'bufanda', 'te abriga el cuello');

-- El precio tiene que ser entre 15 y 30 euros
insert into Regalos (ID_Regalo, Nombre_Regalo, Descripcion,Precio)
values 	(3, 'bufanda', 'te abriga el cuello', 10.5);

insert into Regalos (ID_Regalo, Nombre_Regalo, Descripcion,Precio)
values 	(3, 'bufanda', 'te abriga el cuello', 40.5);

/* Comprobación de restricciones de personas*/

-- 	Clave Primaria: id_Persona

insert into Personas (ID_Persona, Nombre, Edad, Direccion)
values 	(101, 'Eva', 21, 'C/ Oca, 16. Parla');

-- El nombre es un dato obligatorio

insert into Personas (ID_Persona, Edad, Direccion)
values 	(103, 21, 'C/ Oca, 16. Parla');

-- Comprobar que la edad está entre 15  y 100

insert into Personas (ID_Persona, Nombre, Edad, Direccion)
values 	(103, 'Eva', 14, 'C/ Oca, 16. Parla');

insert into Personas (ID_Persona, Nombre, Edad, Direccion)
values 	(103, 'Eva', 101, 'C/ Oca, 16. Parla');

-- 	Valor por defecto de dirección es C/ Mayor, 3. Madrid

insert into Personas (ID_Persona, Nombre, Edad)
values 	(103, 'Eva', 21); -- da error porque no tiene valor por defecto habría que añadir valor por defecto NULL

select * from Personas;

/* Comprobación de restricciones de  IntercambioRegalos */
-- Clave Primaria: idRelación
insert into IntercambioRegalos (ID_Relacion, ID_Persona_Origen, ID_Persona_Destino, ID_Regalo)
values 	(1000, 102, 103, 2);

-- Valor único: id_Persona_Origen, id_Persona_Destino (una persona no puede hacer dos regalos que vayan destinados a la otra persona)
insert into IntercambioRegalos (ID_Relacion, ID_Persona_Origen, ID_Persona_Destino, ID_Regalo)
values 	(1003, 101, 102, 2);

insert into IntercambioRegalos (ID_Relacion, ID_Persona_Origen, ID_Persona_Destino, ID_Regalo)
values 	(1003, 101, 103, 2); -- Esta funciona bien

insert into IntercambioRegalos (ID_Relacion, ID_Persona_Origen, ID_Persona_Destino, ID_Regalo)
values 	(1004, 103, 102, 2); -- Esta funciona bien

-- id_Persona_Origen tiene que hacer referencia a una persona
insert into IntercambioRegalos (ID_Relacion, ID_Persona_Origen, ID_Persona_Destino, ID_Regalo)
values 	(1005, 104, 102, 1);

-- 	id_Persona_ Destino tiene que hacer referencia a una persona

insert into IntercambioRegalos (ID_Relacion, ID_Persona_Origen, ID_Persona_Destino, ID_Regalo)
values 	(1005, 101, 104, 1);

-- 	id_Regalo tiene que hacer referencia a un regalo
insert into IntercambioRegalos (ID_Relacion, ID_Persona_Origen, ID_Persona_Destino, ID_Regalo)
values 	(1005, 103, 101, 4);

select * from IntercambioRegalos;

-- --------------apartad c----------------------------

select * from Regalos;
select * from Personas;

-- 1.	Modifica los datos que se indican de la tabla Personas
-- •	La dirección de todas las personas es “Madrid”
UPDATE Personas
SET Direccion = "Madrid";

-- •	La personas mayores de 25 años, cambian su dirección a Toledo
UPDATE Personas
SET Direccion = "Toledo"
WHERE edad > 25;

-- •	La edad de todas las personas es 18
UPDATE Personas
SET Edad = 18; 

-- •	La personas que se llaman Ana tienen una edad de 25 años
UPDATE Personas
SET Edad = 25
WHERE Nombre ='Ana'; 

-- •	Las personas que se llaman Eva, cambian su nombre a Carla, y su dirección a Ávila
UPDATE Personas
SET Direccion="Avila", Nombre="Carla"
WHERE Nombre="Eva";

-- •	Las personas que son de Toledo y tienen más de 21 años, tienen un id de 90
UPDATE Personas
SET ID_Persona=90
WHERE Direccion ="Toledo" AND Edad>21;

-- •	Las personas que NO son de Toledo o tienen menos de 21 años, cambian su nombre por Diana
UPDATE Personas
SET Nombre='Diana'
WHERE Direccion !="Toledo" OR Edad<21;

-- •	Las personas que viven en Madrid, suman un año a su edad
UPDATE Personas
SET edad=edad+1
WHERE Direccion = "Madrid";

/*2.	Borrar los siguientes datos
•	Borrar los datos de la tabla Intercambio de Regalos*/
delete from Intercambioregalos;

-- •	Borrar los datos de las personas menores de 20 años.
delete from Personas 
where edad <20; 

-- •	Borrar los datos de las personas de Toledo y que NO se llamen Carla
delete from Personas
where direccion="Toledo" and nombre!="Carla";

/*Usando la base de datos AmigoInvisible.
Borrar la tabla Intercambio de Regalos
Borra la base de datos AmigoInvisible */

use AmigoInvisible;
drop table IntercambioRegalos;
drop database AmigoInvisible;

-- 1.	Crea la tabla DPTO Dpto (Num, Nombre, localidad, pais)
use banco;
CREATE TABLE DPTO (
Num INT, 
Nombre VARCHAR(20), 
localidad VARCHAR (12), 
pais VARCHAR(12));

/*
2.	En la tabla EMPLEADO haz las siguientes modificaciones:
a.	Añade el campo DNI después del campo ID

*/
describe empleado;
ALTER TABLE empleado
ADD dni VARCHAR (10) after id;
/*
b.	Añade el campo apellido después del nombre
*/
ALTER TABLE empleado
ADD apellido VARCHAR (10) after nombre;
/*
c.	Añade el campo comisión después del salario
*/
ALTER TABLE empleado
ADD comision decimal (6,2) after salario;

/*
d.	Añade el campo jefe
e.	Añade el campo NumDpto
*/
ALTER TABLE empleado
ADD jefe int;

ALTER TABLE empleado
ADD numdpto int;

/*
f.	Cambia el nombre del campo Id por NumEmp
*/

ALTER TABLE empleado 
RENAME COLUMN  id TO NumEmp;

/*
g.	Borra el campo fecha de nacimiento, peso y teléfono 
Nota la tabla tendrá los siguientes campos: Empleado (NumEmp, dni nombre, apellido, Salario, comisión, Jefe, NumDpto)
*/
ALTER TABLE  empleado  
DROP COLUMN  fecha_nacimiento ;
ALTER TABLE  empleado  
DROP COLUMN  peso ;
ALTER TABLE  empleado  
DROP COLUMN  telefono ;
describe empleado;

/*
3.	En la tabla DPTO realiza las siguientes modificaciones:
a.	Borra el campo país
b.	Modifica el campo nombre a un tipo de datos de textos de 50 caracteres de longitud
*/
ALTER TABLE dpto
DROP COLUMN pais;
ALTER TABLE dpto
MODIFY nombre VARCHAR (50); -- también MODIFY COLUMN ...

/*
4.	Añade las siguientes restricciones:
a.	No permitir valor nulos en el campo Nombre de empleado
b.	Valor por defecto de comisión es igual a 0
*/
ALTER TABLE empleado
MODIFY nombre varchar(25) NOT NULL;

ALTER TABLE empleado
MODIFY comision decimal(6,2) DEFAULT 0; -- 0.0

/*
c.	Claves primaria NumEmp de empleado y Num de Dpto
d.	Valor único: Dni de cliente
*/

ALTER TABLE empleado
ADD CONSTRAINT pk_empleado PRIMARY KEY (numEmp);
ALTER TABLE dpto
ADD CONSTRAINT pk_dpto PRIMARY KEY (num);

/*
d.	Valor único: Dni de cliente
e.	Comprobar que el valor salario de la tabla empleado es superior a 600 
f.	El campo NumDpto de Empleado está relacionado con la tabla Dpto
g.	El campo Jefe está relacionado con el campo NumEmp de Empleado
*/

ALTER TABLE empleado
ADD CONSTRAINT uniq_dniempleado UNIQUE (dni);

ALTER TABLE empleado 
ADD CONSTRAINT ch_salario CHECK (salario>600);
/*
f.	El campo NumDpto de Empleado está relacionado con la tabla Dpto
g.	El campo Jefe está relacionado con el campo NumEmp de Empleado
*/

ALTER TABLE empleado
ADD CONSTRAINT fk_dpto FOREIGN KEY (numDpto) REFERENCES dpto(num);

ALTER TABLE empleado
ADD CONSTRAINT fk_jefe FOREIGN KEY (jefe) REFERENCES empleado(numEmp);


/*
5.	Borrar la restricción que existe sobre salario de la tabla empleado
*/
ALTER TABLE empleado
DROP CONSTRAINT ch_salario;


/*
6.	Renombrar la tabla Dpto a Departamentos
*/

ALTER TABLE dpto RENAME TO departamentos; 

/*
7.	Renombrar la columna jefe por IdJefe
*/

ALTER TABLE empleado
RENAME COLUMN jefe TO idJefe;

DESCRIBE EMPLEADO;


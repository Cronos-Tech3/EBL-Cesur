-- 1.	 Obtener las registros de la relación MARCAS  para las que el atributo ciudad es “Barcelona”
SELECT *
FROM MARCAS
WHERE CIUDAD='BARCELONA';

-- 2.	Obtener todos los campos  de los clientes de Madrid
SELECT *
FROM clientes
WHERE CIUDAD='MADRID';
-- 3.  Realizar una consulta  en la que aparezca los valores de los atributos apellidos y ciudad para los clientes de Madrid
SELECT APELLIDO, CIUDAD
FROM CLIENTES
WHERE CIUDAD='MADRID';
-- 4.	Obtener las registros de la relación DISTRIBUCION para las que el atributo cantidad toma un valor mayor que 15
SELECT *
FROM DISTRIBUYEN
WHERE CANTIDAD>15;
-- 5.	Obtener el cifc de todos los concesionarios cuyo atributo cantidad en la tabla DISTRIBUCION es mayor que 18
SELECT CIFC
FROM DISTRIBUYEN
WHERE CANTIDAD > 18;
-- 6.	Obtener las registros de la relación CLIENTES para las que el atributo ciudad toma un valor distinto de “Madrid”
SELECT *
FROM CLIENTES
WHERE CIUDAD <> 'MADRID';
-- 7.	Obtener las registros de la relación CLIENTES para las que el atributo apellidos es “García” y el atributo ciudad es “Madrid”
SELECT *
FROM clientes
WHERE APELLIDO='GARCIA' AND CIUDAD='MADRID';
-- 8.	Obtener el cifc de todos los concesionarios cuyo atributo cantidad en la tabla de distribución es mayor que 10 y menor que 5
SELECT CIFC
FROM DISTRIBUYEN
WHERE CANTIDAD > 10 OR CANTIDAD <5;


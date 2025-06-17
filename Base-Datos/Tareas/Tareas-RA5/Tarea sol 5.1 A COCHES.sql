/*	Modifica la tabla VENDEN, para que se pueda almacenar la fecha de venta.*/
 alter table venden add column fechaVenta date; 
 
 /*    Visualiza los datos de la tabla VENDEN. */
 SELECT *
FROM VENDEN;

/*	En el campo fecha de venta completa con los siguientes datos
•	El concesionario 1, ha vendido todos los coches en el año 2018 (completa el mes y el día que quieras)
•	El concesionario 2, ha vendido todos los coches en el año 2019 (completa el mes y el día que quieras)
•	El concesionario 3, ha vendido todos los coches en el año 2020 (completa el mes y el día que quieras)
•	El concesionario 4, ha vendido todos los coches en el año 2021 (completa el mes y el día que quieras)*/
update venden set fechaVenta='2018-01-01' where cifc='001';
update venden set fechaVenta='2019-01-01' where cifc='002';
update venden set fechaVenta='2020-01-01' where cifc='003';
update venden set fechaVenta='2021-01-01' where cifc='004';

--  Obtener todos los campos de todos los concesionarios
SELECT *
FROM CONCESIONARIOS;

-- 	Realizar una consulta en la que aparezcan los valores del atributo apellido de la relación CLIENTES
SELECT APELLIDO
FROM  CLIENTES; 

-- Realizar una consulta en la que aparezcan los valores de los atributos apellidos y ciudad de la relación CLIENTES
SELECT APELLIDO, CIUDAD
FROM CLIENTES;

--  Realizar una consulta donde aparezcan el nombre de los atributos nombre y ciudad de la relación CONCESIONARIO, en la cabecera de las columnas aparecerá Nombre del cliente y Residencia.
SELECT NOMBRE 'Nombre del Cliente', CIUDAD 'Residencia'
FROM CONCESIONARIOS;

-- 1.	Devuelve un listado con el nombre, apellidos y email de los empleados cuyo jefe tiene un código de jefe igual a 7.
select nombre, apellido1, apellido2, email 
from empleado
where codigo_jefe = 7;
-- 2.	Devuelve el nombre del puesto, nombre, apellidos y email del director general de la empresa.
select * from empleado;
select puesto, nombre, apellido1, apellido2, email 
from empleado
where puesto="director General";
-- 3.	Devuelve un listado con el nombre, apellidos y puesto de aquellos empleados que no sean representantes de ventas.
select nombre, apellido1, apellido2, puesto 
from empleado
where puesto <> "representante ventas";
-- 4.	Devuelve un listado con el nombre de los todos los clientes españoles.
select *
from cliente
where pais ="Spain";
-- 5.	Devuelve un listado con los distintos estados por los que puede pasar un pedido.
select distinct estado
from pedido;
-- 6.	Devuelve un listado con el código de pedido, código de cliente, fecha esperada y 
-- fecha de entrega de los pedidos que no han sido entregados a tiempo.
select * from pedido;
select codigo_pedido, fecha_esperada, fecha_entrega
from pedido
where estado ="Entregado" and fecha_entrega <= fecha_esperada;

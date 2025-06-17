-- 2.	Realiza consultas para ver todas las tablas.

select * from cliente;
select * from detalle_pedido;
select * from empleado;
select * from gama_producto;
select * from oficina;
select * from pago;
select * from pedido;
select * from producto;



-- 3.	Devuelve un listado con el código de oficina y la ciudad donde hay oficinas.

select codigo_oficina, ciudad from oficina;

-- 4.	Devuelve un listado con la ciudad y el teléfono de las oficinas
select  ciudad , telefono from oficina;

-- 5.	Muestra una consulta con el nombre y apellido de las persona de contacto, y su dirección completa (cada campo de dirección se separará del siguiente mediante un punto)

select nombre_contacto, apellido_contacto, concat_ws (". ", linea_direccion1, linea_direccion2, ciudad, region, pais, codigo_postal) Dirección from cliente;

-- 6.	Muestra los puestos que ocupan los empleados (cada puesto solo se mostrará una vez).
select distinct puesto from empleado;

-- 7.	Mostrar los detalle de los pedidos: el código de producto, el precio unidad, la cantidad y el precio total a pagar (es el precio unidad por las unidades vendidas)
select codigo_producto, precio_unidad, cantidad,  precio_unidad* cantidad "Precio Total" from detalle_pedido;

-- 8.	Mostrar del pedido, el código de pedido, y los días previstos de entrega
--  (es la diferencia entre la fecha esperada y la fecha pedio),
-- y los días que se ha tardado en entregar (fecha de entrega menos la fecha de pedido), y el estado 
select codigo_pedido, fecha_esperada - fecha_pedido "Días previstos", fecha_entrega - fecha_pedido "Días reales", estado from pedido;

-- 9.	Muestra los distintos márgenes de beneficio que tienen los productos. (el margen es el precio del venta y el precio de proveedor).
select distinct  precio_venta - precio_proveedor Margen from producto;
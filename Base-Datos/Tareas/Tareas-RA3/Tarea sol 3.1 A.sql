-- Crear la base de datos llamada TiendaRopa
CREATE DATABASE TiendaRopa;

-- Muestra las bases de datos que hay en el sistema
show databases;

-- Seleccionar la base de datos para trabajar en ella
USE TiendaRopa;

-- Crear las tablas con los campos y tipos de datos especificados y añadidos
/*
a.	    Tabla Productos:
•	ID_Producto (número entero que se autoincremente).
•	NombreProducto (cadena de texto, máximo 50 caracteres).
•	Categoria (cadena de texto, máximo 30 caracteres).
•	Precio (número decimal con 2 decimales).
•	EnStock (valor verdadero o falso)
*/

CREATE TABLE Productos (
    ID_Producto INT UNSIGNED,          
    NombreProducto VARCHAR(50),             
    Categoria VARCHAR(30),                   
    Precio DECIMAL(10, 2),                  
    EnStock BOOLEAN
);

/*
b.	    Tabla Clientes:
•	ID_Cliente (número entero que se autoincremente).
•	NombreCliente (cadena de texto, máximo 50 caracteres).
•	Email (cadena de texto, máximo 100 caracteres).
•	Telefono (cadena de texto, máximo 15 caracteres).*/

CREATE TABLE Clientes (
    ID_Cliente INT UNSIGNED,           
    NombreCliente VARCHAR(50),              
    Email VARCHAR(100),                     
    Telefono VARCHAR(15),                   
    FechaNacimiento DATE                    
);

/*
c.	    Tabla Ventas:
•	ID_Venta (número entero que se autoincremente).
•	ID_Producto (número entero que se autoincremente).
•	ID_Cliente (número entero que se autoincremente).
•	FechaVenta (fecha).
*/
CREATE TABLE Ventas (
    ID_Venta INT UNSIGNED,             
    ID_Producto INT UNSIGNED,                        
    ID_Cliente INT UNSIGNED,                        
    FechaVenta DATE
);


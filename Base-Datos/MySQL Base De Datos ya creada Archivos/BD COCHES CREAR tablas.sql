-- CREAR BBDD Y PONER EN USO
DROP  DATABASE IF EXISTS Coches;
CREATE DATABASE Coches;
use Coches;

-- - CREAR TABLAS
CREATE TABLE CLIENTES (
DNI INT ,
NOMBRE VARCHAR (15),
APELLIDO VARCHAR (15),
CIUDAD VARCHAR (15) ,
CONSTRAINT pkClientes primary key (dni));
 
CREATE TABLE COCHES (
CODCOCHE INT ,
NOMBRE VARCHAR (10),
MODELO VARCHAR (10),
CONSTRAINT pkCoches primary key (codcoche) );

CREATE TABLE MARCAS ( 
CIFM	INT ,
NOMBRE	VARCHAR (15),
CIUDAD VARCHAR (15),
CONSTRAINT pkMarcas primary key (cifm));

CREATE TABLE CONCESIONARIOS (
CIFC	INT  ,
NOMBRE VARCHAR (10)	,
CIUDAD VARCHAR (15),
CONSTRAINT pkConcesionario primary key (cifc));

CREATE TABLE FABRICA ( 
CIFM INT ,
CODCOCHE INT  ,
CONSTRAINT PK_FABRICA PRIMARY KEY (CIFM, CODCOCHE),
CONSTRAINT fkFabrica_cifm foreign key (cifm) REFERENCES MARCAS (CIFM),
CONSTRAINT fkFabrica_codcoche  foreign key (codcoche) REFERENCES COCHES (CODCOCHE)

);

CREATE TABLE DISTRIBUYEN ( 
CIFC INT	,
CODCOCHE INT ,
CANTIDAD INT ,
CONSTRAINT PK_DISTRIBUYEN PRIMARY KEY (CIFC, CODCOCHE),
CONSTRAINT fkdistribuyen_cifc foreign key (cifc) REFERENCES CONCESIONARIOS (CIFC),
CONSTRAINT fkdistribuyen_codcoche  foreign key (codcoche) REFERENCES COCHES (CODCOCHE)
);

CREATE TABLE VENDEN ( 
CIFC	INT	,
DNI	INT  ,
CODCOCHE	INT ,
COLOR VARCHAR (10),
CONSTRAINT PK_VENDEN PRIMARY KEY (CIFC, DNI, CODCOCHE),
CONSTRAINT fkvenden_cifc foreign key (cifc) REFERENCES CONCESIONARIOS (CIFC),
CONSTRAINT fkvenden_dni foreign key (dni) REFERENCES CLIENTES (DNI),
CONSTRAINT fkvenden_codcoche  foreign key (codcoche) REFERENCES COCHES (CODCOCHE)
); 

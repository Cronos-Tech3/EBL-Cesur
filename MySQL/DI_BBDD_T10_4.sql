-- Paso 1: Crear la base de datos si no existe
CREATE DATABASE IF NOT EXISTS miapp;

-- Paso 2: Seleccionar la base de datos
USE miapp;

-- Paso 3: Crear la tabla 'configuraciones'
-- Contiene columnas para el usuario, la clave de configuración y el valor
-- La clave primaria compuesta asegura que cada par (usuario, clave) sea único
CREATE TABLE IF NOT EXISTS configuraciones (
    usuario VARCHAR(50),
    clave VARCHAR(50),
    valor VARCHAR(255),
    PRIMARY KEY (usuario, clave)
);


INSERT INTO configuraciones (usuario, clave, valor) VALUES ('ejemplo_user', 'VentanaAncho', '600');
INSERT INTO configuraciones (usuario, clave, valor) VALUES ('ejemplo_user', 'VentanaAlto', '400');


-- Crear la base de datos (si no existe)
CREATE DATABASE IF NOT EXISTS portfolio;

-- Usar la base de datos
USE portfolio;

-- Crear la tabla 'proyectos'
CREATE TABLE proyectos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT,
    imagen VARCHAR(255),
    url VARCHAR(255)
);

-- Crear la tabla 'lenguaje'
CREATE TABLE lenguaje (
    id INT AUTO_INCREMENT PRIMARY KEY,
    imagen VARCHAR(255),
    nombre VARCHAR(255) NOT NULL
);

-- Crear la tabla de unión 'proyectos_lenguajes'
CREATE TABLE proyectos_lenguajes (
    proyecto_id INT,
    lenguaje_id INT,
    PRIMARY KEY (proyecto_id, lenguaje_id),
    FOREIGN KEY (proyecto_id) REFERENCES proyectos(id),
    FOREIGN KEY (lenguaje_id) REFERENCES lenguaje(id)
);

-- Insertar datos en la tabla 'proyectos'
INSERT INTO proyectos (nombre, descripcion, imagen, url)
VALUES
    ("Android_LoginRegistro", "Login de una app móvil que guarda en shared preferences los correos, nombres y contraseñas", "https://franklineduardojimenezgiraldo.gitbooks.io/android-studio/content/img_login/diseno_login.png", "https://gitlab.com/cronos5952007/android_loginregistro.git"),
    ("TrivialMaster", "Trivial normal hecho en Java", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRDk37uwYXEWaHMEWx_2PgLwYXZfDmVqwR6HeM-B-WXf4aRHiDGqd9njSSj6EFQrAusX88&usqp=CAU", "https://gitlab.com/cronos5952007/trivialmaster.git"),
    ("Trivial-JDBC", "Trivial con JDBC cliente, servidor y manejador de hilos", "https://upload.wikimedia.org/wikipedia/commons/1/1a/Trivial_Pursuit_icon.png", "https://gitlab.com/cronos5952007/trivial-jdbc.git"),
    ("HuertoAppEnrique", "Api de Android básica que simula un huerto", "https://www.udea.edu.co/wps/wcm/connect/udea/d0d8d235-2dac-438f-a460-2ac2cc61a139/1/WhatsApp+Image+2023-08-14+at+10.02.31.jpeg?MOD=AJPERES", "https://gitlab.com/cronos5952007/huertoapp.git"),
    ("Estacionamiento_Inteligente", "Ejercicio de Hilos y Procesos con semáforo", "https://services.meteored.com/img/article/por-que-los-semaforos-podrian-tener-un-cuarto-color-y-como-nos-beneficia-ambiente-tecnologia-1676835739826_1280.jpg", "https://gitlab.com/cronos5952007/estacionamiento_inteligente.git"),
    ("CifradoYFirma", "API para Cifrar y descifrar mensajes ejercicio", "https://www.itdigitalsecurity.es/files/202311/ciberseguridad-candado.png", "https://gitlab.com/cronos5952007/cifradoyfirma.git");

-- Insertar datos en la tabla 'lenguaje'
INSERT INTO lenguaje (imagen, nombre) VALUES
    ("https://proximahost.es/blog/wp-content/uploads/2022/01/java.jpg", "java"),
    ("https://cms-assets.tutsplus.com/uploads/users/1499/posts/29820/preview_image/kotlin.jpg", "Kotlin");

-- Insertar datos en la tabla 'proyectos_lenguajes'
INSERT INTO proyectos_lenguajes (proyecto_id, lenguaje_id) VALUES
    (1, 1),
    (2, 2),
    (3, 2),
    (4, 1);
    
    
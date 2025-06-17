package com.example.portfolio.model;

import jakarta.persistence.*;

/**
 * Entidad que representa un lenguaje de programación en la base de datos.
 * La tabla asociada en la base de datos se llama "Lenguaje".
 */
@Entity // Anotación de JPA que marca esta clase como una entidad, la cual se mapea a una tabla en la base de datos.
@Table(name="Lenguaje") // Anotación de JPA que especifica el nombre de la tabla en la base de datos a la que se mapea esta entidad.
public class Lenguaje {

    /**
     * Identificador único del lenguaje.
     * Esta propiedad es la clave primaria de la tabla "Lenguaje" y su valor se genera automáticamente.
     */
    @Id // Anotación de JPA que marca este campo como la clave primaria de la entidad.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Anotación de JPA que especifica la estrategia de generación de la clave primaria. GenerationType.IDENTITY indica que la base de datos gestionará la generación automática (auto-incremento).
    private int idLenguaje; // Campo privado para almacenar el ID del lenguaje (entero).
    private String nombre;  // Campo privado para almacenar el nombre del lenguaje (String).
    private String imagen;  // Campo privado para almacenar la ruta o el nombre del archivo de la imagen (String).

    /**
     * Obtiene el identificador único del lenguaje.
     * @return El ID del lenguaje.
     */
    public int getIdLenguaje() {
        return idLenguaje;
    }

    /**
     * Establece el identificador único del lenguaje.
     * @param idLenguaje El nuevo ID del lenguaje.
     */
    public void setIdLenguaje(int idLenguaje) {
        this.idLenguaje = idLenguaje;
    }

    /**
     * Obtiene el nombre del lenguaje.
     * @return El nombre del lenguaje.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del lenguaje.
     * @param nombre El nuevo nombre del lenguaje.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la ruta o nombre del archivo de la imagen del lenguaje.
     * @return La ruta o nombre del archivo de la imagen.
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * Establece la ruta o nombre del archivo de la imagen del lenguaje.
     * @param imagen La nueva ruta o nombre del archivo de la imagen.
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}

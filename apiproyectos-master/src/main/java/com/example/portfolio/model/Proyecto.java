package com.example.portfolio.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Entidad que representa un proyecto en la base de datos.
 * La tabla asociada en la base de datos se llama "proyectos".
 */
@Entity // Anotación de JPA que marca esta clase como una entidad, la cual se mapea a una tabla en la base de datos.
@Table(name = "proyectos") // Anotación de JPA que especifica el nombre de la tabla en la base de datos a la que se mapea esta entidad.
public class Proyecto {

    /**
     * Identificador único del proyecto.
     * Esta propiedad es la clave primaria de la tabla "proyectos" y su valor se genera automáticamente.
     */
    @Id // Anotación de JPA que marca este campo como la clave primaria de la entidad
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Anotación de JPA que especifica la estrategia de generación de la clave primaria. GenerationType.IDENTITY indica que la base de datos gestionará la generación automática (auto-incremento).
    private int id; // Campo privado para almacenar el ID del proyecto (entero).
    private String nombre;  // Campo privado para almacenar el nombre del proyecto (String).
    private String descripcion; // Campo privado para almacenar la descripción del proyecto (String).
    private String imagen;  // Campo privado para almacenar la ruta o el nombre del archivo de la imagen (String).
    private String url;  // Campo privado para almacenar la URL del proyecto (String)

    /**
     * Lista de lenguajes de programación utilizados en este proyecto.
     * Esta relación es de muchos a muchos con la entidad Lenguaje.
     * La persistencia y la fusión de los lenguajes asociados se gestionan mediante la configuración de cascada.
     */
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})  // Anotación de JPA que define una relación muchos a muchos con la entidad Lenguaje. CascadeType.PERSIST y CascadeType.MERGE indican que las operaciones de persistencia y fusión se propagarán a las entidades Lenguaje relacionadas.
    private List<Lenguaje> lenguajes = new ArrayList<>(); // Campo privado para almacenar la lista de objetos Lenguaje asociados al proyecto, inicializada como una nueva lista ArrayList.

    //Getters and setters

    public int getIdProyecto() {
        return id;
    }

    public void setIdProyecto(int idProyecto) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        url = url;
    }

    public List<Lenguaje> getLenguajes() {
        return lenguajes;
    }

    public void setLenguajes(List<Lenguaje> lenguajes) {
        this.lenguajes = lenguajes;
    }
}

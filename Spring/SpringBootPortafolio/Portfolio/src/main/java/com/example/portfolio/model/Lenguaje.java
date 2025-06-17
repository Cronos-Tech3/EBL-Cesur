package com.example.portfolio.model;

import jakarta.persistence.*;

@Entity
public class Lenguaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLenguaje;

    public String Nombre;
    public String Imagen;

    public void setId(Long id) {
        this.idLenguaje = id;
    }

    public Long getId() {
        return idLenguaje;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String imagen) {
        Imagen = imagen;
    }
}

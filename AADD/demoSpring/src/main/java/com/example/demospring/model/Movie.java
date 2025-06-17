package com.example.demospring.model;

import jakarta.persistence.*;

@Entity
@Table(name="Movies")
public class Movie {
    @Id // Anotado restriccion de clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // estrategia para generar un valor
    private Long id;

    private String movie_name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }
}

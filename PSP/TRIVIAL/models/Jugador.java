package TRIVIAL.TRIVIAL.models;

import java.sql.Timestamp;

/**
 * La clase Jugador representa a un jugador en el juego, incluyendo su información personal y puntuación.
 */
public class Jugador {
    private int id;
    private String nombre;
    private String email;
    private String contrasena; // Nueva columna
    private Timestamp fechaRegistro;
    private int puntuacion;

    // Constructor para inicializar un jugador
    public Jugador(int id, String nombre, String email, String contrasena, Timestamp fechaRegistro, int puntuacion) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena; // Inicializa contrasena
        this.fechaRegistro = fechaRegistro;
        this.puntuacion = puntuacion;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Timestamp getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Timestamp fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
}
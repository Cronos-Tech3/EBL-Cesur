package JAVA_APUNTES.Biblioteca_JoseTornero_EnriqueBenito;

import java.util.Arrays;

public class Publicacion {

    //Atributos
    private String titulo;
    private Autoria[] autorias;
    private int ejemplares;
    private int prestados;

    // Constructor
    public Publicacion(String titulo, Autoria[] autorias, int ejemplares) {
        this.titulo = titulo;
        this.autorias = autorias;
        this.ejemplares = ejemplares;
        this.prestados = 0;
    }

    // Getters y Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    // Métodos para prestar y devolver
    public int prestar() {
        if (ejemplares > prestados) {
            prestados++;
            return ejemplares - prestados;
        } else {
            return -1;
        }
    }

    public int devolver() {
        if (prestados > 0) {
            prestados--;
            return ejemplares - prestados;
        } else {
            return -1;
        }
    }

    // metodo toString
    @Override
    public String toString() {
        return "Publicacion{" +
                "titulo='" + titulo + '\'' +
                ", autorias=" + Arrays.toString(autorias) +
                ", ejemplares=" + ejemplares +
                ", prestados=" + prestados +
                '}';
    }
}

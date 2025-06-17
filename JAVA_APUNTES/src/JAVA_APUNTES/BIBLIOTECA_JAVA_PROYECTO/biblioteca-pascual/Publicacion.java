/*package bibliotecaPascualQuiles;

import java.util.Arrays;

public class Publicacion {
    /*tod0 en privado y con getters, solo hay setters para ejemplares y prestados
    que se dan a poder necesitar ser modificados en el futuro
     */
/*
    private String titulo;

    private Autoria [] autoria = new Autoria[5];

    private int ejemplares;

    private int prestados;

    public String getTitulo() {
        return titulo;
    }

    public Autoria[] getAutoria() {
        return autoria;
    }

    public int getEjemplares() {
        return ejemplares;
    }

    public int getPrestados() {
        return prestados;
    }

    @Override
    public String toString() {
        return "Publicacion{" +
                "titulo='" + titulo + '\'' +
                ", autoria=" + Arrays.toString(autoria) +
                ", ejemplares=" + ejemplares +
                ", prestados=" + prestados +
                '}';
    }

    public void setPrestados(int prestados) {
        this.prestados = prestados;
    }

    public void setEjemplares(int ejemplares) {
        this.ejemplares = ejemplares;
    }

    public Publicacion(String titulo, Autoria[] autoria, int ejemplares, int prestados) {
        this.titulo = titulo;
        this.autoria = autoria;
        this.ejemplares = ejemplares;
        this.prestados = prestados;
    }

    //si ya están todos prestados devuelve un -1, en caso contrario añade un prestado y devuelve los ejemplares restantes
    public int prestar(){
        if (prestados == ejemplares) return -1;
        prestados++;
        return ejemplares-prestados;
    }

    //si no hay ninguno prestado devuelve un -1, en caso contrario resta 1 prestado y devuelve los ejemplares restantes
    public int devolver(){
        if (prestados < 1) return -1;
        prestados--;
        return ejemplares-prestados;
    }
}

 */

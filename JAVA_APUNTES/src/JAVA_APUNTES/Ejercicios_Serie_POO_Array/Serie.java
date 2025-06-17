package JAVA_APUNTES.Ejercicios_Serie_POO_Array;

import java.util.Arrays;

public class Serie {

    private String nombre;

    private String genero;

    private Temporada[] temporadas;

    public Serie(String nombre, String genero, Temporada[] temporadas) {
        this.nombre = nombre;
        this.genero = genero;
        this.temporadas = temporadas;
    }

    @Override
    public String toString() {
        return "Serie{" +
                "nombre='" + nombre + '\'' +
                ", genero='" + genero + '\'' +
                ", temporadas=" + Arrays.toString(temporadas) +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Temporada[] getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(Temporada[] temporadas) {
        this.temporadas = temporadas;
    }

    public int capitulos_por_temporadas (Temporada t) {  //
    return t.capitulos_totales();

    }

    public int capitulos_totales() {
        int suma = 0;
        for (int i = 0; i < temporadas.length; i++){
            suma+=temporadas[i].capitulos_totales();
        }
        return suma;
    }

    public double valoracionMedia() {
        int suma = 0;
        for (int i = 0; i < temporadas.length; i++){
            suma+=temporadas[i].capitulos_totales();
        }
        return suma;
    }







}

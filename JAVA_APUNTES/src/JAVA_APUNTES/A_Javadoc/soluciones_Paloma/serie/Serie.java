package JAVA_APUNTES.A_Javadoc.soluciones_Paloma.serie;

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

    @Override
    public String toString() {
        return "Serie{" +
                "nombre='" + nombre + '\'' +
                ", genero='" + genero + '\'' +
                ", temporadas=" + Arrays.toString(temporadas) +
                '}';
    }

    public int capitulos_por_temporada(Temporada t){
        return t.capitulosTotales();
    }

    public int capitulos_totales(){
        int suma = 0;
        for (int i = 0; i < temporadas.length; i++) {
            suma += temporadas[i].capitulosTotales();
        }
        return suma;
    }

    public double valoracionMedia(){
        double suma = 0;
        for (int i = 0; i < temporadas.length; i++) {
            suma += temporadas[i].valoracionMedia();
        }
        return suma/temporadas.length;
    }
}

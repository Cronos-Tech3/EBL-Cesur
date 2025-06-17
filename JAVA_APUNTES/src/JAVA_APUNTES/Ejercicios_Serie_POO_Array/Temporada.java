package JAVA_APUNTES.Ejercicios_Serie_POO_Array;

import java.util.Arrays;

public class Temporada {

    private int numero;

    private int anio;

    private Capitulo[] capitulos;

    public int capitulos_totales() {
        return capitulos.length;
    }

    public double valoracion_media() {
        double sumaValoracion = 0;
        for (int i = 0; i < capitulos.length; i++) {
        sumaValoracion+= capitulos[i].getValoracion();
        }
        return sumaValoracion / capitulos.length;
    }

    public Temporada(int numero, int anio, Capitulo[] capitulos) {
        this.numero = numero;
        this.anio = anio;
        this.capitulos = capitulos;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public Capitulo[] getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(Capitulo[] capitulos) {
        this.capitulos = capitulos;
    }

    @Override
    public String toString() {
        return "Temporada{" +
                "numero=" + numero +
                ", anio=" + anio +
                ", capitulos=" + Arrays.toString(capitulos) +
                '}';
    }
}

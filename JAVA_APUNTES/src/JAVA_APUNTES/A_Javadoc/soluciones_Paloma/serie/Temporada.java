package JAVA_APUNTES.A_Javadoc.soluciones_Paloma.serie;

import java.util.Arrays;

public class Temporada {
    private int numero;
    private int anio;
    private Capitulo[] capitulos;

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

    public int capitulosTotales(){
        return capitulos.length;
    }

    public double valoracionMedia(){
        double suma = 0;
        //recorrer el array de capitulos
        for (int i = 0; i < capitulos.length; i++) {
            suma += capitulos[i].getValoracion();
        }

        return suma/capitulosTotales();
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

package Enrique_Benito_Lopez;

import java.util.ArrayList;

public class Mortifago extends Mago implements IMarcaTenebrosa{
    private int nivelMagia;
    private String mascara;

    public Mortifago(String nombre, int edad, int nivelMagia, String mascara) {
        super(nombre, edad);
        this.nivelMagia = nivelMagia;
        this.mascara = mascara;
    }

    @Override
    public int calcularMediaPotenciaHechizos() throws SinHechizosException {
        ArrayList<Hechizo> hechizos = getHechizos();
        int suma = 0;
        int numHechizos = 0;
        int media = 0;
        for (Hechizo h : hechizos){
            suma += h.getPotencia();
        }
        if (hechizos.isEmpty()) throw new SinHechizosException();

        return media;

    }

    @Override
    public Hechizo obtenerHechizoPotencialMinimo() throws SinHechizosException {
        ArrayList<Hechizo> hechizos = getHechizos();
        int min_potencia = Integer.MIN_VALUE;
        int contador = 0;
        int indice = 0;
        if (hechizos.isEmpty()) throw new SinHechizosException();
        for (Hechizo h : hechizos){
            if (h.getPotencia() > min_potencia) {
                min_potencia = h.getPotencia();
                indice = contador;
            }
            contador++;
        }
        return hechizos.get(indice);
    }


    @Override
    public void usarHechizo() throws PotenciaInsuficienteException, SinHechizosException {
        Hechizo mejorHechizo = obtenerHechizoPotencialMinimo();

        if(mejorHechizo.getPotencia() > nivelMagia) throw new PotenciaInsuficienteException();

        System.out.println(mejorHechizo);
        System.out.println("Este es el total de la potencia de los hechizos: " + calcularMediaPotenciaHechizos());
    }


    @Override
    public String toString() {
        return "Mortifago{" +
                "nivelMagia=" + nivelMagia +
                ", mascara='" + mascara + '\'' +
                '}';
    }
}

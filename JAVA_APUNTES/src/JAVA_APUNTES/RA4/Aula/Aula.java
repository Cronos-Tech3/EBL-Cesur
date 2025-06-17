package JAVA_APUNTES.RA4.Aula;

import java.util.Scanner;

public class Aula {

    public int numAlum;

    public int numOrdenadores;

    public Profesor profesor;

    public Aula(int numAlum, int numOrdenadores, Profesor profesor) {
        this.numAlum = numAlum;
        this.numOrdenadores = numOrdenadores;
        this.profesor = profesor;
    }

    @Override
    public String toString() {
        return "Aula{" +
                "numAlum=" + numAlum +
                ", numOrdenadores=" + numOrdenadores +
                ", profesor=" + profesor +
                '}';
    }

    public void mostrarMedia(){
        Scanner sc = new Scanner(System.in);
        int contadorNota = 0;
        double sumaNota = 0;
        System.out.println("Ingrese una nota, o 0 para salir");
        double nota = sc.nextDouble();
        while (nota>0){
            contadorNota++;
            sumaNota+=nota;

            System.out.println("Ingrese una nota, o 0 para salir");
            nota = sc.nextDouble();
        }
        System.out.println(sumaNota/contadorNota);




    }

}

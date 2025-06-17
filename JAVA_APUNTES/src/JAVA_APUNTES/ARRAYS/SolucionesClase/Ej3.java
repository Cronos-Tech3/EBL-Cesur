package solucionesEjerciciosArrys;

import java.util.Scanner;

public class Ej3 {
    public static void main(String[] args) {
        String[] frases = new String[5];
        String[] inverso = new String[5];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < frases.length; i++) {
            frases[i] = sc.nextLine();
        }

        int contador = 0;
        for (int i = frases.length-1; i >=0 ; i--) {
            inverso[contador] = frases[i];
            contador++;
        }

        for (int i = frases.length-1; i >=0 ; i--) {
            inverso[(frases.length-1)-i] = frases[i];
        }

    }
}

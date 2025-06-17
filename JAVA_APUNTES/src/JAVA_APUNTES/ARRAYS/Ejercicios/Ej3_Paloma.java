package JAVA_APUNTES.ARRAYS.Ejercicios;

import java.util.Scanner;

public class Ej3_Paloma {
    public static void main(String[] args) {


        String [] frase = new String [5];
        String [] inverso = new String [5];
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca 5 palabras: ");

        for (int i = 0; i < frase.length; i++){
            frase [i] = sc.nextLine();
        }

        int contador = 0;
        for (int i = frase.length-1; i >=0 ; i--) {
            inverso [contador] = frase [i];
            contador++;
        }

        for (int i = frase.length-1; i >=0 ; i--) {
            inverso [(frase.length)-1-i] = frase[i];

        }

    }
}

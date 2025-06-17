package JAVA_APUNTES.BUCLES.Bucles_Extra;

import java.util.Scanner;

public class Ej9_AlgoritmoVocal_NoVocal {
    public static void main(String[] args) {
        /*
        Algoritmo que pida caracteres e imprima ‘VOCAL’ si son vocales y ‘NO VOCAL’
        en caso contrario, el programa termina cuando se introduce un espacio.
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("Cuantos caracteres desea introducir ");
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            System.out.print("Introducir caracter: ");
            char caracter = sc.next().charAt(0);
            System.out.println(caracter);


        }


    }
}

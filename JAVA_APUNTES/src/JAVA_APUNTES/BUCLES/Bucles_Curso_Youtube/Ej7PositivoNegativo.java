package JAVA_APUNTES.BUCLES.Bucles_Curso_Youtube;

import java.util.Scanner;

public class Ej7PositivoNegativo{
    public static void main(String[] args) {
        //Pedir 10 Pruebas_X.numeros por teclado y que imprima cuantos son negativos y cuantos positivos
        Scanner sc = new Scanner(System.in);
        int contadorP = 0;
        int contadorN = 0;
        for (int i = 0; i<=9 ; i++) {
            System.out.println("Ingrese un numero");
            int n = sc.nextInt();
            if (n>0) {
                contadorP++;
            }
            if (n<0) {
                contadorN++;
            }

        }
        System.out.println("De los Pruebas_X.numeros ingresados " + contadorP + " son positivos");
        System.out.println("De los Pruebas_X.numeros ingresados " + contadorN + " son negativos");

    }
}

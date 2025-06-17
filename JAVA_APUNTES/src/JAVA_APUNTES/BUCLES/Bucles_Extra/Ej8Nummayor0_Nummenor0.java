package JAVA_APUNTES.BUCLES.Bucles_Extra;

import java.util.Scanner;

public class Ej8Nummayor0_Nummenor0 {
    public static void main(String[] args) {
        /*
        Realizar un algoritmo que pida números (se pedirá por teclado la cantidad de
        números a introducir). El programa debe informar de cuántos números
        introducidos son mayores que 0, menores que 0 e iguales a 0.
         */
        int n, contadorMayor = 0, contadorMenor = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Cuantos Pruebas_X.numeros quiere introducir: ");
        n = sc.nextInt();

        for (int i = 0; i < n; i++){
            System.out.println("Introduzca numero: ");
            int n2 = sc.nextInt();
            if (n2 > 0) {
                contadorMayor++;
            } else {
                contadorMenor++;
            }
         }
        System.out.println("Numeros mayores que 0 hay: " + contadorMayor);
        System.out.println("Numeros menores que 0 hay: " + contadorMenor);
    }
}

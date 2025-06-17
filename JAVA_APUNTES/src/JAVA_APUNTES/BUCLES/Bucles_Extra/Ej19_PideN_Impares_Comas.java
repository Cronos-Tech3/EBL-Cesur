package JAVA_APUNTES.BUCLES.Bucles_Extra;

import java.util.Scanner;

public class Ej19_PideN_Impares_Comas {
    public static void main(String[] args) {
        // Escribir un programa que pida al usuario un número entero positivo y muestre
        //por pantalla todos los números impares desde 1 hasta ese número separados
        //por comas.

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un numero positivo: ");
        int num = sc.nextInt();
        for (int i = 1; i <= num; i++) {
            if (i % 2 != 0) {
                System.out.print(i + " , ");
            }
        }
    }
}

package JAVA_APUNTES.BUCLES.Bucles_Extra;

import java.util.Scanner;

public class Ej10NumPar_Entre_2_NUM {
    public static void main(String[] args) {
        // Escribir un programa que imprima todos los números pares entre dos números
        //que se le pidan al usuario.
        int num1, num2;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el primer numero: ");
        num1 = sc.nextInt();
        System.out.println("Ingrese el segundo numero: ");
        num2 = sc.nextInt();
        for (int i = num1; i <= num2; i++) {
            if (i % 2 == 0) {
                System.out.println(i + "");
            }
        }
        for (int i = num1; i >= num2; i--) {
            if (i % 2 == 0) {
                System.out.println(i + "");
            }
        }

    }
}

package JAVA_APUNTES.BUCLES.Bucles_Curso_Youtube;

import java.util.Scanner;

public class Ej11numeros7en7 {
    public static void main(String[] args) {
        //Numeros comprendidos entre dos Pruebas_X.numeros introducidos por teclado distintos entre si
        //y que muestre los Pruebas_X.numeros naturales entre los dos introducidos de 7 en 7
        //el programa debera comprobar que el numero 1 es distinto al numero 2

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el primer numero");
        int num1 = sc.nextInt();
        System.out.println("Ingrese el segundo numero");
        int num2 = sc.nextInt();

        while (num1 == num2) {
            System.out.println("Los Pruebas_X.numeros no pueden ser iguales");

            System.out.println("Ingrese el primer numero");
             num1 = sc.nextInt();

            System.out.println("Ingrese el segundo numero");
             num2 = sc.nextInt();

        }
        for (int i = num1 + 1; i <= num2 - 1; i++) {

            if (i % 7 == 0) {
                System.out.println(i);
            }
        }

    }
}

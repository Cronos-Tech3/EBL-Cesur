package JAVA_APUNTES.BUCLES.Bucles_Curso_Youtube;

import java.util.Scanner;

public class Ej14Multiplos3 {
    public static void main(String[] args) {
        //Multiplos de 3 que hay entre 1 numero y un numero introducido por teclado. Mostrar la suma

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el primer numero: ");
        int num1 = sc.nextInt();
        int suma = 0;

        for (int i = 1; i <= num1; i++) {

            if (i % 3 == 0) {
                System.out.println(i);
                suma += i;


            }

        }
        System.out.println("La suma  es: " + suma);
    }
}

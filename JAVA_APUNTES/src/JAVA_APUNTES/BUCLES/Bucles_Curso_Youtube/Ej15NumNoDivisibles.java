package JAVA_APUNTES.BUCLES.Bucles_Curso_Youtube;

import java.util.Scanner;

public class Ej15NumNoDivisibles {
    public static void main(String[] args) {
        // Mostrar todos los Pruebas_X.numeros que van antes del numero introducido por teclado.
        //Pero solo los que no sean divisibles por otro que metimos por teclado

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un numero");
        int num = sc.nextInt();
        System.out.println("Introduce el numero por el que no se puede dividir");
        int divisible = sc.nextInt();
        for (int i = 1; i <= num; i++) {

            if (i%divisible != 0) {
                System.out.println(i);
            }
        }
    }
}

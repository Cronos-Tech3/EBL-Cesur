package JAVA_APUNTES.BUCLES.Bucles_Extra;

import java.util.Scanner;

/**
 * @author Enrique Benito
 * @Version 1
 *
 * Pedir un número entre 0 y 9.999
 */

public class Ej23 {
    public static void main(String[] args) {
        // Pedir un número entre 0 y 9.999 y decir cuantas cifras tiene.

        Scanner sc = new Scanner(System.in);
        int contador = 0;
        System.out.println("Ingrese un numero entre 0 y 9.999 ");
        int  num = sc.nextInt();

        while (num>0) {
            num = num/10;
            contador++;
        }
        System.out.println(contador);
    }
}

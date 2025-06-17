package JAVA_APUNTES.ARRAYS.Ejercicios;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ej4_propio {
    public static void main(String[] args) {

        /**
         *Crea un programa que pida un número al usuario un número de mes (por
         * ejemplo, el 4) y diga cuántos días tiene (por ejemplo, 30) y el nombre del mes.
         * Debes usar un vector. Para simplificarlo vamos a suponer que febrero tiene 28
         * días.
         */

        Scanner scl = new Scanner(System.in);
        Scanner scn = new Scanner(System.in);

        String[] meses = {"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre" };
        int[] dias = {31, 28, 31, 30, 31, 30, 31, 30, 31, 31, 30, 31};

        System.out.println("Ingrese un numero de mes: ");
        try {
            int num = scn.nextInt();
            System.out.println("El mes es: " + meses[num - 1] + " con " + dias[num-1] + " dias");


        } catch (InputMismatchException ipe) {
            System.out.println("Insertaste una letra en lugar de un numero");
        }






    }
}

package JAVA_APUNTES.ARRAYS.SolucionesClase;

import java.util.Scanner;

public class Soluciones {

    /**
     * funcion que llenea un array por teclado
     * @param array int[]
     * @return int[]
     */

    public static int [] rellenarArray(int[] array) {
        //rellenar array
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            array [i] = sc.nextInt();
        }

        return array;
    }







}

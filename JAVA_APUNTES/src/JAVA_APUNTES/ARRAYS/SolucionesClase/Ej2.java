package JAVA_APUNTES.ARRAYS.SolucionesClase;

import java.util.Arrays;

/**
 * Escribe un programa que genere al azar 20 números enteros
 * comprendidos entre 0 y 9. Estos números se deben introducir
 * en un array de 4 filas por 5 columnas.
 */
public class Ej2 {
    public static void main(String[] args) {
        int numeros[][] = new int[4][5];

        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros[i].length; j++) {
                numeros[i][j] = (int)(Math.random()*10);
            }
            System.out.println(Arrays.toString(numeros[i]));
        }

        for(int[] fila : numeros){
            for(int num : fila){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

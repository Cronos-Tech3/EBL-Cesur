package JAVA_APUNTES.ARRAYS.EJER;

import java.util.Arrays;

/**
 * Escribe un programa que genere al azar 20 números enteros comprendidos
 * entre 0 y 9. Estos números se deben introducir en un array de 4 filas por 5
 * columnas.
 */
public class ej2 {
    public static void main(String[] args) {
        int [][] matriz = new int [4][5]; //filas y columnas
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j <matriz[i].length; j++) {
                matriz[i][j] = (int) (Math.random()*10); //numeros del 0 al 9
                System.out.print(matriz[i][j] + " - [" + i + " " + j + "] ");
            }
        }
        System.out.println(); //por estética, separa posiciones y matriz
        for (int[] fila:matriz) {
            for (int num: fila) {

            }
            System.out.println(Arrays.toString(fila)); // muestra la matriz
        }

    }
}

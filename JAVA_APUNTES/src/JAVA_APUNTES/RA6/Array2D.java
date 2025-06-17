package JAVA_APUNTES.RA6;

import java.util.Arrays;

public class Array2D {
    public static void main(String[] args) {
        int [][] matriz = new int[3][3];
        int contador = 1;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[j][i] = contador;
                System.out.print(matriz[j][i] + " - [" + i + " " + j + "] ");
                contador++;
            }
            System.out.println();
        }


        for(int[] fila:matriz){
            System.out.println(Arrays.toString(fila));
        }

        for(int[] fila:matriz){
            for(int x : fila){
                System.out.print(x);
            }
            System.out.println();
        }
    }
}

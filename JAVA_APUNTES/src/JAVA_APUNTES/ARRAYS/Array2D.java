package JAVA_APUNTES.ARRAYS;

import java.util.Arrays;

public class Array2D {
    public static void main(String[] args) {
        
        int [][] matriz = new int[3][3];
        int contador = 1;
        for (int i = 0; i < matriz.length;i++) {
            
            
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = contador;   // para i 1 j 0 para i 1 j 1 para i 1 j 2
                contador++;
                System.out.println(matriz[i][j]+ " - " + i + " ");   // TODO: 29/11/2024 rellenar y comentar 
                
            }
            
        }
        // for each 
        for (int[] fila:matriz){
            System.out.println(Arrays.toString(fila));
            
        }
        
        
        
        
    }
}

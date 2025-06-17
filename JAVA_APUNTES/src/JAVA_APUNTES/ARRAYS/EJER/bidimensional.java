package JAVA_APUNTES.ARRAYS.EJER;
/**
 * Array 2D
 */
import java.util.Arrays;

public class bidimensional {
    public static void main(String[] args) {
        //Array bidimensional
        int [][] matriz; //bidimensional = dos arrays = dos corchetes = para recorrerlo necesitamos dos bucles
        matriz = new int [3][3]; //el array grande tiene tres arrays pequeños, y cada array pequeño tiene tres columnas
        // matriz [0][0] = 1; la matriz 00 tiene un 1

        int contador = 1; //valor que toma la primera celda de la matriz

        for (int i = 0; i < matriz.length ; i++) { //recorre el primer array
            for (int j = 0; j <matriz[i].length; j++) { // recorre los arrays de dentro del array grande
                matriz[i][j] = contador;
                System.out.print(matriz[i][j] + " - [" + i + " " + j + "] "); //muestra las posiciones de la matriz
                contador++;
            }
        }
        System.out.println(); //por estética, separa posiciones y matriz
        for (int[] fila:matriz) {
            System.out.println(Arrays.toString(fila)); // muestra la matriz
        }

        System.out.println("***********************************");
        System.out.println("***********************************");
        //hacer la matriz inversa
        int conta = 1; //nuevo contador para que o siga sumando el anterior

        for (int i = 0; i < matriz.length ; i++) { //el bucle se construye igual
            for (int j = 0; j <matriz[i].length; j++) {
                matriz[j][i] = conta;  //pero se intercambia j por i
                System.out.print(matriz[j][i] + " - [" + j + " " + i + "] "); // aqui tambien se cambian de lugar j e i
                conta++;
            }
        }
        System.out.println();
        for (int[] col:matriz) { //mostrar la nueva matriz
            System.out.println(Arrays.toString(col));
        }


        
    }
}

package JAVA_APUNTES.ARRAYS.Ejercicios;

import java.util.Arrays;
import java.util.Scanner;

public class Ej1 {
    public static void main(String[] args) {
        //Escribe un programa que pida 10 números por teclado, los almacene en un
        //array y que luego muestre el máximo valor, el mínimo y las posiciones que
        //ocupan en el array
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese 10 numeros: ");
        int [] numeros = new int[10];   // 10 porque length recorre del 1 al 10
        int [] numeros1 = new int[10];
        for (int i = 0 ; i < numeros.length; i++){   // bucle for para recorrer el array
            numeros[i] = sc.nextInt();   //pedimos al usuario que meta los 10 numeros

        }
        numeros1 = Arrays.copyOf(numeros, numeros.length);  // numeros1 es igual a una copia del array original

        Arrays.sort(numeros);    // ordenamos los numeros con sort
        System.out.println(numeros[0]);  // mostramos el numero menor del orden
        System.out.println(numeros[9]);  // mostramos el numero mayor del orden

        for (int i = 0; i < numeros.length; i++){     // con este bucle recorremos el array para sacar su posicion excacta
            if (numeros[0] == numeros1[i]){
                System.out.println("la posicion es: "+ i);
            }

        }



    }
}

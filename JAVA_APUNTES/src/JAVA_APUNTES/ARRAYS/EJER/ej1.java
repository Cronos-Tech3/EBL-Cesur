package JAVA_APUNTES.ARRAYS.EJER;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 1. Escribe un programa que pida 10 números por teclado, los almacene en un 
 * array y que luego muestre el máximo valor, el mínimo y las posiciones que 
 * ocupan en el array.
 */
public class ej1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] numeros = new int[10];
        int [] copia;

        System.out.println("Introduce 10 números enteros");
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = sc.nextInt();
        }

        copia = Arrays.copyOf(numeros, numeros.length); //copia la referencia usando el método copyof,
                                                        // copiando desde numeros a numeros.length
        System.out.println(Arrays.toString(numeros)); //para ver cómo es originalmente
        Arrays.sort(numeros); //ordena de menor a mayor los numeros
        System.out.println(numeros[0] + " y " + numeros[9]); //menor y mayor
        int menor = numeros[0];
        int mayor = numeros[9];
        int posicionMenor = 0, posicionMayor = 0;
        System.out.println(Arrays.toString(numeros)); //verlo tras ordenarse
        System.out.println(Arrays.toString(copia));

        for (int i = 0; i < numeros.length; i++){  // con este bucle recorremos el array para sacar su posicion excacta
            if (copia[i]==menor){
                posicionMenor=i;
                break;
            }
        }
        for (int i = 0; i < numeros.length; i++){
            if (copia[i]==mayor) {
                posicionMayor = i;
                break;
            }
        }
        System.out.println("La posición del menor es: " + posicionMenor);
        System.out.println("La posición del mayor es: " + posicionMayor);

















    }
}

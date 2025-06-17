package JAVA_APUNTES.ARRAYS.SolucionesClase;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Escribe un programa que pida 10 números por teclado,
 * los almacene en un array y que luego muestre el máximo valor,
 * el mínimo y las posiciones que ocupan en el array.
 */
public class Ej1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] numeros = new int[10];
        int [] copia;
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = sc.nextInt();
        }
        copia = Arrays.copyOf(numeros, numeros.length);
        System.out.println(Arrays.toString(numeros));
        Arrays.sort(numeros); //ordena de menor a mayor
        int menor = numeros[0];
        int posicionMenor = 0;
        System.out.println("menor: " + menor); //menor
        int mayor = numeros[9];
        int posicionMayor = 0;
        System.out.println("mayor: " + mayor); //mayor
        for (int i = 0; i < copia.length; i++) {
            if(copia[i]==menor){
                posicionMenor = i;
                break;
            }
        }
        for (int i = 0; i < copia.length; i++) {
            if(copia[i]==mayor){
                posicionMayor=i;
                break;
            }
        }
        System.out.println("posicion mayor: "+posicionMayor);
        System.out.println("posicion menor: " +posicionMenor);

    }
}

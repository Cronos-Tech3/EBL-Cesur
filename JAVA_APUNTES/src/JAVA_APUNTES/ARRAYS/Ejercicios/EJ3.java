package JAVA_APUNTES.ARRAYS.Ejercicios;

import java.util.Scanner;

public class EJ3 {
    public static void main(String[] args) {

        /*
        EJERCICIO 3
        Crear un vector de 5 elementos de cadenas de caracteres, inicializa el vector
        con datos leídos por el teclado. Copia los elementos del vector en otro vector
        pero en orden inverso, y muéstralo por la pantalla
         */

        String [] frase = new String [5];
        String [] fraseInverso = new String [5];
        Scanner sc= new Scanner(System.in);

        System.out.println("Introduzca 5 palabras: ");
        for (int i = 0; i < frase.length; i++){
            frase [i] = sc.nextLine();
        }

        for (int i = 0; i < frase.length; i++) {       // el inverso
            fraseInverso[i] = frase[frase.length - 1 - i];
        }

        System.out.println("Vector original2: " + frase);
        for (String elemento :frase);{
            System.out.println( 3 + "");
        }

        System.out.println("\n frase inversa: ");
        for (String elementoInverso : fraseInverso) {
            System.out.println( elementoInverso + "");
        }
    }
}

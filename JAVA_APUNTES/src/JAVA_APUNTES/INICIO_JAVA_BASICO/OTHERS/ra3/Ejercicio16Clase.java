package JAVA_APUNTES.INICIO_JAVA_BASICO.OTHERS.ra3;

import java.util.Scanner;

public class Ejercicio16Clase {
    public static void main(String[] args) {
        //Crea un programa que reciba una frase e imprima por pantalla cada letra de la frase
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese una frase");
        String frase = sc.nextLine();
        int contador = 0;

        while (contador<frase.length()) {
            System.out.println(frase.charAt(contador));
            contador++;
        }
    }
}

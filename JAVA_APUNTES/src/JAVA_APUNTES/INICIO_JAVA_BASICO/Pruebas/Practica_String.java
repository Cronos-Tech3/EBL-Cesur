package JAVA_APUNTES.INICIO_JAVA_BASICO.Pruebas;

import java.util.Scanner;

public class Practica_String {
    public static void main(String[] args) {
        // Crea un programa que reciba un numero del usuario y pedirá al usuario ese numero en palabras y generara una frase añadiendo espacio entre las palabras.

        Scanner scn = new Scanner(System.in);
        Scanner scl = new Scanner(System.in);
        String palabra= " ";
        String frase=" ";

        System.out.println("Ingrese un numero");
        int num = scn.nextInt();
        for (int i =0; i < num; i++) {
            System.out.println("Ingrese una palabra");
            palabra = scl.nextLine();
            frase += palabra + " ";

        }
        System.out.println(frase);
        System.out.println(frase.substring(0,frase.length()-1));//imprime la frase sin el espacio final
        System.out.println(frase.charAt(0));
    }
}

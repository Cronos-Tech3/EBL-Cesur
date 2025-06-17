package JAVA_APUNTES.INICIO_JAVA_BASICO.INICIO_JAVA;

import java.util.Scanner;

public class Ej16_Frase_Letra_Por_Pantalla {
    public static void main(String[] args) {
        /*
        Crea un programa que reciba una frase e imprima por pantalla cada letra de la frase.
         */
        String frase;
        int contador = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("Inserta una frase");
        frase = sc.nextLine();

        while(contador<frase.length()){

            System.out.println(frase.charAt(contador)); //0 1 2

            contador++;
        }
    }
}

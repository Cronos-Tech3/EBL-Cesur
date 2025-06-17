package JAVA_APUNTES.INICIO_JAVA_BASICO.INICIO_JAVA;

import java.util.Scanner;

public class Ej17_Hola_aloH_length_Menos1 {
    public static void main(String[] args) {
        /*
        Crea un programa que reciba una frase y le muestre dada la vuelta (Hola -> aloH);
         */
        String frase;
        Scanner sc = new Scanner(System.in);

        System.out.println("Inserta una frase");
        frase = sc.nextLine();// pedimos la frase

        int contador = frase.length()-1; //necesitamos que valga la ultima posicion de la frase
        //si la frase tiene length 4, la última posición es la 3

        while(contador>=0){ //necesitamos que vaya 3 2 1 0 -> incluyendo el cero
            System.out.print(frase.charAt(contador)); //mostramos el caracter en esa posicion
            contador--; //restamos uno
        }

    }
}

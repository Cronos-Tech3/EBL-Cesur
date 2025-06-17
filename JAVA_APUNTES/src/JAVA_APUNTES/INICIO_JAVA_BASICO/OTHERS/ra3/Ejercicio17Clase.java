package JAVA_APUNTES.INICIO_JAVA_BASICO.OTHERS.ra3;

import java.util.Scanner;

public class Ejercicio17Clase {
    public static void main(String[] args) {
        /*
        Crea un programa que reciba una frase y le muestre dada la vuelta (Hola -> aloH);
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese una frase");
        String frase = sc.nextLine();
        int contador = frase.length()-1;
        while (contador>=0){

            System.out.print(frase.charAt(contador));
            contador--;

        }
    }
}

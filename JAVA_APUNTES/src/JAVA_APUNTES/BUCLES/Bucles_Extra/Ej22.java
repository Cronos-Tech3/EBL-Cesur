package JAVA_APUNTES.BUCLES.Bucles_Extra;

import java.util.Scanner;

public class Ej22 {
    public static void main(String[] args) {
        //. Escribir un programa en el que se pregunte al usuario por una frase y una letra, y
        //muestre por pantalla el número de veces que aparece la letra en la frase

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese una frase: ");
        String frase = sc.nextLine();
        System.out.println("Ingrese una letra que este en la frase anterior: ");
        String letra = sc.nextLine();
        int contador = 0;
        for (int i = 0; i < frase.length(); i++) {


            if (letra.equalsIgnoreCase((frase.charAt(i)+ ""))) {
                contador++;
            }

        }
        System.out.println("la letra " + letra + " se repite " + contador + " veces. ");

    }
}

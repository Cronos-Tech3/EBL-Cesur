package JAVA_APUNTES.INICIO_JAVA_BASICO.INICIO_JAVA;

import java.util.Scanner;

public class Ej3_Frase_Longitud_de_laMisma {
    public static void main(String[] args) {
    //  Crea un programa que pida una frase e indique la longitud de la misma
        Scanner sc = new Scanner(System.in); // Declaramos Scanner
        System.out.println("Ingrese una frase "); // pedimos al usuario
        String frase = sc.nextLine(); // introducir por teclado
        int fraselarga = frase.length(); // frase.lenght() nos mide la longitud de la frase con espacios incluidos
        System.out.println("La frase escrita tiene un total de caracteres y espacios " + fraselarga);

    }
}

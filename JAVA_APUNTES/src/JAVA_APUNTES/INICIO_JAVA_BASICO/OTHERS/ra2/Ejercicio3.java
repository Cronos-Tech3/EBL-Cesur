package ra2;

import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese una palabra o frase");
        String frase;
        frase = sc.nextLine();
        int numeroDeLetras = frase.length();
        System.out.println("El numero de letras y espacios contenidos es " + numeroDeLetras);



    }
}

package ra2;

import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        // Crea un programa que pida un número y diga si es par o impar
        Scanner sc = new Scanner(System.in);
        int num;
        System.out.println("Ingrese un numero");
        num = sc.nextInt();
        String par = num%2==0 ? "Es Par":"Es Impar";
        System.out.println(par);

        boolean impar = num%2==0;
        String pruebaImpar = impar ? "Es par":"Es impar";
        System.out.println(pruebaImpar);

        if (num%2==0) {
            pruebaImpar = "par";
        } else {
            pruebaImpar = "impar";
        }
        System.out.println("el numero es" + pruebaImpar);













    }
}

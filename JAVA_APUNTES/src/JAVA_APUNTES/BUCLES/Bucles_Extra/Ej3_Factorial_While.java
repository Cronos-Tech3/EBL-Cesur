package JAVA_APUNTES.BUCLES.Bucles_Extra;

import java.util.Scanner;

public class Ej3_Factorial_While {
    public static void main(String[] args) {
        /*
        Ej 3 -Pida ingresar un numero y que el programa regrese su factorial
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un numero que no sea negativo ");
        int n = sc.nextInt();

        if (n<0){
            System.out.println("El numero no puede ser negativo");
        } else {
            long fact = 1;
            int contador = 1;

            while (contador<=n){
                fact *= contador;
                contador++;
            }
            System.out.println("el factorial de " + n + " es " + fact);
        }




    }
}

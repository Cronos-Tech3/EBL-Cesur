package EjerciciosBucle;

import java.util.Scanner;

public class Ej1Bucle {
    public static void main(String[] args) {
        /*
        Pedir números hasta que se introduzca uno negativo, y calcular la media.
         */
        Scanner sc = new Scanner(System.in);
        int suma = 0;
        int contador = 0;
        int num;
        System.out.println("Ingrese un numero (o numero negativo para salir ");

        while (true) {
            num = sc.nextInt();
            if (num < 0) {
                break;
            }
            suma += num;
            contador++;
        }
        if (contador > 0) {
            double media = (double) suma/ contador;
            System.out.println("La media de los numeros es: " + media);
        } else {
            System.out.println("No se introdujo ningun numero ");
        }
        sc.close();
    }
}



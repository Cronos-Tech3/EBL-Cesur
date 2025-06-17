package JAVA_APUNTES.BUCLES.Bucles_Extra;

import java.util.Scanner;

public class Ej11_limiteInferior_limiteSuperior_operacion {
    public static void main(String[] args) {
        //Escribe un programa que pida el límite inferior y superior de un intervalo.  Si el
        //límite inferior es mayor que el superior lo tiene que volver a pedir.  A
        //continuación, se van introduciendo números hasta que introduzcamos el 0.
        //Cuando termine el programa dará las siguientes informaciones
        //a. La suma de los números que están dentro del intervalo (intervalo
        //abierto).
        //b.  Cuantos números están fuera del intervalo.
        //c. Informa si hemos introducido algún número igual a los límites del
        //intervalo.

        Scanner sc = new Scanner(System.in);
        int limiteinferior, limitesuperior;

         while (true) {
             System.out.println("Ingrese el limite inferior: ");
             limiteinferior = sc.nextInt();
             System.out.println("Ingrese el limite superior: ");
             limitesuperior = sc.nextInt();
             if (limiteinferior < limitesuperior) {
                 break;
             } else {
                 System.err.println("El limite inferior tiene que ser menor que el superior ");
             }
         }
        ;
        int sumaintervalo = 0;
        int contadorfuera = 0;
        int contadorIntervalo =0;

        while (true) {
            System.out.println("Introduce numeros, 0 para salir ");
            int numeros = sc.nextInt();

            if (numeros == 0) {
                System.err.println("Cerrando el programa, Gracias Puto ");
                break;
            }
            if (numeros >= limiteinferior && numeros <= limitesuperior) {
                sumaintervalo += numeros;
            } else {
                contadorfuera++;
            }
            if (numeros == limiteinferior || numeros == limitesuperior) {
                contadorIntervalo++;
            }
        }
        System.out.println("la suma de los numeros dentro del intervalo es: " + sumaintervalo);
        System.out.println(contadorfuera + " numeros son los que estan fuera del intervalo ");
        System.out.println("Se han introducido " + contadorIntervalo + " igual al valor del limite del intervalo");
    }
}

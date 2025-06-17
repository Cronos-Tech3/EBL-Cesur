package JAVA_APUNTES.BUCLES.Bucles_Extra;

import java.util.Scanner;

public class Ej7AdivinaN_Ramdom {
    public static void main(String[] args) {
        /*
        Crea una aplicación que permita adivinar un número. La aplicación genera un
número aleatorio del 1 al 100. A continuación, va pidiendo números y va
respondiendo si el número a adivinar es mayor o menor que el introducido,
además de los intentos que te quedan (tienes 10 intentos para acertarlo). El
programa termina cuando se acierta el número (además te dice en cuantos
intentos lo has acertado), si se llega al límite de intentos te muestra el número
que había generado.
         */

        Scanner sc = new Scanner(System.in);
        int numero;
        int aleatorio = (int) (Math.random()*100)+1;
        int i;
        for ( i = 0; i < 10; i++) {
            System.out.println("Ronda " + (i+1) +"/10 - Inserta un numero:");
            numero = sc.nextInt();

            if(numero==aleatorio){
                System.out.println("Has acertado en la ronda " + (i+1));
                break;
            } else if (numero>aleatorio) {
                System.out.println("El número que buscas es menor.");
            }else{
                System.out.println("El número que buscas es mayor.");
            }
            System.out.println("Te quedan " + (10-(i+1)) + " intentos.");
        }
        if(i==10){
            System.out.println("El número aleatorio era: " + aleatorio);
        }


    }
}

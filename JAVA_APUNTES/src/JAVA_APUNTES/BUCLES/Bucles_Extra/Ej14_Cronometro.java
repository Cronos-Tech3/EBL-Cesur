package JAVA_APUNTES.BUCLES.Bucles_Extra;

import java.util.Scanner;

public class Ej14_Cronometro {
    public static void main(String[] args) throws InterruptedException {

    /*
    Hacer un programa que muestre un cronometro, indicando las horas, minutos y
    segundos. Se pedirá al usuario primero un número determinado de horas,
    minutos y segundos.
     */

        Scanner sc = new Scanner(System.in);
        int horas = 0;
        int minutos = 0;
        int segundos = 0;

        System.out.println("Introduzca numero de horas: ");
        horas = sc.nextInt();

        System.out.println("Introduzca numero de minutos: ");
        minutos = sc.nextInt();

        System.out.println("Introduzca numero de segundos: ");
        segundos = sc.nextInt();

        while (!(horas == 0 && minutos == 0 && segundos == 0)) {

            if (horas < 10) {
                System.out.print("0" + horas);
            } else {
                System.out.print(horas);
            }

            System.out.print(":");

            if (minutos < 10) {
                System.out.print("0" + minutos);
            } else {
                System.out.print(minutos);
            }

            System.out.print(":");

            if (segundos < 10) {
                System.out.print("0" + segundos);
            } else {
                System.out.print(segundos);
            }

            System.out.println("");

            if (segundos == 0) {

                if (minutos == 0) {
                    horas--;
                    minutos = 59;
                    segundos = 59;
                } else if (minutos != 0) {
                    minutos--;
                    segundos = 59;
                }

            } else {
                segundos--;
            }

            Thread.sleep(1000);
        }

        System.out.println("00:00:00");
        System.out.println("Fin de la cuenta atras");







    }
}

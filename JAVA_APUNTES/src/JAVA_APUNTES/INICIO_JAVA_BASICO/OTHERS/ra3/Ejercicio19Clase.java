package JAVA_APUNTES.INICIO_JAVA_BASICO.OTHERS.ra3;

import java.util.Scanner;

public class Ejercicio19Clase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int contador = 1;
        while (contador<=3) {
            System.out.println("Ronda");
            int num = sc.nextInt();
            int aleatorio = (int) (Math.random() * 6);
            if (aleatorio == num) {
                System.out.println("Empate");
            } else if (aleatorio == 0) {
                num = 1;
                System.out.println("gana jugador con papel");
            } else if (aleatorio == 0) {
                num = 2;
                System.out.println("gana la maquina con piedra");

            } else if (aleatorio == 1) {
                num = 0;
                System.out.println("Gana la maquina con papel");
            } else if (aleatorio == 1) {
                num = 2;
                System.out.println("Gana el jugador con tijera");
            } else if (aleatorio == 2) {
                num = 0;
                System.out.println("Gana el jugador con piedra");
            } else if (aleatorio == 2) {
                num = 1;
                System.out.println("Gana la maquina con tijera");
            }

          contador++;
        }


    }
}







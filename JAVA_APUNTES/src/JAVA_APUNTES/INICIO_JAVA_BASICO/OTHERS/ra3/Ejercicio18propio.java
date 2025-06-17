package JAVA_APUNTES.INICIO_JAVA_BASICO.OTHERS.ra3;

import java.util.Scanner;

public class Ejercicio18propio {
    public static void main(String[] args) {
        // Escribe un programa para jugar a piedra, papel y tijera. El programa generará un
        // número del 0 al 2, de tal manera que el 0 será piedra, el 1 será papel y el 2 será tijera.
        // El programa debe pedir al usuario que inserte su elección y decirle si ha ganado o
        // perdido.
        Scanner sc = new Scanner(System.in);
        int opcion;
        System.out.println("bienvenido al juego de piedra, papel y tijera");
        System.out.println("Ingrese un numero del siguiente menu");
        do {
            do {
                System.out.println("0.Piedra");
                System.out.println("1.Papel");
                System.out.println("2.Tijera");
                System.out.println("3.Salir");
                opcion = sc.nextInt();
                int aleatorio = (int) (Math.random() * 3);

                if (opcion == aleatorio) {
                    System.out.println("Empate");
                } else if (opcion == 2) {
                    aleatorio = 0;
                    System.out.println("Gana la maquina con valor " + aleatorio + " versus jugador con " + opcion);
                } else if (opcion == 2) {
                    aleatorio = 1;
                    System.out.println("Gana el jugador con valor " + opcion + " versus maquina con " + aleatorio);
                } else if (opcion == 0) {
                    aleatorio = 1;
                    System.out.println("Gana la maquina con valor " + aleatorio + " versus jugador con " + opcion);
                } else if (opcion == 0) {
                    aleatorio = 2;
                    System.out.println("Gana el jugador con valor " + opcion + " versus maquina con " + aleatorio);
                } else if (opcion == 1) {
                    aleatorio = 0;
                    System.out.println("Gana el jugador con valor " + opcion + " versus maquina con " + aleatorio);
                } else if (opcion == 1) {
                    aleatorio = 2;
                    System.out.println("Gana la maquina con valor " + aleatorio + " versus jugador con " + opcion);
                }
            } while (opcion < 0 || opcion > 3);
        } while (opcion != 3);



    }
}

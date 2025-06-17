package JAVA_APUNTES.INICIO_JAVA_BASICO.OTHERS.ra3;

import java.util.Scanner;

public class Ejercicio18V2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int aleatorio =(int) (Math.random()*6);
        if (aleatorio==num){
            System.out.println("Empate");
        } else if (aleatorio == 0){
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
            num= 0;
            System.out.println("Gana el jugador con piedra");
        } else if (aleatorio == 2) {
            num= 1;
            System.out.println("Gana la maquina con tijera");
        }
        //generar numero aleatorio 0-2

        //pedir opcion a usuario en forma de numero

        //cuando empato -> cuando opcion y aleatorio sean iguales

        //ganare cuando el numero del usuario sea: usuario 1 , maquina 0 -


    }
}

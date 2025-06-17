package ra2;

import java.util.Scanner;

public class Ejercicio18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese piedra, papel o tijera ");
        int num = sc.nextInt();
        int aleatorio = (int) (Math.random()*3);

        switch (aleatorio) {
            case 1:
                num=0;
                aleatorio=0;
                System.out.println("Empate");
                break;
            case 2:
                num=0;
                aleatorio=1;
                System.out.println("Gana la maquina con " + aleatorio);
                break;
            case 3:
                num=0;
                aleatorio=2;
                System.out.println("Gana el jugador " + "la maquina eligio " + aleatorio);
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;

        }



    }
}

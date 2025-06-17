package JAVA_APUNTES.INICIO_JAVA_BASICO.INICIO_JAVA;


import java.util.Scanner;

public class Ej9_MatchRandon_0_5 {
    public static void main(String[] args) {
        //  Creaunjuego que genere un número al azar del 0 al 5 y pida un número al usuario
        // para que acierte el número
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un numero al azar del 0 al 5 ");
        int num = sc.nextInt();
        int aleatorio = (int) (Math.random() * 6);
        String acierto = num==aleatorio?"Has acertado enorabuena!! ":"Fallaste!! Pruebe de nuevo =) ";

        System.out.println(acierto + "el numero aleatorio es " + aleatorio);
    }
}

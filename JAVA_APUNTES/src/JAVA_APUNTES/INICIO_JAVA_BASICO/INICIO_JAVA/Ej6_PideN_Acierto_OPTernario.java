package JAVA_APUNTES.INICIO_JAVA_BASICO.INICIO_JAVA;

import java.util.Scanner;

public class Ej6_PideN_Acierto_OPTernario {
    public static void main(String[] args ) {
        // Crea un programa que pregunte el número de capítulos de la nueva temporada de
        // “Haikyū!!” y devuelva si has acertado o no
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuantos capitulos tiene la nueva temporada de Haikyu");
        int n = sc.nextInt();
        String acierto = (n==25) ? "Es correcto ":"Es incorrecto "; // Operador Ternario
        System.out.println(acierto);
        // otra forma sería hacerlo con un bucle while de forma que te estaría preguntando
        // hasta que aciertes o incluyas un if para salir del bucle
    }
}

package JAVA_APUNTES.BUCLES.Bucles_Curso_Youtube;

import java.util.Scanner;

public class Ej9numerosPrimos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un numero");
        int num = sc.nextInt();
        int contador = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                contador++;
            }
        }
        if (contador <= 2 ) {
            System.out.println("Es primo");
        } else {
            System.out.println("No es primo");
        }
    }
}

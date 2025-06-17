package JAVA_APUNTES.BUCLES.Bucles_Curso_Youtube;

import java.util.Scanner;

public class Ej8BaseExponente {
    public static void main(String[] args) {
        //Poner una base y un exponente y que calcule la potencia
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la base");
        int base = sc.nextInt();
        System.out.println("Ingrese el exponente");
        int exponente = sc.nextInt();
        int total = base;
        System.out.println(base);
        for (int i = 1; i < exponente; i++) {
            total *= base;
            System.out.println(total);
        }
    }
}

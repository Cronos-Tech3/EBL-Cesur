package JAVA_APUNTES.INICIO_JAVA_BASICO.INICIO_JAVA;

import java.util.Scanner;

public class Ej10_PideN_PideString_Repeat {
    public static void main(String[] args) {
        //Crea un programa que pida un número y una palabra e imprima por pantalla la palabra
        // el número de veces que ha pedido.
        Scanner sc = new Scanner(System.in);
        System.out.println("ingrese un numero");
        int num = sc.nextInt();
        System.out.println("ingrese una palabra");
        String palabra = sc.next();
        System.out.println(palabra.repeat(num ));

    }
}

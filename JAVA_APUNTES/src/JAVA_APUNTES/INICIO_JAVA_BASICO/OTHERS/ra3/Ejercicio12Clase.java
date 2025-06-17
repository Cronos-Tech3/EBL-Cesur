package JAVA_APUNTES.INICIO_JAVA_BASICO.OTHERS.ra3;

import java.util.Scanner;

public class Ejercicio12Clase {
    public static void main(String[] args) {
        // Con el programa anterior crea un menú que se muestre como el siguiente:
        // 1-Sumar.
        // 2-Restar.
        // 3-Multiplicar.
        // 4-Dividir
        // 5-Salir
        // El programa se deje ejecutar en un bucle del que sólo se podrá salir cuando el usuario
        // inserte el número 5.
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese dos numeros ");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        System.out.println("Ingrese la opcion segun su numero");
        System.out.println("1-Sumar");
        System.out.println("2-Restar");
        System.out.println("3-Multiplicar");
        System.out.println("4-Division");
        System.out.println("5-Salir");

    }
}

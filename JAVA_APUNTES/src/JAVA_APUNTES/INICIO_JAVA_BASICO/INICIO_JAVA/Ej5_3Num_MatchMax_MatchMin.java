package JAVA_APUNTES.INICIO_JAVA_BASICO.INICIO_JAVA;

import java.util.Scanner;

public class Ej5_3Num_MatchMax_MatchMin {
    public static void main(String[] args) {
        //Crea un programa que pida tres números y diga cuál es mayor y cuál es el menor
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese tres Pruebas_X.numeros diferentes ");
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();
        int n1mayor = Math.max(n1, n2); // De esta forma solo podemos hacerlo de dos en dos
        int n3mayor = Math.max(n3, n1mayor); // Si no habria que agregar un If para mayor y menor
        int n1menor = Math.min(n1, n2); // O hacerlo con Bucle
        int n3menor = Math.min(n3, n1menor); //
        System.out.println("El numero mayor es: "+ n3mayor);
        System.out.println("El numero menor es: "+ n3menor);
    }
}

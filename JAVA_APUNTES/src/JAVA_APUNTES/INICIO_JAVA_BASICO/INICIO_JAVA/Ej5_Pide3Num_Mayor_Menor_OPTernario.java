package JAVA_APUNTES.INICIO_JAVA_BASICO.INICIO_JAVA;

import java.util.Scanner;

public class Ej5_Pide3Num_Mayor_Menor_OPTernario {
    public static void main(String[] args) {
        //Crea un programa que pida tres números y diga cuál es mayor y cuál es el menor
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese tres Pruebas_X.numeros diferentes ");
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();
        int n1mayor = (n1>n2) ? (n1):(n2); // OP Ternario para mayor de n1 y n2
        int n3mayor = (n3>n1mayor) ? (n3):(n1mayor); // OP Ternario para mayor n3 con n1Mayor
        int n1menor = (n1<n2) ? (n1):(n2); // OP Ternario para menor n1 y n2
        int n3menor = (n3<n1menor) ? (n3):(n1menor); // OP Ternario para menor de n3 con n1Menor
        System.out.println("El numero mayor es: "+ n3mayor);
        System.out.println("El numero menor es: "+ n3menor);
    }
}

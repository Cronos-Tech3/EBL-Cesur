package JAVA_APUNTES.BUCLES.Bucles_Curso_Youtube;

import java.util.Scanner;

public class Ej6CuadradoCubo {
    public static void main(String[] args){
        //Programa que pida al usuario un numero y te de los 5 siguientes en cuadrado y cubo
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un puto numero ");
        int n = sc.nextInt();
        for (int i = n + 1; i<=n+5;i++){
            System.out.println("El cuadrado de " + i + " es " + i*i + " El cubo de " + i + " es " + i*i*i);
        }
    }
}

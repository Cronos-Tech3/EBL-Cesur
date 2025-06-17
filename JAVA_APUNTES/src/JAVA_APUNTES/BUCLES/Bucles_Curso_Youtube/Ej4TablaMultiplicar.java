package JAVA_APUNTES.BUCLES.Bucles_Curso_Youtube;

import java.util.Scanner;

public class Ej4TablaMultiplicar {
    public static void main(String[] args) {
        //Tabla de multiplicar por variable introducida por teclado

        Scanner sc = new Scanner(System.in);
        System.out.println("ingrese un numero, para ver su tabla de multiplicar");
        int n = sc.nextInt();
        for (int i = 0; i <= 10; i++ ){
            System.out.println(n + " X " + i + " = " + (n*i));
        }
    }
}

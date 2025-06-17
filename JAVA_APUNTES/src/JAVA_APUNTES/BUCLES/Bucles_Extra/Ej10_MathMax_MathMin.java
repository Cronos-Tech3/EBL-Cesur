package JAVA_APUNTES.BUCLES.Bucles_Extra;

import java.util.Scanner;

public class Ej10_MathMax_MathMin {
    public static void main(String[] args) {
        // .Escribir un programa que imprima todos los números pares entre dos números
        //que se le pidan al usuario
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un numero: ");
        int num1 = sc.nextInt();
        System.out.println("Ingrese otro numero: ");
        int num2 = sc.nextInt();
        for (int i = Math.min(num1,num2); i <= Math.max(num1,num2); i++){
            if (i%2==0){
                System.out.println(i);
            }
        }
    }
}

package JAVA_APUNTES.BUCLES.Bucles_Curso_Youtube;

import java.util.Scanner;

public class Ej10Suma_a_Uno {
    public static void main(String[] args) {
    //Suma de los 100 Pruebas_X.numeros siguientes a uno introducido por teclado
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un numero");
        int num = sc.nextInt();

        int suma = 0;

        while (num < 0) {
            System.out.println("Introduce un numero positivo");
            num = sc.nextInt();
        }

        for (int i = num + 1; i<=num + 101 ; i++) {
            suma += i;

        }
        System.out.println(suma);

    }
}

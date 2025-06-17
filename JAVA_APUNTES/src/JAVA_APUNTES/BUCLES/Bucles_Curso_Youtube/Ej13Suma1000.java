package JAVA_APUNTES.BUCLES.Bucles_Curso_Youtube;

import java.util.Scanner;

public class Ej13Suma1000 {
    public static void main(String[] args) {
        // Pidiendo Pruebas_X.numeros hasta que la suma sea 1000. Despues mostrar la suma

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese numero: ");

        int suma = 0;

        while (suma <= 1000) {
            int num = sc.nextInt();
            suma += num;

        }
        System.out.println("La suma es " + suma);
    }
}

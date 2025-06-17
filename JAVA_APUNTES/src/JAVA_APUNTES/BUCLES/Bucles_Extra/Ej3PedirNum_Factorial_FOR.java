package JAVA_APUNTES.BUCLES.Bucles_Extra;

import java.util.Scanner;

public class Ej3PedirNum_Factorial_FOR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int producto = 1;
        System.out.println("Ingrese un numero: ");
        int n = sc.nextInt();
        for (int i = n; i > 0; i--){
          producto = producto*i;
        }
        System.out.println("El factorial de: " + n + " es " + producto);
    }
}

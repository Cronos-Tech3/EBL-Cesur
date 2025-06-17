package JAVA_APUNTES.BUCLES.Bucles_Extra;

import java.util.Scanner;

public class Ej20_Inversion_Anual {
    public static void main(String[] args) {
        //Escribir un programa que pregunte al usuario una cantidad a invertir, el interés
        //anual y el número de años, y muestre por pantalla el capital obtenido en la
        //inversión cada año que dura la inversión.
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese la cantidad a invertir: ");
        int cantidad = sc.nextInt();
        System.out.println("Ingrese el interes anual: ");
        int interes = sc.nextInt();
        System.out.println("Ingrese en años el tiempo que dura la inversion");
        int tiempo = sc.nextInt();
        for (int i = 1; i <= tiempo; i++) {
            cantidad*=interes;
            System.out.println("Para el año " + i + " tenemos una ganancia de " + cantidad);
        }
    }
}

package JAVA_APUNTES.BUCLES.Bucles_Extra;

import java.util.Scanner;

public class Ej24 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce un número entre 0 y 9999: ");
        int numero = scanner.nextInt();

        while (numero < 0 || numero > 9999) {
            System.out.println("Número fuera del rango. Inténtalo de nuevo.");
            System.out.print("Introduce un número entre 0 y 9999: ");
            numero = scanner.nextInt();
        }

        // Separar las cifras del número
        int unidades = numero % 10;
        int decenas = (numero / 10) % 10;
        int centenas = (numero / 100) % 10;
        int miles = (numero / 1000) % 10;

        boolean esCapicua;
        if (numero < 10) {
            esCapicua = true;
        } else if (numero < 100) {
            esCapicua = unidades == decenas;
        } else if (numero < 1000) {
            esCapicua = unidades == centenas;
        } else {
            esCapicua = (unidades == miles) && (decenas == centenas);
        }

        if (esCapicua) {
            System.out.println("El número " + numero + " es capicúa.");
        } else {
            System.out.println("El número " + numero + " no es capicúa.");
        }
    }
}

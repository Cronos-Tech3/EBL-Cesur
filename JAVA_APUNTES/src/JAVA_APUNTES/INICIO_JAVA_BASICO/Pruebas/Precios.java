package JAVA_APUNTES.INICIO_JAVA_BASICO.Pruebas;

import java.util.Scanner;

public class Precios {
    public static void main(String[] args) {
        double precio, Suma = 0;
        int contador = 0;
        double contadorMin = 0;
        double contadorMax = 0;

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un precio");
        precio = sc.nextDouble();

        while(precio>=0) {
            contador++;
            Suma += precio;
            if (precio > contadorMax) {
                contadorMax = precio;
            }
            if (contador == 1) {
                contadorMin = precio;
            } else if (precio < contadorMin) {
                contadorMin = precio;

            }
            System.out.println("Ingrese un precio");
            precio = sc.nextDouble();

        }

        System.out.println("La media es: " + Suma/contador);
        System.out.println("El precio mas alto es: " + contadorMax);
        System.out.println("El precio mas bajo es: " + contadorMin);

    }
}

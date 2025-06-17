package JAVA_APUNTES.BUCLES.Bucles_Extra;

import java.util.Scanner;




public class Ej4Num_MEDIA_POSI_NEGA_CeroCont {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[10];
        int sumaPositivos = 0, sumaNegativos = 0, cantidadCeros = 0;
        int countPositivos = 0, countNegativos = 0;

        System.out.println("Introduce 10 números:");

        for (int i = 0; i < 10; i++) {
            numeros[i] = scanner.nextInt();

            if (numeros[i] > 0) {
                sumaPositivos += numeros[i];
                countPositivos++;
            } else if (numeros[i] < 0) {
                sumaNegativos += numeros[i];
                countNegativos++;
            } else {
                cantidadCeros++;
            }
        }

        double mediaPositivos = (countPositivos == 0) ? 0 : (double) sumaPositivos / countPositivos;
        double mediaNegativos = (countNegativos == 0) ? 0 : (double) sumaNegativos / countNegativos;

        System.out.println("Media de números positivos: " + mediaPositivos);
        System.out.println("Media de números negativos: " + mediaNegativos);
        System.out.println("Cantidad de ceros: " + cantidadCeros);


    }
}

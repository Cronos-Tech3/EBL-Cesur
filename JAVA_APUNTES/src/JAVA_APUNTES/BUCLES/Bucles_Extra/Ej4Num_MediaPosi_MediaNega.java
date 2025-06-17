package JAVA_APUNTES.BUCLES.Bucles_Extra;

import java.util.Scanner;

public class Ej4Num_MediaPosi_MediaNega {
    public static void main(String[] args) {
        //Pedir 10 números. Mostrar la media de los números positivos, la media de los
        //números negativos y la cantidad de ceros.
        Scanner sc = new Scanner(System.in);
        int contadorPositivo = 0, contadorNegativo = 0, contadorCero = 0;
        int sumaPositivo = 0, sumaNegativo = 0;

        for (int i = 0; i < 10; i++) {
            System.out.println("Ingrese numero: ");
            int num = sc.nextInt();
            if ( num > 0) {
                contadorPositivo++;
                sumaPositivo += num;
            } else if (num < 0) {
                contadorNegativo++;
                sumaNegativo += num;
            } else  {
                contadorCero++;
            }
        }
        if (contadorPositivo > 0) {
            System.out.println("La media de los Pruebas_X.numeros postivos es: " + sumaPositivo*1.0/contadorPositivo);
        } else {
            System.out.println("No hay Pruebas_X.numeros positivos");
        }
        if (contadorNegativo > 0) {
            System.out.println("La media de los Pruebas_X.numeros negativos es: " + sumaNegativo*1.0/contadorNegativo);
        } else {
            System.out.println("No hay Pruebas_X.numeros negativos");
        }
        System.out.println("el total de ceros es: " + contadorCero);

    }
}

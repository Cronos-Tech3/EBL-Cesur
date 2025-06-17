package EjerciciosBucle;

import java.util.Scanner;

public class Ej4extra {
    public static void main(String[] args) {
        // Pedir 10 números. Mostrar la media de los números positivos, la media de los
        //números negativos y la cantidad de ceros

        Scanner sc = new Scanner(System.in);
        int n;
        int contadorPositivo = 0;
        int contadorNegativo = 0;
        int contadorZero = 0;
        int sumapositivo = 0;
        int sumanegativo = 0;

        for(int i = 0; i < 10;i++ ){
            System.out.println("Ingrese un numero");
            n = sc.nextInt();
            if (n<0){
                contadorNegativo++;
                sumanegativo += n;
            } else if (n>0){
                sumapositivo +=n;
                contadorPositivo++;
            } else {
                contadorZero++;
            }
        }
        if (contadorPositivo>0){
            System.out.println("La media de los numeros positivos es: " + sumapositivo*1.0/contadorPositivo);
        }
        if (contadorNegativo>0){
            System.out.println("La media de los numeros negativos es: " + sumanegativo*1.0/contadorNegativo);
        }
        System.out.println("Total de ceros: " + contadorZero);

    }
}

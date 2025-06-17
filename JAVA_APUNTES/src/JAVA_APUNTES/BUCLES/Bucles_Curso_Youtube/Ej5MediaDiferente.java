package JAVA_APUNTES.BUCLES.Bucles_Curso_Youtube;

import java.util.Scanner;

public class Ej5MediaDiferente {
    public static void main(String[] args) {
        //Programa que calcule la media de los Pruebas_X.numeros introducidos hasta introducir un negativo
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un numero, o numero negativo para salir ");
        int n;
        double suma = 0;
        int contador = 0;
        n = sc.nextInt();
        while (n >= 0){
            n = sc.nextInt();
            suma += n;
            contador++;
            double media =(double) suma / contador;
            System.out.println("La media es: " + media );

        }
    }
}

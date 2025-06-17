package JAVA_APUNTES.BUCLES.Bucles_Curso_Youtube;

import java.util.Scanner;

public class Ej5Media {
    public static void main(String[] args) {
        //Programa que calcule la media de los Pruebas_X.numeros introducidos hasta introducir un negativo
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese Pruebas_X.numeros, o numero negativo para salir");
        int contador = 0;
        double suma = 0;
        while (true) {
            int n = sc.nextInt();
            if (n<0){
                break;
            }
            contador++;
            suma += n;
        }
        if (contador > 0) {
            double media = (double) suma/contador;
            System.out.println("La media de los Pruebas_X.numeros es " + media);
        } else {
            System.out.println("No se introdujo ningun numero");
        }
    }
}

package JAVA_APUNTES.BUCLES.Bucles_Extra;

import java.util.Scanner;

public class Ej1PedirNumOnegativo_Media {
    public static void main(String[] args) {
        //Pedir números hasta que se introduzca uno negativo, y calcular la media
        Scanner sc = new Scanner(System.in);
        int sumaNum = 0;
        int contador = 0;

        System.out.println("Ingrese numero, o negativo para salir");
        int num = sc.nextInt();
        while (num > 0) {

            sumaNum += num;
            contador++;
            System.out.println("Ingrese numero, o negativo para salir");
            num = sc.nextInt();
        }
        if (contador > 0){
            System.out.println("la media de los Pruebas_X.numeros es: " + sumaNum*1.0 / contador);
        } else {
            System.out.println("No se introdujeron Pruebas_X.numeros");
        }

    }
}

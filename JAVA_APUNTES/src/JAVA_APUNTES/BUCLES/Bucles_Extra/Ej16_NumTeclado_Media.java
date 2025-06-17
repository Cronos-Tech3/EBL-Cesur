package JAVA_APUNTES.BUCLES.Bucles_Extra;

import java.util.Scanner;

public class Ej16_NumTeclado_Media {
    public static void main(String[] args) {
        //Escribe un programa que calcule la media de un conjunto de números positivos
        //introducidos por teclado. A priori, el programa no sabe cuántos números se
        //introducirán. El usuario indicará que ha terminado de introducir los datos
        //cuando meta un número negativo.
        int suma = 0;
        int contador = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese numeros positivos: ");
        int num = sc.nextInt();
        while (num>0) {
            suma += num;
            contador++;
            System.out.println("Ingrese numeros positivos, o negativo para salir");
            num = sc.nextInt();
        }
        sc.close();
        System.out.println("La media de los numeros es: " + (suma/contador));
    }
}

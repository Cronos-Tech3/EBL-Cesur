package ra2;

import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        //Crea un programa que pida tres notas y saque la media

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese tres numeros para saber su media");
        float num1, num2, num3;

        num1 = sc.nextFloat();
        num2 = sc.nextFloat();
        num3 = sc.nextFloat();
        float media;
        media = (num1 + num2 + num3) / 3;
        System.out.println("la media de los tres numeros es " +  media);
        System.out.println("la media de los tres numeros es " + ((num1 + num2 + num3) / 3));

    }
}

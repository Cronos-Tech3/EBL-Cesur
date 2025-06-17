package JAVA_APUNTES.INICIO_JAVA_BASICO.OTHERS.ra3;

import java.util.Scanner;

public class Ejercicio14Clase {
    public static void main(String[] args) {
        //Escribe un programa que pida los precios de las suscripciones que tiene, el programa
        //debe preguntar por los precios hasta que insertemos un cero, y luego muestre el precio
        //medio y el coste total

        //datos--1 para guardar el precio---2--un contador--scanner
        // 2 precio lo introduce el usuarop
        // 3 condicion del bucle--->  precio!=0
        //3.1 contar cuantos precios, sumar los precios en total
        //calcular media y mostrar
        Scanner sc = new Scanner(System.in);

        int contador = 0;
        double precio, total = 0;
        System.out.println("Inserte un precio");
        precio = sc.nextDouble();

        while (precio!=0){
            contador++; //añadiendo un nuevo precio a mi contador
            total += precio; //sumando precio al total de precios --> total = total + precio

            System.out.println("Inserte un precio");
            precio = sc.nextDouble();
        }
        System.out.println(" El total de a pagar es: " + total);
        System.out.println("el precio medio de las suscripciones es: " + total/contador);
    }

}

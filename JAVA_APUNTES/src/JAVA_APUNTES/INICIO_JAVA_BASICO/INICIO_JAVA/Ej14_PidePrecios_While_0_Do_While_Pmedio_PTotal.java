package JAVA_APUNTES.INICIO_JAVA_BASICO.INICIO_JAVA;

import java.util.Scanner;

public class Ej14_PidePrecios_While_0_Do_While_Pmedio_PTotal {
    public static void main(String[] args) {
        /*
        Escribe un programa que pida los precios de las suscripciones que tiene, el programa
        debe preguntar por los precios hasta que insertemos un cero, y luego muestre el precio
        medio y el coste total.
         */
        double precio, total = 0;
        int contador = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("Inserta un precio");
        precio = sc.nextDouble();
        //Usando un bucle while
        while(precio!=0) {
            contador++; //añadiendo un nuevo precio a mi contador
            //contador = contador + 1

            total += precio; //sumando precio al total de precios -> total = total + precio

            System.out.println("Inserta un precio");
            precio = sc.nextDouble();
        }
        System.out.println("El total de a pagar es: " + total);
        System.out.println("El precio medio de las suscripciones es: " + total/contador);

        /* Aqui estariamos haciendolo con un do-while
        do {
            System.out.println("Inserta un precio");
            precio = sc.nextDouble();
            if(precio!=0){
                contador++; //añadiendo un nuevo precio a mi contador
                //contador = contador + 1

                total += precio; //sumando precio al total de precios -> total = total + precio
            }
        }while (precio!=0);
         */
    }
}








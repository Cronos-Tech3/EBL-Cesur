package EjerciciosBucle;

import java.util.Scanner;

public class Ej2extra {
    public static void main(String[] args) {
        //Diseñar un programa que muestre el producto de los 10 primeros números
        //impares
        int producto = 1;
        for (int i = 0 ; i < 20; i++) {
            if (i%2!=0){
                System.out.println(i);
                producto *= i;
            }
        }
        System.out.println(producto);
        int contador = 1;
        for (int i = 0; i < 10; i++){
            System.out.println(contador);
            contador +=2;
            producto *=contador;
        }
    }
}

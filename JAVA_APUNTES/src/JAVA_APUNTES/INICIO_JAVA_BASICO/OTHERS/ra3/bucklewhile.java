package JAVA_APUNTES.INICIO_JAVA_BASICO.OTHERS.ra3;

import java.util.Scanner;

public class bucklewhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ingrese un producto");
        String producto = sc.nextLine();
        Scanner scn = new Scanner(System.in);
        int contador = 0;
        double precio, acumulador = 0;
        //mientras no sea igual a "."
        while (!producto.equalsIgnoreCase(".")){
            System.out.println("Inserta un precio para el producto " + producto);
            precio = scn.nextDouble();
            acumulador += precio;

            contador++;//contador + 1
            System.out.println(producto);
            System.out.println("inserta otro producto o . para salir");
            producto = sc.nextLine();

        }
        System.out.println("se ha ejecutado " + contador + " veces");
        System.out.println("total: " + acumulador + " euros");
    }
}

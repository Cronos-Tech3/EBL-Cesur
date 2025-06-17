package JAVA_APUNTES.A_Javadoc.soluciones_Paloma.Simulacro1;

import java.util.Scanner;

/**
 * Crea un programa que analice los precios de los coches de un concesionario.
 * El programa recibirá precios de coches hasta que se inserte un número negativo.
 * Cuando se inserte un número negativo el programa devolverá la media de los precios
 * de los coches, el coche más caro del concesionario y el más barato.
 */
public class Ejercicio3 {
    public static void main(String[] args) {
        double precio, sumatorioPrecios = 0, contador=0, maximoPrecio = 0, minPrecio = 0;
        Scanner sc = new Scanner(System.in);
        while(true){
            precio = sc.nextDouble();;
            if(precio<0){
                break;
            }
            contador++;
            sumatorioPrecios+=precio;
            if(contador==1){
                maximoPrecio = precio;
                minPrecio = precio;
            }else{
                maximoPrecio = Math.max(maximoPrecio, precio);
                minPrecio = Math.min(minPrecio, precio);
            }
        }
        System.out.println("La media es: " + (sumatorioPrecios/contador));
        System.out.println(maximoPrecio);
        System.out.println(minPrecio);
        /*
        precio = sc.nextDouble();
        while(precio>=0){
            contador++;
            sumatorioPrecios += precio;
            if(contador==1){
                maximoPrecio = precio;
                minPrecio = precio;
            }else{
                maximoPrecio = Math.max(maximoPrecio, precio);
                minPrecio = Math.min(minPrecio, precio);
            }
            precio = sc.nextDouble();
        }
        System.out.println("La media es: " + (sumatorioPrecios/contador));
        System.out.println(maximoPrecio);
        System.out.println(minPrecio);
        */
        /*
        do{
            precio = sc.nextDouble();
            if(precio>=0){
                contador++;
                sumatorioPrecios += precio;
                if(contador==1){
                    maximoPrecio = precio;
                    minPrecio = precio;
                }else{
                    //maximoPrecio = Math.max(maximoPrecio, precio);
                    // minPrecio = Math.min(minPrecio, precio);
                    if(maximoPrecio<precio){
                        maximoPrecio = precio;
                    }
                    if(minPrecio>precio){
                        minPrecio = precio;
                    }
                }
            }
        }while(precio>=0);
        try{
            System.out.println("La media es: " + (sumatorioPrecios/contador));
            System.out.println(maximoPrecio);
            System.out.println(minPrecio);
        }catch (ArithmeticException ae){
            System.out.println("No has metido números");
        }
        */

        /*
        if(contador==0){
            System.out.println("No has metido números");
        }else{
            System.out.println("La media es: " + (sumatorioPrecios/contador));
            System.out.println(maximoPrecio);
            System.out.println(minPrecio);
        }
         */


    }
}

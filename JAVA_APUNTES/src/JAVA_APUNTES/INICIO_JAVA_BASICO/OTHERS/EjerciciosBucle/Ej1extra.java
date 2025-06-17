package EjerciciosBucle;

import java.util.Scanner;

public class Ej1extra {
    public static void main(String[] args) {
        /*
         Pedir números hasta que se introduzca uno negativo, y calcular la media.
         */
        Scanner sc = new Scanner(System.in);
        int num;
        int suma = 0;
        int contador = 0;
        System.out.println("Ingrese un numero, o negativo para salir");
        num = sc.nextInt();
        while(num>0){ //mientras no sea negativo
            suma += num; //sumo su valor
            contador++; //sumo uno al contador,hay un nuevo valor
            System.out.println("Ingrese un numero, o negativo para salir");
            num = sc.nextInt(); //pido dato al usuario
        }
        System.out.println("La media es: " + (suma*1.0/contador)); // pedimos la media, *1.0 para que el valor salga en double
    }
}

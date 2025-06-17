package ra2;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Ejercicio10 {
    public static void main(String[] args) {
        //Crea un programa que pida un numero e imprima por pantalla una palabra el numero de veces ese numero
        Scanner scl = new Scanner(System.in);
        Scanner scn = new Scanner(System.in);
        int num = 0;
        System.out.println("Ingrese un numero");
        int numusuario = scn.nextInt();
        System.out.println("Ingrese una palabra");
        String palabra = scl.nextLine();
        while (num<numusuario){ //0 1 2 < 3
            System.out.println(palabra);
            num++;
        }

        while (numusuario>0){ //3 2 1 > 0
            System.out.println(palabra);
            numusuario--;
        }
    }

    //Crea un programa que pida un numero e imprima por pantalla el numero de veces ese numero

}

package JAVA_APUNTES.INICIO_JAVA_BASICO.INICIO_JAVA;

import java.util.Scanner;

public class Ej10_PideN_String_Do_While {
    public static void main(String[] args) {
        /*
        EJERCICIO 10: Crea un programa que pida un número y una palabra e imprima por pantalla la palabra
        el número de veces que ha pedido.
         */

        Scanner scl = new Scanner(System.in);
        Scanner scn = new Scanner(System.in);
        int num = 0;
        System.out.println("Inserta un numero y una palabra");
        int numUsuario = scn.nextInt();
        String palabraUsuario = scl.nextLine();

        do{
            if(numUsuario>0){
                System.out.println(palabraUsuario);
                num++;
            }
        }while (num<numUsuario);
    }
}

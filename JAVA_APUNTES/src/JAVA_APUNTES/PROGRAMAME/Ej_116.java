package JAVA_APUNTES.PROGRAMAME;

import java.util.Scanner;

public class Ej_116 {
// La entrada consta de una única línea que contiene un número n, 0 ≤ n ≤ 5, que indica cuántos mensajes hay que emitir.
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el numero, que indique cuantos mensajes hay que emitir");

        int n = sc.nextInt();


        for (int  i = 0; 0 <= n; i++){

            System.out.println("Hola mundo.");
        }

    }

}

package JAVA_APUNTES.BUCLES.Bucles_Extra;

import java.util.Scanner;

public class Ej12_Base_Exponente {
    public static void main(String[] args) {
        /*
         Escribe un programa que, dados dos números, uno real (base) y un entero
         positivo (exponente), saque por pantalla el resultado de la potencia. No se
         puede utilizar el operador de potencia.
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el numero base: ");
        double base = sc.nextDouble();
        System.out.println("Ingrese el exponente (numero positivo) ");
        int exp = sc.nextInt();
        double resultado = 1;
        for (int i = 1; i <= exp; i++) {
            resultado *= base;
            // int = 0, establece que la variable i se inicia en 0
            // i < exponente significa que el bucle se ejecutara si exponente es mayor que 0
            //i++ incremente en i + 1 despues de cada interaccion del bucle
            // Dentro del bucle resultado *= base, es equivalente a resultado = resultado * base
            // Esto multiplica el resultado por la base en cada interaccion
            // Ejemplo: Si la base es 2 y el exponente es 3, el bucle se ejecutara 3 veces de forma que
            // el valor de resultado sera de la siguiente forma:
            // Primer paso: resultado = 1 * 2 -> 2
            // segundo paso: resultado = 2 * 2 -> 4
            // tercer paso: resultado = 4 * 2 -> 8
        }

        System.out.println("El resultado es: " + resultado);
    }
}

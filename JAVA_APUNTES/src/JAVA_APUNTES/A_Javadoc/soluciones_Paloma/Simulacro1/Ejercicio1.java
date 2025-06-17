package JAVA_APUNTES.A_Javadoc.soluciones_Paloma.Simulacro1;

import java.util.Scanner;

/**
 * Crea un programa que pida un número a un usuario y devuelva si es divisible entre 2, 3 o 5.
 * Si no es divisible entre ninguno de los valores deberá devolver la frase ‘No es divisible entre ninguno’.
 */
public class Ejercicio1 {
    public static void main(String[] args) {
        int numero;
        Scanner sc = new Scanner(System.in);
        numero = sc.nextInt();
        if(numero%2==0){
            System.out.println("Es divisble entre dos");
        }else if(numero%3==0){
            System.out.println("Es divisble entre tres");
        }else if(numero%5==0){
            System.out.println("Es divisble entre cinco");
        }else{
            System.out.println("No es divisible entre ninguno");
        }

        if(numero%2==0 || numero%3==0 || numero%5==0){
            System.out.println("Divisible entre alguno");
        }else{
            System.out.println("No es divisible entre ninguno");
        }
    }
}

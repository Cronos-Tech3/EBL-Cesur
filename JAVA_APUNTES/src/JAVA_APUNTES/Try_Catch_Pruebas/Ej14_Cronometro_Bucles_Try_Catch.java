package JAVA_APUNTES.Try_Catch_Pruebas;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ej14_Cronometro_Bucles_Try_Catch {
    public static void main(String[] args) {
        // Hacer un programa que muestre un cronometro, indicando las horas, minutos y
        //segundos. Se pedirá al usuario primero un número determinado de horas,
        //minutos y segundos.
        Scanner sc = new Scanner(System.in);
        while(true){

            System.out.println("Ingrese una hora: ");
            try  {
                int hora = sc.nextInt();
            } catch (InputMismatchException sE) {
                System.out.println(sE);
                System.out.println("Ingrese el valor en numero ");
                sc.nextLine();

            }

            System.out.println("Ingrese los minutos: ");
            int minutos = sc.nextInt();


        }




    }
}

package ra2;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Ejercicio11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1, num2;
        System.out.println("Ingrese dos numeros");
        num1 = sc.nextInt();
        num2 = sc.nextInt();
        int suma, resta, multi, divi;
        suma = num1 + num2;
        resta = num1 - num2;
        multi = num1 * num2;
        divi = num1 / num2;
        //pedir una operacion
        //en funcion de ese valor mostrar
        System.out.println("Elija que tipo de operacion quiere: suma,resta, multiplicacion, division");
        String operacion;
        operacion = sc.next();
        if (operacion.equalsIgnoreCase("suma")){
            System.out.println("La suma de los numeros es " + suma);
        } else if (operacion.equalsIgnoreCase("resta")) {
            System.out.println("La resta de los numeros es " + resta);
        } else if (operacion.equalsIgnoreCase("division")) {
            System.out.println("La division de los dos numeros es " + divi);
        } else if (operacion.equalsIgnoreCase("multiplicacion")) {
            System.out.println("La multiplicacion de los dos numeros es " + multi);
        } else {
            System.out.println("Ingrese correctamente el tipo de operacion que se la indicado");

        }

    }
}
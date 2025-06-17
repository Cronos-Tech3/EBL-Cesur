package ra2;

import java.util.Scanner;

public class Ejercicio1 {
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
        System.out.println("La suma de los numeros es " + suma);
        System.out.println("La resta de los numeros es " + resta);
        System.out.println("La multiplicacion de los numeros es " +multi);
        System.out.println("La division de los numeros es " + divi);


    }
}

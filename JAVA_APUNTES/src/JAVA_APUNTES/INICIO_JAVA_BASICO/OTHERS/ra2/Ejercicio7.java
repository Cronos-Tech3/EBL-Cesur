package ra2;

import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args) {
        // Crea un programa que pida al usuario una temperatura en grados Celsius y la
        //transforme en Fahrenheit. Celsius = (5/9) * (Fahrenheit-32)
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un numero que representara esa temperatura en grados celsius ");
        double num = sc.nextDouble();
        double farem = num*9/5+32;
        System.out.println("el numero " + num + " son " + farem + " grados faremheim");
    }
}

package JAVA_APUNTES.INICIO_JAVA_BASICO.INICIO_JAVA;

import java.util.Scanner;

public class Ej4_PideNum_muestrePar_Impar {
    public static void main(String[] args) {
        //  Crea un programa que pida un número y diga si es par o impar
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un numero ");
        int num = sc.nextInt();
        String par = (num%2==0) ? "es par" : "es impar"; // num divido entre 2 resto == a 0
        // operador ternario (condicion) ? "si la cumple":"si no la cumple"
        System.out.println(par);
    }
}

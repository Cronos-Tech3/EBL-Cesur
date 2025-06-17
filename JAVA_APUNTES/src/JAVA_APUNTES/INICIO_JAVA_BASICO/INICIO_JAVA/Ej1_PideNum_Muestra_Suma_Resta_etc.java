package JAVA_APUNTES.INICIO_JAVA_BASICO.INICIO_JAVA;

import java.util.Scanner;

public class Ej1_PideNum_Muestra_Suma_Resta_etc {
    public static void main(String[] args) {
        // Pide dos números y muestra la suma, resta, multiplicación y división de ambos
        Scanner sc = new Scanner(System.in); // Declaramos Scanner
        System.out.println("Ingrese dos Pruebas_X.numeros");
        int n = sc.nextInt(); // numeros a introducir por teclado
        int n1 = sc.nextInt();
        // Imprimimos las operaciones para esos numeros
        System.out.println("la suma de los Pruebas_X.numeros es " + (n + n1));
        System.out.println("la resta de los Pruebas_X.numeros es " + (n - n1));
        System.out.println("la multiplicacion de los Pruebas_X.numeros es " + (n * n1));
        System.out.println("la division de los Pruebas_X.numeros es " + (n / n1));
    }
}

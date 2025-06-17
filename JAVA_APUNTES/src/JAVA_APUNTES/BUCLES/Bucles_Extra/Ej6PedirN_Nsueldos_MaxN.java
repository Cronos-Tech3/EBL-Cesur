package JAVA_APUNTES.BUCLES.Bucles_Extra;

import java.util.Scanner;

public class Ej6PedirN_Nsueldos_MaxN {
    public static void main(String[] args) {
        //Pedir un número N, introducir N sueldos, y mostrar el sueldo máximo
        int n;
        double sueldo, maxSueldo = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un numero: ");
        n = sc.nextInt();
        for (int i = 0; i < n ; i++){
            System.out.println("Ingrese un sueldo: ");
            sueldo = sc.nextDouble();
            if (sueldo > maxSueldo){
                maxSueldo = sueldo;
            }
        }
        System.out.println("el sueldo maximo es: " + maxSueldo);
    }
}

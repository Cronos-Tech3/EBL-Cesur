package ra2;

import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        //Crea un programa que pida tres números y diga cuál es mayor y cuál es el menor
        Scanner sc = new Scanner(System.in);
        int num1, num2, num3;
        System.out.println("Ingrese tres numeros");
        num1 = sc.nextInt();
        num2 = sc.nextInt();
        num3 = sc.nextInt();
        int numeroMayor = (num1>num2) ? (num1):(num2);
        int numeroMa = (num3>numeroMayor) ? (num3):(numeroMayor);
        int numeroMenor = (num1<num2) ? (num1):(num2);
        int numeroMe3 = (num3<numeroMenor) ? (num3): (numeroMenor);


        System.out.println("el numero mayor es " + numeroMa);
        System.out.println("el numero menor es " + numeroMe3);

        numeroMayor = Math.max(num1, num2);
    }
}

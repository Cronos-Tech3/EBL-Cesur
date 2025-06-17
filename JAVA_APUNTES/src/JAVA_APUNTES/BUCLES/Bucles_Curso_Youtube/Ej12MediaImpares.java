package JAVA_APUNTES.BUCLES.Bucles_Curso_Youtube;

import java.util.Scanner;

public class Ej12MediaImpares {
    public static void main(String[] args) {
        /*
        Vamos a introducir números por teclado hasta que uno sea negativo.
        Después calcularemos la media de los números introducidos que sean
        impares y veremos cual es el número par más alto
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un numero");
        int num = sc.nextInt();
        int suma = 0;
        int unidades = 0;
        int maximo = 0;

        while (num>=0) {
            if (num%2!=0) {
                unidades++;
                suma += num;
                }

                if (num%2==0) {
                    if (num > maximo) {
                    maximo = num;
                    }
                }
            System.out.println("Introduce un numero");
            num = sc.nextInt();
        }
        System.out.println("la media de los impares es " + suma/unidades);
        System.out.println("el numero maximo de los pares es " + maximo);
    }
}

package EjerciciosBucle;

import java.util.Scanner;

public class Ej6extra{
    public static void main(String[] args) {
        //Pedir un numero N, introducir N sueldos, y mostrar el sueldo maximo
        Scanner sc = new Scanner(System.in);
       int numero;
       double sueldo, maximo = 0;
        System.out.println("Ingrese el numero de sueldos que quiere pedir");
          numero = sc.nextInt();

        for(int i = 0; i < numero; i++){
            System.out.println("Inserta un sueldo");
            sueldo = sc.nextDouble();
            if (sueldo>maximo){
                maximo = sueldo;
            }
        }
        System.out.println("el sueldo mayor es: " + maximo);
    }
}

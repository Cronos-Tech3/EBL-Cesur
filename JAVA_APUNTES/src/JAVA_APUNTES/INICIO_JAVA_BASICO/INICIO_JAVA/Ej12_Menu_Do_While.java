package JAVA_APUNTES.INICIO_JAVA_BASICO.INICIO_JAVA;

import java.util.Scanner;

public class Ej12_Menu_Do_While {
    public static void main(String[] args) {

        // Con el programa anterior crea un menú que se muestre como el siguiente:
        // 1-Sumar.
        // 2-Restar.
        // 3-Multiplicar.
        // 4-Dividir
        // 5-Salir
        // El programa se deje ejecutar en un bucle del que sólo se podrá salir cuando el usuario
        // inserte el número 5.

        Scanner s = new Scanner(System.in);
        int operacion;
        do {
        System.out.println("Ingrese dos Pruebas_X.numeros");
        int num1 = s.nextInt();
        int num2 = s.nextInt();
        System.out.println("Que tipo de operacion quiere: suma, resta, multiplicacion, division");
        System.out.println("Seleccione el numero en el siguiente menu");

            do {
            System.out.println(" 1-sumar");
            System.out.println(" 2-restar");
            System.out.println(" 3-multiplicar");
            System.out.println(" 4-division");
            System.out.println(" 5-salir");
            operacion = s.nextInt();
        }
            while ( operacion < 1 || operacion > 5 );
                switch (operacion) {
                    case 1 :
                        System.out.println(num1 + num2);
                        break;
                    case 2 :
                        System.out.println(num1 - num2);
                        break;
                    case 3:
                        System.out.println(num1 * num2);
                        break;
                    case 4:
                        if (num2 !=0) {
                            System.out.println(num1 / num2);
                        } else {
                            System.err.println("Error, No se puede dividir entre 0");
                        }

                        break;
                     case 5:
                         System.exit(5);
                }

        } while (operacion !=5);
    }
}

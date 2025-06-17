package JAVA_APUNTES.INICIO_JAVA_BASICO.INICIO_JAVA;

import java.util.Scanner;

public class Ej12_Menu_Switch_Clase {
    public static void main(String[] args) {
        /*
        12. Con el programa anterior crea un menú que se muestre como el siguiente:
            1-Sumar.
            2-Restar.
            3-Multiplicar.
            4-Dividir
            5-Salir
            El programa se deje ejecutar en un bucle del que sólo se podrá salir cuando el usuario
            inserte el número 5.
         */
        int num1, num2, suma;
        Scanner scn = new Scanner(System.in);
        int operacion;
        Scanner scl = new Scanner(System.in);

  /*      //pedir una operación
        System.out.println("1-Sumar.\n" +
                "2-Restar.\n" +
                "3-Multiplicar.\n" +
                "4-Dividir\n" +
                "5-Salir");
        operacion = scn.nextInt();
*/
/*        while(operacion != 5){
            //en función de ese valor mostrar
            System.out.println("Inserta dos números:");
            num1 = scn.nextInt();
            num2 = scn.nextInt();
            suma = num1 + num2;

            if(operacion==1){
                System.out.println("La suma es: " + suma);
            } else if (operacion==2) {
                System.out.println("La resta es: " + (num1 - num2));
            }else if (operacion==3) {
                System.out.println("La multi es: " + (num1 * num2));
            }else if (operacion==4) {
                System.out.println("La divi es: " + (num1 / num2));
            }else{
                System.out.println("Operación inválida");
            }

            System.out.println("1-Sumar.\n" +
                    "2-Restar.\n" +
                    "3-Multiplicar.\n" +
                    "4-Dividir\n" +
                    "5-Salir");
            operacion = scn.nextInt();
        }
*/
        do {
            //en función de ese valor mostrar
            System.out.println("Inserta dos números:");
            num1 = scn.nextInt();
            num2 = scn.nextInt();
            suma = num1 + num2;

            System.out.println("1-Sumar.\n" +
                    "2-Restar.\n" +
                    "3-Multiplicar.\n" +
                    "4-Dividir\n" +
                    "5-Salir");
            operacion = scn.nextInt();

            if(operacion==1){
                System.out.println("La suma es: " + suma);
            } else if (operacion==2) {
                System.out.println("La resta es: " + (num1 - num2));
            }else if (operacion==3) {
                System.out.println("La multi es: " + (num1 * num2));
            }else if (operacion==4) {
                System.out.println("La divi es: " + (num1 / num2));
            }else{
                System.out.println("Operación inválida");
            }
        }while (operacion != 5);

        System.out.println("Cerrando...");

    }
}


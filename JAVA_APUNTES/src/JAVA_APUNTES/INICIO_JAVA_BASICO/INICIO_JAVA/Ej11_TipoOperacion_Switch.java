package JAVA_APUNTES.INICIO_JAVA_BASICO.INICIO_JAVA;

import java.util.Scanner;

public class Ej11_TipoOperacion_Switch {
    public static void main(String[] args) {
        //Añade al ejercicio 1 la pregunta de qué tipo de operación quiere que se realice, de tal
        // forma que el usuario inserte dos números y la operación que quiere que se ejecute, y
        // el programa devuelva la salida correcta.
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese dos Pruebas_X.numeros");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        System.out.println("Que tipo de operacion quiere: suma, resta, multiplicacion, division");
        String operacion = sc.next();
        switch (operacion) {
            case "suma":
                System.out.println(num1 + num2);
                break;
                case "resta":
                    System.out.println(num1 - num2);
                    break;
                    case "multiplicacion":
                        System.out.println(num1 * num2);
                        break;
                        case "division":
                            System.out.println(num1 / num2);
        }
    }
}

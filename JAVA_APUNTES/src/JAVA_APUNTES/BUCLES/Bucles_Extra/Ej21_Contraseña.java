package JAVA_APUNTES.BUCLES.Bucles_Extra;

import java.util.Scanner;

public class Ej21_Contraseña {
    public static void main(String[] args) {
        //Escribir un programa que almacene la cadena de caracteres contraseña en una
        //variable, pregunte al usuario por la contraseña hasta que introduzca la
        //contraseña correcta.

            Scanner sc = new Scanner(System.in);
            int contador = 0;

            System.out.println("Ingrese la contraseña: al cuarto intento se bloquea");
            String n = sc.nextLine();
        if (n.equals("holamundo")){
            System.out.println("Caja abierta");
        }
        while (!n.equals("holamundo")) {
            contador++;
            System.out.println("Introduzca contraseña: ");
            n = sc.nextLine();
            if (n.equals("holamundo")) {
                System.out.println("Caja abierta");
                break;
            }
            if (contador == 3) {
                System.err.println("Usuario bloqueado");
                break;
            }
        }
    }
}

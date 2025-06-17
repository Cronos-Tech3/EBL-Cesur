package JAVA_APUNTES.BUCLES.Bucles_Extra;

import java.util.Scanner;

public class Ej21 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String regClave;
        String clave;
        int intentos = 0;

        System.out.println("Registr su clave");
        regClave = sc.nextLine();

        do {
            System.out.println("Ingrese su clave: ");
            clave = sc.nextLine();
            if (!clave.equals(regClave)) {
                intentos++;
                System.out.println("Clave incorrecta");
            }
        } while (!clave.equals(regClave));
        System.out.println("Acceso concedido");
    }
}

package JAVA_APUNTES.BUCLES.Bucles_Curso_Youtube;

import java.util.Scanner;

public class Ej3CajaFuerte {
    public static void main(String[] args) {
        /*
        Control a acceso a caja fuerte. La combinacion es un numero de 4 cifras.
        El programa pide la contraseña. Si no acertamos: Lo siento esa no es la combinacion.
        Si acertamos la caja fuerte se a abierto
        tenemos 4 intentos
         */
        Scanner sc = new Scanner(System.in);
        int contrasena = 1111;

        for (int i = 0; i < 4; i++) {
            System.out.println("Introduzca la contraseña");
            int intento = sc.nextInt();
            if (intento==contrasena) {
                System.out.println("Se abrio la caja");
                break;
            } else {
                System.out.println("Contraaseña incorrecta");
            }
            if (i==3){
                System.err.println("Usuario Bloqueado");
            }

        }



    }
}

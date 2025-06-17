package JAVA_APUNTES.A_Javadoc.soluciones_Paloma.validador_usuario_REGEX;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nombre = sc.nextLine();
        String email = sc.nextLine();
        String contrasenia = sc.nextLine();

        if(ValidadorUsuario.validarNombre(nombre) &&
            ValidadorUsuario.validarEmail(email) &&
            ValidadorUsuario.validarContrasenia(contrasenia)){
            Usuario u1 = new Usuario(nombre, email, contrasenia);
        }else{
            System.out.println("No has cumplido las validaciones");
        }
    }
}

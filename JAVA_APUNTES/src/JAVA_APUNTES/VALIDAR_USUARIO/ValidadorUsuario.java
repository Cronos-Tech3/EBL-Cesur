package JAVA_APUNTES.VALIDAR_USUARIO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidadorUsuario {

public static boolean validarNombre(String nombre){
    Pattern patron = Pattern.compile("nombre");
    Matcher m = patron.matcher(nombre);


    return false;
}




}

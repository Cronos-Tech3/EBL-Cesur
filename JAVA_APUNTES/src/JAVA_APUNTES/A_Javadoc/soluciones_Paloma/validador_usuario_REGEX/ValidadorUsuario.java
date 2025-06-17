package JAVA_APUNTES.A_Javadoc.soluciones_Paloma.validador_usuario_REGEX;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidadorUsuario {

    public static boolean validarNombre(String nombre){
        Pattern patron = Pattern.compile("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\s]{3,}$");
        Matcher m = patron.matcher(nombre);
        return m.find();
    }

    public static boolean validarEmail(String nombre){
        Pattern patron = Pattern.compile("^([a-zA-Z0-9._%-]+)@([a-zA-Z0-9.-]+).([a-zA-Z]{2,6})$");
        Matcher m = patron.matcher(nombre);
        return m.find();
    }

    public static boolean validarContrasenia(String nombre){
        Pattern patron = Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[@#$%^&+=!]).{8,}$");
        Matcher m = patron.matcher(nombre);
        return m.find();
    }
}

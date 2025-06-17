package JAVA_APUNTES.RA7.Dinosaurios_Simulacro;

public class AlturaInsuficienteException extends RuntimeException {
    public AlturaInsuficienteException(){
        super("No tiene altura suficiente");
    }
}

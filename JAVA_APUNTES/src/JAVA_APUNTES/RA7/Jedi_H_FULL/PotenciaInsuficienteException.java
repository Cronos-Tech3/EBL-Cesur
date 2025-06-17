package JAVA_APUNTES.RA7.Jedi_H_FULL;

public class PotenciaInsuficienteException extends RuntimeException{
    public PotenciaInsuficienteException(){
        super("El nivel de fuerza del Jedi no es suficiente para lanzar alguna habilidad");
    }
}
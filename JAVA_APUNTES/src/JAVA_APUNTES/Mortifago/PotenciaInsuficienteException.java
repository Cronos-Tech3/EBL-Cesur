package Enrique_Benito_Lopez;

public class PotenciaInsuficienteException extends RuntimeException {
    public PotenciaInsuficienteException(){
        super("El nivel de Magia es insuficente para lanzar el hechizo");
    }
}

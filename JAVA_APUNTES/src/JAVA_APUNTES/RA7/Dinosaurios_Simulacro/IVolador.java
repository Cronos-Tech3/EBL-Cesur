package JAVA_APUNTES.RA7.Dinosaurios_Simulacro;

public interface IVolador {

    void despegar() throws AlturaInsuficienteException;
    int calcularAlturaMaxima(int velocidad, int tiempo) throws AlturaInsuficienteException;
    int calcularDistanciaRecorrida(int velocidad, int tiempo);
}

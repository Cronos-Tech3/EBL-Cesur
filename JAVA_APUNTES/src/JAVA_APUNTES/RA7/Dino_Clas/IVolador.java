package JAVA_APUNTES.RA7.Dino_Clas;

/*
EXPLICACIÓN
    En esta interfaz definicmo los metodos relacionados
    con la capacidad de volar
 */
public interface IVolador {

    /* Metodo -> Despegar
            En caso de no tener la altura mínima para despegar y se intente
            lanza una excepción
     */
    void despegar() throws AlturaInsuficienteException;


    /* Metodo -> Calculo de altura máxima
           Calcula la altura máxima basada en la velocidad y el tiempo,
           lanzando una excepción si la altura no es suficiente.

     En caso positivo lanza la altura calculada
     */
    int calcularAlturaMaxima(int velocidad, int tiempo) throws AlturaInsuficienteException;


    /* Metodo -> Calculo de distación recorrida
        Calcula la distancia en base a la velocidad y tiempo
     */
    int calcularDistanciaRecorrida(int velocidad, int tiempo);
}
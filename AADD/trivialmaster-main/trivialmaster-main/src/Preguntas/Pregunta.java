package Preguntas;

import java.util.List;

/**
 * @author enrique benito lopez
 *
 * Descripcion de la clase
 * La clase Preguntas representa un objeto con enunciado y una lista de opciones como atributos.
 *
 * Metodos
 * getEnunciado(): Describe un metodo que obtiene el enunciado de una pregunta.
 * getOpciones(): Describe un metodo que obtiene la lista de las opciones de la respuesta.
 */

public class Pregunta {

    //ATRIBUTOS
    /**
     * El enunciado de la pregunta.
     */
    private String enunciado;

    /**
     * La lista de opciones de respuesta para la pregunta.
     */
    private List<Opcion> opciones;

    //CONSTRUCTOR
    /**
     * Constructor de la clase Preguntas.
     * @param enunciado el enunciado de la pregunta
     * @param opciones la lista de opciones de respuesta
     */
    public Pregunta(String enunciado, List<Opcion> opciones) {
        this.enunciado = enunciado;
        this.opciones = opciones;
    }

    //GETTERS

    /**
     * Obtiene el enunciado de la pregunta.
     *
     * @return el enunciado de la pregunta
     */

    public String getEnunciado() {
        return enunciado;
    }

    /**
     * Obtiene la lista de opciones de respuesta para la pregunta.
     *
     * @return la lista de opciones de respuesta
     */
    public List<Opcion> getOpciones() {
        return opciones;
    }
}

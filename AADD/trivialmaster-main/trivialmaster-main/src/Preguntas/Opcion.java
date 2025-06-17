package Preguntas;

/**
 * @author enrique benito lopez
 *
 * Descripcion de la clase
 * La clase Opcion representa una opcion de respuesta para una pregunta de trivial
 * cada opcion tiene un texto y un indicador si la respuesta es correcta.
 *
 * Metodos
 * getTexto(): Describe el metodo que devuelve el texto de la opción de respuesta.
 * esCorrecta(): Describe el metodo que verifica si la opción es la respuesta correcta.
 */

public class Opcion {
    //ATRIBUTOS

    /**
     * El texto de la opción de respuesta.
     */
    private String texto;

    /**
     * Indica si la opción es la respuesta correcta.
     */
    private boolean esCorrecta;

    //CONSTRUCTOR

    /**
     * Constructor de la clase Opcion.
     *
     * @param texto el texto de la opción de respuesta
     * @param esCorrecta indica si la opción es la respuesta correcta
     */
    public Opcion(String texto, boolean esCorrecta) {
        this.texto = texto;
        this.esCorrecta = esCorrecta;
    }

    //GETTER

    /**
     * Obtiene el texto de la opción de respuesta.
     *
     * @return el texto de la opción de respuesta
     */
    public String getTexto() {
        return texto;
    }

    /**
     * Verifica si la opción es la respuesta correcta.
     *
     * @return true si la opción es la respuesta correcta, false en caso contrario
     */
    public boolean esCorrecta() {
        return esCorrecta;
    }
}

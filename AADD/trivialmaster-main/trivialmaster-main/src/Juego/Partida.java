package Juego;

import Users.Player;
import java.util.Date;

/**
 * @author Juan Jose tornero dato
 * @author Enrique Benito Lopez
 *
 * Descripción Clase
 * La clase partida representa una partida de trivial con una fecha,
 * un jugador y una puntuación.
 *
 * Metodos
 * sumarPunto(): Describe el metodo que incrementa la puntuación de la partida en 1 punto.
 * toString(): Describe el metodo que devuelve una representación en forma de cadena de la partida.
 * getPuntuacion(): Describe el metodo que devuelve la puntuación de la partida.
 */

public class Partida {

    //ATRIBUTOS
    /**
     * La fecha en la que se inició la partida.
     */
    private Date fecha;

    /**
     * El jugador que está participando en la partida.
     */
    private Player jugador;

    /**
     * La puntuación obtenida en la partida.
     */
    private int puntuacion;

    //CONSTRUCTOR
    /**
     * Constructor de la clase Partida.
     * Inicializa la fecha con la fecha actual, asigna el jugador y establece la puntuación inicial en 0.
     *
     * @param jugador el jugador que participa en la partida
     */
    public Partida(Player jugador) {
        this.fecha = new Date();
        this.jugador = jugador;
        this.puntuacion = 0;
    }

    /**
     * Incrementa la puntuación de la partida en 1 punto.
     */
    public void sumarPunto() {
        this.puntuacion++;
    }

    /**
     * Devuelve una representación en forma de cadena de la partida.
     *
     * @return una cadena que contiene la fecha, el nombre del jugador y la puntuación
     */
    @Override
    public String toString() {
        return "Fecha: " + fecha + ", Jugador: " + jugador.getNombre() + ", Puntuación: " + puntuacion;
    }

    /**
     * Obtiene la puntuación de la partida.
     *
     * @return la puntuación de la partida
     */
    public int getPuntuacion() {
        return puntuacion;
    }
}

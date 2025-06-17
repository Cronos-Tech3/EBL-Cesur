package TRIVIAL.TRIVIAL.models;

import java.sql.Timestamp;

/**
 * La clase Puntuacion representa la puntuación de un jugador en el juego, incluyendo la fecha de actualización.
 */
public class Puntuacion {
    private int id;
    private int jugadorId;
    private int puntos;
    private Timestamp fechaActualizacion;

    /**
     * Constructor para inicializar una puntuación.
     *
     * @param id El identificador único de la puntuación.
     * @param jugadorId El identificador del jugador.
     * @param puntos La cantidad de puntos obtenidos por el jugador.
     * @param fechaActualizacion La fecha y hora de la última actualización de la puntuación.
     */
    public Puntuacion(int id, int jugadorId, int puntos, Timestamp fechaActualizacion) {
        this.id = id;
        this.jugadorId = jugadorId;
        this.puntos = puntos;
        this.fechaActualizacion = fechaActualizacion;
    }

    /**
     * Obtiene el identificador único de la puntuación.
     *
     * @return El identificador único de la puntuación.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador único de la puntuación.
     *
     * @param id El identificador único de la puntuación.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el identificador del jugador.
     *
     * @return El identificador del jugador.
     */
    public int getJugadorId() {
        return jugadorId;
    }

    /**
     * Establece el identificador del jugador.
     *
     * @param jugadorId El identificador del jugador.
     */
    public void setJugadorId(int jugadorId) {
        this.jugadorId = jugadorId;
    }

    /**
     * Obtiene la cantidad de puntos obtenidos por el jugador.
     *
     * @return La cantidad de puntos obtenidos por el jugador.
     */
    public int getPuntos() {
        return puntos;
    }

    /**
     * Establece la cantidad de puntos obtenidos por el jugador.
     *
     * @param puntos La cantidad de puntos obtenidos por el jugador.
     */
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    /**
     * Obtiene la fecha y hora de la última actualización de la puntuación.
     *
     * @return La fecha y hora de la última actualización de la puntuación.
     */
    public Timestamp getFechaActualizacion() {
        return fechaActualizacion;
    }

    /**
     * Establece la fecha y hora de la última actualización de la puntuación.
     *
     * @param fechaActualizacion La fecha y hora de la última actualización de la puntuación.
     */
    public void setFechaActualizacion(Timestamp fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
}
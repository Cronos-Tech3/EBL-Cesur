package TRIVIAL.TRIVIAL.models;

import java.sql.Timestamp;

/**
 * La clase Juego representa una sesión de juego, incluyendo información sobre el administrador, el jugador, la fecha del juego y la puntuación final.
 */
public class Juego {
    private final int id;
    private final int adminId;
    private final int jugadorId;
    private final Timestamp fechaJuego;
    private final int puntuacionFinal;

    /**
     * Constructor para inicializar una sesión de juego con todos los atributos.
     *
     * @param id El identificador único del juego.
     * @param adminId El identificador del administrador.
     * @param jugadorId El identificador del jugador.
     * @param fechaJuego La fecha y hora de la sesión de juego.
     * @param puntuacionFinal La puntuación final obtenida en el juego.
     */
    public Juego(int id, int adminId, int jugadorId, Timestamp fechaJuego, int puntuacionFinal) {
        this.id = id;
        this.adminId = adminId;
        this.jugadorId = jugadorId;
        this.fechaJuego = fechaJuego;
        this.puntuacionFinal = puntuacionFinal;
    }

    /**
     * Constructor para inicializar una sesión de juego sin ID ni fecha de juego.
     *
     * @param adminId El identificador del administrador.
     * @param jugadorId El identificador del jugador.
     * @param puntuacionFinal La puntuación final obtenida en el juego.
     */
    public Juego(int adminId, int jugadorId, int puntuacionFinal) {
        this(-1, adminId, jugadorId, null, puntuacionFinal); // Sin ID ni fecha juego
    }

    /**
     * Obtiene el identificador único del juego.
     *
     * @return El identificador único del juego.
     */
    public int getId() {
        return id;
    }

    /**
     * Obtiene el identificador del administrador.
     *
     * @return El identificador del administrador.
     */
    public int getAdminId() {
        return adminId;
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
     * Obtiene la fecha y hora de la sesión de juego.
     *
     * @return La fecha y hora de la sesión de juego.
     */
    public Timestamp getFechaJuego() {
        return fechaJuego;
    }

    /**
     * Obtiene la puntuación final obtenida en el juego.
     *
     * @return La puntuación final obtenida en el juego.
     */
    public int getPuntuacionFinal() {
        return puntuacionFinal;
    }
}
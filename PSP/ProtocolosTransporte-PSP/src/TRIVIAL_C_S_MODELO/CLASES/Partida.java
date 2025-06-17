package TRIVIAL_C_S_MODELO.CLASES;

import java.sql.Timestamp;

public class Partida {
    private int id;
    private int playerId;
    private int score;

    public Partida(int id, int playerId, int score, Timestamp date) {
        this.id = id;
        this.playerId = playerId;
        this.score = score;
    }

    // Getters y setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getPlayerId() {
        return 0;
    }

    public int getScore() {
        return 0;
    }



    public Timestamp getDate() {
        return null;
    }
}

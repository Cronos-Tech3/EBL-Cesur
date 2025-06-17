package TRIVIAL_C_S_MODELO.DAO;

import TRIVIAL_C_S_MODELO.CLASES.Partida;

public interface PartidaDAO {
    void createPartida(Partida partida);
    Partida readPartida(int id);
    void updatePartida(Partida partida);
    void deletePartida(int id);
    // Otros métodos relevantes

}
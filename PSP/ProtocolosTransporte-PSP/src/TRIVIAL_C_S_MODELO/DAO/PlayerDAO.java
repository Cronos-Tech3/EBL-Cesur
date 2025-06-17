package TRIVIAL_C_S_MODELO.DAO;

import TRIVIAL_C_S_MODELO.CLASES.Player;

public interface PlayerDAO {
    void createPlayer(Player player);
    Player readPlayer(int id);
    void updatePlayer(Player player);
    void deletePlayer(int id);
    // Otros métodos relevantes
}
package TRIVIAL_C_S_MODELO.CLASES;

public class Player extends User {
    public Player(int id, int userId, int score) {
        super(1, "root", "1234");
    }

    public Player(String name, String s) {
        super("username", "password", name);
    }

    public int getUserId() {
        return 0;
    }

    public int getScore() {
        return 0;
    }

    public String getAciertos() {
        return null;
    }
    // Atributos específicos de Player
}

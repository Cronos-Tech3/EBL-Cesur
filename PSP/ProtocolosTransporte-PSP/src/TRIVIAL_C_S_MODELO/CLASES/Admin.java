package TRIVIAL_C_S_MODELO.CLASES;

public class Admin extends User {
    public Admin(int id, int userId) {
        super("username", "password", "name");
    }

    public int getUserId() {
        return 0;
    }
    // Atributos específicos de Admin
}

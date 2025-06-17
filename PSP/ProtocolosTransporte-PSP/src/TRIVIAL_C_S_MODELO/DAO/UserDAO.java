package TRIVIAL_C_S_MODELO.DAO;

import TRIVIAL_C_S_MODELO.CLASES.User;
public interface UserDAO {
    void createUser(User user) throws IllegalArgumentException;
    User readUser(int id);
    void updateUser(User user);
    void deleteUser(int id);
    // Otros métodos relevantes
}
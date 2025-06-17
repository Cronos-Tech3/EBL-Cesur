package TRIVIAL_C_S_MODELO.DAO;

import TRIVIAL_C_S_MODELO.CLASES.Admin;

public interface AdminDAO {
    void createAdmin(Admin admin);
    Admin readAdmin(int id);
    void updateAdmin(Admin admin);
    void deleteAdmin(int id);
    // Otros métodos relevantes
}
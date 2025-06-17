package TRIVIAL_C_S_MODELO;

import TRIVIAL_C_S_MODELO.CLASES.User;
import TRIVIAL_C_S_MODELO.DAO.UserDAO;
import TRIVIAL_C_S_MODELO.DAO.UserDAOImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TrivialMainBDOO {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3307/usersTrivial?useSSL=false&serverTimezone=Europe/Madrid";

        try (Connection connection = DriverManager.getConnection(url, "root", "1234")) {
            UserDAO userDAO = new UserDAOImpl(connection);

            // Datos del usuario a crear
            String username = "root";
            String password = "1234";
            String name = "root"; // Añadir nombre del usuario

            // Validación de datos
            if (username == null || password == null || name == null ||
                    username.isBlank() || password.isBlank() || name.isBlank()) {
                System.err.println("Error: Username, password y name no pueden ser nulos o vacíos.");
                return;
            }

            // Crear el usuario con el nombre
            User user = new User(username, password, name);
            userDAO.createUser(user);

            System.out.println("Usuario creado correctamente en la base de datos.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
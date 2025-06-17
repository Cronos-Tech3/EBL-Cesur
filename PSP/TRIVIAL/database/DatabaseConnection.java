package TRIVIAL.TRIVIAL.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Devuelve una conexión activa con la base de datos especificada en la URL.
 *
 * @return Una instancia de {@link Connection}, activa y conectada al servidor MySQL.
 * @throws SQLException Si no se puede establecer una conexión con la base de datos.
 * <p>
 * Este método intenta cargar el controlador JDBC de MySQL explícitamente.
 * Si el controlador no está disponible, se imprimirá un mensaje informativo.
 * </p>
 */

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3307/TRIVIAL_DB?useSSL=false&serverTimezone=Europe/Madrid";
    private static final String USER = "root"; // Cambia por tu usuario
    private static final String PASSWORD = "1234"; // Cambia por tu contraseña

    public static Connection getConnection() throws SQLException {
        try {
            // Asegurarse de cargar explícitamente el driver en caso necesario
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador JDBC: " + e.getMessage());
        }

        // Crear la conexión
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
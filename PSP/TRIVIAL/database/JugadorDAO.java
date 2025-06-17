package TRIVIAL.TRIVIAL.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JugadorDAO {

    /**
     * Inserta un jugador en la base de datos.
     *
     * @param nombre    El nombre del jugador.
     * @param email     El email del jugador (debe ser único).
     * @param puntuacion La puntuación inicial del jugador.
     * @return true si el registro fue exitoso, false en caso contrario.
     */
    public boolean registrarJugador(String nombre, String email, int puntuacion) {
        String sql = "INSERT INTO Jugadores (nombre, email, puntuacion) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            // Asignar los valores a los parámetros de la consulta
            statement.setString(1, nombre);
            statement.setString(2, email);
            statement.setInt(3, puntuacion);

            // Ejecutar la consulta
            int filasInsertadas = statement.executeUpdate();
            return filasInsertadas > 0; // Retorna true si se insertaron filas

        } catch (SQLException e) {
            System.out.println("Error al registrar el jugador: " + e.getMessage());
            return false;
        }
    }
}
package TRIVIAL_C_S_MODELO.DAO;

import TRIVIAL_C_S_MODELO.CLASES.Pregunta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreguntaDAOImpl implements PreguntaDAO {
    private Connection connection;

    public PreguntaDAOImpl(Connection connection) {
    }

    @Override
    public void createPregunta(Pregunta pregunta) {
        String sql = "INSERT INTO Pregunta (question, answer) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, pregunta.getQuestion());
            statement.setString(2, pregunta.getAnswer());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Pregunta readPregunta(int id) {
        String sql = "SELECT * FROM Pregunta WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Pregunta(resultSet.getInt("id"), resultSet.getString("question"), resultSet.getString("answer"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updatePregunta(Pregunta pregunta) {
        String sql = "UPDATE Pregunta SET question = ?, answer = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, pregunta.getQuestion());
            statement.setString(2, pregunta.getAnswer());
            statement.setInt(3, pregunta.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePregunta(int id) {
        String sql = "DELETE FROM Pregunta WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
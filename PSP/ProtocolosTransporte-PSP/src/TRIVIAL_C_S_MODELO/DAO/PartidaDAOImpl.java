package TRIVIAL_C_S_MODELO.DAO;

import TRIVIAL_C_S_MODELO.CLASES.Partida;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PartidaDAOImpl implements PartidaDAO {
    private Connection connection;

    public PartidaDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void createPartida(Partida partida) {
        String sql = "INSERT INTO Partida (player_id, score, date) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, partida.getPlayerId());
            statement.setInt(2, partida.getScore());
            statement.setTimestamp(3, partida.getDate());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Partida readPartida(int id) {
        String sql = "SELECT * FROM Partida WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Partida(resultSet.getInt("id"), resultSet.getInt("player_id"), resultSet.getInt("score"), resultSet.getTimestamp("date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updatePartida(Partida partida) {
        String sql = "UPDATE Partida SET player_id = ?, score = ?, date = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, partida.getPlayerId());
            statement.setInt(2, partida.getScore());
            statement.setTimestamp(3, partida.getDate());
            statement.setInt(4, partida.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePartida(int id) {
        String sql = "DELETE FROM Partida WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
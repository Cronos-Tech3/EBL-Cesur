package TRIVIAL_C_S_MODELO.DAO;

import TRIVIAL_C_S_MODELO.CLASES.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerDAOImpl implements PlayerDAO {
    private Connection connection;

    public PlayerDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void createPlayer(Player player) {
        String sql = "INSERT INTO Player (user_id, score) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, player.getUserId());
            statement.setInt(2, player.getScore());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Player readPlayer(int id) {
        String sql = "SELECT * FROM Player WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Player(resultSet.getInt("id"), resultSet.getInt("user_id"), resultSet.getInt("score"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updatePlayer(Player player) {
        String sql = "UPDATE Player SET user_id = ?, score = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, player.getUserId());
            statement.setInt(2, player.getScore());
            statement.setInt(3, player.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePlayer(int id) {
        String sql = "DELETE FROM Player WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
package TRIVIAL.TRIVIAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * La clase ConsultaDePuntuaciones proporciona métodos para consultar y gestionar las puntuaciones de los jugadores en la base de datos.
 */
public class ConsultaDePuntuaciones {

    // URL de la base de datos
    public static final String DB_URL = "jdbc:mysql://localhost:3307/TRIVIAL_DB?useSSL=false&serverTimezone=Europe/Madrid";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "1234";

    /**
     * Consulta la puntuación general de todos los jugadores.
     */
    public void consultarPuntuacionGeneral() {
        String query = "SELECT jugadores.nombre, puntuaciones.puntos FROM jugadores JOIN puntuaciones ON jugadores.id = puntuaciones.jugador_id ORDER BY puntos DESC";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            System.out.println("=== Puntuaciones de Todos los Jugadores ===");
            while (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                int puntos = resultSet.getInt("puntos");
                System.out.println("Jugador: " + nombre + " - Puntos: " + puntos);
            }
        } catch (Exception e) {
            System.err.println("Error al consultar puntuaciones generales: " + e.getMessage());
        }
    }

    /**
     * Consulta la puntuación de un jugador específico.
     *
     * @param id El ID del jugador.
     */
    public void consultarPuntuacionJugador(int id) {
        String query = "SELECT jugadores.nombre, puntuaciones.puntos FROM jugadores JOIN puntuaciones ON jugadores.id = puntuaciones.jugador_id WHERE jugadores.id = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String nombre = resultSet.getString("nombre");
                    int puntos = resultSet.getInt("puntos");
                    System.out.println("Jugador: " + nombre + " - Puntos: " + puntos);
                } else {
                    System.out.println("No se encontró al jugador con ID: " + id);
                }
            }
        } catch (Exception e) {
            System.err.println("Error al consultar puntuación del jugador: " + e.getMessage());
        }
    }

    /**
     * Registra o actualiza la puntuación de un jugador.
     *
     * @param idJugador El ID del jugador.
     * @param nuevaPuntuacion La nueva puntuación del jugador.
     */
    public void registrarOActualizarPuntuacion(int idJugador, int nuevaPuntuacion) {
        String querySelect = "SELECT puntos FROM puntuaciones WHERE jugador_id = ?";
        String queryUpdate = "UPDATE puntuaciones SET puntos = ?, fecha_actualizacion = CURRENT_TIMESTAMP WHERE jugador_id = ?";
        String queryInsert = "INSERT INTO puntuaciones (jugador_id, puntos, fecha_actualizacion) VALUES (?, ?, CURRENT_TIMESTAMP)";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            // Verificar si ya existe puntuación para el jugador
            boolean existe = false;
            try (PreparedStatement selectStmt = connection.prepareStatement(querySelect)) {
                selectStmt.setInt(1, idJugador);
                try (ResultSet resultSet = selectStmt.executeQuery()) {
                    existe = resultSet.next();
                }
            }

            // Actualizar o insertar puntuación
            if (existe) {
                try (PreparedStatement updateStmt = connection.prepareStatement(queryUpdate)) {
                    updateStmt.setInt(1, nuevaPuntuacion);
                    updateStmt.setInt(2, idJugador);
                    updateStmt.executeUpdate();
                    System.out.println("Puntuación actualizada para el jugador con ID: " + idJugador);
                }
            } else {
                try (PreparedStatement insertStmt = connection.prepareStatement(queryInsert)) {
                    insertStmt.setInt(1, idJugador);
                    insertStmt.setInt(2, nuevaPuntuacion);
                    insertStmt.executeUpdate();
                    System.out.println("Puntuación registrada para el jugador con ID: " + idJugador);
                }
            }
        } catch (Exception e) {
            System.err.println("Error al registrar o actualizar puntuación: " + e.getMessage());
        }
    }

    /**
     * Obtiene una lista de preguntas desde la base de datos.
     *
     * @return Una lista de arreglos de cadenas, donde cada arreglo representa una pregunta con sus opciones y respuesta correcta.
     */
    public List<String[]> obtenerPreguntas() {
        List<String[]> preguntas = new ArrayList<>();
        String query = "SELECT texto, opcion1, opcion2, opcion3, respuesta_correcta FROM preguntas";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String texto = resultSet.getString("texto");
                String opcion1 = resultSet.getString("opcion1");
                String opcion2 = resultSet.getString("opcion2");
                String opcion3 = resultSet.getString("opcion3");
                int respuestaCorrecta = resultSet.getInt("respuesta_correcta");
                preguntas.add(new String[]{texto, opcion1, opcion2, opcion3, String.valueOf(respuestaCorrecta)});
            }
        } catch (Exception e) {
            System.err.println("Error al obtener preguntas de la base de datos: " + e.getMessage());
        }

        return preguntas;
    }

    /**
     * Modifica una pregunta existente en la base de datos.
     *
     * @param idPregunta El ID de la pregunta a modificar.
     * @param texto El nuevo texto de la pregunta.
     * @param opcion1 La nueva opción 1.
     * @param opcion2 La nueva opción 2.
     * @param opcion3 La nueva opción 3.
     * @param respuestaCorrecta La nueva respuesta correcta.
     */
    public void modificarPregunta(int idPregunta, String texto, String opcion1, String opcion2, String opcion3, int respuestaCorrecta) {
        String query = "UPDATE preguntas SET texto = ?, opcion1 = ?, opcion2 = ?, opcion3 = ?, respuesta_correcta = ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            // Establecer los parámetros de la consulta
            statement.setString(1, texto); // Nuevo texto de la pregunta
            statement.setString(2, opcion1); // Nueva opción 1
            statement.setString(3, opcion2); // Nueva opción 2
            statement.setString(4, opcion3); // Nueva opción 3
            statement.setInt(5, respuestaCorrecta); // Nueva respuesta correcta
            statement.setInt(6, idPregunta); // ID de la pregunta a modificar

            // Ejecutar la actualización
            int filasActualizadas = statement.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("La pregunta con ID " + idPregunta + " fue modificada correctamente.");
            } else {
                System.out.println("No se encontró ninguna pregunta con el ID especificado.");
            }

        } catch (Exception e) {
            System.err.println("Error al modificar la pregunta: " + e.getMessage());
        }
    }

    /**
     * Metodo auxiliar para modificar una pregunta utilizando un objeto ConsultaDePuntuaciones y un Scanner.
     *
     * @param consulta El objeto ConsultaDePuntuaciones.
     * @param scanner El objeto Scanner para la entrada del usuario.
     */
    public void modificarPregunta(ConsultaDePuntuaciones consulta, Scanner scanner) {
        System.out.println("=== Modificar Pregunta ===");
        System.out.println("Ingrese el ID de la pregunta a modificar:");
        int idPregunta = scanner.nextInt();
        scanner.nextLine();
    }
}
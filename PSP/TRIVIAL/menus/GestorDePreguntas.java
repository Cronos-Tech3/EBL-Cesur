package TRIVIAL.TRIVIAL.menus;

import TRIVIAL.TRIVIAL.database.DatabaseConnection;
import java.sql.*;
import java.util.Scanner;

public class GestorDePreguntas {

    public static void gestionarPreguntas(Scanner scanner) {
        int opcion;

        do {
            System.out.println("\n=== GESTOR DE PREGUNTAS ===");
            System.out.println("1. Añadir nueva pregunta");
            System.out.println("2. Eliminar pregunta");
            System.out.println("3. Editar pregunta");
            System.out.println("4. Ver todas las preguntas");
            System.out.println("5. Volver al menú administrador");
            System.out.print("Selecciona una opción: ");

            opcion = leerEnteroConValidacion(scanner, "Por favor, introduzca una opción válida.");

            switch (opcion) {
                case 1 -> anadirPregunta(scanner);
                case 2 -> eliminarPregunta(scanner);
                case 3 -> editarPregunta(scanner);
                case 4 -> verPreguntas();
                case 5 -> System.out.println("Volviendo al menú administrador...");
                default -> System.out.println("Opción inválida. Inténtalo de nuevo.");
            }
        } while (opcion != 5);
    }

    private static void anadirPregunta(Scanner scanner) {
        System.out.println("\n== Añadir Nueva Pregunta ==");

        System.out.print("Introduce el enunciado de la pregunta: ");
        String texto = leerLineaNoVacia(scanner, "El enunciado no puede estar vacío.");

        System.out.print("Introduce la opción 1: ");
        String opcion1 = leerLineaNoVacia(scanner, "La opción 1 no puede estar vacía.");

        System.out.print("Introduce la opción 2: ");
        String opcion2 = leerLineaNoVacia(scanner, "La opción 2 no puede estar vacía.");

        System.out.print("Introduce la opción 3: ");
        String opcion3 = leerLineaNoVacia(scanner, "La opción 3 no puede estar vacía.");

        System.out.print("Introduce la respuesta correcta (1/2/3): ");
        int respuestaCorrecta = leerEnteroConValidacion(scanner, "Debe ser un número entre 1 y 3.");

        if (respuestaCorrecta < 1 || respuestaCorrecta > 3) {
            System.out.println("La respuesta correcta debe ser 1, 2 o 3. Inténtalo nuevamente.");
            return;
        }

        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO preguntas (texto, opcion1, opcion2, opcion3, respuesta_correcta) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, texto);
                stmt.setString(2, opcion1);
                stmt.setString(3, opcion2);
                stmt.setString(4, opcion3);
                stmt.setInt(5, respuestaCorrecta);
                stmt.executeUpdate();
                System.out.println("Pregunta añadida correctamente.");
            }
        } catch (Exception e) {
            System.out.println("Error al añadir la pregunta: " + e.getMessage());
        }
    }

    private static void eliminarPregunta(Scanner scanner) {
        System.out.println("\n== Eliminar Pregunta ==");
        verPreguntas();

        System.out.print("Introduce el ID de la pregunta que deseas eliminar: ");
        int id = leerEnteroConValidacion(scanner, "Por favor, introduce un número válido.");

        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "DELETE FROM preguntas WHERE id = ?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, id);
                int rowsAffected = stmt.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Pregunta eliminada correctamente.");
                } else {
                    System.out.println("No se encontró una pregunta con ese ID.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar la pregunta: " + e.getMessage());
        }
    }

    private static void editarPregunta(Scanner scanner) {
        System.out.println("\n== Editar Pregunta ==");
        verPreguntas();

        System.out.print("Introduce el ID de la pregunta que deseas editar: ");
        int id = leerEnteroConValidacion(scanner, "Por favor, introduce un número válido.");

        // Pedir al usuario qué valores cambiar
        System.out.print("Nuevo enunciado (dejar vacío para mantener): ");
        String nuevoTexto = scanner.nextLine();

        System.out.print("Nueva opción 1 (dejar vacío para mantener): ");
        String nuevaOpcion1 = scanner.nextLine();

        System.out.print("Nueva opción 2 (dejar vacío para mantener): ");
        String nuevaOpcion2 = scanner.nextLine();

        System.out.print("Nueva opción 3 (dejar vacío para mantener): ");
        String nuevaOpcion3 = scanner.nextLine();

        System.out.print("Nueva respuesta correcta (1/2/3, dejar vacío para mantener): ");
        String nuevaRespuesta = scanner.nextLine();

        try (Connection connection = DatabaseConnection.getConnection()) {
            StringBuilder sql = new StringBuilder("UPDATE preguntas SET ");
            boolean tieneCambios = false;

            if (!nuevoTexto.isBlank()) {
                sql.append("texto = ?, ");
                tieneCambios = true;
            }
            if (!nuevaOpcion1.isBlank()) {
                sql.append("opcion1 = ?, ");
                tieneCambios = true;
            }
            if (!nuevaOpcion2.isBlank()) {
                sql.append("opcion2 = ?, ");
                tieneCambios = true;
            }
            if (!nuevaOpcion3.isBlank()) {
                sql.append("opcion3 = ?, ");
                tieneCambios = true;
            }
            if (!nuevaRespuesta.isBlank()) {
                sql.append("respuesta_correcta = ?, ");
                tieneCambios = true;
            }

            if (!tieneCambios) {
                System.out.println("No se realizaron cambios.");
                return;
            }

            sql.delete(sql.length() - 2, sql.length()); // Eliminar la última coma
            sql.append(" WHERE id = ?");

            try (PreparedStatement stmt = connection.prepareStatement(sql.toString())) {
                int paramIndex = 1;

                if (!nuevoTexto.isBlank()) stmt.setString(paramIndex++, nuevoTexto);
                if (!nuevaOpcion1.isBlank()) stmt.setString(paramIndex++, nuevaOpcion1);
                if (!nuevaOpcion2.isBlank()) stmt.setString(paramIndex++, nuevaOpcion2);
                if (!nuevaOpcion3.isBlank()) stmt.setString(paramIndex++, nuevaOpcion3);
                if (!nuevaRespuesta.isBlank()) stmt.setInt(paramIndex++, Integer.parseInt(nuevaRespuesta));

                stmt.setInt(paramIndex, id);

                int rowsUpdated = stmt.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Pregunta actualizada correctamente.");
                } else {
                    System.out.println("No se encontró una pregunta con ese ID.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar la pregunta: " + e.getMessage());
        }
    }

    private static void verPreguntas() {
        System.out.println("\n== Listado de Preguntas ==");

        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM preguntas";
            try (PreparedStatement stmt = connection.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {

                if (!rs.isBeforeFirst()) {
                    System.out.println("No hay preguntas registradas.");
                    return;
                }

                while (rs.next()) {
                    System.out.printf("ID: %d | %s%n", rs.getInt("id"), rs.getString("texto"));
                    System.out.printf("   1) %s | 2) %s | 3) %s | Respuesta Correcta: %d%n",
                            rs.getString("opcion1"), rs.getString("opcion2"),
                            rs.getString("opcion3"), rs.getInt("respuesta_correcta"));
                }
            }
        } catch (Exception e) {
            System.out.println("Error al cargar las preguntas: " + e.getMessage());
        }
    }

    private static int leerEnteroConValidacion(Scanner scanner, String mensajeError) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(mensajeError);
            }
        }
    }

    private static String leerLineaNoVacia(Scanner scanner, String mensajeError) {
        while (true) {
            String linea = scanner.nextLine().trim();
            if (!linea.isEmpty()) return linea;
            System.out.println(mensajeError);
        }
    }
}
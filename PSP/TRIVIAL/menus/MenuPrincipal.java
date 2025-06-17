package TRIVIAL.TRIVIAL.menus;

import TRIVIAL.TRIVIAL.Registro; // Se importa correctamente la clase Registro
import TRIVIAL.TRIVIAL.database.DatabaseConnection; // Verifica que este paquete también sea correcto
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import static TRIVIAL.TRIVIAL.menus.GestorDePreguntas.gestionarPreguntas;

/**
 * Clase principal que gestiona el menú de la aplicación.
 * Incluye funcionalidades para jugadores y administradores.
 */
public class MenuPrincipal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Registro registro = new Registro(); // Instancia del registro de administradores
        boolean salir = false;

        while (!salir) {
            mostrarMenu();
            int opcion = leerEnteroConValidacion(scanner, "Por favor, ingrese una opción válida.");

            switch (opcion) {
                case 1 -> registrarJugador(scanner);
                case 2 -> iniciarSesionJugador(scanner, new ConsultaDePuntuaciones());
                case 3 -> registrarAdministrador(scanner);
                case 4 -> iniciarSesionAdministrador(scanner, registro);
                case 5 -> salir = true;
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        }

        scanner.close();
        System.out.println("Gracias por usar el sistema. ¡Adiós!");
    }

    /**
     * Método para mostrar el menú principal
     */
    private static void mostrarMenu() {
        System.out.println("\n--- Menú Principal ---");
        System.out.println("1. Registrar Jugador");
        System.out.println("2. Iniciar Sesión como Jugador");
        System.out.println("3. Registrar Administrador");
        System.out.println("4. Iniciar Sesión como Administrador");
        System.out.println("5. Salir");
        System.out.println("Ingrese una opción:");
    }

    /**
     * Método para registrar un nuevo jugador.
     */
    private static void registrarJugador(Scanner scanner) {
        System.out.println("--- Registrar Jugador ---");
        System.out.print("Ingrese su nombre de usuario: ");
        String username = scanner.nextLine();

        System.out.print("Ingrese su contraseña: ");
        String password = scanner.nextLine();

        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO jugadores (usuario, contrasena) VALUES (?, ?)"
            );
            statement.setString(1, username);
            statement.setString(2, password);
            statement.executeUpdate();
            System.out.println("Jugador registrado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al registrar jugador: " + e.getMessage());
        }
    }

    /**
     * Método para iniciar sesión como jugador.
     */
    private static void iniciarSesionJugador(Scanner scanner, ConsultaDePuntuaciones consultaDePuntuaciones) {
        System.out.println("--- Iniciar Sesión como Jugador ---");
        System.out.print("Ingrese su nombre de usuario: ");
        String username = scanner.nextLine();

        System.out.print("Ingrese su contraseña: ");
        String password = scanner.nextLine();

        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT id FROM jugadores WHERE usuario = ? AND contrasena = ?"
            );
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int jugadorId = resultSet.getInt("id");
                System.out.println("Inicio de sesión exitoso. ¡Bienvenido, " + username + "!");
                mostrarMenuJugador(scanner, jugadorId);
            } else {
                System.out.println("Credenciales incorrectas. Intente nuevamente.");
            }
        } catch (Exception e) {
            System.out.println("Error al intentar iniciar sesión: " + e.getMessage());
        }
    }

    /**
     * Método para mostrar el menú del jugador.
     */
    private static void mostrarMenuJugador(Scanner scanner, int jugadorId) {
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- Menú del Jugador ---");
            System.out.println("1. Ver Puntuaciones");
            System.out.println("2. Jugar Trivia");
            System.out.println("3. Salir");
            int opcion = leerEnteroConValidacion(scanner, "Por favor, ingrese una opción válida.");

            switch (opcion) {
                case 1 -> verPuntuaciones(jugadorId);
                case 2 -> jugarTrivia(scanner, jugadorId);
                case 3 -> salir = true;
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    /**
     * Método para iniciar sesión como administrador.
     */
    private static void iniciarSesionAdministrador(Scanner scanner, Registro registro) {
        System.out.println("--- Iniciar Sesión como Administrador ---");
        System.out.print("Ingrese su usuario: ");
        String usuario = scanner.nextLine();

        System.out.print("Ingrese su contraseña: ");
        String contrasena = scanner.nextLine();

        if (registro.autenticarAdministrador(usuario, contrasena) != null) {
            System.out.println("Inicio de sesión exitoso. ¡Bienvenido, administrador!");
            desplegarMenuAdministrador(scanner);
        } else {
            System.out.println("Credenciales incorrectas. Por favor, intente de nuevo.");
        }
    }

    /**
     * Método para registrar un nuevo administrador.
     */
    private static void registrarAdministrador(Scanner scanner) {
        System.out.println("--- Registrar Administrador ---");
        System.out.print("Ingrese su nombre de usuario: ");
        String usuario = scanner.nextLine();

        System.out.print("Ingrese su contraseña: ");
        String contrasena = scanner.nextLine();

        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO administradores (usuario, contrasena) VALUES (?, ?)"
            );
            statement.setString(1, usuario);
            statement.setString(2, contrasena);
            statement.executeUpdate();
            System.out.println("Administrador registrado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al registrar administrador: " + e.getMessage());
        }
    }

    /**
     * Método para desplegar el menú del administrador.
     */
    private static void desplegarMenuAdministrador(Scanner scanner) {
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- Menú del Administrador ---");
            System.out.println("1. Gestionar Preguntas");
            System.out.println("2. Salir");

            int opcion = leerEnteroConValidacion(scanner, "Por favor, ingrese una opción válida.");
            switch (opcion) {
                case 1 -> gestionarPreguntas(scanner);
                case 2 -> salir = true;
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    /**
     * Método para leer y validar enteros proporcionados por el usuario.
     */
    private static int leerEnteroConValidacion(Scanner scanner, String mensajeError) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(mensajeError);
            }
        }
    }

    /**
     * Método para ver las puntuaciones del jugador.
     */
    private static void verPuntuaciones(int jugadorId) {
        // Implementación omitida por simplicidad
    }

    /**
     * Método para jugar la trivia.
     */
    private static void jugarTrivia(Scanner scanner, int jugadorId) {
        // Implementación omitida por simplicidad
    }
}
package TRIVIAL.TRIVIAL;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Enrique Benito Lopez
 * @author Juan Jose tornero Dato
 */

public class Cliente {
    private static final String HOST = "localhost"; // Cambiar si necesario
    private static final int PUERTO = 12345;

    /**
     * Método principal que inicia el cliente, se conecta al servidor y muestra un menú interactivo.
     *
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        try (
                // Crea un socket para conectarse al servidor en el host y puerto especificados
                Socket socket = new Socket(HOST, PUERTO);
                // Crea un PrintWriter para enviar datos al servidor
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                // Crea un BufferedReader para leer datos del servidor
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                // Crea un Scanner para leer la entrada del usuario desde la consola
                Scanner scanner = new Scanner(System.in)
        ) {
            System.out.println("Conectado al servidor.");
            // Variable para controlar el bucle del menú principal
            boolean continuar = true;

            // Bucle principal del menú interactivo
            while (continuar) {
                System.out.println("=== MENÚ PRINCIPAL ===");
                System.out.println("1. Registrar jugador");
                System.out.println("2. Registrar administrador");
                System.out.println("3. Iniciar sesión como jugador");
                System.out.println("4. Iniciar sesión como administrador");
                System.out.println("5. Salir");
                System.out.print("Seleccione una opción: ");
                String opcion = scanner.nextLine();

                switch (opcion) {
                    case "1":
                        registrarJugador(scanner, out, in);
                        break;
                    case "2":
                        registrarAdministrador(scanner, out, in);
                        break;
                    case "3":
                        iniciarSesionJugador(scanner, out, in);
                        break;
                    case "4":
                        iniciarSesionAdministrador(scanner, out, in);
                        break;
                    case "5":
                        continuar = false;
                        System.out.println("Saliendo del programa.");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            }
        } catch (IOException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
    }

    /**
     * Registra un nuevo jugador enviando sus datos al servidor.
     *
     * @param scanner El Scanner para leer la entrada del usuario.
     * @param out El PrintWriter para enviar datos al servidor.
     * @param in El BufferedReader para leer la respuesta del servidor.
     * @throws IOException Si ocurre un error de entrada/salida.
     */
    private static void registrarJugador(Scanner scanner, PrintWriter out, BufferedReader in) throws IOException {
        System.out.print("Introduce tu nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Introduce tu email: ");
        String email = scanner.nextLine();
        System.out.print("Introduce tu contraseña: ");
        String contrasena = scanner.nextLine();

        // Envía los datos del jugador al servidor en el formato especificado
        out.println("REGISTRAR_JUGADOR;" + nombre + ";" + email + ";" + contrasena);
        // Lee y muestra la respuesta del servidor
        System.out.println("Respuesta del servidor: " + in.readLine());
    }

    /**
     * Registra un nuevo administrador enviando sus datos al servidor.
     *
     * @param scanner El Scanner para leer la entrada del usuario.
     * @param out El PrintWriter para enviar datos al servidor.
     * @param in El BufferedReader para leer la respuesta del servidor.
     * @throws IOException Si ocurre un error de entrada/salida.
     */
    private static void registrarAdministrador(Scanner scanner, PrintWriter out, BufferedReader in) throws IOException {
        System.out.print("Introduce tu nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Introduce tu email: ");
        String email = scanner.nextLine();
        System.out.print("Introduce tu contraseña: ");
        String contrasena = scanner.nextLine();

        // Envía los datos del administrador al servidor en el formato especificado
        out.println("REGISTRAR_ADMINISTRADOR;" + nombre + ";" + email + ";" + contrasena);
        // Lee y muestra la respuesta del servidor
        System.out.println("Respuesta del servidor: " + in.readLine());
    }

    /**
     * Inicia sesión para un jugador enviando sus datos al servidor.
     *
     * @param scanner El Scanner para leer la entrada del usuario.
     * @param out El PrintWriter para enviar datos al servidor.
     * @param in El BufferedReader para leer la respuesta del servidor.
     * @throws IOException Si ocurre un error de entrada/salida.
     */
    private static void iniciarSesionJugador(Scanner scanner, PrintWriter out, BufferedReader in) throws IOException {
        System.out.print("Introduce tu email: ");
        String email = scanner.nextLine().trim();
        System.out.print("Introduce tu contraseña: ");
        String password = scanner.nextLine().trim();

        // Formatear el mensaje para enviarlo al servidor
        String mensaje = "INICIAR_SESION_JUGADOR;" + email + ";" + password;
        System.out.println("Enviando mensaje al servidor: " + mensaje);

        // Enviar el mensaje al servidor
        out.println(mensaje);
        // Asegura que todos los datos pendientes en el PrintWriter se envíen al servidor
        out.flush();

        // Recibir respuesta del servidor
        String respuesta = in.readLine();
        // Verifica si no se recibió respuesta del servidor
        if (respuesta == null) {
            System.out.println("Error: no se recibió respuesta del servidor.");
            return;
        }
        System.out.println("Respuesta del servidor: " + respuesta);

        // Si el inicio de sesión es exitoso, mostrar el menú del jugador
        if (respuesta.startsWith("OK")) {
            System.out.println("Inicio de sesión exitoso. Bienvenido al juego.");
            menuJugador(scanner, out, in);
        } else {
            System.out.println("Error al iniciar sesión: " + respuesta);
        }
    }

    /**
     * Inicia sesión para un administrador enviando sus datos al servidor.
     *
     * @param scanner El Scanner para leer la entrada del usuario.
     * @param out El PrintWriter para enviar datos al servidor.
     * @param in El BufferedReader para leer la respuesta del servidor.
     * @throws IOException Si ocurre un error de entrada/salida.
     */
    private static void iniciarSesionAdministrador(Scanner scanner, PrintWriter out, BufferedReader in) throws IOException {
        System.out.print("Introduce tu email: ");
        String email = scanner.nextLine();
        System.out.print("Introduce tu contraseña: ");
        String contrasena = scanner.nextLine();

        // Formatea el comando para enviarlo al servidor
        String comando = "INICIAR_SESION_ADMINISTRADOR;" + email + ";" + contrasena;
        // Imprime el comando que se enviará al servidor (para depuración)
        System.out.println("[CLIENTE] Enviando comando: " + comando); // Depuración
        out.println(comando); // Enviar solicitud al servidor

        // Lee la respuesta del servidor
        String respuesta = in.readLine();
        // Imprime la respuesta recibida del servidor
        System.out.println("[CLIENTE] Respuesta del servidor: " + respuesta); // Mostrar respuesta al cliente

        // Si la autenticación es exitosa, inicia el menú de administrador
        if (respuesta.startsWith("OK")) {
            // Si la autenticación es exitosa, iniciar menú de administrador
            menuAdministrador(scanner, out, in);
        }
    }

    /**
     * Muestra el menú del jugador y maneja las opciones seleccionadas.
     *
     * @param scanner El Scanner para leer la entrada del usuario.
     * @param out El PrintWriter para enviar datos al servidor.
     * @param in El BufferedReader para leer la respuesta del servidor.
     * @throws IOException Si ocurre un error de entrada/salida.
     */
    private static void menuJugador(Scanner scanner, PrintWriter out, BufferedReader in) throws IOException {
        // Variable para controlar el bucle del menú del jugador
        boolean continuar = true;
        // Bucle principal del menú del jugador
        while (continuar) {
            System.out.println("\n=== MENÚ DEL JUGADOR ===");
            System.out.println("1. Iniciar trivial");
            System.out.println("2. Ver puntuaciones");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            // Lee la opción seleccionada por el usuario y elimina espacios en blanco al inicio y al final
            String opcion = scanner.nextLine().trim();
            // Maneja la opción seleccionada utilizando una estructura switch
            switch (opcion) {
                case "1":
                    iniciarTrivial(scanner, out, in);
                    break;
                case "2":
                    verPuntuaciones(out, in);
                    break;
                case "3":
                    System.out.println("Cerrando sesión. ¡Hasta luego!");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intente de nuevo.");
            }
        }
    }

    /**
     * Inicia el juego de trivial, enviando preguntas al cliente y procesando sus respuestas.
     *
     * @param scanner El Scanner para leer la entrada del usuario.
     * @param out El PrintWriter para enviar datos al servidor.
     * @param in El BufferedReader para leer la respuesta del servidor.
     * @throws IOException Si ocurre un error de entrada/salida.
     */
    private static void iniciarTrivial(Scanner scanner, PrintWriter out, BufferedReader in) throws IOException {
        // Solicitar al servidor iniciar el trivial
        out.println("INICIAR_TRIVIAL"); // Solicitar al servidor iniciar el trivial
        int puntuacion = 0; // Inicializar la puntuación
        // Iterar para recibir y procesar 5 preguntas
        for (int i = 0; i < 5; i++) {
            String pregunta = in.readLine(); // Recibir pregunta del servidor
            if (pregunta.startsWith("ERROR")) {
                System.out.println("Error: " + pregunta);
                return;
            }
            // Mostrar la pregunta y sus opciones al cliente
            String[] partesPregunta = pregunta.split(";");
            System.out.println("Pregunta " + (i + 1) + ":");
            System.out.println(partesPregunta[2]); // Pregunta
            System.out.println("a) " + partesPregunta[3]);
            System.out.println("b) " + partesPregunta[4]);
            System.out.println("c) " + partesPregunta[5]);
            // Leer la respuesta del cliente
            System.out.print("Tu respuesta (a, b, c): ");
            String respuestaUsuario = scanner.nextLine().trim().toUpperCase();
            // Enviar respuesta al servidor (formato RESPUESTA;id_pregunta;respuesta)
            out.println("RESPUESTA;" + partesPregunta[1] + ";" + respuestaUsuario);
            // Recibir el resultado inmediato de la pregunta
            String resultado = in.readLine();
            System.out.println(resultado);
            if (resultado.startsWith("CORRECTO")) {
                puntuacion++; // Incrementar la puntuación si la respuesta es correcta
            }
            System.out.println();
        }
        // Recibir el resumen final del servidor
        String resumen = in.readLine();
        System.out.println(resumen);
        // Enviar la puntuación final al servidor
        out.println("REGISTRAR_PARTIDA;" + puntuacion);
        System.out.println("Puntuación final enviada al servidor: " + puntuacion);
    }

    /**
     * Solicita al servidor las puntuaciones y las muestra al jugador.
     *
     * @param out El PrintWriter para enviar datos al servidor.
     * @param in El BufferedReader para leer la respuesta del servidor.
     * @throws IOException Si ocurre un error de entrada/salida.
     */
    private static void verPuntuaciones(PrintWriter out, BufferedReader in) throws IOException {
        out.println("VER_PUNTUACIONES"); // Solicitar al servidor las puntuaciones
        String respuesta = in.readLine(); // Recibir la respuesta del servidor
        System.out.println("Puntuaciones:\n" + respuesta); // Mostrar las puntuaciones al jugador
    }

    /**
     * Muestra el menú del administrador y maneja las opciones seleccionadas.
     *
     * @param scanner El Scanner para leer la entrada del usuario.
     * @param out El PrintWriter para enviar datos al servidor.
     * @param in El BufferedReader para leer la respuesta del servidor.
     * @throws IOException Si ocurre un error de entrada/salida.
     */
    private static void menuAdministrador(Scanner scanner, PrintWriter out, BufferedReader in) throws IOException {
        // Variable para controlar el bucle del menú del administrador
        boolean continuar = true;
        // Bucle principal del menú del administrador
        while (continuar) {
            System.out.println("=== MENÚ DE ADMINISTRADOR ===");
            System.out.println("1. Agregar pregunta");
            System.out.println("2. Editar pregunta");
            System.out.println("3. Eliminar pregunta");
            System.out.println("4. Listar todas las preguntas");
            System.out.println("5. Cerrar sesión");
            System.out.print("Seleccione una opción: ");

            String opcion = scanner.nextLine();
            // Maneja la opción seleccionada utilizando una estructura switch
            switch (opcion) {
                case "1": // Agregar pregunta
                    System.out.print("Ingrese el texto de la pregunta: ");
                    String pregunta = scanner.nextLine();
                    System.out.print("Ingrese la opción A: ");
                    String opcionA = scanner.nextLine();
                    System.out.print("Ingrese la opción B: ");
                    String opcionB = scanner.nextLine();
                    System.out.print("Ingrese la opción C: ");
                    String opcionC = scanner.nextLine();
                    System.out.println("Ingrese la correcta:  ");
                    String correcta = scanner.nextLine();
                    out.println("AGREGAR_PREGUNTA;" + pregunta + ";" + opcionA + ";" + opcionB + ";" + opcionC + ";" + correcta);
                    System.out.println("Respuesta del servidor: " + in.readLine());
                    break;

                case "2": // Editar pregunta
                    System.out.print("Ingrese el ID de la pregunta a editar: ");
                    String idEditar = scanner.nextLine();
                    System.out.print("Ingrese el nuevo texto de la pregunta: ");
                    String nuevaPregunta = scanner.nextLine();
                    System.out.print("Ingrese la nueva opción A: ");
                    String nuevaOpcionA = scanner.nextLine();
                    System.out.print("Ingrese la nueva opción B: ");
                    String nuevaOpcionB = scanner.nextLine();
                    System.out.print("Ingrese la nueva respuesta correcta (A o B): ");
                    String nuevaCorrecta = scanner.nextLine();
                    out.println("EDITAR_PREGUNTA;" + idEditar + ";" + nuevaPregunta + ";" + nuevaOpcionA + ";" +
                            nuevaOpcionB + ";" + nuevaCorrecta);
                    System.out.println("Respuesta del servidor: " + in.readLine());
                    break;

                case "3": // Eliminar pregunta
                    System.out.print("Ingrese el ID de la pregunta a eliminar: ");
                    String idEliminar = scanner.nextLine();
                    out.println("ELIMINAR_PREGUNTA;" + idEliminar);
                    System.out.println("Respuesta del servidor: " + in.readLine());
                    break;

                case "4": // Listar preguntas
                    System.out.println("[CLIENTE] Enviando solicitud: LISTAR_PREGUNTAS");
                    out.println("LISTAR_PREGUNTAS"); // Aquí se envía la solicitud correctamente
                    String respuesta = in.readLine();
                    System.out.println("[CLIENTE] Respuesta del servidor: " + respuesta);
                    break;


                case "5": // Salir
                    continuar = false;
                    System.out.println("Sesión cerrada.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
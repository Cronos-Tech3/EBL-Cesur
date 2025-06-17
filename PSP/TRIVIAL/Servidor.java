package TRIVIAL.TRIVIAL;

import  TRIVIAL.TRIVIAL.database.DatabaseConnection;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.util.Arrays;
import java.util.concurrent.Semaphore;

public class Servidor {

    private static final int PUERTO = 12345; // Puerto donde el servidor estará escuchando
    private static final Semaphore SEMAFORO = new Semaphore(2); // Semáforo para limitar las conexiones simultáneas a 2

    /**
     * Metodo principal que inicia el servidor.
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        // Inicia un bloque try-with-resources para asegurar que el ServerSocket se cierre automáticamente
        try (ServerSocket serverSocket = new ServerSocket(PUERTO)) {
            System.out.println("[SERVIDOR] Servidor iniciado en el puerto " + PUERTO);
            // Bucle infinito para mantener el servidor en ejecución
            while (true) {
                // Imprime un mensaje indicando que el servidor está esperando una conexión
                System.out.println("[SERVIDOR] Esperando conexión...");
                SEMAFORO.acquire(); // Adquirir un permiso del semáforo antes de aceptar una conexión
                Socket socket = serverSocket.accept(); // Acepta una conexión entrante y crea un nuevo socket para manejarla
                System.out.println("[SERVIDOR] Cliente conectado desde " + socket.getInetAddress()); // Imprime un mensaje indicando que un cliente se ha conectado, mostrando su dirección IP
                // Inicia un nuevo hilo para manejar la conexión del cliente utilizando ClienteHandler
                new Thread(new ClienteHandler(socket)).start();
            }
        } catch (IOException e) {
            // Maneja excepciones de entrada/salida y muestra un mensaje de error
            System.err.println("[SERVIDOR] Error en el servidor: " + e.getMessage());
        } catch (InterruptedException e) {
            // Maneja excepciones de interrupción y muestra un mensaje de error
            System.err.println("[SERVIDOR] Error al adquirir permiso del semáforo: " + e.getMessage());
        }
    }

    /**
     * Clase interna que maneja la conexión con el cliente.
     */
    private static class ClienteHandler implements Runnable {
        private final Socket socket;

        /**
         * Constructor del ClienteHandler
         *
         * @param socket El socket utilizado para la conexión con el cliente.
         */
        public ClienteHandler(Socket socket) {
            this.socket = socket;
        }
        // Asigna el socket pasado como parámetro a la variable de instancia

        /**
         * Método que se ejecuta cuando el hilo es iniciado.
         */
        @Override
        public void run() {
            // Inicia un bloque try-with-resources para asegurar que los recursos se cierren automáticamente
            try (
                    // Crea un BufferedReader para leer las entradas del cliente
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    // Crea un PrintWriter para enviar respuestas al cliente
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
            ) {
                String solicitud;

                // Ciclo para procesar las solicitudes del cliente mientras esté conectado
                while ((solicitud = in.readLine()) != null) {
                    System.out.println("Solicitud recibida: " + solicitud);
                    String respuesta = procesarSolicitud(solicitud, in, out);
                    if (respuesta != null) {
                        out.println(respuesta); // Enviar respuesta al cliente
                    }
                }
            } catch (IOException e) {
                // Maneja excepciones de entrada/salida y muestra un mensaje de error
                System.err.println("Error manejando cliente: " + e.getMessage());
            } finally {
                // Bloque finally para asegurar que el socket se cierre y el semáforo se libere
                try {
                    socket.close();
                    SEMAFORO.release(); // Liberar un permiso del semáforo
                } catch (IOException e) {
                    System.err.println("Error cerrando el socket: " + e.getMessage());
                }
            }
        }
    }

    /**
     * Procesa la solicitud recibida del cliente.
     *
     * @param solicitud La solicitud recibida del cliente.
     * @param in El BufferedReader para leer la solicitud.
     * @param out El PrintWriter para enviar la respuesta.
     * @return La respuesta procesada.
     */
    private static String procesarSolicitud(String solicitud, BufferedReader in, PrintWriter out) {
        try {
            // Imprimir la solicitud completa recibida
            System.out.println("[SERVIDOR] Solicitud recibida: " + solicitud);

            // Separar la solicitud en partes
            String[] partes = solicitud.split(";");
            System.out.println("[SERVIDOR] Partes de la solicitud: " + Arrays.toString(partes));

            // Convertir el primer elemento de la solicitud en mayúsculas para identificar el comando
            String comando = partes[0].toUpperCase();

            // Manejar los comandos recibidos
            switch (comando) {
                case "REGISTRAR_JUGADOR": // Manejo del comando REGISTRAR_JUGADOR
                    return registrarJugador(partes);

                case "REGISTRAR_ADMINISTRADOR": {
                    try {
                        return registrarAdministrador(solicitud);
                    } catch (SQLException e) {
                        return "ERROR;No se pudo registrar el administrador: " + e.getMessage();
                    }
                }
                case "INICIAR_SESION_JUGADOR":
                    if (partes.length == 3) { // Asegurarse de que se envíen email y contraseña
                        String email = partes[1];
                        String contrasena = partes[2];
                        return iniciarSesionJugador(email, contrasena);
                    } else {
                        return "ERROR;Formato incorrecto de solicitud";
                    }
                case "INICIAR_TRIVIAL":
                    return iniciarTrivial(in, out);

                case "GET_PREGUNTA_TRIVIAL":
                    return obtenerPreguntaTrivial();

                case "RESPONDER_TRIVIAL": // Manejar respuestas del jugador
                    if (partes.length == 3) {
                        try {
                            // Convertimos el ID de pregunta desde la solicitud.
                            int idPregunta = Integer.parseInt(partes[1].trim());
                            String respuesta = partes[2].trim().toUpperCase(); // Normaliza la respuesta del cliente.

                            // Validamos que la respuesta esté en el rango 'A' - 'C'.
                            if (!respuesta.matches("^[A-C]$")) {
                                return "ERROR;Respuesta inválida, debe ser 'A', 'B' o 'C'";
                            }

                            // Verificamos la respuesta seleccionada con la base de datos.
                            return verificarRespuesta(idPregunta, respuesta);

                        } catch (NumberFormatException e) {
                            return "ERROR;ID de la pregunta inválido";
                        }
                    } else {
                        return "ERROR;Formato de respuesta incorrecto";
                    }
                case "VER_PUNTUACIONES":
                    return verPuntuaciones();
                case "REGISTRAR_PARTIDA":
                    if (partes.length == 2) {
                        int puntuacion = Integer.parseInt(partes[1]);
                        return registrarPartida(puntuacion);
                    } else {
                        return "ERROR;Formato incorrecto de solicitud";
                    }

                case "INICIAR_SESION_ADMINISTRADOR":
                    if (partes.length != 3) {
                        return "ERROR;Solicitud malformada (se requieren email y contraseña)";
                    }
                    return iniciarSesionAdministrador(partes[1], partes[2]);

                case "LISTAR_PREGUNTAS":
                    return listarPreguntas();

                case "AGREGAR_PREGUNTA":
                    if (partes.length != 5) {
                        return "ERROR;Solicitud malformada (parámetros insuficientes)";
                    }
                    return agregarPregunta(partes[1], partes[2], partes[3], partes[4], partes[5]);

                case "EDITAR_PREGUNTA":
                    if (partes.length != 6) {
                        return "ERROR;Solicitud malformada (parámetros insuficientes)";
                    }
                    return editarPregunta(
                            Integer.parseInt(partes[1]),
                            partes[2],
                            partes[3],
                            partes[4],
                            partes[5]
                    );

                case "ELIMINAR_PREGUNTA":
                    if (partes.length != 2) {
                        return "ERROR;Solicitud malformada (ID de la pregunta faltante)";
                    }
                    return eliminarPregunta(Integer.parseInt(partes[1]));

                default:
                    System.out.println("[SERVIDOR] Comando no reconocido: " + comando);
                    return "ERROR;Comando no reconocido";
            }
        } catch (Exception e) {
            System.err.println("[SERVIDOR] Error procesando solicitud: " + e.getMessage());
            return "ERROR;Excepción en el servidor: " + e.getMessage();
        }
    }

    /**
     * Registra una partida en la base de datos.
     *
     * @param puntuacion La puntuación obtenida en la partida.
     * @return Un mensaje indicando el resultado de la operación.
     */
    private static String registrarPartida(int puntuacion) {
        // Define la consulta SQL para insertar una nueva partida con su puntuación
        String sql = "INSERT INTO partidas (puntuacion) VALUES (?)";
        // Inicia un bloque try-with-resources para asegurar que los recursos se cierren automáticamente
        try (Connection connection = DatabaseConnection.getConnection();
             // Prepara la declaración SQL con la conexión obtenida
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            // Establece el valor de la puntuación en la declaración preparada
            preparedStatement.setInt(1, puntuacion);
            // Ejecuta la actualización en la base de datos y obtiene el número de filas afectadas
            int filasAfectadas = preparedStatement.executeUpdate();
            // Verifica si alguna fila fue afectada por la operación
            if (filasAfectadas > 0) {
                return "OK;Partida registrada correctamente.";
            } else {
                return "ERROR;No se pudo registrar la partida.";
            }
        } catch (SQLException e) {
            System.err.println("[SERVIDOR] Error al registrar partida: " + e.getMessage());
            return "ERROR;Error de base de datos: " + e.getMessage();
        }
    }

    /**
     * Inicia el juego de trivial, enviando preguntas al cliente y procesando sus respuestas.
     *
     * @param in El BufferedReader para leer las respuestas del cliente.
     * @param out El PrintWriter para enviar preguntas y resultados al cliente.
     * @return Un mensaje indicando el resultado final del trivial.
     */
    private static String iniciarTrivial(BufferedReader in, PrintWriter out) {
        try {
            int puntuacion = 0; // Lleva el conteo de respuestas correctas del jugador
            StringBuilder resumenRespuestas = new StringBuilder(); // Acumula las respuestas correctas
            // Itera para enviar 5 preguntas al cliente
            for (int i = 0; i < 5; i++) {
                // Obtiene una pregunta trivial
                String preguntaRespuesta = obtenerPreguntaTrivial();
                // Verifica si hubo un error al obtener la pregunta
                if (preguntaRespuesta.startsWith("ERROR")) {
                    return preguntaRespuesta; // Error si no hay preguntas disponibles
                }

                out.println(preguntaRespuesta); // Enviar pregunta al cliente
                String respuestaCliente = in.readLine(); // Leer respuesta del cliente

                // Verifica si la respuesta del cliente es válida
                if (respuestaCliente.startsWith("RESPUESTA")) {
                    // Divide la respuesta del cliente en partes
                    String[] partes = respuestaCliente.split(";");
                    // Obtiene el ID de la pregunta
                    int idPregunta = Integer.parseInt(partes[1]);
                    String respuesta = partes[2]; // Respuesta enviada por el cliente
                    // Verifica la respuesta del cliente
                    String resultado = verificarRespuesta(idPregunta, respuesta);
                    out.println(resultado); // Enviar resultado inmediato al cliente

                    if (resultado.startsWith("CORRECTO")) {
                        puntuacion++; // Incrementa puntuación si la respuesta es correcta
                    } else if (resultado.startsWith("INCORRECTO")) {
                        String correcta = resultado.split(": ")[1]; // Extrae respuesta correcta
                        resumenRespuestas.append("Pregunta ").append(i + 1).append(": correcta - ").append(correcta).append("\n");
                    }
                }
            }

            // Enviar el resumen y la puntuación final al jugador
            resumenRespuestas.insert(0, "Respuestas correctas:\n");
            resumenRespuestas.append("Puntuación final: ").append(puntuacion).append("/5\n");
            out.println(resumenRespuestas.toString());

            return "FIN;Trivial terminado.";
        } catch (IOException e) {
            System.err.println("Error durante el trivial: " + e.getMessage());
            return "ERROR;Error durante el trivial.";
        }
    }

    /**
     * Obtiene las puntuaciones de las partidas desde la base de datos.
     *
     * @return Una cadena de texto con las puntuaciones ordenadas por fecha en orden descendente.
     */
    private static String verPuntuaciones() {
        // Define la consulta SQL para seleccionar el id, puntuacion y fecha de las partidas, ordenadas por fecha en orden descendente
        String sql = "SELECT id, puntuacion, fecha FROM partidas ORDER BY fecha DESC";
        // Inicializa un StringBuilder para acumular las respuestas
        StringBuilder respuesta = new StringBuilder();
        // Inicia un bloque try-with-resources para asegurar que los recursos se cierren automáticamente
        try (Connection connection = DatabaseConnection.getConnection();
             // Prepara la declaración SQL con la conexión obtenida
             PreparedStatement statement = connection.prepareStatement(sql);
             // Ejecuta la consulta y obtiene el resultado en un ResultSet
             ResultSet resultSet = statement.executeQuery()) {
            // Itera sobre el ResultSet para procesar cada fila obtenida
            while (resultSet.next()) {
                // Obtiene el id de la partida
                int id = resultSet.getInt("id");
                // Obtiene la puntuacion de la partida
                int puntuacion = resultSet.getInt("puntuacion");
                // Obtiene la fecha de la partida
                Timestamp fecha = resultSet.getTimestamp("fecha");
                // Acumula la información de la partida en el StringBuilder
                respuesta.append("ID: ").append(id).append(", Puntuación: ").append(puntuacion).append(", Fecha: ").append(fecha).append("\n");
            }
            return respuesta.toString(); // Retorna la cadena de texto acumulada con las puntuaciones
        } catch (SQLException e) {
            System.err.println("[SERVIDOR] Error al obtener puntuaciones: " + e.getMessage());
            return "ERROR;Error al obtener las puntuaciones.";
        }
    }


    /**
     * Verifica si la respuesta proporcionada por el cliente es correcta.
     *
     * @param idPregunta El ID de la pregunta que se está verificando.
     * @param respuesta La respuesta proporcionada por el cliente.
     * @return Un mensaje indicando si la respuesta es correcta o incorrecta, o si hubo un error.
     */
    private static String verificarRespuesta(int idPregunta, String respuesta) {
        // Define la consulta SQL para obtener la respuesta correcta de la pregunta con el ID especificado
        String sql = "SELECT correcta FROM Preguntas WHERE id = ?";
        // Inicia un bloque try-with-resources para asegurar que los recursos se cierren automáticamente
        try (Connection connection = DatabaseConnection.getConnection();
             // Prepara la declaración SQL con la conexión obtenida
             PreparedStatement statement = connection.prepareStatement(sql)) {
            // Establece el valor del ID de la pregunta en la declaración preparada
            statement.setInt(1, idPregunta);
            // Ejecuta la consulta y obtiene el resultado en un ResultSet
            try (ResultSet resultSet = statement.executeQuery()) {
                // Verifica si hay un resultado en el ResultSet
                if (resultSet.next()) {
                    // Obtiene la respuesta correcta de la pregunta
                    String correcta = resultSet.getString("correcta");
                    // Compara la respuesta proporcionada por el cliente con la respuesta correcta
                    if (correcta.equalsIgnoreCase(respuesta)) {
                        return "CORRECTO;Respuesta correcta.";
                    } else {
                        return "INCORRECTO;La respuesta correcta era: " + correcta;
                    }
                } else {
                    return "ERROR;Pregunta no encontrada.";
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al verificar respuesta: " + e.getMessage());
            return "ERROR;Error al verificar la respuesta.";
        }
    }



    /**
     * Registra un nuevo jugador en la base de datos.
     *
     * @param partes Un array de cadenas que contiene los datos del jugador (nombre, email, contraseña).
     * @return Un mensaje indicando el resultado de la operación.
     */
    private static String registrarJugador(String[] partes) {
        // Verifica si el comando tiene suficientes partes
        if (partes.length < 4) {
            return "ERROR;Comando incompleto. Uso: REGISTRAR_JUGADOR;nombre;email;contraseña";
        }

        // Extrae y limpia los datos del jugador
        String nombre = partes[1].trim();
        String email = partes[2].trim();
        String contrasena = partes[3].trim();

        // Validaciones básicas
        if (nombre.isEmpty() || email.isEmpty() || contrasena.isEmpty()) {
            return "ERROR;Datos incompletos. Todos los campos son obligatorios.";
        }
        if (!email.matches("^[\\w.-]+@[a-zA-Z\\d.-]+\\.[a-zA-Z]{2,6}$")) {
            return "ERROR;Correo electrónico no válido.";
        }
        if (contrasena.length() < 6) {
            return "ERROR;La contraseña debe tener al menos 6 caracteres.";
        }

        // Insertar en la base de datos al nuevo jugador
        String sql = "INSERT INTO jugadores (nombre, email, contrasena) VALUES (?, ?, ?)";
        // Inicia un bloque try-with-resources para asegurar que los recursos se cierren automáticamente
        try (Connection connection = DatabaseConnection.getConnection();
             // Prepara la declaración SQL con la conexión obtenida
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            // Establece los valores en la declaración preparada
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, contrasena);

            // Ejecuta la actualización en la base de datos y obtiene el número de filas afectadas
            int filasAfectadas = preparedStatement.executeUpdate();
            // Verifica si alguna fila fue afectada por la operación
            if (filasAfectadas > 0) {
                return "OK;Jugador registrado correctamente.";
            } else {
                return "ERROR;No se pudo registrar el jugador.";
            }
        } catch (SQLException e) {
            System.err.println("[SERVIDOR] Error al registrar jugador: " + e.getMessage());
            return "ERROR;Error de base de datos: " + e.getMessage();
        }
    }

    /**
     * Registra un nuevo administrador en la base de datos.
     *
     * @param solicitud La solicitud recibida que contiene los datos del administrador.
     * @return Un mensaje indicando el resultado de la operación.
     * @throws SQLException Si ocurre un error al interactuar con la base de datos.
     */
    private static String registrarAdministrador(String solicitud) throws SQLException {
        // Divide la solicitud en partes utilizando el carácter ';' como separador
        String[] partes = solicitud.split(";");
        // Verifica si el comando tiene suficientes partes
        if (partes.length < 4) {
            return "ERROR;Comando inválido o incompleto";
        }
        // Extrae los datos del administrador
        String nombre = partes[1];
        String email = partes[2];
        String contrasena = partes[3];

        // Validaciones básicas
        if (nombre.isEmpty() || email.isEmpty() || contrasena.isEmpty()) {
            return "ERROR;Datos inválidos o incompletos";
        }

        if (!email.matches("^[\\w.-]+@[a-zA-Z\\d.-]+\\.[a-zA-Z]{2,6}$")) {
            return "ERROR;Correo electrónico no válido";
        }

        // Define la consulta SQL para insertar un nuevo administrador
        String sql = "INSERT INTO administradores (nombre, email, contrasena) VALUES (?, ?, ?)";
        // Inicia un bloque try-with-resources para asegurar que los recursos se cierren automáticamente
        try (Connection connection = DatabaseConnection.getConnection();
             // Prepara la declaración SQL con la conexión obtenida
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            // Establece los valores en la declaración preparada
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, contrasena);
            preparedStatement.executeUpdate();
        }
        // Retorna un mensaje indicando que el administrador ha sido registrado correctamente
        return "OK;Administrador registrado correctamente";
    }

    /**
     * Inicia sesión para un jugador utilizando su email y contraseña.
     *
     * @param email El email del jugador.
     * @param contrasena La contraseña del jugador.
     * @return Un mensaje indicando el resultado de la operación.
     */
    private static String iniciarSesionJugador(String email, String contrasena) {
        // Inicia un bloque try-with-resources para asegurar que la conexión se cierre automáticamente
        try (Connection connection = DatabaseConnection.getConnection()) {
            // Define la consulta SQL para verificar el email y la contraseña del jugador
            String query = "SELECT * FROM jugadores WHERE email = ? AND contrasena = ?";
            // Prepara la declaración SQL con la conexión obtenida
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                // Establece los valores del email y la contraseña en la declaración preparada
                stmt.setString(1, email);
                stmt.setString(2, contrasena);

                // Ejecuta la consulta y obtiene el resultado en un ResultSet
                ResultSet rs = stmt.executeQuery();
                // Verifica si hay un resultado en el ResultSet
                if (rs.next()) {
                    return "OK;Inicio de sesión exitoso";
                } else {
                    return "ERROR;Email o contraseña incorrectos";
                }

            } catch (SQLException e) {
                return "ERROR;Error al ejecutar la consulta: " + e.getMessage();
            }
        } catch (SQLException e) {
            return "ERROR;No se pudo conectar a la base de datos: " + e.getMessage();
        }
    }

    /**
     * Obtiene una pregunta trivial aleatoria de la base de datos.
     *
     * @return Una cadena de texto con la pregunta y sus opciones, o un mensaje de error si no hay preguntas disponibles.
     */
    private static String obtenerPreguntaTrivial() {
        // Define la consulta SQL para seleccionar una pregunta aleatoria de la tabla Preguntas
        String sql = "SELECT id, pregunta, opcion_a, opcion_b, opcion_c, correcta FROM Preguntas ORDER BY RAND() LIMIT 1";

        // Inicia un bloque try-with-resources para asegurar que los recursos se cierren automáticamente
        try (Connection connection = DatabaseConnection.getConnection();
             // Prepara la declaración SQL con la conexión obtenida
             PreparedStatement statement = connection.prepareStatement(sql);
             // Ejecuta la consulta y obtiene el resultado en un ResultSet
             ResultSet resultSet = statement.executeQuery()) {

            // Verifica si hay un resultado en el ResultSet
            if (resultSet.next()) {
                // Obtiene el ID de la pregunta
                int id = resultSet.getInt("id");
                // Obtiene el texto de la pregunta
                String pregunta = resultSet.getString("pregunta");
                String opcionA = resultSet.getString("opcion_a");
                String opcionB = resultSet.getString("opcion_b");
                String opcionC = resultSet.getString("opcion_c");

                // Retorna la pregunta y sus opciones en un formato específico
                return String.format("OK;%d;%s;%s;%s;%s", id, pregunta, opcionA, opcionB, opcionC);
            } else {
                return "ERROR;No hay preguntas disponibles.";
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener pregunta de la base de datos: " + e.getMessage());
            return "ERROR;Error al obtener la pregunta.";
        }
    }

    /**
     * Inicia sesión para un administrador utilizando su email y contraseña.
     *
     * @param email El email del administrador.
     * @param contrasena La contraseña del administrador.
     * @return Un mensaje indicando el resultado de la operación.
     */
    private static String iniciarSesionAdministrador(String email, String contrasena) {
        // Inicia un bloque try-with-resources para asegurar que la conexión se cierre automáticamente
        try (Connection connection = DatabaseConnection.getConnection()) {
            // Define la consulta SQL para verificar el email y la contraseña del administrador
            String query = "SELECT id, nombre FROM administradores WHERE email = ? AND contrasena = ?";

            // Prepara la declaración SQL con la conexión obtenida
            try (PreparedStatement stmt = connection.prepareStatement(query)) {

                // Establece los valores del email y la contraseña en la declaración preparada
                stmt.setString(1, email);
                stmt.setString(2, contrasena);

                // Ejecuta la consulta y obtiene el resultado en un ResultSet
                ResultSet rs = stmt.executeQuery();
                // Verifica si hay un resultado en el ResultSet
                if (rs.next()) {
                    return "OK;Inicio exitoso;AdminID:" + rs.getInt("id") + ";Nombre:" + rs.getString("nombre");
                }
                return "ERROR;Email o contraseña incorrectos";
            }
        } catch (SQLException e) {
            return "ERROR;Error al autenticar administrador: " + e.getMessage();
        }
    }

    /**
     * Lista todas las preguntas disponibles en la base de datos.
     *
     * @return Una cadena de texto con todas las preguntas y sus opciones, o un mensaje de error si no hay preguntas disponibles.
     */
    private static String listarPreguntas() {
        // Imprime un mensaje indicando que se ha iniciado el proceso de listar preguntas
        System.out.println("[SERVIDOR] Iniciando listarPreguntas...");

        // Inicia un bloque try-with-resources para asegurar que la conexión se cierre automáticamente
        try (Connection connection = DatabaseConnection.getConnection()) {
            // Imprime un mensaje indicando que la conexión a la base de datos ha sido establecida
            System.out.println("[SERVIDOR] Conexión a la base de datos establecida.");

            // Construimos la respuesta en bloques utilizando StringBuilder
            StringBuilder respuesta = new StringBuilder();
            // Define la consulta SQL para seleccionar todas las preguntas y sus opciones
            String query = "SELECT pregunta, opcion_a, opcion_b, opcion_C, correcta FROM preguntas";

            // Prepara la declaración SQL con la conexión obtenida
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                // Imprime un mensaje indicando que la consulta SQL está siendo ejecutada
                System.out.println("[SERVIDOR] Ejecutando consulta SQL...");
                // Ejecuta la consulta y obtiene el resultado en un ResultSet
                ResultSet rs = stmt.executeQuery();

                // Verifica si el ResultSet
                if (!rs.isBeforeFirst()) { // Si no hay resultados
                    System.out.println("[SERVIDOR] No se encontraron preguntas en la base de datos.");
                    return "No hay preguntas disponibles.\n";
                }

                // Recorremos todas las preguntas y generamos la impresión por bloques
                while (rs.next()) {
                    respuesta.append("Pregunta: ").append(rs.getString("pregunta")).append("\n");
                    respuesta.append("Opciones:\n");
                    respuesta.append("  A) ").append(rs.getString("opcion_a")).append("\n");
                    respuesta.append("  B) ").append(rs.getString("opcion_b")).append("\n");
                    respuesta.append("Respuesta Correcta: ").append(rs.getString("correcta")).append("\n");
                    respuesta.append("---------------------------------------\n");
                }

                System.out.println("[SERVIDOR] Respuesta generada correctamente.");
                return respuesta.toString();

            } catch (SQLException e) {
                System.err.println("[SERVIDOR] Error al ejecutar la consulta SQL: " + e.getMessage());
                return "ERROR: Error al listar preguntas: " + e.getMessage();
            }

        } catch (SQLException e) {
            System.err.println("[SERVIDOR] No se pudo conectar a la base de datos: " + e.getMessage());
            return "ERROR: No se pudo conectar a la base de datos: " + e.getMessage();
        }
    }




    /**
     * Agrega una nueva pregunta a la base de datos.
     *
     * @param pregunta El texto de la pregunta.
     * @param opcionA La opción A de la pregunta.
     * @param opcionB La opción B de la pregunta.
     * @param opcionC La opción C de la pregunta.
     * @param correcta La respuesta correcta de la pregunta.
     * @return Un mensaje indicando el resultado de la operación.
     */
    private static String agregarPregunta(String pregunta, String opcionA, String opcionB, String opcionC, String correcta) {
        // Inicia un bloque try-with-resources para asegurar que la conexión se cierre automáticamente
        try (Connection connection = DatabaseConnection.getConnection()) {
            // Define la consulta SQL para insertar una nueva pregunta
            String query = "INSERT INTO preguntas (pregunta, opcion_a, opcion_b, opcion_c, correcta) VALUES (?, ?, ?, ?, ?)";

            // Prepara la declaración SQL con la conexión obtenida
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                // Establece los valores de la pregunta y sus opciones en la declaración preparada
                stmt.setString(1, pregunta);
                stmt.setString(2, opcionA);
                stmt.setString(3, opcionB);
                stmt.setString(4, opcionC);
                stmt.setString(5, correcta);

                // Ejecuta la actualización en la base de datos y obtiene el número de filas afectadas
                int filasAfectadas = stmt.executeUpdate();
                return filasAfectadas > 0 ? "OK;Pregunta añadida correctamente" : "ERROR;No se pudo agregar la pregunta";
            }
        } catch (SQLException e) {
            return "ERROR;Error al agregar la pregunta: " + e.getMessage();
        }
    }

    /**
     * Edita una pregunta existente en la base de datos.
     *
     * @param id El ID de la pregunta a editar.
     * @param pregunta El nuevo texto de la pregunta.
     * @param opcionA La nueva opción A de la pregunta.
     * @param opcionB La nueva opción B de la pregunta.
     * @param correcta La nueva respuesta correcta de la pregunta.
     * @return Un mensaje indicando el resultado de la operación.
     */
    private static String editarPregunta(int id, String pregunta, String opcionA, String opcionB, String correcta) {
        // Inicia un bloque try-with-resources para asegurar que la conexión se cierre automáticamente
        try (Connection connection = DatabaseConnection.getConnection()) {
            // Define la consulta SQL para actualizar una pregunta existente
            String query = "UPDATE preguntas SET pregunta = ?, opcion_a = ?, opcion_b = ?, correcta = ? WHERE id = ?";

            // Prepara la declaración SQL con la conexión obtenida
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                // Establece los nuevos valores de la pregunta y sus opciones en la declaración preparada
                stmt.setString(1, pregunta);
                stmt.setString(2, opcionA);
                stmt.setString(3, opcionB);
                stmt.setString(4, correcta);
                stmt.setInt(5, id);

                // Ejecuta la actualización en la base de datos y obtiene el número de filas afectadas
                int filasAfectadas = stmt.executeUpdate();
                return filasAfectadas > 0 ? "OK;Pregunta actualizada correctamente" : "ERROR;Pregunta no encontrada";
            }
        } catch (SQLException e) {
            return "ERROR;Error al editar la pregunta: " + e.getMessage();
        }
    }

    /**
     * Elimina una pregunta de la base de datos.
     *
     * @param id El ID de la pregunta a eliminar.
     * @return Un mensaje indicando el resultado de la operación.
     */
    private static String eliminarPregunta(int id) {
        // Inicia un bloque try-with-resources para asegurar que la conexión se cierre automáticamente
        try (Connection connection = DatabaseConnection.getConnection()) {
            // Define la consulta SQL para eliminar una pregunta por su ID
            String query = "DELETE FROM preguntas WHERE id = ?";

            // Prepara la declaración SQL con la conexión obtenida
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                // Establece el valor del ID de la pregunta en la declaración preparada
                stmt.setInt(1, id);

                // Ejecuta la actualización en la base de datos y obtiene el número de filas afectadas
                int filasAfectadas = stmt.executeUpdate();
                return filasAfectadas > 0 ? "OK;Pregunta eliminada correctamente" : "ERROR;Pregunta no encontrada";
            }
        } catch (SQLException e) {
            return "ERROR;Error al eliminar la pregunta: " + e.getMessage();
        }
    }
}
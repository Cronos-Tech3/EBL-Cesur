package TRIVIAL_C_S_MODELO;

import java.io.*;
import java.net.*;

public class ServidorTrivial {
    private static final int PORT = 12345; // Puerto para escuchar conexiones
    private static final String[] PREGUNTAS = {
            "¿Cuánto es 2 + 2?",
            "¿Cuál es el capital de España?",
            "¿En qué año llegó el hombre a la Luna?",
            "¿Cuál es el idioma más hablado del mundo?",
            "¿Cuál es el océano más grande de la Tierra?"
    };
    private static final String[] RESPUESTAS_CORRECTAS = {
            "4", "Madrid", "1969", "Chino", "Pacífico"
    };

    public static void main(String[] args) {
        System.out.println("Servidor iniciado... Esperando conexiones.");

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                try (Socket socket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

                    System.out.println("Cliente conectado desde " + socket.getInetAddress());

                    // Enviar mensaje de bienvenida
                    out.println("Bienvenido al Trivial.");
                    String nombre = in.readLine(); // Leer el nombre del cliente
                    if (nombre == null || nombre.isBlank()) {
                        out.println("Error: Nombre inválido. Desconectando...");
                        continue;
                    }

                    System.out.println("El cliente se ha identificado como: " + nombre);
                    out.println("Hola, " + nombre + "! Responde las siguientes preguntas:");

                    // Enviar preguntas seriadas al cliente con evaluación de respuestas
                    for (int i = 0; i < PREGUNTAS.length; i++) {
                        out.println("Pregunta " + (i + 1) + ": " + PREGUNTAS[i]); // Enviar pregunta
                        String respuesta = in.readLine(); // Recibir respuesta del cliente

                        // Validar respuesta recibida
                        if (respuesta == null || respuesta.isBlank()) {
                            out.println("Respuesta no válida. Por favor, intenta responder a la pregunta.");
                            i--; // Repetir la misma pregunta
                            continue;
                        }

                        // Evaluar y enviar el resultado
                        if (respuesta.equalsIgnoreCase(RESPUESTAS_CORRECTAS[i])) {
                            out.println("¡Correcto!");
                        } else {
                            out.println("Incorrecto. La respuesta correcta era: " + RESPUESTAS_CORRECTAS[i]);
                        }
                    }

                    // Mensaje de despedida
                    out.println("Gracias por jugar, " + nombre + "! Hasta la próxima.");
                } catch (IOException e) {
                    System.err.println("Error al manejar cliente: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Error al iniciar el servidor: " + e.getMessage());
        }
    }
}
package TRIVIAL_C_S_MODELO;

import java.io.*;
import java.net.Socket;

public class ClienteTrivial {
    private static final String SERVER_ADDRESS = "localhost"; // Dirección del servidor
    private static final int PORT = 12345; // Puerto del servidor

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, PORT);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            // Recibir mensaje de bienvenida del servidor
            String mensajeBienvenida = in.readLine(); // Recibir mensaje inicial
            if (mensajeBienvenida != null) {
                System.out.println(mensajeBienvenida); // Mostrar mensaje en pantalla
            } else {
                System.err.println("Error: No se recibió mensaje de bienvenida del servidor.");
                return;
            }

            // Leer y enviar el nombre del usuario
            System.out.print("Introduce tu nombre: ");
            String nombre = stdIn.readLine(); // Leer nombre del usuario localmente
            out.println(nombre); // Enviar nombre al servidor

            // Recibir preguntas y responderlas
            for (int i = 0; i < 5; i++) { // Cliente espera cinco preguntas
                String pregunta = in.readLine(); // Recibir pregunta del servidor
                if (pregunta == null) {
                    System.err.println("Error: No se recibió la pregunta del servidor.");
                    break;
                }

                // Mostrar al usuario la pregunta ANTES de pedir respuesta
                System.out.println(pregunta);

                // Leer respuesta del usuario
                System.out.print("Tu respuesta: ");
                String respuesta = stdIn.readLine();
                if (respuesta == null || respuesta.isBlank()) {
                    System.out.println("Respuesta vacía. Respondiendo 'sin respuesta'.");
                    out.println("sin respuesta");
                } else {
                    out.println(respuesta); // Enviar respuesta al servidor
                }

                // Recibir y mostrar el resultado de la respuesta
                String resultado = in.readLine();
                if (resultado == null) {
                    System.err.println("Error: No se recibió el resultado de la respuesta.");
                    break;
                }
                System.out.println(resultado);
            }

            // Mensaje de despedida
            String despedida = in.readLine(); // Recibir mensaje de despedida
            if (despedida != null) {
                System.out.println(despedida); // Mostrar mensaje final
            } else {
                System.err.println("Error: No se recibió el mensaje de despedida del servidor.");
            }

        } catch (IOException e) {
            System.err.println("Error: No se pudo conectar al servidor en " + SERVER_ADDRESS + ":" + PORT);
            e.printStackTrace();
        }
    }
}
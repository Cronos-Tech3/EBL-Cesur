package Ficheros;

import Juego.Partida;
import Users.User;
import Preguntas.Pregunta;
import Preguntas.Opcion;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Juan Jose Tornero Dato
 * @author Enrique Benito Lopez
 *
 * Descripcion Clase
 * La clase GestionaFicheros proporciona metodos para gestionar la lectura y escritura de usuarios,
 * preguntas y partidas en ficheros.
 *
 * Metodos
 * cargaUsers(): Describe el metodo que carga los usuarios desde el fichero binario.
 * cargaPreguntas(): Describe el metodo que carga las preguntas desde el fichero de texto.
 * guardaUsers(ArrayList<User> users): Describe el metodo que guarda los usuarios en el fichero binario.
 * leePartidas(): Describe el metodo que lee las partidas desde el fichero de texto.
 * guardaPartida(Partida partida): Describe el metodo que guarda una partida en el fichero de texto (implementación pendiente).
 */

public class GestionaFicheros {
    //ATRIBUTOS

    /**
     * Ruta del fichero que contiene los usuarios.
     */
    private static final String fileUsers = "src\\files/user.dat";

    /**
     * Ruta del fichero que contiene las preguntas.
     */
    private static final String filePreguntas = "src\\files/preguntas.txt";

    /**
     * Ruta del fichero que contiene las partidas.
     */
    private static final String filePartidas = "src\\files/partidas.txt";


    /**
     * Carga los usuarios desde el fichero binario.
     *
     * @return una lista de usuarios
     */
    public static ArrayList<User> cargaUsers() {
        File file = new File(fileUsers);
        if (!file.exists()) {
            try {
                file.getParentFile().mkdirs(); // Crea los directorios necesarios
                file.createNewFile(); // Crea el archivo
            } catch (IOException e) {
                e.printStackTrace();
            }
            return new ArrayList<>(); // Devuelve una lista vacía si el archivo no existe
        }


        ArrayList<User> users = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileUsers))) {
            users = (ArrayList<User>) ois.readObject();
        } catch (EOFException e) {
            // Fin del archivo alcanzado, no hacer nada
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return users;
    }

    /**
     * Carga las preguntas desde el fichero de texto.
     *
     * @return una lista de preguntas
     */
    public static ArrayList<Pregunta> cargaPreguntas() {
        ArrayList<Pregunta> preguntas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePreguntas))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String enunciado = linea;
                List<Opcion> opciones = new ArrayList<>();
                for (int i = 0; i < 4; i++) {
                    linea = br.readLine();
                    opciones.add(new Opcion(linea, i == 0));
                }
                preguntas.add(new Pregunta(enunciado, opciones));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return preguntas;
    }

    /**
     * Guarda los usuarios en el fichero binario.
     *
     * @param users la lista de usuarios a guardar
     */
    public static void guardaUsers(ArrayList<User> users) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileUsers))) {
            oos.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Lee las partidas desde el fichero de texto.
     *
     * @return una lista de cadenas que representan las partidas
     */
    public static ArrayList<String> leePartidas() {
        ArrayList<String> partidas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePartidas))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                partidas.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return partidas;
    }

    /**
     * Guarda una partida en el fichero de texto.
     *
     * @param partida la partida a guardar
     */
    public static void guardaPartida(Partida partida) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePartidas, true))) {
            bw.write(partida.toString());
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

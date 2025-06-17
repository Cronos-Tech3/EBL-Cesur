package Juego;

import Users.*;
import java.util.ArrayList;
import java.util.Scanner;
import static Ficheros.GestionaFicheros.*;

/**
 * @author Juan Jose tornero Dato
 * @author Enrique Benito Lopez
 *
 * Descripcion de Clase
 * La clase trivialMain es la clase donde se desarrolla el metodo principal y da comienzo al juego de trivial.
 * En ella se relacionan todas las clases y funciones para ejecutar el bloque de codigo del proyecto.
 *
 * Metodo
 * registrarUsuario(Scanner scanner, boolean esAdmin): Describe el metodo que registra un nuevo usuario en el sistema.
 * iniciarSesion(Scanner scanner): Describe el metodo que inicia sesión de un usuario en el sistema.
 */

public class TrivialMain {

    /**
     * Lista estática de usuarios registrados.
     */
    static ArrayList<User> users = new ArrayList<>();

    /**
     * Metodo principal que inicia la aplicación de trivial.
     *
     * @param args argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        users = cargaUsers();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("1. Registro player");
            System.out.println("2. Registro admin");
            System.out.println("3. Inicio de sesión");
            System.out.println("4. Salir");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    registrarUsuario(scanner, false);
                    break;
                case 2:
                    registrarUsuario(scanner, true);
                    break;
                case 3:
                    iniciarSesion(scanner);
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 4);

        guardaUsers(users);
    }

    /**
     * Registra un nuevo usuario en el sistema.
     *
     * @param scanner objeto Scanner para la entrada de datos
     * @param esAdmin indica si el usuario a registrar es un administrador
     */
    private static void registrarUsuario(Scanner scanner, boolean esAdmin) {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Contraseña: ");
        String contraseña = scanner.nextLine();
        System.out.print("Repetir contraseña: ");
        String repetirContraseña = scanner.nextLine();

        if (!contraseña.equals(repetirContraseña) || contraseña.length() < 8) {
            System.out.println("Las contraseñas no coinciden o son demasiado cortas.");
            return;
        }

        for (User user : users) {
            if (user.getNombre().equals(nombre)) {
                System.out.println("El usuario ya existe.");
                return;
            }
        }

        if (esAdmin) {
            users.add(new Admin(nombre, contraseña));
        } else {
            users.add(new Player(nombre, contraseña));
        }

        System.out.println("Usuario registrado con éxito.");
    }


    /**
     * Inicia sesión de un usuario en el sistema.
     *
     * @param scanner objeto Scanner para la entrada de datos
     */
    private static void iniciarSesion(Scanner scanner) {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Contraseña: ");
        String contraseña = scanner.nextLine();

        for (User user : users) {
            if (user.getNombre().equals(nombre) && user.compruebaPass(contraseña)) {
                if (user.permisosAdmin()) {
                    TrivialAdmin admin = new TrivialAdmin((Admin) user);
                    admin.administrar();
                } else {
                    TrivialJuego juego = new TrivialJuego((Player) user);
                    juego.jugar();
                }
                return;
            }
        }

        System.out.println("Nombre o contraseña incorrectos.");
    }
}

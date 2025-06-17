package TRIVIAL.TRIVIAL;

import TRIVIAL.TRIVIAL.models.Administrador;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que gestiona el registro y autenticación de administradores.
 * Permite agregar nuevos administradores manualmente y autenticarlos
 * en base a sus credenciales.
 */
public class Registro {

    // Lista para almacenar los administradores registrados
    private final List<Administrador> administradores;

    /**
     * Constructor de la clase Registro.
     * Inicializa la lista de administradores con algunos valores predeterminados.
     */
    public Registro() {
        administradores = new ArrayList<>();
        // Agregar algunos administradores predeterminados para las pruebas
        agregarAdministradorPredeterminado("admin1", "1234");
        agregarAdministradorPredeterminado("admin2", "abcd");
    }

    /**
     * Método que permite agregar un administrador predeterminado al sistema.
     * Este método es utilizado en el constructor únicamente.
     *
     * @param usuario    El nombre de usuario del administrador.
     * @param contrasena La contraseña del administrador.
     */
    private void agregarAdministradorPredeterminado(String usuario, String contrasena) {
        administradores.add(new Administrador(usuario, contrasena));
    }

    /**
     * Autentica un administrador buscando coincidencias en la lista de administradores registrados.
     *
     * @param usuario    El nombre de usuario del administrador.
     * @param contrasena La contraseña del administrador.
     * @return Si las credenciales son válidas, retorna el administrador correspondiente.
     *         Si no, retorna `null` indicando que las credenciales son incorrectas.
     */
    public Administrador autenticarAdministrador(String usuario, String contrasena) {
        for (Administrador admin : administradores) {
            if (admin.getUsuario().equals(usuario) && admin.getContrasena().equals(contrasena)) {
                return admin; // Administrador autenticado con éxito
            }
        }
        return null; // Credenciales incorrectas
    }

    /**
     * Método para probar el listado de administradores registrados.
     * No es necesario utilizarlo en producción, pero puede ayudar en pruebas.
     */
    public void listarAdministradores() {
        System.out.println("Administradores registrados:");
        for (Administrador admin : administradores) {
            System.out.println("Usuario: " + admin.getUsuario());
        }
    }
}
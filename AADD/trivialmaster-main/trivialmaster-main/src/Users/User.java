package Users;

import java.io.Serializable;

/**
 * La clase User es una clase abstracta que representa a un usuario en el sistema.
 * Proporciona métodos para cambiar y comprobar la contraseña, así como un método
 * abstracto para verificar los permisos de administrador.
 */
public abstract class User implements Serializable {
    private String nombre;
    private String contraseña;

    /**
     * Constructor de la clase User.
     *
     * @param nombre      El nombre del usuario.
     * @param contraseña  La contraseña del usuario.
     */
    public User(String nombre, String contraseña) {
        this.nombre = nombre;
        this.contraseña = contraseña;
    }

    /**
     * Cambia la contraseña del usuario si la nueva contraseña tiene al menos 8 caracteres.
     *
     * @param pass La nueva contraseña.
     * @return true si la contraseña se ha cambiado, false en caso contrario.
     */
    public boolean cambiarPass(String pass) {
        if (pass.length() >= 8) {
            this.contraseña = pass;
            return true;
        }
        return false;
    }

    /**
     * Comprueba si la contraseña proporcionada coincide con la contraseña del usuario.
     *
     * @param pass La contraseña a comprobar.
     * @return true si las contraseñas coinciden, false en caso contrario.
     */
    public boolean compruebaPass(String pass) {
        return this.contraseña.equals(pass);
    }

    /**
     * Método abstracto para verificar si el usuario tiene permisos de administrador.
     *
     * @return true si el usuario tiene permisos de administrador, false en caso contrario.
     */
    public abstract boolean permisosAdmin();

    /**
     * Obtiene el nombre del usuario.
     *
     * @return El nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }
}
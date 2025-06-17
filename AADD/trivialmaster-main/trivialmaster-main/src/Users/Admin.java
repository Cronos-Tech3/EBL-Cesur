package Users;

/**
 * @AUTHOR Juan Jose Tornero
 * @DESCRIPTION
 *
 *      La clase Admin representa a un administrador en el sistema.
 *      Hereda de la clase abstracta User y proporciona una implementación específica del
 *      mtodo permisosAdmin.
 *  */


public class Admin extends User {

    /**
     * Constructor de la clase Admin.
     *
     * @param nombre      El nombre del administrador.
     * @param contraseña  La contraseña del administrador.
     */
    public Admin(String nombre, String contraseña) {
        super(nombre, contraseña);
    }

    /**
     * Indica que el administrador tiene permisos de administrador.
     *
     * @return true, ya que un administrador tiene permisos de administrador.
     */
    @Override
    public boolean permisosAdmin() {
        return true;
    }
}

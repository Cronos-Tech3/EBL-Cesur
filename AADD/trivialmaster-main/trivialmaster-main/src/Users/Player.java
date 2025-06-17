package Users;

/**
 * @AUTHOR Juan Jose Tornero
 * @DESCRIPTION
 *      La clase Player representa a un jugador en el sistema.
 *      Hereda de la clase abstracta User y proporciona una implementación
 *      específica del metodo permisosAdmin.
 */
public class Player extends User {

    /**
     * Constructor de la clase Player.
     *
     * @param nombre      El nombre del jugador.
     * @param contraseña  La contraseña del jugador.
     */
    public Player(String nombre, String contraseña) {
        super(nombre, contraseña);
    }

    /**
     * Indica que el jugador no tiene permisos de administrador.
     *
     * @return false, ya que un jugador no tiene permisos de administrador.
     */
    @Override
    public boolean permisosAdmin() {
        return false;
    }
}


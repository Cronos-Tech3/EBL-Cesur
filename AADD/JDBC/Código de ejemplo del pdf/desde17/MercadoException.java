

package tema3.transparencias.desde17;
/**
 * 
 *  @descrition Clase Raiz para la jerarquia de Excepciones de mi aplicación
 */
public class MercadoException extends Exception{

    /**
	 * Necesario por impmentar Serializable
	 */
	private static final long serialVersionUID = 6308847858962342271L;

	public MercadoException(String message) {
        super(message);
    }

}

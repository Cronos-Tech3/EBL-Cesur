package JAVA_APUNTES.RA7.EjDocGestionEmpleado;

/**
 * Excepción personalizada para manejar casos donde no se encuentra un empleado.
 */
public class EmpleadoNoEncontradoException extends Exception {
    public EmpleadoNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}


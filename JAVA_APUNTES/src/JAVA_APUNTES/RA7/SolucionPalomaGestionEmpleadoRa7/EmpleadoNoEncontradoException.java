package JAVA_APUNTES.RA7.SolucionPalomaGestionEmpleadoRa7;

public class EmpleadoNoEncontradoException extends Exception{
    public EmpleadoNoEncontradoException(){
        super("No se ha encontrado ese empleado.");
    }
}

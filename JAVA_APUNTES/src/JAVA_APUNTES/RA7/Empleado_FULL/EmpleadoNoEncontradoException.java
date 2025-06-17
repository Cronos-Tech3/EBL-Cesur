package JAVA_APUNTES.RA7.Empleado_FULL;

public class EmpleadoNoEncontradoException extends Exception{   // Define una clase pública llamada EmpleadoNoEncontradoException que extiende la clase Exception
    public EmpleadoNoEncontradoException(){                 // Constructor de la clase EmpleadoNoEncontradoException
        super("No se ha encontrado ese empleado.");       // Llama al constructor de la clase padre (Exception) con un mensaje específico
    }
}

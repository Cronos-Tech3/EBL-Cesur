package JAVA_APUNTES.RA7.Empleado_FULL;

public interface IAsistencia {      // Define una interfaz pública llamada IAsistencia
    boolean marcarAsistencia(int idEmpleado) throws EmpleadoNoEncontradoException;  // Método para marcar la asistencia de un empleado
    int calcularHorasTrabajadas(int idEmpleado) throws EmpleadoNoEncontradoException;   // Método para calcular las horas trabajadas por un empleado
    boolean registrarAusencia(int idEmpleado) throws EmpleadoNoEncontradoException; // Método para registrar la ausencia de un empleado
}

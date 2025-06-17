package JAVA_APUNTES.RA7.EjGestionEmpleados;

public interface IAsistencia {
    boolean marcarAsistencia(int idEmpleado) throws EmpleadoNoEncontradoException;
    int calcularHorasTrabajadas(int idEmpleado) throws EmpleadoNoEncontradoException;
    boolean registrarAusencia(int idEmpleado) throws EmpleadoNoEncontradoException;
}


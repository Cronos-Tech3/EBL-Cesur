package JAVA_APUNTES.RA7.EjDocGestionEmpleado;

/**
 * Interfaz para gestionar la asistencia de los empleados.
 */
public interface IAsistencia {
    /**
     * Marca la asistencia de un empleado identificado por su ID.
     * @param idEmpleado Identificador del empleado
     * @return true si la asistencia fue marcada correctamente
     * @throws EmpleadoNoEncontradoException Si el empleado no es encontrado
     */
    boolean marcarAsistencia(int idEmpleado) throws EmpleadoNoEncontradoException;

    /**
     * Calcula las horas trabajadas por un empleado identificado por su ID.
     * @param idEmpleado Identificador del empleado
     * @return Las horas trabajadas por el empleado
     * @throws EmpleadoNoEncontradoException Si el empleado no es encontrado
     */
    int calcularHorasTrabajadas(int idEmpleado) throws EmpleadoNoEncontradoException;

    /**
     * Registra la ausencia de un empleado identificado por su ID.
     * @param idEmpleado Identificador del empleado
     * @return true si la ausencia fue registrada correctamente
     * @throws EmpleadoNoEncontradoException Si el empleado no es encontrado
     */
    boolean registrarAusencia(int idEmpleado) throws EmpleadoNoEncontradoException;
}


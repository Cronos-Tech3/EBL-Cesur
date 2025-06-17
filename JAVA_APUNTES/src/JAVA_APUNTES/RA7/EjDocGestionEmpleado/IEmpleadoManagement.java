package JAVA_APUNTES.RA7.EjDocGestionEmpleado;

/**
 * Interfaz para gestionar empleados, incluyendo contratación, cálculo de salario y despido.
 */
public interface IEmpleadoManagement {
    /**
     * Contrata a un nuevo empleado con su nombre y puesto.
     * @param nombre Nombre del empleado
     * @param puesto Puesto de trabajo del empleado
     */
    void contratarEmpleado(String nombre, String puesto);

    /**
     * Calcula el salario del empleado tomando en cuenta sus horas trabajadas y la tarifa por hora.
     * @param idEmpleado Identificador del empleado
     * @param horasTrabajadas Horas trabajadas por el empleado
     * @param tarifaPorHora Tarifa por hora del empleado
     * @return El salario calculado
     * @throws EmpleadoNoEncontradoException Si el empleado no es encontrado
     */
    double calcularSalario(int idEmpleado, int horasTrabajadas, double tarifaPorHora) throws EmpleadoNoEncontradoException;

    /**
     * Despide a un empleado basado en su ID.
     * @param idEmpleado Identificador del empleado
     * @throws EmpleadoNoEncontradoException Si el empleado no es encontrado
     */
    void despedirEmpleado(int idEmpleado) throws EmpleadoNoEncontradoException;
}


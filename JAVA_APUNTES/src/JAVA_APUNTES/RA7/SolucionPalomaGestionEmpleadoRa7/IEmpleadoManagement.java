package JAVA_APUNTES.RA7.SolucionPalomaGestionEmpleadoRa7;

public interface IEmpleadoManagement {
    void contratarEmpleado(String nombre, String puesto);
    double calcularSalario(int idEmpleado, int horasTrabajadas, double tarifaPorHora) throws EmpleadoNoEncontradoException;
    void despedirEmpleado(int idEmpleado) throws EmpleadoNoEncontradoException;

}

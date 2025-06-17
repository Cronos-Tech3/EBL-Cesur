package JAVA_APUNTES.RA7.Empleado_FULL;

public interface IEmpleadoManagement {      // Define una interfaz pública llamada IEmpleadoManagement
    void contratarEmpleado(String nombre, String puesto);   // Método para contratar a un nuevo empleado
    double calcularSalario(int idEmpleado, int horasTrabajadas, double tarifaPorHora) throws EmpleadoNoEncontradoException; // Método para calcular el salario de un empleado
    void despedirEmpleado(int idEmpleado) throws EmpleadoNoEncontradoException; // Método para despedir a un empleado

}

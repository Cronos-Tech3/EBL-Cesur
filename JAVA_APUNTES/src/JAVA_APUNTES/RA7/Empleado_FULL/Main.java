package JAVA_APUNTES.RA7.Empleado_FULL;

public class Main {
    public static void main(String[] args) {    // Método principal que se ejecuta al iniciar el programa
        GestorEmpleado gestor = new GestorEmpleado();   // Crea una instancia de GestorEmpleado
        gestor.contratarEmpleado("Paloma","Profesora"); // Contrata a un empleado con nombre "Paloma" y puesto "Profesora"
        gestor.contratarEmpleado("Juan","Administrativo");  // Contrata a un empleado con nombre "Juan" y puesto "Administrativo"
        gestor.contratarEmpleado("Alonso","Limpieza");      // Contrata a un empleado con nombre "Alonso" y puesto "Limpieza"
        try {
            System.out.println(gestor.listaEmpleados);  // Imprime la lista de empleados
            double salario = gestor.calcularSalario(0, 20, 20); // Calcula el salario del empleado con ID 0, 20 horas trabajadas y tarifa por hora de 20
            System.out.println(salario);               // Imprime el salario calculado
            gestor.despedirEmpleado(2);     // Despide al empleado con ID 2
            gestor.marcarAsistencia(1);     // Marca la asistencia del empleado con ID 1
            gestor.registrarAusencia(0);    // Registra la ausencia del empleado con ID 0
            System.out.println(gestor.calcularHorasTrabajadas(0));  // Imprime las horas trabajadas del empleado con ID 0
            System.out.println(gestor.listaEmpleados);  // Imprime la lista de empleados actualizada
        } catch (EmpleadoNoEncontradoException e) {     // Captura la excepción EmpleadoNoEncontradoException
            System.out.println(e.getMessage());         // Imprime el mensaje de la excepción
        }

    }
}

package JAVA_APUNTES.RA7.EjDocGestionEmpleado;

public class Main {
    public static void main(String[] args) {
        GestorEmpleados gestor = new GestorEmpleados();

        // Contratar a un empleado
        gestor.contratarEmpleado("Juan", "Desarrollador");

        // Calcular y mostrar el salario de un empleado
        try {
            double salario = gestor.calcularSalario(1, 40, 20);
            System.out.println("Salario de Juan: $" + salario);
        } catch (EmpleadoNoEncontradoException e) {
            e.printStackTrace();
        }

        // Despedir a un empleado
        try {
            gestor.despedirEmpleado(1);
        } catch (EmpleadoNoEncontradoException e) {
            e.printStackTrace();
        }

        // Marcar la asistencia y registrar la ausencia de otro empleado
        gestor.contratarEmpleado("Ana", "Diseñadora");
        try {
            gestor.marcarAsistencia(2);
            gestor.registrarAusencia(2);
            int horasTrabajadas = gestor.calcularHorasTrabajadas(2);
            System.out.println("Horas trabajadas por Ana: " + horasTrabajadas);
        } catch (EmpleadoNoEncontradoException e) {
            e.printStackTrace();
        }
    }
}


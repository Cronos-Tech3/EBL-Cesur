package JAVA_APUNTES.RA7.SolucionPalomaGestionEmpleadoRa7;

public class Main {
    public static void main(String[] args) {
        GestorEmpleado gestor = new GestorEmpleado();
        gestor.contratarEmpleado("Paloma","Profesora");
        gestor.contratarEmpleado("Juan","Administrativo");
        gestor.contratarEmpleado("Alonso","Limpieza");
        try {
            System.out.println(gestor.listaEmpleados);
            double salario = gestor.calcularSalario(0, 20, 20);
            System.out.println(salario);
            gestor.despedirEmpleado(2);
            gestor.marcarAsistencia(1);
            gestor.registrarAusencia(0);
            System.out.println(gestor.calcularHorasTrabajadas(0));
            System.out.println(gestor.listaEmpleados);
        } catch (EmpleadoNoEncontradoException e) {
            System.out.println(e.getMessage());
        }

    }
}

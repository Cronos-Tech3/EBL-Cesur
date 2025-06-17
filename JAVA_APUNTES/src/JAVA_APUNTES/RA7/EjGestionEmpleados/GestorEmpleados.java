package JAVA_APUNTES.RA7.EjGestionEmpleados;

import java.util.ArrayList;
import java.util.List;

public class GestorEmpleados implements IEmpleadoManagement, IAsistencia {
    private List<Empleado> empleados;
    private int nextId;

    public GestorEmpleados() {
        empleados = new ArrayList<>();
        nextId = 1;
    }

    @Override
    public void contratarEmpleado(String nombre, String puesto) {
        Empleado nuevoEmpleado = new Empleado(nextId++, nombre, puesto);
        empleados.add(nuevoEmpleado);
        System.out.println("Empleado contratado: " + nombre);
    }

    @Override
    public double calcularSalario(int idEmpleado, int horasTrabajadas, double tarifaPorHora) throws EmpleadoNoEncontradoException {
        Empleado empleado = encontrarEmpleadoPorId(idEmpleado);
        return horasTrabajadas * tarifaPorHora;
    }

    @Override
    public void despedirEmpleado(int idEmpleado) throws EmpleadoNoEncontradoException {
        Empleado empleado = encontrarEmpleadoPorId(idEmpleado);
        empleados.remove(empleado);
        System.out.println("Empleado despedido: " + empleado.getNombre());
    }

    @Override
    public boolean marcarAsistencia(int idEmpleado) throws EmpleadoNoEncontradoException {
        Empleado empleado = encontrarEmpleadoPorId(idEmpleado);
        empleado.setAsistencia(true);
        System.out.println("Asistencia marcada para: " + empleado.getNombre());
        return true;
    }

    @Override
    public int calcularHorasTrabajadas(int idEmpleado) throws EmpleadoNoEncontradoException {
        Empleado empleado = encontrarEmpleadoPorId(idEmpleado);
        return empleado.getHorasTrabajadas();
    }

    @Override
    public boolean registrarAusencia(int idEmpleado) throws EmpleadoNoEncontradoException {
        Empleado empleado = encontrarEmpleadoPorId(idEmpleado);
        empleado.setAsistencia(false);
        System.out.println("Ausencia registrada para: " + empleado.getNombre());
        return true;
    }

    private Empleado encontrarEmpleadoPorId(int idEmpleado) throws EmpleadoNoEncontradoException {
        return empleados.stream()
                .filter(e -> e.getId() == idEmpleado)
                .findFirst()
                .orElseThrow(() -> new EmpleadoNoEncontradoException("Empleado no encontrado"));
    }
}


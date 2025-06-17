package JAVA_APUNTES.RA7.EjDocGestionEmpleado;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que gestiona a los empleados e implementa las interfaces IEmpleadoManagement e IAsistencia.
 */
public class GestorEmpleados implements IEmpleadoManagement, IAsistencia {
    private List<Empleado> empleados; // Lista de empleados
    private int nextId; // Variable para generar identificadores únicos

    public GestorEmpleados() {
        empleados = new ArrayList<>();
        nextId = 1; // Inicializa el próximo ID en 1
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

    /**
     * Encuentra un empleado por su ID.
     * @param idEmpleado Identificador del empleado
     * @return El empleado encontrado
     * @throws EmpleadoNoEncontradoException Si el empleado no es encontrado
     */
    private Empleado encontrarEmpleadoPorId(int idEmpleado) throws EmpleadoNoEncontradoException {
        return empleados.stream()
                .filter(e -> e.getId() == idEmpleado)
                .findFirst()
                .orElseThrow(() -> new EmpleadoNoEncontradoException("Empleado no encontrado"));
    }

    /*
    definición del Método
java
private Empleado encontrarEmpleadoPorId(int idEmpleado) throws EmpleadoNoEncontradoException {
Este método es privado y devuelve un objeto de tipo Empleado. Recibe un parámetro idEmpleado de tipo int, que representa el identificador del empleado que se quiere encontrar. Además, declara que puede lanzar una excepción personalizada EmpleadoNoEncontradoException.

Uso de Streams
java
return empleados.stream()
Aquí comienza un flujo (stream) a partir de la lista empleados. Los streams en Java proporcionan una forma funcional de procesar secuencias de elementos.

Filtrado de la Lista
java
.filter(e -> e.getId() == idEmpleado)
Se aplica un filtro al stream. La función lambda e -> e.getId() == idEmpleado se utiliza para comparar el idEmpleado con el identificador de cada objeto Empleado en la lista. Solo los empleados que cumplen con esta condición (es decir, cuyo id coincide con idEmpleado) pasan el filtro.

Encontrar el Primer Resultado
java
.findFirst()
Después de aplicar el filtro, se busca el primer elemento en el stream que cumple con la condición. findFirst() devuelve un Optional<Empleado>, que es una contenedor que puede o no contener un valor no nulo.

Manejo del Resultado
java
.orElseThrow(() -> new EmpleadoNoEncontradoException("Empleado no encontrado"));
Si no se encuentra ningún empleado con el id proporcionado, se lanza una excepción personalizada EmpleadoNoEncontradoException con el mensaje "Empleado no encontrado". El método orElseThrow() se usa para lanzar esta excepción si el Optional está vacío.

Resumen Completo
java
private Empleado encontrarEmpleadoPorId(int idEmpleado) throws EmpleadoNoEncontradoException {
    return empleados.stream()
                    .filter(e -> e.getId() == idEmpleado)
                    .findFirst()
                    .orElseThrow(() -> new EmpleadoNoEncontradoException("Empleado no encontrado"));
}
Este método:

Inicia un stream a partir de la lista de empleados.

Filtra los empleados para encontrar aquellos cuyo id coincida con idEmpleado.

Busca el primer empleado que cumpla con esta condición.

Si no se encuentra ningún empleado con el id proporcionado, lanza una excepción EmpleadoNoEncontradoException con el mensaje "Empleado no encontrado".

Si se encuentra un empleado, devuelve ese empleado.
     */

}


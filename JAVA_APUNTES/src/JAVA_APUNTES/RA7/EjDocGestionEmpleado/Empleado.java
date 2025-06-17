package JAVA_APUNTES.RA7.EjDocGestionEmpleado;

/**
 * Clase que representa a un empleado con sus atributos y métodos básicos.
 */
public class Empleado {
    private int id; // Identificador único del empleado
    private String nombre; // Nombre del empleado
    private String puesto; // Puesto de trabajo del empleado
    private int horasTrabajadas; // Horas trabajadas por el empleado
    private boolean asistencia; // Indicador de asistencia del empleado

    /**
     * Constructor para crear un empleado con un id, nombre y puesto.
     * @param id Identificador único del empleado
     * @param nombre Nombre del empleado
     * @param puesto Puesto de trabajo del empleado
     */
    public Empleado(int id, String nombre, String puesto) {
        this.id = id;
        this.nombre = nombre;
        this.puesto = puesto;
        this.horasTrabajadas = 0; // Inicialmente, las horas trabajadas son 0
        this.asistencia = false; // Inicialmente, el empleado no ha marcado asistencia
    }

    // Métodos getter para obtener los atributos del empleado
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    // Método para sumar horas trabajadas al empleado
    public void sumarHorasTrabajadas(int horas) {
        this.horasTrabajadas += horas;
    }

    // Métodos getter y setter para la asistencia
    public boolean isAsistencia() {
        return asistencia;
    }

    public void setAsistencia(boolean asistencia) {
        this.asistencia = asistencia;
    }
}


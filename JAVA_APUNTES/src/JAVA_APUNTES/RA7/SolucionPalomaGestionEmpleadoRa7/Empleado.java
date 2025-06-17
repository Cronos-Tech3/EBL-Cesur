package JAVA_APUNTES.RA7.SolucionPalomaGestionEmpleadoRa7;

public class Empleado {
    private int id;
    private String nombre;
    private String puesto;
    private int horasTrabajadas;
    private boolean asistencia;

    static int contadorIds = 0;

    public Empleado(String nombre, String puesto) {
        this.id = contadorIds;
        this.nombre = nombre;
        this.puesto = puesto;
        contadorIds++;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public int getId() {
        return id;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setAsistencia(boolean asistencia) {
        this.asistencia = asistencia;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", puesto='" + puesto + '\'' +
                ", horasTrabajadas=" + horasTrabajadas +
                ", asistencia=" + asistencia +
                '}';
    }
}

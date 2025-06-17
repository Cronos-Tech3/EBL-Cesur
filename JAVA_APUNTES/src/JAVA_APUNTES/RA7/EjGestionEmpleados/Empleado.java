package JAVA_APUNTES.RA7.EjGestionEmpleados;

public class Empleado {
    private int id;
    private String nombre;
    private String puesto;
    private int horasTrabajadas;
    private boolean asistencia;

    public Empleado(int id, String nombre, String puesto) {
        this.id = id;
        this.nombre = nombre;
        this.puesto = puesto;
        this.horasTrabajadas = 0;
        this.asistencia = false;
    }



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

    public void sumarHorasTrabajadas(int horas) {
        this.horasTrabajadas += horas;
    }

    public boolean isAsistencia() {
        return asistencia;
    }

    public void setAsistencia(boolean asistencia) {
        this.asistencia = asistencia;
    }




}

package JAVA_APUNTES.RA7.Empleado_FULL;

public class Empleado {  // Define la clase Empleado
    private int id;  // Variable privada para almacenar el ID del empleado
    private String nombre;  // Variable privada para almacenar el nombre del empleado
    private String puesto;  // Variable privada para almacenar el puesto del empleado
    private int horasTrabajadas;    // Variable privada para almacenar las horas trabajadas por el empleado
    private boolean asistencia;     // Variable privada para almacenar la asistencia del empleado

    static int contadorIds = 0; // Variable estática para contar y asignar IDs únicos a cada empleado


    public Empleado(String nombre, String puesto) { // Constructor de la clase Empleado
        this.id = contadorIds;  // Asigna el valor actual de contadorIds a la variable id
        this.nombre = nombre;   // Asigna el valor del parámetro nombre a la variable nombre
        this.puesto = puesto;   // Asigna el valor del parámetro puesto a la variable puesto
        contadorIds++;          //Incrementa contadorIds para el próximo empleado
    }

    public void setHorasTrabajadas(int horasTrabajadas) {   // Método para establecer las horas trabajadas
        this.horasTrabajadas = horasTrabajadas; // Asigna el valor del parámetro horasTrabajadas a la variable horasTrabajadas
    }

    public int getId() {    // Método para obtener el ID del empleado
        return id;          //Devuelve el valor de la variable id
    }

    public int getHorasTrabajadas() {   // Método para obtener las horas trabajadas
        return horasTrabajadas;         // Devuelve el valor de la variable horasTrabajadas
    }

    public void setAsistencia(boolean asistencia) {     // Método para establecer la asistencia
        this.asistencia = asistencia;                   // Asigna el valor del parámetro asistencia a la variable asistencia
    }

    @Override
    public String toString() {      // Método para obtener una representación en cadena del objeto Empleado
        return "Empleado{" +        // Devuelve una cadena con los valores de las variables del empleado
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", puesto='" + puesto + '\'' +
                ", horasTrabajadas=" + horasTrabajadas +
                ", asistencia=" + asistencia +
                '}';
    }
}

package JAVA_APUNTES.RA4.TAREA_R4_JO;

public class Estudiante_EJ9_POO {

    private String nombre;
    private int edad;
    private char calificacion;

    public Estudiante_EJ9_POO(String nombre, int edad, char calificacion) {
        this.nombre = nombre;
        this.edad = edad;
        this.calificacion = calificacion;
    }

    public char getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(char calificacion) {
        this.calificacion = calificacion;
    }

    public void asignarCalificacion(char calificacion){
        if (calificacion >= 9) {
            System.out.println("A");

        } else if (calificacion >= 7 && calificacion < 9) {
            System.out.println("B");

        } else if (calificacion >= 4 && calificacion < 7) {
            System.out.println("C");

        } else {
            System.out.println("D");
        }
    }

    public String obtenerNivel() {
        switch (calificacion) {
            case 'A':
                return "Excelente";
            case 'B':
                return "Bueno";
            case 'C':
                return "Regular";
            default:
                return "Deficiente";
        }
    }
}
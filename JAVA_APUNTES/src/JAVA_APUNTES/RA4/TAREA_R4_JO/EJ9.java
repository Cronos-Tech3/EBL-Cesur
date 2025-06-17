package JAVA_APUNTES.RA4.TAREA_R4_JO;

public class EJ9 {
    public static void main(String[] args) {

        Estudiante_EJ9_POO e1 = new Estudiante_EJ9_POO("Juan", 30, (char) 9.50);

        e1.asignarCalificacion(e1.getCalificacion());

        e1.obtenerNivel();


    }


}

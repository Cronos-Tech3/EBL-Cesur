package RA4_POO.EjercicioPOO.POO_Ej1;

public class Estudiante {

    public String nombre;
    public int edad;
    public char calificacion;

    public void asignarCalificacion(char calificacion) {
        if(calificacion >= 9) {
            System.out.println("A");
        } else if(calificacion >= 7 && calificacion < 9) {
            System.out.println("B");
        } else if(calificacion >= 4 && calificacion < 7) {
            System.out.println("C");
        }else {
            System.out.println("D");
        }

    }

    public String obtenerNivel () {
        switch( calificacion) {
            case 'A':
                return "Excelente";
            case 'B':
                return "Bueno";

            case 'C':
                return "Regular";
            case 'D':
                return "Deficiente";
        }


        return "";
    }

}

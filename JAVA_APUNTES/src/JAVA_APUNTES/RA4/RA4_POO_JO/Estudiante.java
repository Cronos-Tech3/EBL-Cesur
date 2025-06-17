package RA4_POO;

public class Estudiante {

    private String nombre;
    private int edad;
    private char calificacion;



    public void asignarCalificacion(char calificacion){
        if(calificacion >= 9){
            System.out.println("A");

        }else if (calificacion >= 7 && calificacion < 9){
            System.out.println("B");

        }else if (calificacion >= 4 && calificacion < 7){
            System.out.println("C");

        }else {
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

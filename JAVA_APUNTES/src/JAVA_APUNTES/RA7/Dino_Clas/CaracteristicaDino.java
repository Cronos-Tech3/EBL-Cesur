package JAVA_APUNTES.RA7.Dino_Clas;

/*
EXPLICACIÓN
    En esta clase representamos las características del dinosaurio
 */
public class CaracteristicaDino {

    //ATRIBUTOS//
    private String descripcion;
    private int edad;
    private String color;
    private double longitud;

    //CONSTRUCTOR//
    public CaracteristicaDino(String descripcion, int edad, String color, double longitud) {
        this.descripcion = descripcion;
        this.edad = edad;
        this.color = color;
        this.longitud = longitud;
    }

    //GETTER Y SETTERS
    public String getDescripcion() {
        return descripcion;
    }

    public int getEdad() {
        return edad;
    }

    public String getColor() {
        return color;
    }

    public double getLongitud() {
        return longitud;
    }
}
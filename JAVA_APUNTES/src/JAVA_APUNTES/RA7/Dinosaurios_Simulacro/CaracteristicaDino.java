package JAVA_APUNTES.RA7.Dinosaurios_Simulacro;

public class CaracteristicaDino {
    private String descripcion;
    private int edad;
    private String color;
    private double longitud;

    public CaracteristicaDino(String descripcion, int edad, String color, double longitud) {
        this.descripcion = descripcion;
        this.edad = edad;
        this.color = color;
        this.longitud = longitud;
    }

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

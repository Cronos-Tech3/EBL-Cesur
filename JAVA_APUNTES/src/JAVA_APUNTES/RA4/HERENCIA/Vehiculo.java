package JAVA_APUNTES.RA4.HERENCIA;

public class Vehiculo {
    /*
    Clase Vehiculo con atributos públicos:
    numRuedas : int
    tipo : String
    color : String
    velocidadMaxima : int
    y métodos toString, constructor con todos los atributos.

    Clase Coche hereda de vehículo, con los atributos públicos:
    traccion : String
    numPuertas : int
    y métodos toString con todos los atributos, constructor con todos los atributos.

    Clase Moto hereda de vehículo con los atributos públicos:
    cilindrada : int
    tiempos : int
    y métodos toString con todos los atributos, constructor con todos los atributos.
     */


    public int numRuedas;
    public String tipo;
    public String color;
    public int velocidadMaxima;

    //toString
    @Override
    public String toString() {
        return "Vehiculo{" +
                "numRuedas=" + numRuedas +
                ", tipo='" + tipo + '\'' +
                ", color='" + color + '\'' +
                ", velocidadMaxima=" + velocidadMaxima +
                '}';
    }
    //constructor
    public Vehiculo(int numRuedas, String tipo, String color, int velocidadMaxima) {
        this.numRuedas = numRuedas;
        this.tipo = tipo;
        this.color = color;
        this.velocidadMaxima = velocidadMaxima;
    }
}

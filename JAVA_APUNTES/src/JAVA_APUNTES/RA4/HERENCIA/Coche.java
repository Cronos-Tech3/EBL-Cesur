package JAVA_APUNTES.RA4.HERENCIA;

public class Coche extends Vehiculo {

    public String traccion;
    public int numPuertas;

    //conctructor with super
    public Coche(int numRuedas, String tipo, String color, int velocidadMaxima, String traccion, int numPuertas) {
        super(numRuedas, tipo, color, velocidadMaxima);
        this.numPuertas=numPuertas; //el numero de puertas sera el numero de puertas que le pase
        this.traccion=traccion;     //la traccion sera la traccion que le pase
    }

    //toString
    @Override
    public String toString() {
        return "Coche{" +
                "traccion='" + traccion + '\'' +
                ", numPuertas=" + numPuertas +
                ", numRuedas=" + numRuedas +
                ", tipo='" + tipo + '\'' +
                ", color='" + color + '\'' +
                ", velocidadMaxima=" + velocidadMaxima +
                '}';
    }




}

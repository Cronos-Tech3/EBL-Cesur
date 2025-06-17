package JAVA_APUNTES.RA4.HERENCIA;

public class Moto extends Vehiculo{


    public int cilindrada;
    public int tiempos;

    public Moto(Vehiculo vehiculo, int cilindrada, int tiempos ) {
        super(vehiculo.numRuedas, vehiculo.tipo, vehiculo.color, vehiculo.velocidadMaxima);
        //lo siguiente hay que añadirlo
        this.cilindrada=cilindrada;
        this.tiempos=tiempos;
    }
    //constructor con super con todos los atributos



    @Override
    public String toString() {
        return "Moto{" +
                "cilindrada=" + cilindrada +
                ", tiempos=" + tiempos +
                ", numRuedas=" + numRuedas +
                ", tipo='" + tipo + '\'' +
                ", color='" + color + '\'' +
                ", velocidadMaxima=" + velocidadMaxima +
                '}';
    }


}

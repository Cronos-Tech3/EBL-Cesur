package JAVA_APUNTES.ARRAYS.ArrayList_Concesionario;

public class Auto extends Vehiculo {

    private int puertas;

    private boolean electrico;

    public Auto(String marca, String modelo, int anio, double precio, int puertas, boolean electrico) {
        super(marca, modelo, anio, precio);
        this.puertas = puertas;
        this.electrico = electrico;
    }

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    public boolean isElectrico() {
        return electrico;
    }

    public void setElectrico(boolean electrico) {
        this.electrico = electrico;
    }

    public double calcularDescuento() {
        return (electrico)?getPrecio()*0.2:getPrecio()*0.1;
    }
}

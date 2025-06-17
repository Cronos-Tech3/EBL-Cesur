package JAVA_APUNTES.RA6;

public class Vehiculo {
    private String marca;
    private String modelo;
    private int anio;
    private double precio;

    public Vehiculo(String marca, String modelo, int anio, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void mostrarDetalles(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", anio=" + anio +
                ", precio=" + precio +
                '}';
    }

    public String generarDetalles(){
        return "Vehículo: " +
                "\t - marca: " + marca +
                "\t - modelo: " + modelo +
                "\t - precio: " + precio +
                "\t - año: " + anio;
    }

    public double calcularImpuesto(){
        double resultado = 0.10*precio;
        return resultado;
    }
}

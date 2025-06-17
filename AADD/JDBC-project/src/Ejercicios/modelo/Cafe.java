package modelo;

public class Cafe {
    private String nombre;
    private int proveedor;
    private double precio;
    private int ventas;
    private double total;

    public Cafe(String nombre, int proveedor, double precio, int ventas, double total) {
        this.nombre = nombre;
        this.proveedor = proveedor;
        this.precio = precio;
        this.ventas = ventas;
        this.total = total;
    }

    public Cafe(String nombre, int proveedor, double precio) {
        this.nombre = nombre;
        this.proveedor = proveedor;
        this.precio = precio;
    }

    public void setVentas(int ventas) {
        this.ventas = ventas;
        this.total = ventas * precio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getProveedor() {
        return proveedor;
    }

    public double getPrecio() {
        return precio;
    }

    public int getVentas() {
        return ventas;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Cafe{" +
                "nombre='" + nombre + '\'' +
                ", proveedor=" + proveedor +
                ", precio=" + precio +
                ", ventas=" + ventas +
                ", total=" + total +
                '}';
    }
}

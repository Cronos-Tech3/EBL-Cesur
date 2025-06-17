package JAVA_APUNTES.RA4.TAREA_R4_JO;

public class Factura_Clase {

    private String descripcion;
    private int cantidad;
    private double precioUnitario;

    public void calcularTotal() {
        double total = cantidad * precioUnitario;
        System.out.println(total);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Factura_Clase(String descripcion, int cantidad, double precioUnitario) {
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;


    }

    public void mostrarDetalle() {
        System.out.println(descripcion);
        System.out.println(cantidad);
        System.out.println(precioUnitario);
    }
}

package RA4_POO;

public class Factura {

    public String descripcion;
    public int cantidad;
    public double precioUnitario;

    public void calcularTotal(){
        double total = cantidad * precioUnitario;
        System.out.println(total);

    }

    public void mostrarDetalle() {
        System.out.println(descripcion);
        System.out.println(cantidad);
        System.out.println(precioUnitario);

    }

}

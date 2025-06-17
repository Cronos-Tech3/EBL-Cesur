package RA4_POO.EjercicioPOO.POO_Ej1;

public class Factura {


    public String descripcion;
    public int cantidad;
    public double orecioUnitario;


    public void calcularTotal() {
        double total = cantidad * orecioUnitario;
        System.out.println(total);
    }

    public void mostrarDetalle() {
        System.out.println(descripcion);
        System.out.println(cantidad);
        System.out.println(orecioUnitario);
       
    }
}

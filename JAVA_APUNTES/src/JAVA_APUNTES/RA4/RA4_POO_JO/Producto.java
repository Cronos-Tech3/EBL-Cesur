package RA4_POO;

public class Producto {

    public String nombre;
    public double precio;
    public double cantidad;


    public double caluclarTotal() {

        double cesta = 0;
        if (cantidad > 0) {
            cesta = precio * cantidad;
        }else {
            System.out.println("No hay items");
        }
        return cesta;
    }


    public void mostrarDetalle() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: " + precio);
        System.out.println("Cantidad: " + cantidad);
    }
}

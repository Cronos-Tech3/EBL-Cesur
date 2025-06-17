package RA4_POO.EjercicioPOO.POO_Ej1;

public class Producto22 {

    public String  nombre;
    public int cantidad;
    public int precio;

    public Producto22(String nombre, int cantidad, int precio) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public void calculoPrecio(int precioTotal) {
        precioTotal = precio+cantidad;
        System.out.println(precioTotal);
    }

    public void mostrarDetalles() {

        System.out.println("Nombre: " + nombre);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Precio: " + precio);
    }


}

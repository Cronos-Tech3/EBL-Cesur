package JAVA_APUNTES.RA4.EjercicioCompleto;

public class Producto {

    public String nombre;
    public double precio;
    public int cantidad;




    public void caluclarTotal() {
        double sumatorio = 0;
        double cesta = precio *cantidad;
        if (cantidad >0) {
            cesta +=sumatorio;
        }
        System.out.println(sumatorio);
    }

    public void setNombre(String nombre) {  // no devuelve nada, el uso de setter es para poder cambiar su valor
        this.nombre = nombre;
    }

    public String getNombre() {    // un getter si devuelve un dato porque lo estamos llamando
        return nombre;
    }

    public void mostrarDetalle() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: " + precio);
        System.out.println("Cantidad: " + cantidad);
    }

    public Producto(String nombre, double precio, int cantidad) {  // el constructor de producto
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public static double hola() {
        return 3.14;
    }


}

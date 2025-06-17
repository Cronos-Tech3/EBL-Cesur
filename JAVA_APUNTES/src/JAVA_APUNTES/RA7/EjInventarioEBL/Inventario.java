package JAVA_APUNTES.RA7.EjInventarioEBL;

import java.util.ArrayList;

public class Inventario {
    private ArrayList<ProductoBase> productos;

    public Inventario() {

        productos = new ArrayList<>();
    }

    public void agregarProducto(ProductoBase producto) {

        productos.add(producto);
    }

    public void aplicarDescuentoPorCategoria(CategoriaProducto categoria, double descuento) {
        for (ProductoBase producto : productos) {
            if (producto.getCategoria() == categoria) {
                try {
                    producto.aplicarDescuento(descuento);
                } catch (DescuentoInvalidoException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public double calcularValorTotalInventario() {
        double valorTotal = 0.0;
        for (ProductoBase producto : productos) {
            valorTotal += producto.getPrecioFinal();
        }
        return valorTotal;
    }
}
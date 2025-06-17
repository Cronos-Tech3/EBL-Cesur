package JAVA_APUNTES.RA7.EjInventarioEBL;
/**
 * @author Benito Lopez, enrique
 *
 * Class {Main_Inv}
 *
 */

import java.util.Date;

public class Main_Inv {
    public static void main(String[] args) {
        Producto producto1 = new Producto("Portatil", CategoriaProducto.ELECTRONICA, 1000);
        Producto producto2 = new Producto("pantalon", CategoriaProducto.ROPA, 20);
        Producto producto4 = new Producto("Macarrones",CategoriaProducto.ALIMENTACION,3.10);

        ProductoConPromocion producto3 = new ProductoConPromocion("Tablet", CategoriaProducto.ELECTRONICA, 500, new Date(2025, 1, 1), new Date(2025, 12, 31));

        Inventario inventario = new Inventario();
        inventario.agregarProducto(producto1);
        inventario.agregarProducto(producto2);
        inventario.agregarProducto(producto3);
        inventario.agregarProducto(producto4);

        inventario.aplicarDescuentoPorCategoria(CategoriaProducto.ELECTRONICA, 50);
        inventario.aplicarDescuentoPorCategoria(CategoriaProducto.ALIMENTACION,1.80);

        System.out.println("Valor total del inventario: " + inventario.calcularValorTotalInventario());
    }
}
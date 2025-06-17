package JAVA_APUNTES.RA7.EjInventarioEBL;

public class Producto extends ProductoBase implements IDescuento {

    public Producto(String nombre, CategoriaProducto categoria, double precioBase) {
        super(nombre, categoria, precioBase);
    }

    @Override
    public double getPrecioFinal() {
        return precioBase - descuento;
    }

    @Override
    public void aplicarDescuentoPorcentual(double porcentajeDescuento) throws DescuentoInvalidoException {
        if (porcentajeDescuento < 0) {
            throw new DescuentoInvalidoException("Descuento Negativo");
        }
        this.descuento = precioBase * porcentajeDescuento / 100;
    }

    @Override
    public void aplicarDescuentoPorcentajeMaximo(double porcentajeDescuento, double porcentajeMaximo) throws DescuentoInvalidoException {
        if (porcentajeDescuento < 0 || porcentajeDescuento > porcentajeMaximo) {
            throw new DescuentoInvalidoException("Descuento Negativo");
        }
        this.descuento = precioBase * porcentajeDescuento / 100;
    }
}

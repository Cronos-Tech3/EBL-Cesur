package JAVA_APUNTES.RA7.EjInventarioEBL;

import java.util.Date;

public class ProductoConPromocion extends ProductoBase implements IPromocion {
    private Date fechaInicioPromocion;
    private Date fechaFinPromocion;

    public ProductoConPromocion(String nombre, CategoriaProducto categoria, double precioBase, Date fechaInicioPromocion, Date fechaFinPromocion) {
        super(nombre, categoria, precioBase);
        this.fechaInicioPromocion = fechaInicioPromocion;
        this.fechaFinPromocion = fechaFinPromocion;
    }

    @Override
    public double getPrecioFinal() {
        return precioBase - descuento;
    }

    @Override
    public void aplicarPromocion(double porcentajeDescuento) throws DescuentoInvalidoException {
        if (porcentajeDescuento < 0) {
            throw new DescuentoInvalidoException("El descuento no puede ser negativo.");
        }
        this.descuento = precioBase * porcentajeDescuento / 100;
    }

    @Override
    public boolean estaEnPromocion() {
        Date ahora = new Date();
        return ahora.after(fechaInicioPromocion) && ahora.before(fechaFinPromocion);
    }
}

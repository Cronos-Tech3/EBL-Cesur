package JAVA_APUNTES.RA7.EjInventarioEBL;

public abstract class ProductoBase {
    protected String nombre;
    protected CategoriaProducto categoria;
    protected double precioBase;
    protected double descuento;

    public ProductoBase(String nombre, CategoriaProducto categoria, double precioBase) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precioBase = precioBase;
        this.descuento = 0.0;
    }

    public String getNombre() {
        return nombre;
    }

    public CategoriaProducto getCategoria() {
        return categoria;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public double getDescuento() {
        return descuento;
    }

    public void aplicarDescuento(double descuento) throws DescuentoInvalidoException {
        if (descuento < 0) {
            throw new DescuentoInvalidoException("Descuento invalido");
        }
        this.descuento = descuento;
    }

    public abstract double getPrecioFinal();
}

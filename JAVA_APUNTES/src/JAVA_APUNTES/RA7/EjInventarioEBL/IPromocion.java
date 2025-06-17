package JAVA_APUNTES.RA7.EjInventarioEBL;

public interface IPromocion {
    void aplicarPromocion(double porcentajeDescuento) throws DescuentoInvalidoException;

    boolean estaEnPromocion();
}
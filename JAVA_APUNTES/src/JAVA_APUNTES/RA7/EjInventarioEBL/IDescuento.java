package JAVA_APUNTES.RA7.EjInventarioEBL;

public interface IDescuento {
    void aplicarDescuentoPorcentual(double porcentajeDescuento) throws DescuentoInvalidoException;

    void aplicarDescuentoPorcentajeMaximo(double porcentajeDescuento, double porcentajeMaximo) throws DescuentoInvalidoException;
    }

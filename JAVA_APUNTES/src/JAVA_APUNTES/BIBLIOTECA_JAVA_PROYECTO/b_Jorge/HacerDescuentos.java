package JAVA_APUNTES.BIBLIOTECA_JAVA_PROYECTO.b_Jorge;

public class HacerDescuentos {

    double precio = 0;

    //EXPLICACIÓN = Para que el descuento funcione bien, debemos multiplicar el precio por 1.00 -el descuento
    //20% descuento = precio * 0.80
    //10% descuento = precio * 0.90

    public double descuentoEspecial(String tipoCliente) {
        if (tipoCliente.equalsIgnoreCase("estudiante")) {
            return precio * 0.85; // Descuento del 15%
        } else if (tipoCliente.equalsIgnoreCase("miembro")) {
            return precio * 0.90; // Descuento del 10%
        } else {
            return precio; // Sin descuento
        }
    }
}

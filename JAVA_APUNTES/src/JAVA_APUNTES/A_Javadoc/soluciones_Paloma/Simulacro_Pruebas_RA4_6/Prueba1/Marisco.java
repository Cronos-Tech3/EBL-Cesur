package JAVA_APUNTES.A_Javadoc.soluciones_Paloma.Simulacro_Pruebas_RA4_6.Prueba1;

public class Marisco {
    public String nombre;
    public String tipo;
    public double precioBase;
    public boolean esDeTemporada;

    // Constructor: se llama cuando creamos un nuevo Marisco
    public Marisco(String nombre, String tipo, double precioBase, boolean esDeTemporada) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.precioBase = precioBase;
        this.esDeTemporada = esDeTemporada;
    }

    // Método para calcular el precio según el mes
    public double calcularPrecio(String mes) {
        double precioFinal = precioBase; // Empezamos con el precio base

        // Aplicamos recargo en diciembre
        if (mes.equalsIgnoreCase("diciembre")) { //equalsIgnoreCase ignora mayúsculas y minúsculas
            precioFinal *= 1.15; // Aumenta el precio un 15%
        }
        // Aplicamos descuento en agosto
        else if (mes.equalsIgnoreCase("agosto")) {
            precioFinal *= 0.90; // Reduce el precio un 10%
        }
        //Aplicamos descuento en noviembre si es de temporada
        else if (mes.equalsIgnoreCase("noviembre") && esDeTemporada) {
            precioFinal *= 0.95; // Reduce el precio un 5%
        }

        return precioFinal; // Devolvemos el precio final calculado
    }

    // Método para mostrar la información del marisco
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Tipo: " + tipo + ", Precio Base: " + precioBase + ", Temporada: " + esDeTemporada;
    }
}

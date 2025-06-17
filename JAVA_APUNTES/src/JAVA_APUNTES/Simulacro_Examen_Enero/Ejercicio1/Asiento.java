package JAVA_APUNTES.Simulacro_Examen_Enero.Ejercicio1;

public class Asiento {
    private int fila;
    private int numeroAsiento;
    public double precio;
    public boolean vip;

    public Asiento(int fila, int numeroAsiento, double precio, boolean vip) {
        this.fila = fila;
        this.numeroAsiento = numeroAsiento;
        this.precio = precio;
        this.vip = vip;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(int numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    public double calcularPrecio(String diaSemana) {
        double precioFinal = precio;
        if (diaSemana.equalsIgnoreCase("martes")) {
            precioFinal -= precio * 0.20;  //20% descuento
        }
        if (vip){
            precioFinal += precio * 0.20;  //20% de recargo
        }
        return precioFinal;
    }

    @Override
    public String toString() {
        //String frase = "F[" + fila + "]-";
        // con un if else lo hizo
        return "Asiento " +
                "F" + fila +
                "A" + numeroAsiento +
                (vip ? " (VIP)" : "");

    }
}

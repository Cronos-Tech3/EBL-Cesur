package JAVA_APUNTES.X_Simulacro_Examen_RA_4_6.teatroSol;

/**
 * Atributos: Todos serán públicos a excepción de la fila y el número de asiento que será privado.
 * Constructores: de la clase Teatro crea solamente uno que reciba el nombre y que inicialice el
 * array con 80 posiciones. De Asiento, un solo constructor que reciba todos los atributos.
 * Getters y setters: Crea sólo los necesarios, de manera que haya los menos posibles.
 * Clase Asiento:
 * Atributos: fila: int, numero: int, precio: double, vip: boolean.
 * Métodos:
 * − calcularPrecio(diaSemana: String): double
 * o Descripción: Este método calcula el precio final del asiento teniendo en cuenta el día
 * de la semana. Aplica descuentos si es martes y recargos si es un asiento VIP.
 * o Acciones Esperadas:
 * − Si el día de la semana es "martes", se aplica un descuento del 20% al precio.
 * − Si el asiento es VIP, se aplica un recargo del 20% al precio.
 * − Devuelve el precio final después de aplicar descuentos o recargos.
 * − toString(): String
 * o Descripción: Este método proporciona una representación en cadena del objeto
 * Asiento, mostrando su ubicación (fila y número), si es VIP o no.
 * o Acciones Esperadas:
 * − Devuelve una cadena que representa el asiento en el formato "F[fila]-
 * Anumero".
 * */

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
            precioFinal = precioFinal + precio*0.20;  //20% de recargo; se suma al precio final por si coincide que es martes con que es asiento vip
        }
        return precioFinal;
    }

    @Override
    public String toString() {
        String frase = "F[" + fila + "]-";
        if (vip){
            frase += "V " + numeroAsiento;
        }else{
            frase += "A " + numeroAsiento;
        }
        return frase;
    }

}

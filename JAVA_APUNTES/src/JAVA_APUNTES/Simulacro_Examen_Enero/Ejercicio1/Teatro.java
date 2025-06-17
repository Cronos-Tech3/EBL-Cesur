package JAVA_APUNTES.Simulacro_Examen_Enero.Ejercicio1;

public class Teatro {
    public String nombre;
    public Asiento[][] asientos;

    public Teatro(String nombre) {
        this.nombre = nombre;
        this.asientos = new Asiento[8][10]; //80 posiciones
    }

    public void agregarAsiento(int fila, int numero, double precio, boolean vip) {
        if (fila >= 0 && fila < asientos.length && numero >= 0 && numero < asientos[0].length && asientos[fila][numero] == null) {
            asientos[fila][numero] = new Asiento(fila, numero, precio, vip);
            System.out.println("Asiento agregado en la fila " + fila + ", número " + numero);
        } else {
            System.out.println("Posición inválida o asiento ya ocupado.");
        }
    }

    public void calcularPrecios(String diaSemana) {
        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[i].length; j++) {
                if (asientos[i][j] != null) {
                    double precioFinal = asientos[i][j].calcularPrecio(diaSemana);
                    System.out.println(asientos[i][j] + " - Precio final: " + precioFinal);
                }
            }
        }
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[i].length; j++) {
                if (asientos[i][j] != null) {
                    result += asientos[i][j].vip? "V" : "A";
                } else {
                    result += "_";
                }
                result += "\n";
            }
        }
        return result;
    }




}

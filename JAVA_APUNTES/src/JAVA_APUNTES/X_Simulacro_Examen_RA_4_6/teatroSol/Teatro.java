package JAVA_APUNTES.X_Simulacro_Examen_RA_4_6.teatroSol;

/**
 * Clase Teatro:
 * Atributos: nombre: String, asientos: Asiento[][].
 * Métodos:
 * − agregarAsiento(fila: int, numero: int, precio: double, vip: boolean)
 * o Descripción: Este método agrega un nuevo asiento al array bidimensional de
 * asientos en la posición especificada.
 * o Acciones Esperadas:
 * − Verifica que la posición (fila, número) sea válida y esté disponible (sea nulo).
 * − Crea un nuevo objeto Asiento y lo agrega al array bidimensional en la
 * posición correspondiente.
 * − Imprime un mensaje indicando que se ha agregado el asiento.
 * − calcularPrecios(diaSemana: String)
 * o Descripción: Este método calcula y muestra los precios finales de todos los asientos
 * del teatro para un día de la semana específico.
 * o Acciones Esperadas:
 * − Itera sobre todos los asientos en el array bidimensional.
 * − Para cada asiento no nulo, llama al método calcularPrecio con el día de
 * la semana proporcionado.
 * − Imprime en la consola la información del asiento y su precio final.
 * − toString(): String
 * o Descripción: Este método proporciona una representación en cadena del objeto
 * Teatro, mostrando la disposición de los asientos (ocupados o no) en el formato de
 * una matriz.
 * o Acciones Esperadas:
 * − Itera sobre el array bidimensional de asientos.
 * − Para cada posición, si el asiento no es nulo, agrega "V" si es VIP o "A" si no lo
 * es a la representación en cadena.
 * − Devuelve la representación completa de la disposición de los asientos.
 * */


public class Teatro {
    public String nombre;
    public Asiento[][] asientos;

    public Teatro(String nombre) {
        this.nombre = nombre;
        this.asientos = new Asiento[8][10]; //80 posiciones
    }

    public void agregarAsiento(int fila, int numero, double precio, boolean vip) {
        if (fila < asientos.length && fila >= 0 && numero < asientos[0].length
                && numero >= 0) {
            if (asientos[fila][numero] == null) {
                Asiento a1 = new Asiento(fila, numero, precio, vip);
                asientos[fila][numero] = a1;
                System.out.println("Se ha insertado con éxito en la fila " + fila + ", número " + numero);
            }else {
                System.out.println("El asiento no está libre");
            }
        } else {
            System.out.println("Ese asiento no existe");
        }
    }

    public void calcularPrecios(String diaSemana) {
        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[i].length; j++) {
                if (asientos[i][j] != null) {
                    Asiento a = asientos[i][j];
                    double precioFinal = asientos[i][j].calcularPrecio(diaSemana);
                    System.out.println(a + " / " + precioFinal);
                }else {
                    System.out.println("-");
                }
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        String frase = "Teatro: " + nombre + "\n";
        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[i].length; j++) {
                if (asientos[i][j] != null) {
                    Asiento a = asientos[i][j];
                    frase += a.vip? "V" : "A";
                } else {
                    frase += "-";
                }
                frase += "\n";
            }
        }
        return frase;
    }




}

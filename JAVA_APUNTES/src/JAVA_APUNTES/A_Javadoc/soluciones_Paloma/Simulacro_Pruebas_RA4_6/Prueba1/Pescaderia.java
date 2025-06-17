package JAVA_APUNTES.A_Javadoc.soluciones_Paloma.Simulacro_Pruebas_RA4_6.Prueba1;

public class Pescaderia {
    public String nombre;
    public Marisco[] mariscos;

    // Constructor: se llama al crear una nueva Pescaderia
    public Pescaderia(String nombre) {
        this.nombre = nombre;
        this.mariscos = new Marisco[10]; // Creamos un array para 10 mariscos (puedes cambiar este número)
    }

    // Método para agregar un marisco
    public void agregarMarisco(String nombre, String tipo, double precioBase, boolean esDeTemporada) {
        for (int i = 0; i < mariscos.length; i++) {
            if (mariscos[i] == null) { // Buscamos un espacio vacío en el array
                mariscos[i] = new Marisco(nombre, tipo, precioBase, esDeTemporada); // Creamos el marisco y lo añadimos
                System.out.println("Marisco agregado.");
                return; // Salimos del método porque ya hemos añadido el marisco
            }
        }
        System.out.println("La pescadería está llena. No se pueden agregar más mariscos."); // Mensaje si el array está lleno
    }

    // Método para calcular los precios según el mes
    public void calcularPrecios(String mes) {
        for (Marisco marisco : mariscos) { // Recorremos el array
            if (marisco != null) { // Nos aseguramos de que no sea un espacio vacío (null)
                double precioFinal = marisco.calcularPrecio(mes); // Calculamos el precio final
                System.out.println(marisco.toString() + ", Precio Final en " + mes + ": " + precioFinal); // Mostramos la información
            }
        }
    }

    // Método para mostrar la información de la pescadería
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Mariscos en " + nombre + ":\n"); // Usamos StringBuilder para construir la cadena
        for (Marisco marisco : mariscos) { // Recorremos el array
            if (marisco != null) { // Nos aseguramos de que no sea un espacio vacío
                sb.append(marisco.toString()).append("\n"); // Añadimos la información del marisco a la cadena
            }
        }
        return sb.toString(); // Devolvemos la cadena completa
    }
}

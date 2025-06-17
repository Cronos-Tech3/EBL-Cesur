package ProblemasSincronizacion;

/*
 * Clase que simula un contador compartido entre varios hilos y utilizaremos la sincronización para evitar condiciones de carrera.
 * Mediante la utilización de la sincronización con la palabra clave synchronized,
 * hemos garantizado que la sección crítica (es decir, las operaciones de incremento y  decremento)
 * se ejecute de manera segura y consistente en un entorno de concurrencia.*/
public class SeccionCritica {
    private int valor = 0;

    // Método para incrementar el contador de manera segura
    public synchronized void incrementar() {
        valor++;
    }
    // Método para incrementar el contador de manera segura
    public synchronized void decrementar() {
        valor--;
    }

    // Método para obtener el valor actual del contador
    public synchronized int obtenerValor() {
        return valor;
    }

    public static void main(String[] args) {
        // Creamos una instancia de contador compartida
        SeccionCritica contador = new SeccionCritica();

        // Creamos varios hilos que incrementarán el contador
        Thread hilo1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                contador.incrementar();
            }
        });

        Thread hilo2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                contador.decrementar();
            }
        });

        // Iniciamos los hilos
        hilo1.start();
        hilo2.start();

        // Esperamos a que ambos hilos terminen
        try {
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Mostramos el valor final del contador
        System.out.println("Valor final del contador: " + contador.obtenerValor());
    }
}


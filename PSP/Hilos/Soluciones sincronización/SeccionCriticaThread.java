/*
* Para garantizar la sincronización, utilizamos un objeto de bloqueo (lock) sobre el cual se sincroniza la sección crítica
* (la operación de incremento del contador) dentro del método incrementar().
* Esto asegura que solo un hilo pueda ejecutar la sección crítica a la vez,
* evitando así condiciones de carrera y garantizando la consistencia de los datos compartidos.
* */
public class SeccionCriticaThread {
    // Variable compartida por los hilos
    private static int contador = 0;
    private static final Object lock = new Object(); // Objeto para sincronización

    public static void main(String[] args) {
        // Creamos varios hilos
        MiThread[] hilos = new MiThread[5];
        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new MiThread();
            hilos[i].start();
        }

        // Esperamos a que todos los hilos terminen
        for (Thread hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Imprimimos el valor final del contador
        System.out.println("Valor final del contador: " + contador);
    }

    static class MiThread extends Thread {
        public void run() {
            // Cada hilo incrementa el contador 1000 veces de manera sincronizada
            for (int i = 0; i < 1000; i++) {
                incrementar();
            }
        }

        // Método para incrementar el contador de manera sincronizada
        private void incrementar() {
            synchronized (lock) {
                contador++;
            }
        }
    }
}

package ProblemasSincronizacion;

public class SeccionCriticaRunnable  {
    // Variable compartida por los hilos
    private static int contador = 0;
    private static final Object lock = new Object(); // Objeto para sincronización

    public static void main(String[] args) {
        // Creamos varios objetos Runnable
        Runnable miRunnable = new MiRunnable();

        // Creamos varios hilos con la misma instancia Runnable
        Thread[] hilos = new Thread[5];
        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new Thread(miRunnable);
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

    static class MiRunnable implements Runnable {
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
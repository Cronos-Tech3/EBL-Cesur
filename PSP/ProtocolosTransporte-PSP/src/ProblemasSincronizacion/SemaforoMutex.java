package ProblemasSincronizacion;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * Un "mutex" es un mecanismo de sincronización que garantiza que solo un hilo pueda acceder a un recurso compartido en un momento dado.
 * Cada hilo adquiere el lock del mutex antes de entrar en la sección crítica y lo libera después de salir de la sección crítica.
 * El mutex garantiza que solo un hilo pueda ejecutar la sección crítica a la vez, lo que evita condiciones de carrera
 * y garantiza la coherencia de los datos compartidos. El resultado final es que el contador se incrementa de manera
 * correcta y consistente, gracias al uso del mutex para coordinar el acceso concurrente.
 */

public class SemaforoMutex {

    // Declaramos un mutex como un ReentrantLock
    static Lock mutex = new ReentrantLock();

    // Variable compartida por los hilos
    static int contador = 0;

    public static void main(String[] args) {
        // Creamos varios hilos
        Thread[] hilos = new Thread[5];
        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new Thread(new MiRunnable(), "Hilo-" + (i + 1));
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
            // Adquirimos el lock del mutex
            mutex.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " entró a la sección crítica.");
                // Simulamos una operación crítica
                for (int i = 0; i < 1000; i++) {
                    contador++;
                }
                System.out.println(Thread.currentThread().getName() + " salió de la sección crítica.");
            } finally {
                // Liberamos el lock del mutex en el bloque finally
                mutex.unlock();
            }
        }
    }
}

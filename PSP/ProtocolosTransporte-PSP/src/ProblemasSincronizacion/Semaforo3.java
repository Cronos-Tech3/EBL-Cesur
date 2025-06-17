package ProblemasSincronizacion;

import java.util.concurrent.Semaphore;

/*
 * Al declarar un semáforo con 3 permisos para realizar el mismo código, tenemos el problema normal de que no sabemos si si se han sumado los valores!*/

public class Semaforo3 {
    // Definimos un semáforo con tres permisos disponibles
    static Semaphore semaforo = new Semaphore(3);

    // Variable compartida por los hilos
    static int contador = 0;

    public static void main(String[] args) {
        // Creamos varios hilos
        Thread[] hilos = new Thread[6];
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
            try {
                // Esperamos adquirir un permiso del semáforo
                semaforo.acquire();
                System.out.println(Thread.currentThread().getName() + " entró a la sección crítica.");
                // Simulamos una operación crítica
                for (int i = 0; i < 1000; i++) {
                    contador++;
                }
                System.out.println(Thread.currentThread().getName() + " salió de la sección crítica.");
                // Liberamos el permiso del semáforo
                semaforo.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

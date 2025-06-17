import java.util.concurrent.Semaphore;

/*
* Programa donde múltiples hilos intentarán acceder a una sección crítica protegida por un semáforo.
* El semáforo asegura que solo un hilo pueda ejecutar la sección crítica a la vez,
* lo que evita condiciones de carrera y garantiza la coherencia de los datos compartidos.
* El resultado final es que el contador se incrementa de manera correcta y consistente,
* gracias al uso del semáforo para coordinar el acceso concurrente.
*/
public class Semaforo {
    // Definimos un semáforo con 1 permiso disponible
    static Semaphore semaforo = new Semaphore(1);

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

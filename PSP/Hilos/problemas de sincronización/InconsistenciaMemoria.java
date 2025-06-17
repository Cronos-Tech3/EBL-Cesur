/*
* Inconsistencia de memoria:
* Donde los cambios en una variable no son visibles para otros hilos debido a la falta de sincronización.
* El problema aquí es que no hay garantías de que los cambios realizados en la variable flag por un hilo
* sean visibles para el otro hilo. Esto es debido a la falta de sincronización en la modificación y lectura de la variable flag.
* Como resultado, ambos hilos pueden leer un valor desactualizado de flag en la caché local y no ver los cambios realizados por el otro hilo.
* */
public class InconsistenciaMemoria {
    static boolean flag = false;

    public static void main(String[] args) {
        // Crear e iniciar el primer hilo
        Thread hilo1 = new Thread(new MiRunnable(), "Hilo1");
        hilo1.start();

        // Crear e iniciar el segundo hilo
        Thread hilo2 = new Thread(new MiRunnable(), "Hilo2");
        hilo2.start();
    }

    static class MiRunnable implements Runnable {
        public void run() {
            if (!flag) {
                System.out.println(Thread.currentThread().getName() + ": Entrando en el bloque if");
                flag = true;
                System.out.println(Thread.currentThread().getName() + ": Modificando el valor de flag a true");
            } else {
                System.out.println(Thread.currentThread().getName() + ": El valor de flag es true, no se ejecuta el bloque if");
            }
        }
    }

    /*
    * Posibles soluciones:
    * Para solucionar este problema de inconsistencia de memoria, necesitaríamos usar mecanismos de sincronización,
    * como el uso de palabras clave synchronized, volatile, o clases en el paquete java.util.concurrent que
    * proporcionan operaciones atómicas y sincronización. Estas garantizan que los cambios realizados
    * en las variables sean visibles para todos los hilos.
    */

}

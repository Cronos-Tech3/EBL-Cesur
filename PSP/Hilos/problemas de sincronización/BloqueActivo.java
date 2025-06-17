/*
* Bloqueo Activo o Livock:
* Ocurre cuando los hilos están compitiendo activamente para adquirir
* un recurso que no está disponible, lo que resulta en un uso ineficiente
* de la CPU y una posible falta de progreso. Un ejemplo típico de bloqueo
* activo es cuando los hilos están esperando indefinidamente por un recurso que
* está siendo ocupado por otro hilo, y en lugar de esperar de manera pasiva,
* están haciendo constantemente comprobaciones activas para ver si pueden adquirir el recurso.*/
public class BloqueActivo {
    static boolean recursoDisponible = true;

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
            while (!recursoDisponible) {
                // Hacer comprobaciones activas mientras el recurso no esté disponible
                System.out.println(Thread.currentThread().getName() + ": El recurso no está disponible, esperando...");
                try {
                    Thread.sleep(1000); // Esperar un tiempo antes de volver a comprobar
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // Si el recurso está disponible, adquirirlo
            recursoDisponible = false;
            System.out.println(Thread.currentThread().getName() + ": Recurso adquirido.");
            // Realizar el trabajo con el recurso
            try {
                Thread.sleep(1000);
                // Liberar el recurso al finalizar el trabajo
                recursoDisponible = true;
                System.out.println(Thread.currentThread().getName() + ": Recurso liberado.");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    /*
    * Posibles soluciones:
    * Sería preferible usar mecanismos de sincronización, como esperar notificaciones (wait/notify),
    * barreras (CountDownLatch, CyclicBarrier), o utilizar objetos de bloqueo reentrante (ReentrantLock)
    * para que los hilos puedan esperar de manera pasiva y eficiente la disponibilidad del recurso.*/
}

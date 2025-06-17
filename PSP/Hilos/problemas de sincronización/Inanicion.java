/*
* La inanición (starvation):
* Ocurre cuando un hilo no puede obtener acceso a los recursos o la CPU que necesita para progresar
* porque otros hilos están acaparando esos recursos continuamente. Esto puede suceder en situaciones
* donde hay prioridades de hilos, sincronización inadecuada o mal manejo de semáforos.
* Debido a la competencia constante por el recurso compartido, es posible que los hilos
* con prioridades más bajas experimenten inanición, ya que los hilos con prioridades más altas
* pueden tener más oportunidades de acceso al recurso compartido y monopolizarlo,
* dejando a los hilos con prioridades más bajas esperando indefinidamente.*/
public class Inanicion {
    static int recursoCompartido = 0;

    public static void main(String[] args) {
        // Crear varios hilos con diferentes prioridades
        Thread hilo1 = new Thread(new MiRunnable(), "Hilo 1");
        hilo1.setPriority(Thread.MIN_PRIORITY); // Prioridad mínima

        Thread hilo2 = new Thread(new MiRunnable(), "Hilo 2");
        hilo2.setPriority(Thread.NORM_PRIORITY); // Prioridad normal

        Thread hilo3 = new Thread(new MiRunnable(), "Hilo 3");
        hilo3.setPriority(Thread.MAX_PRIORITY); // Prioridad máxima

        // Iniciar los hilos
        hilo1.start();
        hilo2.start();
        hilo3.start();
    }

    static class MiRunnable implements Runnable {
        public void run() {
            while (true) {
                /*
                * Aunque los hilos tienen diferentes prioridades, la sincronización se realiza utilizando un bloque synchronized,
                * lo que garantiza que solo un hilo pueda modificar el recurso compartido a la vez.*/
                synchronized (Inanicion.class) {
                    recursoCompartido++; // Incrementar el recurso compartido
                    System.out.println(Thread.currentThread().getName() + " incrementó el recurso compartido a " + recursoCompartido);
                }
                // Introducir una pequeña pausa para permitir que otros hilos compitan
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /*
    * Posibles soluciones:
    * Es importante diseñar sistemas con una distribución justa y eficiente de recursos,
    * considerando el uso de colas o mecanismos que garanticen un acceso equitativo a los
    * recursos compartidos. Además, es crucial evaluar la necesidad de prioridades de
    * hilos y su impacto en el rendimiento y la justicia del sistema.
    */
}

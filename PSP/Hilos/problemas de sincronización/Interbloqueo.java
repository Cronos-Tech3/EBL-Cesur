/*
* El interbloqueo o deadlock:
* Ocurre cuando dos o más hilos quedan atrapados esperando indefinidamente por recursos que se están utilizando entre ellos.*/
public class Interbloqueo {
    static Object recurso1 = new Object();
    static Object recurso2 = new Object();

    public static void main(String[] args) {
        // Hilo 1 intentará adquirir recurso1 y luego recurso2
        Thread hilo1 = new Thread(() -> {
            synchronized (recurso1) {
                System.out.println(Thread.currentThread().getName() + " adquirió recurso1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " esperando por recurso2");
                synchronized (recurso2) {
                    System.out.println(Thread.currentThread().getName() + " adquirió recurso2");
                }
            }
        }, "Hilo1");

        // Hilo 2 intentará adquirir recurso2 y luego recurso1
        Thread hilo2 = new Thread(() -> {
            synchronized (recurso2) {
                System.out.println(Thread.currentThread().getName() + " adquirió recurso2");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " esperando por recurso1");
                synchronized (recurso1) {
                    System.out.println(Thread.currentThread().getName() + " adquirió recurso1");
                }
            }
        }, "Hilo2");

        // Iniciar los hilos
        hilo1.start();
        hilo2.start();
        /*
        * Explicación: Si los hilos se ejecutan simultáneamente,
        * hay una posibilidad de que Hilo1 adquiera recurso1 y se detenga esperando por recurso2,
        * mientras que Hilo2 adquiera recurso2 y se detenga esperando por recurso1.
        * Ninguno de los hilos puede liberar su recurso actual porque están esperando al otro,
        * lo que resulta en un interbloqueo.*/

        /*
        * Posibles soluciones:
        * Es importante adquirir los recursos en el mismo orden en todos los hilos o usar estrategias
        * como la asignación de recursos compartidos de manera más cuidadosa para evitar este tipo de situaciones.
         */
    }
}

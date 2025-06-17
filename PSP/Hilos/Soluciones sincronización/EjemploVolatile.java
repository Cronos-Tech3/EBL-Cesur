/*
* La palabra clave volatile se utiliza para indicar que una variable puede ser modificada
* por múltiples hilos que operan concurrentemente. La variable volatile garantiza la visibilidad
* de las modificaciones realizadas por un hilo a todas las demás hebras.*/
public class EjemploVolatile {
    // Declaramos la variable booleana como volatile
    private static volatile boolean detenerHilo = false;

    /*
    * La palabra clave volatile se usa para garantizar que el cambio en el valor de detenerHilo
    * realizado por un hilo sea visible para todos los demás hilos. Sin la palabra clave volatile,
    * el segundo hilo podría almacenar en caché el valor de detenerHilo y no notar el
    * cambio realizado por el primer hilo. Sin embargo, con volatile,
    * el cambio se hace visible a todos los hilos inmediatamente.*/
    public static void main(String[] args) {
        // Creamos un hilo que cambia el valor de la variable detenerHilo después de 3 segundos
        Thread hilo1 = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            detenerHilo = true;
            System.out.println("El hilo 1 ha cambiado el valor de detenerHilo a true");
        });

        // Creamos otro hilo que se ejecutará mientras detenerHilo sea false
        Thread hilo2 = new Thread(() -> {
            while (!detenerHilo) {
                System.out.println("Hilo2 en ejecución...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Hilo2 detenido.");
        });

        // Iniciamos los hilos
        hilo1.start();
        hilo2.start();
    }
}

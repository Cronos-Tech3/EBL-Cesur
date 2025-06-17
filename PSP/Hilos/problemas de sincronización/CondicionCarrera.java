/*
* Condición de carrera:
* El problema de sincronización ocurre porque ambos hilos
* están cambiando la variable contador sin sincronización explícita.
* Como resultado, hay una posibilidad de que los cambio se superpongan,
* lo que puede llevar a resultados inconsistentes.*/
public class CondicionCarrera {

    public static int contador = 0;
    public static class ObjetoRunnableSuma implements Runnable{
        public void run(){
            for (int i = 0; i < 10000; i++) {
                contador++;
            }
        }
    }
    public static class ObjetoRunnableResta implements Runnable{
        public void run(){
            for (int i = 0; i < 10000; i++) {
                contador--;
            }
        }
    }
    public static void main(String[] args) {
        // Crear dos hilos
        Thread hilo1 = new Thread(new ObjetoRunnableSuma(), "Sumador");
        Thread hilo2 = new Thread(new ObjetoRunnableResta(), "Restador");

        // Iniciar los hilos
        hilo1.start();
        hilo2.start();

        // Esperar a que ambos hilos terminen
        try {
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Imprimir el valor final del contador
        System.out.println("Valor final del contador: " + contador);

        /*
        * Posibles soluciones:
        * Para solucionar este problema de sincronización y evitar la condición de carrera,
        * podríamos utilizar sincronización mediante bloques synchronized o
        * utilizar tipos de datos atómicos como AtomicInteger en lugar de un int simple.
        * Esto garantizaría que solo un hilo pueda acceder al contador en un momento dado.
        * */
    }
}

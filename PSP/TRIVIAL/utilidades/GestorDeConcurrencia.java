package TRIVIAL.TRIVIAL.utilidades;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;

/**
 * Clase GestorDeConcurrencia: permite ejecutar tareas de forma concurrente,
 * utilizando un semáforo para limitar el acceso simultáneo y un pool de hilos
 * para gestionar múltiples tareas.
 */
public class GestorDeConcurrencia {

    private final Semaphore semaforo;
    private final ExecutorService gestorHilos;

    /**
     * Constructor para inicializar el GestorDeConcurrencia.
     *
     * @param numeroMaxHilos El máximo de tareas concurrentes que se pueden ejecutar.
     */
    public GestorDeConcurrencia(int numeroMaxHilos) {
        this.semaforo = new Semaphore(numeroMaxHilos); // Controlar el acceso simultáneo
        this.gestorHilos = Executors.newFixedThreadPool(numeroMaxHilos); // Crear un pool fijo de hilos
    }

    /**
     * Método genérico para ejecutar tareas concurrentes que devuelven un resultado.
     *
     * @param tarea La tarea que se desea ejecutar, implementada como ConcurrentTask.
     * @param <T>   El tipo del resultado que devuelve la tarea.
     * @return El resultado de la tarea si se ejecuta correctamente. Devuelve null si ocurre un error.
     */
    public <T> T ejecutarTarea(ConcurrentTask<T> tarea) {
        try {
            semaforo.acquire(); // Solicitar permiso antes de ejecutar la tarea
            Future<T> future = gestorHilos.submit(tarea::execute); // Enviar tarea al pool
            return future.get(); // Bloquear hasta obtener el resultado
        } catch (Exception e) {
            System.err.println("Error al ejecutar la tarea: " + e.getMessage());
            return null; // Devuelve null en caso de error
        } finally {
            semaforo.release(); // Liberar el semáforo
        }
    }

    /**
     * Método para ejecutar tareas que no devuelven resultado (Runnable).
     *
     * @param tarea La tarea a ejecutar.
     */
    public void ejecutarTarea(Runnable tarea) {
        try {
            semaforo.acquire(); // Solicitar permiso de ejecución
            gestorHilos.execute(() -> {
                try {
                    tarea.run(); // Ejecutar la tarea
                } finally {
                    semaforo.release(); // Liberar el semáforo al finalizar la tarea
                }
            });
        } catch (InterruptedException e) {
            System.err.println("Error al ejecutar la tarea: " + e.getMessage());
            Thread.currentThread().interrupt(); // Restaurar el estado de interrupción
        }
    }

    /**
     * Método para acceder a recursos compartidos de manera controlada mediante un semáforo.
     *
     * @param recurso El nombre del recurso (para fines de diagnóstico).
     * @param tarea   La tarea a ejecutar sobre el recurso compartido.
     */
    public void accederRecursoCompartido(String recurso, Runnable tarea) {
        try {
            semaforo.acquire(); // Solicitar permiso de acceso
            gestorHilos.execute(() -> {
                System.out.println("Accediendo al recurso compartido: " + recurso);
                try {
                    tarea.run(); // Ejecutar la tarea con acceso al recurso
                } finally {
                    semaforo.release(); // Liberar el recurso al finalizar
                    System.out.println("Recurso liberado: " + recurso);
                }
            });
        } catch (InterruptedException e) {
            System.err.println("Error al acceder al recurso compartido: " + e.getMessage());
            Thread.currentThread().interrupt(); // Restaurar el estado de interrupción
        }
    }

    /**
     * Apaga el gestor de hilos, permitiendo que las tareas actuales terminen su ejecución.
     */
    public void apagar() {
        gestorHilos.shutdown(); // Apagar el gestor de hilos de manera ordenada
        System.out.println("Gestor de concurrencia apagado correctamente.");
    }

    /**
     * Interfaz funcional para definir tareas concurrentes con un resultado.
     *
     * @param <T> El tipo del resultado devuelto por la tarea.
     */
    @FunctionalInterface
    public interface ConcurrentTask<T> {
        T execute();
    }
}
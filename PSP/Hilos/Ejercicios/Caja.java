package Ejercicio2;

import java.util.concurrent.Semaphore;

public class Caja {
    private String nombre;
    Semaphore semaforo;

    public Caja(String nombre, Semaphore semaforo) {
        this.nombre = nombre;
        this.semaforo = semaforo;
    }

    public void procesarCompra(String cliente, int productos){


        try {
            semaforo.acquire(); //obtener permiso
            System.out.println("La caja " + nombre + " recibe al cliente " + cliente);

            for (int i = 0; i < productos ; i++) {
                //procesar productos
                System.out.println("Procesando producto " + (i+1) + " de " + cliente);
                procesarProductos(cliente, i);
                System.out.println("Producto " + (i+1) + " de " + cliente + " procesado"  );

            }

            //liberar permiso
            System.out.println("Productos de " + cliente + " procesados");
            semaforo.release();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    private void procesarProductos(String cliente, int numeroProducto){
        try {
            int tiempoProcesamiento = (int) (Math.random()*10000);
            Thread.sleep(tiempoProcesamiento);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

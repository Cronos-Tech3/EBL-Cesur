package Ejercicio2;

import java.util.concurrent.Semaphore;

public class Supermercado {
    public static void main(String[] args) {
        Semaphore semaforo = new Semaphore(2);
        Caja caja1 = new Caja("Caja 1", semaforo);
        Caja caja2 = new Caja("Caja 2", semaforo);
        Caja caja3 = new Caja("Caja 3", semaforo);

        CajaHilo cajahilo1 = new CajaHilo(caja1, "Pepe", 5);
        CajaHilo cajahilo2 = new CajaHilo(caja2, "María", 3);
        CajaHilo cajahilo3 = new CajaHilo(caja3, "Carlos", 6);

        cajahilo1.start();
        cajahilo2.start();
        cajahilo3.start();

    }
}

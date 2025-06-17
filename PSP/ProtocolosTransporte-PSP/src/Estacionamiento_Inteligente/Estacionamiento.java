package Estacionamiento_Inteligente;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Estacionamiento {
    private final int capacidadMaxima = 5;
    private final Semaphore semaforo = new Semaphore(capacidadMaxima);
    private final ArrayList<Coche> cochesAparcados = new ArrayList<>();

    public synchronized boolean entrar(Coche coche) {
        if (coche.esVip()) {
            try {
                semaforo.acquire();
                if (cochesAparcados.size() >= capacidadMaxima) {
                    desalojarCocheNormal(coche);
                }
                cochesAparcados.add(coche);
                System.out.println(coche + " ha entrado.");
                return true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            try {
                if (semaforo.tryAcquire(5, TimeUnit.SECONDS)) {
                    synchronized (this) {
                        cochesAparcados.add(coche);
                        System.out.println(coche + " ha entrado.");
                    }
                    return true;
                } else {
                    System.out.println(coche + " no ha encontrado plaza y se marcha.");
                    return false;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public synchronized void salir(Coche coche) {
        if (cochesAparcados.remove(coche)) {
            semaforo.release();
            System.out.println(coche + " ha salido.");
        }
    }

    private synchronized void desalojarCocheNormal(Coche cocheVip) {
        for (Coche coche : cochesAparcados) {
            if (!coche.esVip()) {
                cochesAparcados.remove(coche);
                semaforo.release();
                System.out.println(coche + " ha sido desalojado por " + cocheVip);
                break;
            }
        }
    }
}

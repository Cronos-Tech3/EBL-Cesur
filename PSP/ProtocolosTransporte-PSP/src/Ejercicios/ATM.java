package Ejercicios;

import java.util.concurrent.Semaphore;

public class ATM extends Thread{
    private String name;
    private Semaphore semaforo;

    public ATM(String name, Semaphore semaforo){
        this.name = name;
        this.semaforo = semaforo;
    }

    @Override
    public void run(){
        int aleatorio = (int)(Math.random()*8)+3;
        try {
            semaforo.acquire();
            for (int i = 0; i < aleatorio; i++) {
                System.out.println(name + " está en uso.");
                sleep(1000);
            }
            System.out.println("Sale del " + name);
            semaforo.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

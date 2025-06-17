package ejercicios;

import java.util.concurrent.Semaphore;

public class ATMMain {
    public static void main(String[] args) {
        ATM[] array = new ATM[5];
        Semaphore semaforo = new Semaphore(3);
        for (int i = 0; i < 5; i++) {
            array[i] = new ATM("ATM-"+i, semaforo);
            array[i].start();
        }


    }
}

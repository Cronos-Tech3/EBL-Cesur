package Estacionamiento_Inteligente;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Estacionamiento estacionamiento = new Estacionamiento();
        ArrayList<Coche> coches = new ArrayList<>();

        for (int i = 1; i <= 15; i++) {
            coches.add(new Coche("Coche " + i, i % 3 == 0, estacionamiento));
        }

        for (Coche coche : coches) {
            coche.start();
        }

        for (Coche coche : coches) {
            try {
                coche.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Todos los coches han intentado aparcar.");
    }
}

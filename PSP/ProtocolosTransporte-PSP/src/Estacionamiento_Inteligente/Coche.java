package Estacionamiento_Inteligente;

public class Coche extends Thread {
    private final String nombre;
    private final boolean vip;
    private final Estacionamiento estacionamiento;

    public Coche(String nombre, boolean vip, Estacionamiento estacionamiento) {
        this.nombre = nombre;
        this.vip = vip;
        this.estacionamiento = estacionamiento;
    }

    public boolean esVip() {
        return vip;
    }

    @Override
    public void run() {
        if (estacionamiento.entrar(this)) {
            try {
                Thread.sleep((int) (Math.random() * 4000) + 2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            estacionamiento.salir(this);
        }
    }

    @Override
    public String toString() {
        return (vip ? "[VIP] " : "[Normal] ") + nombre;
    }
}

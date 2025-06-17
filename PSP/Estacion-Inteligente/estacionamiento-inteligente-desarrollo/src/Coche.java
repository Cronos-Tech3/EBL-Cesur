public class Coche extends Thread {

    private String nombre;
    private boolean vip;

    private Estacionamiento estacionamiento;

    public Coche(String nombre, boolean vip, Estacionamiento estacionamiento) {
        this.nombre = nombre;
        this.vip = vip;
        this.estacionamiento = estacionamiento;
    }

    public boolean isVip() {
        return vip;
    }

    public boolean esVip() {
        if (vip) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public void run() {
        try {
            if(estacionamiento.entrar(this)){
                Thread.sleep((2+(int)(Math.random()*5))*1000);
                estacionamiento.salir(this);
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {

        if (vip) {
            return "[" + vip + "]" + nombre;
        } else {
            return "[Normal]" + nombre;
        }
    }
}

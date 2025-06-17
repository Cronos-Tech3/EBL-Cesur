package Ejercicio2;

public class CajaHilo extends Thread {
    private Caja caja;
    private String cliente;
    private int productos;

    public CajaHilo(Caja caja, String cliente, int productos) {
        this.caja = caja;
        this.cliente = cliente;
        this.productos = productos;
    }

    @Override
    public void run(){
        caja.procesarCompra(cliente, productos);
    }
}

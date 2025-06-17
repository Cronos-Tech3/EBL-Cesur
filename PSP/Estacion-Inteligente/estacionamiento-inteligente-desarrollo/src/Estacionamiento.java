import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Estacionamiento {

    private final int cantidadMaxima = 5;
    private final Semaphore semaforo = new Semaphore(cantidadMaxima);
    private final ArrayList<Coche> cochesAparcados = new ArrayList<>();

    public boolean entrar(Coche coche) throws InterruptedException {

        if(coche.isVip()){
            semaforo.acquire();
            if(cochesAparcados.size()>= cantidadMaxima){
                desalojarCocheNormal(coche);
            }else{
                cochesAparcados.add(coche);
            }
            semaforo.release();
            return true;

        }else{
            if(semaforo.tryAcquire(5, TimeUnit.SECONDS)){
                if(cochesAparcados.size()>= cantidadMaxima){
                    cochesAparcados.add(coche);
                    return true;
                }

            }
            return false;
        }

    }

    public synchronized void salir(Coche coche){
        cochesAparcados.remove(coche);
    }

    public synchronized void desalojarCocheNormal(Coche cocheVip){
        for (int i = 0; i < cochesAparcados.size(); i++) {
            if(!cochesAparcados.get(i).isVip()){
                cochesAparcados.remove(i);
                cochesAparcados.add(cocheVip);
                System.out.println("Se ha sacado un coche normal para aparcar uno vip");
                break;
            }

        }
    }

}

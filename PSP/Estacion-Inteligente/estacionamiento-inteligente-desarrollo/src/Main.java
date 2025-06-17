import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Estacionamiento e = new Estacionamiento();
        ArrayList<Coche> cochesAparcados = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            boolean vip=(i%3==0);
            Coche c =new Coche("Coche" +i, vip, e);
            cochesAparcados.add(c);
        }

        for(Coche c:cochesAparcados){
            c.start();
        }

        for(Coche c:cochesAparcados){
            try {
                c.join();
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }

    }
}

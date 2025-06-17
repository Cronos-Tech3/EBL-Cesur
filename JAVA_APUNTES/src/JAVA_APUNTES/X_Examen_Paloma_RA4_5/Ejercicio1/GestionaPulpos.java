package JAVA_APUNTES.X_Examen_Paloma_RA4_5.Ejercicio1;

public class GestionaPulpos {
    public static void main(String[] args) {
        Pulpo p = new Pulpo("paloma");
        Tentaculo t1 = new Tentaculo(1, 10);
        Tentaculo t2 = new Tentaculo(2, 12);
        Tentaculo t3 = new Tentaculo(1, 30);
        System.out.println("Tentaculos insertados: " + p.anadirTentaculo(t1));
        System.out.println("Tentaculos insertados: " + p.anadirTentaculo(t2));

        if(p.anadirTentaculo(t3) == -1){
            System.out.println("No se ha podido insertar t3");
        }
        System.out.println(p);
        System.out.println(p.crecerTentaculo(1, 3));
        System.out.println(p.crecerTentaculo(2, 2));
        if(p.crecerTentaculo(22, 2) == -1){
            System.out.println("Ese id no existe");
        }
        System.out.println(p);

    }

}

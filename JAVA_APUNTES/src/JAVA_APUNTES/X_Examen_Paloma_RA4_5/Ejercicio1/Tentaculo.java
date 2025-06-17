package JAVA_APUNTES.X_Examen_Paloma_RA4_5.Ejercicio1;

public class Tentaculo {
    private int id;
    public int longitud;

    public Tentaculo(int id, int longitud) {
        this.id = id;
        this.longitud = longitud;
    }

    public int getId() {
        return id;
    }

    public int crecer(int longitud){
        this.longitud += longitud;
        return this.longitud;
    }

    @Override
    public String toString() {
        return "Tentaculo{" + id +
                "}-longitud:{" + longitud +
                '}';
    }
}

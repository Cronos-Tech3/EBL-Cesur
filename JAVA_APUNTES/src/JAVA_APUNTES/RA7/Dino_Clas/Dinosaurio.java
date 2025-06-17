package JAVA_APUNTES.RA7.Dino_Clas;

import java.util.ArrayList;
import java.util.List;

/* EXPLICACIÓN
    En esta clase creamos el dinosaurio. Las caracterisrica las heredamos de
    la clase CaracterísticaDino e implementa las interfaces IVolador y
    ICaracterizable
 */
public class Dinosaurio extends CaracteristicaDino implements IVolador, ICaracterizable {

    //ATRIBUTOS//
    private String nombre;
    private int alturaMaxima;
    private List<String> caracteristicas;


    //CONSTRUCTOR//
    public Dinosaurio(String descripcion, int edad, String color, double longitud, String nombre, int alturaMaxima) {
        super(descripcion, edad, color, longitud);
        this.nombre = nombre;
        this.alturaMaxima = alturaMaxima;
        this.caracteristicas = new ArrayList<>();
    }

    // GETTERS Y SETTERS//
    public String getNombre() {
        return nombre;
    }

    public int getAlturaMaxima() {
        return alturaMaxima;
    }


    // METODOS//

        @Override
    public void agregarCaracteristica(String caracteristica) {
        caracteristicas.add(caracteristica);
        System.out.println("Se ha añadido una nueva característica: " + caracteristica);
    }

    @Override
    public void eliminarCaracteristica(String caracteristica) {
        caracteristicas.remove(caracteristica);
        System.out.println("Se ha eliminado la característica: " + caracteristica);
    }

    @Override
    public void mostrarCaracteristicas() {
        for (String caracteristica : caracteristicas) {
            System.out.println(caracteristica);
        }
    }

    @Override
    public void despegar() throws AlturaInsuficienteException {
        if (alturaMaxima < 50) {
            throw new AlturaInsuficienteException("La altura máxima es insuficiente para despegar.");
        } else {
            System.out.println("El dinosaurio " + nombre + " ha despegado y está volando.");
        }
    }

    @Override
    public int calcularAlturaMaxima(int velocidad, int tiempo) throws AlturaInsuficienteException {
        int altura = velocidad * tiempo;
        if (altura < alturaMaxima) {
            throw new AlturaInsuficienteException("La altura calculada es insuficiente.");
        }
        return altura;
    }

    @Override
    public int calcularDistanciaRecorrida(int velocidad, int tiempo) {
        return velocidad * tiempo;
    }
}

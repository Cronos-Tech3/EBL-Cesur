package Enrique_Benito_Lopez;

import java.util.ArrayList;

public abstract class Mago {
    private String nombre;
    private int edad;
    private ArrayList<Hechizo> hechizos = new ArrayList<>();

    public Mago(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public void agregarHechizo(Hechizo hechizo){
        hechizos.add(hechizo);
    }

    public ArrayList<Hechizo> getHechizos() {
        return hechizos;
    }

    public boolean eliminarHechizo(String hechizo) throws SinHechizosException{
        int contador = 0;
        if (hechizos.isEmpty()) throw new SinHechizosException();

        for (Hechizo h : hechizos) {

            if(h.getNombre().equalsIgnoreCase(hechizo)){
                hechizos.remove(contador);
                return true;
            }
            contador++;
        }
        return false;
    }

    public void mostrarHechizos() throws SinHechizosException{
        if(hechizos.isEmpty()) throw new SinHechizosException();
        for (Hechizo h : hechizos){
            System.out.println(h.toString());
        }
    }

    public abstract void usarHechizo() throws PotenciaInsuficienteException, SinHechizosException;


    @Override
    public String toString() {
        return "Mago{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", hechizos=" + hechizos +
                '}';
    }
}

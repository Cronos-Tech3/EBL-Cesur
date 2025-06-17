package JAVA_APUNTES.ARRAYS.ArrayList_Concesionario;

import java.util.LinkedList;

public class ConcesionarioLL {

    private String nombreConcesionario;

    private String direccionFisica;

    private String telefono;

    private int cantidadVehiculos;

    private LinkedList<Vehiculo> inventario;


    public ConcesionarioLL(String nombreConcesionario, String direccionFisica, String telefono) {
        this.nombreConcesionario = nombreConcesionario;
        this.direccionFisica = direccionFisica;
        this.telefono = telefono;

        inventario = new LinkedList<Vehiculo>();
    }

    public String getNombreConcesionario() {
        return nombreConcesionario;
    }

    public void setNombreConcesionario(String nombreConcesionario) {
        this.nombreConcesionario = nombreConcesionario;
    }

    public String getDireccionFisica() {
        return direccionFisica;
    }

    public void setDireccionFisica(String direccionFisica) {
        this.direccionFisica = direccionFisica;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getCantidadVehiculos() {
        return cantidadVehiculos;
    }

    public void setCantidadVehiculos(int cantidadVehiculos) {
        this.cantidadVehiculos = cantidadVehiculos;
    }

    public LinkedList<Vehiculo> getInventario() {
        return inventario;
    }

    public void setInventario(LinkedList<Vehiculo> inventario) {
        this.inventario = inventario;
    }

    public boolean agregarVehiculo(Vehiculo vehiculo){
        cantidadVehiculos++;
        return inventario.add(vehiculo);
    }

    public void quitarPrimero() {
        inventario.remove();
    }

    public boolean quitarVehiculo(int posicion){
        if (posicion>=0 && posicion< inventario.size()){
            inventario.remove(posicion);
            cantidadVehiculos--;
            return true;
        }
        return false;
    }

    public void mostrarInventario(){

        for (Vehiculo v : inventario) {
            if (v!=null){
                //System.out.println(v.mostrarDetalle());  Todo  Aqui faltan cosas
            }

        }



    }

}


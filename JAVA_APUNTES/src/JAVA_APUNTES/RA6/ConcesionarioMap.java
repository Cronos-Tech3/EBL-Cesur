package JAVA_APUNTES.RA6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ConcesionarioMap {
    private String nombre;
    private String direccion;
    private String telefono;
    private HashMap<String, Vehiculo> inventario;
    private int cantidadVehiculos;

    public ConcesionarioMap(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        inventario = new HashMap<String,Vehiculo>();
        //cantidadVehiculos = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public HashMap<String, Vehiculo> getInventario() {
        return inventario;
    }

    public void setInventario(HashMap<String, Vehiculo> inventario) {
        this.inventario = inventario;
    }

    public int getCantidadVehiculos() {
        return cantidadVehiculos;
    }

    public void setCantidadVehiculos(int cantidadVehiculos) {
        this.cantidadVehiculos = cantidadVehiculos;
    }

    public boolean agregarVehiculo(Vehiculo vehiculo, String clave){  //todo son dos por poner

        //si no existe esa clave lo voy a sobreescribir
        if (!inventario.containsKey(clave)){
            cantidadVehiculos++;
            inventario.put(clave, vehiculo);
            return true;
        } else {

        }

        return true;


    }

    public boolean quitarVehiculo( String clave){
        //si existe lo borro
        if(inventario.containsKey(clave)){
            inventario.remove(clave);
            cantidadVehiculos--;
            return true;
        }
        return false;
    }

    public void mostrarInventario(){
        //System.out.println(inventario); //también vale así
        for(Vehiculo v : inventario.values()){
            if(v!=null){
                System.out.println(v.generarDetalles());
            }
        }
        //solo las claves
        for (String clave : inventario.keySet()){
            System.out.println(clave);
        }

        // Todo Remplazarlo





    }
}

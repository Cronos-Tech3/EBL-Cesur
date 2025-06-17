package JAVA_APUNTES.A_Javadoc.soluciones_Paloma.Ej_Conce_ArraysRA4;
import java.util.HashMap;
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
        inventario = new HashMap<String, Vehiculo>();
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

    public boolean agregarVehiculo(Vehiculo vehiculo, String clave){
        //si existe esa clave, lo voy a sobreescribir, por lo tanto no sumo un vehículo
        //si no existe esa clave, sumo un nuevo vehículo
        if(!inventario.containsKey(clave)){
            cantidadVehiculos++;
        }
        inventario.put(clave, vehiculo); //si no existe ese elemento lo añade, si existe lo sobreescribe
        return true;
    }

    public boolean agregarVehiculoSinSobreescribir(Vehiculo vehiculo, String clave){
        //si existe esa clave, lo voy a sobreescribir, por lo tanto no sumo un vehículo
        //si no existe esa clave, sumo un nuevo vehículo
        if(!inventario.containsKey(clave)){
            cantidadVehiculos++;
            inventario.put(clave, vehiculo); //si no existe ese elemento lo añade, si existe lo sobreescribe
            return true;
        }

        return false;
    }
    public boolean quitarVehiculo(String clave){
        //si existe lo borro
        if(inventario.containsKey(clave)){
            inventario.remove(clave);
            cantidadVehiculos--;
            return true;
        }
        return false;
    }

    public void mostrarInventario(){

        //aqui solo estoy recorriendo los valores
        for(Vehiculo v : inventario.values()){
            if(v!=null){
                System.out.println(v.generarDetalles());
            }
        }
        //solo las claves
        for(String clave: inventario.keySet()){
            System.out.println(clave);
        }
        //aqui obtengo tanto la clave como el valor
        for(Map.Entry<String, Vehiculo> entrada : inventario.entrySet()){
            System.out.println(entrada.getKey() + ":" + entrada.getValue());
        }
    }
}

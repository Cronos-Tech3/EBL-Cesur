package JAVA_APUNTES.A_Javadoc.soluciones_Paloma.Ej_Conce_ArraysRA4;

public class Concesionario {
    private String nombre;
    private String direccion;
    private String telefono;
    private Vehiculo[] inventario;
    private int cantidadVehiculos;

    public Concesionario(String nombre, String direccion, String telefono, int capacidad) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        inventario = new Vehiculo[capacidad];
        //cantidadVehiculos = 0;
    }

    public Concesionario(String nombre, String direccion, String telefono, Vehiculo[] inventario, int cantidadVehiculos) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.inventario = inventario;
        this.cantidadVehiculos = cantidadVehiculos;
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

    public Vehiculo[] getInventario() {
        return inventario;
    }

    public void setInventario(Vehiculo[] inventario) {
        this.inventario = inventario;
    }

    public int getCantidadVehiculos() {
        return cantidadVehiculos;
    }

    public void setCantidadVehiculos(int cantidadVehiculos) {
        this.cantidadVehiculos = cantidadVehiculos;
    }

    public boolean agregarVehiculo(Vehiculo vehiculo){
        boolean resultado = false;
        /*
        if(cantidadVehiculos< inventario.length){
            inventario[cantidadVehiculos] = vehiculo;
            cantidadVehiculos++;
            resultado = true;
        }
        */
        for (int i = 0; i < inventario.length; i++) {
            if(inventario[i]==null){
                inventario[i] = vehiculo;
                cantidadVehiculos++;
                resultado = true;
                break;
            }
        }
        return resultado;
    }

    public boolean quitarVehiculo(int posicion){
        boolean resultado = false;

        if(posicion < inventario.length && posicion>=0){
            if(inventario[posicion] != null){
                inventario[posicion] = null;
                resultado = true;
                cantidadVehiculos--;
            }
        }
        /*
        try{
            if(inventario[posicion] != null){
                inventario[posicion] = null;
                resultado = true;
                cantidadVehiculos--;
            }
        }catch (Exception e){
            resultado = true;
        }
        */
        return resultado;
    }

    public void mostrarInventario(){
        //System.out.println(Arrays.toString(inventario));
        for(Vehiculo v : inventario){
            if(v!=null){
                System.out.println(v.generarDetalles());
            }

        }
    }
}

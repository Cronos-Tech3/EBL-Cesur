package JAVA_APUNTES.RA7.Dino_Clas;

/*
EXPLICACIÓN
    Define los métodos que van a permitir modificar las caracteristicas
    adicionales del dinosaurio
 */
public interface ICaracterizable {

    // Metodo para agregar características
    void agregarCaracteristica(String caracteristica);

    // Metodo para eliminar una caracteristica existente ya
    void eliminarCaracteristica(String caracteristica);

    //Metodo que muestra las caracterisitas del dinosaurio
    void mostrarCaracteristicas();
}

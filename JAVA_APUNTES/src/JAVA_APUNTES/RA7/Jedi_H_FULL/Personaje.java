package JAVA_APUNTES.RA7.Jedi_H_FULL;


import java.util.ArrayList;

/* EXPLICACIÓN
Se trata de una clase abstracta que define las caracterísiticas y comportamientos de un personaje dentro del
sistema
 */

public abstract class Personaje {

    // ATRIBUTOS//
    private String nombre;
    private int edad;
    private ArrayList<Habilidad> habilidades = new ArrayList<>();

    // CONSTRUCTOR//
    // Inicializa el nombre y la edad del personaje//
    public Personaje(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    // GETTER Y SETTERS//
        // En este caso solo se ha preciso un getter el cual devulva la lista de habilidades del personaje.

    public ArrayList<Habilidad> getHabilidades() {
        return habilidades;
    }

    //METODOS//

    //AGREAR HABILIDAD//
    /* FUNCIONAMIENTO
      Agrega la hailidad a la lista de habilidades del personaje
     */
    public void agregarHabilidad(Habilidad habilidad){
        habilidades.add(habilidad);
    }

    //ELIMINAR HABILIDAD//
        /* FUNCIONAMIENTO
        Elimina una hbailidad de la lista de habilidades del personaje
        Si la lsita de habilidades está vacia lanza la excepción SinHbailidadesExcepción.
        Devuelve true en caso de encontrar la habilidad y eliminarla
        Devulve false en caso contratio
        */
    public boolean eliminarHabilidad(String habilidad) throws SinHabilidadesException {
        //1º) CONTADOR -> Para llevar la cuenta del índice de la habilidad en la lista
        int counter = 0;

        //2º) VERIFICACIÓN DE LA LISTA DE HABILIDADES
        /*
        Verificacmos si la lista está vacia
            En caso afirmativo se lanza la excepción SinHabilidadesExcepción indicando al usuario que no hay
            habilidades para eliminar
         */
        if (habilidades.isEmpty()) throw new SinHabilidadesException();

        //3º)RECORREMOS LA LISTA DE HABILIDADES (FOR-EACH)
        for (Habilidad h : habilidades){

            //4º) COMPARATIVA DE NOMBRE DE HABILIDADES
            /*
            Comparamos el nombre de cada habilidad con el nombre de la habilidad que se desea eliminar.
            En este caso se ignora mayusculas y minusculas
             */
            if (h.getNombre().equalsIgnoreCase(habilidad)){

                // 5º)Eliminación de la habilidad
                /*
                En caso de encontrarse la habilidad la elimina la misma usando el contador inicial
                Devuelve un true e indica que la habilidad ha sido eliminada de forma correcta.
                 */
                habilidades.remove(counter);
                return true;
            }
            // EN CASO DE NO ENCONTRAR LA HBAILIDAD SE INCREMENTA EL INDICA Y SE PASA AL SIGUIENTE
            counter++;
        }
        return false;
    }

    // MOSTRAR HABILIDAD
    /*
     Miestra la lista de habidades del personje. En caso de es de estar vacia lanza la excepción SinHabilidadException.
     */
    public void mostrarHabilidades() throws SinHabilidadesException{
        if (habilidades.isEmpty())throw new SinHabilidadesException();
        for (Habilidad h : habilidades){
            System.out.println(h.toString());
        }
    }

    public abstract void usarFuerza() throws SinHabilidadesException;
}
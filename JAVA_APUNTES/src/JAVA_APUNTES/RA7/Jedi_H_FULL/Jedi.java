package JAVA_APUNTES.RA7.Jedi_H_FULL;

import java.util.ArrayList;
/* EXPLICACIÓN
        Esta clase implementa la interfaz IFuerza ->
            Proporciona implementación de los métodos definidos en Ifuerza
 */

public class Jedi extends Personaje implements IFuerza{

    //ATRIBUTOS//
    private int nivelFuerza;
    private String colorSable;


    //CONSTRUCTOR (con super)
    public Jedi(String nombre, int edad, int nivelFuerza, String colorSable) {
        super(nombre, edad);
        this.nivelFuerza = nivelFuerza;
        this.colorSable = colorSable;
    }

    /*Funcionamiento ->
        Recorre la lista de habilidades de los Jedi y suma la potencia de cada una de las habilidades
        En caso de esta vacia se lanza una excepción -> SinHabilidadesException
       */
    @Override
    public int calcularSumaPotenciaHabilidades() throws SinHabilidadesException {
        ArrayList<Habilidad> habilidades = getHabilidades();
        int total = 0;
        for (Habilidad h : habilidades){
            total += h.getPotencia();
        }
        if (habilidades.isEmpty())throw new SinHabilidadesException();
        return total;
    }


    /*Funcionamiento ->
        Este metodo recorre la lista de habilidades del Jedi y encuentra la habilidad con la mayor potencia.
        Si la lista de habilidades está vacía, lanza una excepción SinHabilidadesException.
       */
    @Override
    public Habilidad obtenerHabilidadPotenciaMaxima() throws SinHabilidadesException {
        ArrayList<Habilidad> habilidades = getHabilidades();
        int max_potencia = Integer.MIN_VALUE;
        int index = 0;
        int counter = 0;
        if (habilidades.isEmpty())throw new SinHabilidadesException();
        for (Habilidad h : habilidades){
            if(h.getPotencia() > max_potencia){
                max_potencia = h.getPotencia();
                index = counter;
            }
            counter++;
        }
        return habilidades.get(index);
    }

    /*Funcionamiento ->
    Este metodo recorre la lista de habilidades del Jedi y encuentra la habilidad con la mayor potencia.
    Si la lista de habilidades está vacía, lanza una excepción SinHabilidadesException.
            */
    @Override
    public void usarFuerza() throws SinHabilidadesException, PotenciaInsuficienteException {

        // 1º Obtenemos la habilidad con mayor potencia
                 /*
                    El metodo llama a obtenerHabilidadPotenciaMaxima para encontrar
                    la habilidad con la mayor potencia que posee el Jedi. Si el Jedi no tiene habilidades,
                    este metodo lanzara una excepcion SinHabilidadesException.
         */
        Habilidad mejorHabilidad = obtenerHabilidadPotenciaMaxima();

        // 2º VERIFICAMOS EL NIVEL DE FUERZA
        /*
                    Se compara la potencia de la habilidad más potente con el nivel de fuerza del Jedi.
                    Si la potencia de la habilidad es mayor que el nivel de fuerza del Jedi,
                    se lanza una excepción PotenciaInsuficienteException.
         */
        if (mejorHabilidad.getPotencia() > nivelFuerza)throw new PotenciaInsuficienteException();

        //3º EXPONEMOS LA HABILIDAD Y LA SUMA DE LA POTENCIA
        /*
                Si el Jedi tiene suficiente nivel de fuerza, se imprime la habilidad más potente
                y la suma de la potencia de todas las habilidades del Jedi.
         */
        System.out.println(mejorHabilidad);
        System.out.println("Este es el total de la potencia de las habilidades: " + calcularSumaPotenciaHabilidades());
    }
}

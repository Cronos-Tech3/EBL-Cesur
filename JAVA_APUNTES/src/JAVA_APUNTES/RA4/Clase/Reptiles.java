package JAVA_APUNTES.RA4.Clase;

public class Reptiles {

    //atributos de Reptibles

    int edad;

    boolean escamoso;

    boolean venenoso;

    boolean carnivoro;

    double longitud;

    String especie;

    String desplazamiento;



    public void tieneEscamas(){
        if(escamoso){
            System.out.println("Su cuerpo esta compuesto de pequeñas escamas");
        }else{
            System.out.println("No es de la familia escamosa");
        }
    }

    public void tieneVeneno(){
        if(venenoso){
            System.out.println("Es venenoso");
        }else{
            System.out.println("No es venenoso");
        }
    }

    public void come(){
        if(carnivoro){
            System.out.println("Come carne");
        }else{
            System.out.println("no come carne");
        }
    }
    public String moverse(){
        String resultado = "";
        if(desplazamiento.equals("reptar")){
            resultado = "repta";
        } else if (desplazamiento.equals("cuadripedo")) {
            resultado = "se mueve a cuatro patas";
        }
        return resultado;
    }





}

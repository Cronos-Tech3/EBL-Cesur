package JAVA_APUNTES.A_Javadoc.soluciones_Paloma.Ej_Clase_RA4;

public class Mamifero {
    int numPatas;
    boolean carnivoro;
    String especie;
    String desplazamiento;
    boolean extinto;

    public void comeCarne(){
        if(carnivoro){
            System.out.println("come carne");
        }else{
            System.out.println("no come carne");
        }
    }

    public String moverse(){
        String resultado = "";

        if(desplazamiento.equals("volar")){
            resultado="vuela";
        }else if(desplazamiento.equals("nadar")){
            resultado="nada";
        }else{
            resultado="camina";
        }

        return resultado;
    }

    public void comprobarExtincion(boolean sigue){
        if(!sigue){
            extinto=true;
            System.out.println("Se ha extinguido la especie");
        }
    }
}

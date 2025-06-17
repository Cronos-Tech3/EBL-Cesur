package JAVA_APUNTES.RA4.Clase;

public class Arbol {
    // atributos para la clase Arbol
    double altura;
    private int edad;
    boolean caduca;
    String especie;

    //Metodos
    //void si es void no devuelve nada
    //modificador de acceso (public) tipo de dato (void si no devuelve), nombre(siempre empiece con minuscula)
    //entre parentesis tendremos los parametros que le llegan al método

    public void caerhojas(){
        if(caduca) {
            System.out.println("se caen las hojas");
        }else{
            System.out.println("no se caen las hojas");
        }
    }

    public int sumarAnio(int num){
        edad+=num;
        return edad;
    }

    //creamos un constructor vacio nombre del constructor = al de la clase
    public Arbol(double altura, int edad, boolean caduca, String especie){
        if (altura<=0){
            this.altura =1;
        }else {
            this.altura = altura;
        }


        this.edad = edad;
        if (especie.equals("pino")){
            this.caduca = false;
        }else {
            this.caduca = true;
        }

        this.especie = especie;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    //metodo static que siempre esta ahi y no se necesita instanciarla para llamarla
    public static void cosasArbol(){
        System.out.println("los arboles susurran a las palmeras");
    }
}

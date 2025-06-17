package JAVA_APUNTES.A_Javadoc.soluciones_Paloma.Ej_Clase_RA4;

public class Arbol {
    public double altura;
    private int edad;
    boolean caduca;
    String especie;

    public Arbol(double altura, int edad, String especie){
        if(altura <=0){
            this.altura = 1;
        }else{
            this.altura = altura;
        }

        this.edad = edad;
        if(especie.equals("pino")){
            this.caduca = false;
        }else{
            this.caduca = true;
        }

        this.especie = especie;
    }


    //modificador de acceso, tipo de dato de retorno (void si no devuelve), nombre (siempre empieza con minúscula)
    //entre paréntesis tendremos los parámetros que le llegan al método
    public void caerHojas(){
        if(caduca){
            System.out.println("se caen las hojas");
        }else{
            System.out.println("no se caen las hojas");
        }
    }
    public int sumarAnio(int num){
        edad += num;
        return edad;
    }
}

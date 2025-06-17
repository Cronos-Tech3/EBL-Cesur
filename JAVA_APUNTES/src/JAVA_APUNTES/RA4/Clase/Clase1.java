package JAVA_APUNTES.RA4.Clase;

public class Clase1 {
    public Clase1() {
    }

    public static void main(String[] args) {

        Arbol a1 = new Arbol(5,5,true, "roble");  //a1 es una instancia del arbol

        Arbol.cosasArbol();  //metodo static no necesitamos instanciarlo


        a1.altura = 22;
        a1.setEdad(12);  // al poner la edad en privado
        a1.caduca = true;
        a1.especie = "roble";

        a1.caerhojas();

        int x = a1.sumarAnio(2);
        System.out.println(x);
        System.out.println(a1.getEdad());


        Reptiles r1 = new Reptiles();   //r1 = reptil1

        r1.longitud = 180;
        r1.escamoso = true;
        r1.especie = "crocodiliano";
        r1.venenoso = false;
        r1.desplazamiento = "cuadripedo";

        System.out.println(r1.escamoso);


        Persona p1 = new Persona("Paco", 47, 1.70);
        p1.saludar();
        p1.cumplirAnios();
        System.out.println(p1);





    }
}

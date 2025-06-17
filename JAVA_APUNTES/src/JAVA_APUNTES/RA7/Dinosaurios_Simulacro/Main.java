package JAVA_APUNTES.RA7.Dinosaurios_Simulacro;

public class Main {
    public static void main(String[] args) {
        //ArrayList<String> c = new ArrayList<>();
        Dinosaurio d1 = new Dinosaurio("asda", 5, "asdas", 5, "asdasd", 55);
        Dinosaurio d2 = new Dinosaurio("ggfgfg", 5, "gfgfg", 5, "gfgfg", 45);
        d1.agregarCaracteristica("asdasdasd");
        d1.agregarCaracteristica("asdasdasd2");
        d2.agregarCaracteristica("gfgfgfgf");
        d1.mostrarCaracteristicas();
        d2.mostrarCaracteristicas();
        d1.eliminarCaracteristica("asdasdasd");
        d1.mostrarCaracteristicas();

        d1.despegar();
        try{
            d2.despegar();
        }catch (AlturaInsuficienteException e){
            System.out.println(e.getMessage());
        }
        try{
            d1.calcularAlturaMaxima(10, 2);
        }catch (AlturaInsuficienteException e){
            System.out.println(e.getMessage());
        }
        System.out.println(d1.calcularDistanciaRecorrida(10, 2));

    }
}

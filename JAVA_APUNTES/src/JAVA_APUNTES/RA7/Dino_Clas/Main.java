package JAVA_APUNTES.RA7.Dino_Clas;

public class Main {
    public static void main(String[] args) {
        // Creamos un dinosaurio //
        Dinosaurio dino = new Dinosaurio("T-Rex", 5, "Verde", 12.5, "Rex", 60);

        //Agregamos las caracteristicas
        dino.agregarCaracteristica("Feroz");
        dino.agregarCaracteristica("Grande");

        //Mostramos las características
        dino.mostrarCaracteristicas();

        /* EXPLICACIÓN
                Intentamos hacer despegar al dinosaurio creado
                Metemos un try-catch la cual maneja la excepción
                en caso de no cumplir la altura minima.
         */
        try {
            dino.despegar();
            int altura = dino.calcularAlturaMaxima(10, 6);
            System.out.println("Altura máxima: " + altura);
            int distancia = dino.calcularDistanciaRecorrida(10, 6);
            System.out.println("Distancia recorrida: " + distancia);
        } catch (AlturaInsuficienteException e) {
            System.out.println(e.getMessage());
        }
    }
}
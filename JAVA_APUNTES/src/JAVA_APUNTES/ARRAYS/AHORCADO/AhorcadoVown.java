package JAVA_APUNTES.ARRAYS.AHORCADO;

public class AhorcadoVown {

    private final String[] palabras = { "perro", "gato", "avestruz", "gallina"}; //constante que va a tener todas las palabras de mi ahorcado

    public String solucion;    //la palabra elegida

    public String[] solucionArray;

    public AhorcadoVown() {
        int aleatorio = (int) (Math.random()* palabras.length);
        this.solucion = palabras[aleatorio];  // solucion es igual a palabras en su posicion aleatorio
        for (int i = 0; i < solucion.length(); i++) {

        }
        // Arrays.fill(solucionArray, val: "_");   metodo de array fill de rellenar



    }

    //public boolean buscarLetra (){    //funcion buscarLetra
    // return resultado;
    //}


}

package JAVA_APUNTES.A_Javadoc.soluciones_Paloma.ahorcado;

import java.util.Arrays;

public class Ahorcado {
    //constante con los valores del juego
    private final String[] palabras = {"perro", "gato", "avestruz", "gallina"};
    public String solucion; //variable para almacenar la palabra con la que juego
    public String[] solucionArray; //variable para almacenar los guiones bajos
    public int intentos; //variable para almacenar el número de intentos que tengo
    public int aciertos; //variable para saber cuantas letras he acertado

    public Ahorcado(){
        //genero numero aleatorio
        int aleatorio = (int)(Math.random()* palabras.length);
        //inicializo intentos a 6 y aciertos a 0
        intentos = 6;
        aciertos = 0;
        //con el numero aleatorio obtengo la palabra
        this.solucion = palabras[aleatorio];//perro
        //inicilizo el array con el numero de letras de la palabra
        solucionArray = new String[solucion.length()]; //logitud array es 5, perro son 5 caracteres
        //relleno el array con guiones
        Arrays.fill(solucionArray, "_");
        /*
        for (int i = 0; i < solucionArray.length; i++) {
            solucionArray[i] = "_";
        }
         */
    }

    public boolean buscarLetra(String letra){
        boolean resultado = false;
        //recorro la palabra
        for (int i = 0; i < solucion.length(); i++) {
            //si alguna letra de la palabra es igual a la que paso como parámetro
            if(letra.equalsIgnoreCase(solucion.charAt(i)+"")){
                //cambio el valor del guion por la letra en el array
                solucionArray[i] = letra;
                //he acertado la letra
                resultado=true;
                aciertos++;
            }
        }
        //si no está la letra, resto un acierto
        if(!resultado){
            intentos--;
        }
        return resultado;
    }

    public String pintarAhorcado(){
        String solucion = "";
        //en función de los intentos el dibujo cambia
        switch (intentos){
            case 6:
                solucion = "     _______\n" +
                        "    |/     \n" +
                        "    |      \n" +
                        "    |      \n" +
                        "    |      \n" +
                        "    |      \n" +
                        "    |\n" +
                        "jgs_|___";
                break;
            case 5:
                solucion = "     _______\n" +
                        "    |/      |\n" +
                        "    |      (_)\n" +
                        "    |      \n" +
                        "    |      \n" +
                        "    |      \n" +
                        "    |\n" +
                        "jgs_|___";
                break;
            case 1:
                solucion = "     _______\n" +
                    "    |/      |\n" +
                    "    |      (_)\n" +
                    "    |      \\|/\n" +
                    "    |       |\n" +
                    "    |      / \\\n" +
                    "    |\n" +
                    "jgs_|___";
                break;
            default:
                solucion = "     _______\n" +
                        "    |/      |\n" +
                        "    |      (_)\n" +
                        "    |      \\|/\n" +
                        "    |       |\n" +
                        "    |      \n" +
                        "    |\n" +
                        "jgs_|___";
                break;

        }

        return solucion;
    }

}

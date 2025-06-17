package JAVA_APUNTES.X_Simulacro_Examen_RA_4_6.GestorAnimales;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * GestorAnimales:
 * • Atributos: animales: colección estática de tipo Stack de Animal.
 * • Método main para probar la funcionalidad del programa.
 * o Se crearán al menos 2 perros y dos gatos. Pidiendo datos por teclado y
 * comprobando que los nombres de los animales son letras del alfabeto internacional,
 * con mayúsculas y minúsculas de entre 3 y 25 caracteres admitiendo espacios.
 * o Añade los animales creados al Stack.
 * o Recorre el Stack utilizando un iterador, asegúrate de que se muestran bien todos los
 * elementos de los animales (que se muestran todos sus atributos de forma correcta y
 * sin la palabra null).
 * o Llama a todos los métodos de los 4 animales. Mostrando una frase con el dato que
 * devuelven.
 */

public class GestorAnimales {

    public static Stack<Animal> animales = new Stack<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nombrePerro, tipoAlimentacion, raza;
        String nombreGato, tipoAlimentacionG, pelaje;
        HashMap<Diente, Boolean> dientes = new HashMap<Diente, Boolean>();

        for (int i = 0; i < 2; i++) {
            while(true) {
                System.out.println("Inserte datos de perro");
                nombrePerro = sc.nextLine();
                tipoAlimentacion = sc.nextLine();
                raza = sc.nextLine();

                if (comprobar(nombrePerro) && comprobar(tipoAlimentacion) && comprobar(raza)) {
                    Perro p1 = new Perro(nombrePerro,1,tipoAlimentacion,true, dientes, raza,true);
                    animales.push(p1);
                    break;
                }else{
                    System.out.println("valor no valido. ");
                }
            }
        }

        for (int i = 0; i < 2; i++) {
            while(true) {
                System.out.println("Inserte datos de gato");
                nombreGato = sc.nextLine();
                tipoAlimentacionG = sc.nextLine();
                pelaje = sc.nextLine();

                if (comprobar(nombreGato) && comprobar(tipoAlimentacionG) && comprobar(pelaje)) {
                    Gato g1 = new Gato(nombreGato,1,tipoAlimentacionG,true, dientes, pelaje,true);
                    animales.push(g1);
                    break;
                }else{
                    System.out.println("valor no valido");
                }
            }
        }

        Iterator<Animal> it = animales.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());

        }

        Diente d = new Diente("di1", 1);
        for(Animal a : animales) {
            a.hacerSonido();
            System.out.println("El animal se mueve: " + a.moverse());
            System.out.println("El diente d1: " + a.agregarDiente("di1", 1));
            System.out.println("El diente d1: " + a.agregarDiente("di1", 1));
            System.out.println("El valor de d1: " + a.obtenerDiente("di1"));
            System.out.println("El valor de d2: " + a.obtenerDiente("di2"));
        }

    }

    public static boolean comprobar(String texto){
        Pattern pat  = Pattern.compile("^[a-zA-Z\s]{3,25}$");
        Matcher mat = pat.matcher(texto);
        return mat.find();
    }
}

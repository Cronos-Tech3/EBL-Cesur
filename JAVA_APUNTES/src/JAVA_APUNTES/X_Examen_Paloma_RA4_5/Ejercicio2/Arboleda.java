package JAVA_APUNTES.X_Examen_Paloma_RA4_5.Ejercicio2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Arboleda {
    public static HashSet<Planta> arboles = new HashSet<>();

    public static void main(String[] args) {
        HashMap<String, Double> temps = new HashMap<>();
        Clima c = new Clima("seco","madrid", temps);
        c.agregarTemperatura("invierno", 11.5);
        c.agregarTemperatura("verano", 35.5);
        System.out.println(c.obtenerTemperatura("invierno"));
        Arbusto arb1 = new Arbusto("arb1", 1.6, true, true, c);
        Arbusto arb2 = new Arbusto("arb2", 1.6, true, true, c);
        arboles.add(arb1);
        arboles.add(arb2);

        System.out.println(arb1.florece());
        System.out.println(arb1.podar());
        System.out.println(arb1.producir_frutos());
        System.out.println(arb1.regar(10));

        Scanner scn = new Scanner(System.in);
        Scanner scl = new Scanner(System.in);

        for (int i = 0; i < 2; i++) {
            String especie = scl.nextLine();
            double altura = scn.nextDouble();
            boolean frutos = scl.nextLine().equals("si");
            String tipoHoja = scl.nextLine();
            double diametro = scn.nextDouble();

            Pattern pat = Pattern.compile("^[a-záéíóúñ]{1,12}$");
            Matcher mat = pat.matcher(tipoHoja);
            if(mat.find()){
                Arbol a1 = new Arbol(especie, altura, frutos, tipoHoja, diametro);
                arboles.add(a1);
                System.out.println(a1.caer_hojas());
            }else{
                System.out.println("Error");
                i--;
            }
        }

        Iterator<Planta> it = arboles.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }


    }
}

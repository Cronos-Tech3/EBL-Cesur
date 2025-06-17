package JAVA_APUNTES.X_Simulacro_Examen_RA_4_6.antonio;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main2 {
    static Scanner sc = new Scanner(System.in);
    static Scanner scl = new Scanner(System.in);
  public  static Stack<Animal>animals = new Stack<>();
    public static void main(String[] args) {
        //HashMap<Diente, Boolean> dientes=new HashMap<>();
        for (int i = 0; i <2 ; i++) {
            System.out.println("Dime el nombre del perro");
            String nombre = validarnombre();
            System.out.println("Dime la edad del perro");

            int edad = scl.nextInt();

            System.out.println("Dime el tipo de alimentacion del perro");
            String tipo = sc.nextLine();

            System.out.println("Dime si tiene cola");
            boolean cola = scl.nextBoolean();



            System.out.println("Dime la raza del perro");
            String raza = sc.nextLine();

            System.out.println("Dime si ladra el perro");
            String ladra = sc.nextLine();

            //Perro Perro=new Perro(nombre,edad,tipo,cola,dientes,raza,ladra);




            //animals.push(Perro);
            //System.out.println(" El diente se D1 se a agregado correctamente " + Perro.AgregarDiente("D1",1));
            //System.out.println( " El diente D1 se a obtenido correctamnte " + Perro.obtenerDiente("D2"));


            //Perro.hacerSonido();
            //System.out.println(" El perro se a movido correctamente " + Perro.moverse());


        }





      Iterator<Animal> iterator =animals.iterator();
      while (iterator.hasNext()){
          System.out.println(iterator.next());
      }



    }

    public static String validarnombre() {
        String nombre;
        while (true) {
             nombre = sc.nextLine();

            Pattern patron = Pattern.compile("[A-Z a-z \s]{3,25}", Pattern.CASE_INSENSITIVE);
            Matcher matcher = patron.matcher(nombre);
            if (matcher.find()) {
                break;
            } else {

                System.out.println("El nombre no es valido");

            }

        }
        return nombre;
    }
    public static boolean comprobar(String texto){
        Pattern patron = Pattern.compile("[A-Z ]{3,25}");
        Matcher matcher = patron.matcher(texto);
        return matcher.find();
    }




}

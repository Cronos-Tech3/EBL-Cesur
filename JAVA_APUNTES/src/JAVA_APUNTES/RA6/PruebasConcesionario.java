package JAVA_APUNTES.RA6;


import java.util.ArrayList;
import java.util.LinkedList;

public class PruebasConcesionario {
    public static void main(String[] args) {
        Concesionario c2 = new Concesionario("con1","dir1","1111111", new Vehiculo[2], 0);
        Concesionario c1 = new Concesionario("con1","dir1","1111111", 2);
        Vehiculo v1 = new Vehiculo("seat","ibiza",2023, 33000);
        Auto a1 = new Auto("seat","ibiza",2024, 35000, 5, true);
        Auto a2 = new Auto(v1, 3, false);
        c1.agregarVehiculo(a1);
        c1.agregarVehiculo(a2);
        //como devuelve un boolean, lo puedo meter en una variable o en un if y comprobar si ha funcionado
        if(c1.agregarVehiculo(v1)){
            System.out.println("Insertado");
        }else{
            System.out.println("No insertado");
        }
        //como es void no devuelve nada y no tengo que mostrar nada
        c1.mostrarInventario();
        //mostrar el valor que devuelve la función
        System.out.println(v1.calcularImpuesto());
        //recojo el valor para sumarlo
        double total = v1.calcularImpuesto() + v1.getPrecio();
        System.out.println("El total con impuestos es: " + total);
        System.out.println(a1.calcularDescuento());
        double total2 = a1.getPrecio() + a1.calcularImpuesto() - a1.calcularDescuento();
        System.out.println("El precio total con impuestos y descuento es: " + total2);

        c1.quitarVehiculo(1);
        c1.mostrarInventario();
        Vehiculo[] invA = new Vehiculo[3];
        invA[0] = v1;
        invA[1] = a1;
        invA[2] = a1;
        System.out.println(invA[0]);
        for (int i = 0; i < invA.length; i++) {
            System.out.println(invA[i]);
        }
        ArrayList<Vehiculo> inv = new ArrayList<Vehiculo>();
        inv.add(v1); //posicion 0
        inv.add(a1); //posicion 1
        inv.add(a2); //posicion 2
        System.out.println(inv.get(0));//me da v1
        inv.remove(0); //borra la 0 y reorganiza
        System.out.println(inv.get(0)); //me da a1
        System.out.println(inv.size()); //tamaño del arraylist
        for (int i = 0; i < inv.size(); i++) {
            System.out.println(inv.get(i));
        }

        ConcesionarAL cal = new ConcesionarAL("con1","dir1","1111111");
        cal.agregarVehiculo(v1);
        cal.mostrarInventario();

        ArrayList<Integer> numeros = new ArrayList<Integer>();
        LinkedList<Integer> numeros2 = new LinkedList<Integer>();

    }
}

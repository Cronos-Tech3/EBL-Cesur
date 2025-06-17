package JAVA_APUNTES.A_Javadoc.soluciones_Paloma.Ej_Conce_ArraysRA4;
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

    }
}

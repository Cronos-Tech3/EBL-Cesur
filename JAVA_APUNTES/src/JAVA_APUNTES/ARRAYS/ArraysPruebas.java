package JAVA_APUNTES.ARRAYS;

import java.util.Arrays;

public class ArraysPruebas {
    public static void main(String[] args) {
        //declarando un array de numeros
        int[] numeros;
        //iniciamos el array con 5 posiciones constructor del array
        numeros = new int[5];    //un array de una dimension
        //rellenar el array con un numero aleatorio entre el 1 y el 10

        //numeros[0] = (int)(Math.random()*10 + 1);
        //numeros[1] = (int)(Math.random()*10 + 1);
        //numeros[2] = (int)(Math.random()*10 + 1);
        //numeros[3] = (int)(Math.random()*10 + 1);
        //numeros[4] = (int)(Math.random()*10 + 1);

        //se hacer el for o la parte de arriba es lo mismo, pero siempre se hace con for
        for (int i = 0; i < numeros.length;i++){
            numeros[i] = (int)(Math.random()*10 + 1);
            System.out.println(numeros[i]);
        }
        System.out.println("********");
        //al ser un array tenemos una coleccion de datos que podemos usar con muchos metodos
        // Arrays. aqui veriamos todos los metodos del array y nos importaria su clase
        Arrays.sort(numeros);  //sort es ordenar de menor a mayor
        System.out.println(numeros[0]);  //aqui nos daria el valor minimo de la lista del array
        System.out.println("********");

        //for i se usa para recorrer el contenido de una coleccion, en este caso un array
        for (int i = 0; i < numeros.length;i++){
            numeros[i] = (int)(Math.random()*10 + 1);  //aqui se rellena con numeros aleatorios
            System.out.println(numeros[i]);
        }
        System.out.println("***********");

        //for each para cada numero tiene la siguiente posicion
        for (int num : numeros) {  //te da una copia del valor de dentro del array
            System.out.println(num);
            num = 3;   //no se puede editar con numero el numero del array no cambia el valor del array

        }

        System.out.println("***********");
        // tercera forma de recorrer array con toString
        Arrays.sort(numeros);   //ordeno de menor a mayor con sort
        System.out.println(numeros[0]);  //muestro el menor
        System.out.println(Arrays.toString((numeros))); //muestro como un string


        //cuando nosotros queramos dar valores
        //cuando usamos un for each solo puedo usarlo para recorrer y ver lo que contiene, pero no puedo editarlo

        System.out.println("************");

        int[] diasMes = {31, 28, 31, 30, 31};

        //ArrayList

        //ArrayList<Vehiculo> inv = new ArrayList<Vehiculo>();
        //inv.add(v1); añadir un vehiculo  //ctrl D duplicar Lineas
        //System.out.println(inv.get(0)); // me da v1 al estar en la posicion 0

        //Vehiculo[] invA = new Vehiculo[3];
        //invA[0] = v1;
        //invA[1] = v1;
        //invA[2] = v1;

        //ArrayList<Vehiculo> inv = new ArrayList<Vehiculo>();
        //inv.add(v1);
        //inv.add(a1);
        //inv.add(a2);

        //System.out.println(inv.get(0));
        //inv.remove(0); //borra la posicion 0

        /*for (int i= 0; i < inv.size(); i++ ){   //para recorrer arrayList
            System.out.println(inv.get);
        }
        */


        //linkedList cuando sea almacenar muchos objetos que no tenga que cambiar
        //si hay que cambiar es mejor hacer una arrayList

        //Stack


        //sets no admite elementos repetidos
        //se usa cuando yo quiero que no se metan elementos repetidos en una lista
        //te quita todos los elementos repetidos

    }
}

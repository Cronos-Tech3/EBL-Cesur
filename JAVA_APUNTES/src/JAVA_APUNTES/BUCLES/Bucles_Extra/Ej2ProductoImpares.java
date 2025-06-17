package JAVA_APUNTES.BUCLES.Bucles_Extra;

public class Ej2ProductoImpares {
    public static void main(String[] args){
        //Diseñar un programa que muestre el producto de los 10 primeros números
        //impares.
        int producto = 1;
        for (int i = 0; i <= 20; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
                producto *= i;
            }
        }
        System.out.println(producto);
    }
}

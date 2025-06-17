package JAVA_APUNTES.BUCLES.Bucles_Curso_Youtube;

public class Ej2While {
    public static void main(String[] args) {
        /*
        muestra los Pruebas_X.numeros del 320 a 160 de 20 en 20 usando bucle while
         */
        int i = 321;
        while ( i > 160) {
            i--;
            if (i%20==0){
                System.out.println(i);
            }


        }
    }
}

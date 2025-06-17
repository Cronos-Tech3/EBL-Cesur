package JAVA_APUNTES.BUCLES.BUCLES_ANIDADO;

public class BucleAnidadoCorteLineas {
    public static void main(String[] args) {

        int cont = 0;
        for (int i = 1; i <= 4; i++) {  //filas
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }

        System.out.println("**********************************");

        int cont2 = 0;
        for (int i = 0; i <= 4; i++) {  //filas
            for (int j = 1; j <= i; j++) {
                System.out.print(i);
            }
            System.out.println();
        }

        System.out.println("-----------------------------------------");

        int cont3 = 0;
        for (int i = 0; i <= 4; i++) {  //filas
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("--------------------------------------");

        int cont4 = 0;
        for (int i = 5; i <= 4; i++) {  //filas
            for (int j = 1; j <= i; j--) {
                System.out.print("*");
            }
            System.out.println();
        }





    }
}



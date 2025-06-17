package JAVA_APUNTES.BUCLES.Bucles_Anidados;

public class BuclesAnidadosGUIA {
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

        int contadorEspacio = 3;


        for (int i = 1; i <=4; i++) {
            for (int j = 0; j < contadorEspacio; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++){
                System.out.print("* ");
            }
            contadorEspacio--;
            System.out.println();
        }
        System.out.println("*************************");
        int ContadordEspacios = 3;
        int contadorNumeros = 1;
        for (int i = 1; i <=4; i++) {
            for (int j = 0; j < ContadordEspacios; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++){
                System.out.print(contadorNumeros + " ");
                contadorNumeros++;
            }
            ContadordEspacios--;
            System.out.println();
        }




    }
}

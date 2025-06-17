package JAVA_APUNTES.BUCLES.BUCLES_ANIDADO;

public class BuclesAnidados {
    public static void main(String[] args) {

        int cont = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(cont + " ");
                cont++;
            }
            System.out.println();
        }

    }
}

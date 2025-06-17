package JAVA_APUNTES.BUCLES.BUCLES_ANIDADO;

public class BuclesAnidadesInverso {
    public static void main(String[] args) {

        int cont = 1;

        for (int i = 1; i <= 3; i++){
            for (int j = 0; j < 3; j++){
                System.out.print(i+(3*j) + " ");
                            }
            System.out.println();
        }
        /*
    j=0 -> i+(3*j) -> 1+(3*0) = 1
    j=1 -> i+(3*j) -> 1+(3*1) = 4
    j=2 -> i+(3*j) -> 1+(3*2) = 7

     */

        System.out.println("*********************");

        int cont2;
        for (int i = 0; i != 3; i++) {
            cont2 = i;
            for (int j = 0; j < 3; j++)
            System.out.print(cont2 + " ");
            cont2 +=3;

        }






    }


}

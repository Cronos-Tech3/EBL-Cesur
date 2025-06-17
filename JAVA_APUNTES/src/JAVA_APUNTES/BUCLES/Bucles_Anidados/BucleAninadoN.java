package JAVA_APUNTES.BUCLES.BUCLES_ANIDADO;

public class BucleAninadoN {
    public static void main(String[] args) {
        // N(1) -> 1
        // N(2) -> 1 + 2 = 3
        // N(3) -> 1 + 2 + 3 = 6
        // N(4) -> 1 + 2 + 3 + 4 = 10
        int N = 5;

        for (int i = 1; i <= N; i++) {
            System.out.print("N(" + i + "); -> ");
            int suma = 0;
            for (int j = 1; j <= i; j++) {
                suma += j;
                System.out.print(j);
                if (j==i){
                    System.out.print(" = ");
                } else {
                    System.out.print(" + ");
                }
            }
            System.out.println(suma);
            System.out.println("\n");
        }
    }
}

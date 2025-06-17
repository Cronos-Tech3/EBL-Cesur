package JAVA_APUNTES.BUCLES.Bucles_Extra;

import java.util.Scanner;

public class Ej24_Capicua_Intervalos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n > 9 && n < 100) {
            int aa = n/10;
            int bb = n - (aa*10);
        }

        if (n > 99 && n < 1000) {
            int aa = n/100;
            int bb = (n - (aa*100))/10;
            int cc = n - aa*100 - bb*10;
            System.out.println(aa+ " " + bb + " " + cc);
        }

    }
}

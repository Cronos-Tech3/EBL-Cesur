package JAVA_APUNTES.INICIO_JAVA_BASICO.Num_Primos;

public class Primo {
    public static void main(String[] args) {

        int ContadordEspacios = 3;
        int contadorNumeros = 1;

        for (int i = 1; i <= 4; i++) {
            for (int j = 0; j < ContadordEspacios; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                int contadorPrimos = 1;
                for (int k = 2; k < contadorNumeros; k++) {
                    if (contadorNumeros % k == 0) {
                        contadorPrimos++;

                    }
                }
                if (contadorPrimos == 1) {
                    System.out.print(contadorNumeros + " ");
                    contadorNumeros++;
                } else {
                    j--;
                }
                contadorNumeros++;
            }
            ContadordEspacios--;
            System.out.println();
        }


    }

}


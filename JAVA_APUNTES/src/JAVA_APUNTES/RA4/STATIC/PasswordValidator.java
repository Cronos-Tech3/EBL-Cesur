package JAVA_APUNTES.RA4.STATIC;



public class PasswordValidator {

        public final static int MIN_LENGTH=0;

        public final static char ESPECIAL_CHAR = '@';

        public final static int MIN_MAYUS = 1;

        public static boolean check_password(String pass) {
            String mayus = pass.toUpperCase();
            boolean resultado = true;
            int contadorEspeciales = 0, contadorMayus = 0;
            if (pass.length()>=MIN_LENGTH) {
                for (int i = 0; i < pass.length(); i++) {
                    if (pass.charAt(i)==ESPECIAL_CHAR) {
                        contadorEspeciales++;
                    } else if (pass.charAt(i)==mayus.charAt(i)){
                        contadorMayus++;
                    }

                }

                if (contadorEspeciales==0) {
                    resultado=false;
                }

            }
            // Faltan cosas

            return resultado;
        }



    }


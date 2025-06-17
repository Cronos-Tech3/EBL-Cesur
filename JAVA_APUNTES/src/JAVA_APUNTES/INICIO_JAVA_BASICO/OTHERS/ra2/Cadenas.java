package ra2;

public class Cadenas {
    public static void main(String[] args) {
        String frase = "holaa";
        System.out.println(frase.length());
        System.out.println(frase.charAt(1));
        System.out.println(frase.charAt(frase.length()-1));//ultimo caracter
        System.out.println(frase.substring(1, 3));

        System.out.println(frase.equals("holaa"));
        System.out.println(frase.equalsIgnoreCase("HOLAA"));

        System.out.println(frase.isEmpty());

        System.out.println(frase.toUpperCase());//toda la cadena en mayuscula nos pone
        System.out.println(frase.toLowerCase());// toda la cadena en minuscula

        System.out.println(frase.replace('a', 'o'));


    }
}

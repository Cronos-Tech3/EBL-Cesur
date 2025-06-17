package JAVA_APUNTES.BIBLIOTECA_JAVA_PROYECTO.b_Jorge;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Libro {
    private String titulo;
    private String autor;
    public double precio;
    public boolean disponible;

    public Libro(String titulo, String autor, boolean disponible, double precio) {
        this.titulo = titulo;
        this.autor = autor;
        this.disponible = disponible;
        this.precio = precio;
    }


    public static boolean validarTitulo (String titulo){
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9 ]{3,50}$");


        Matcher matcher = pattern.matcher(titulo);

        boolean matchFound = matcher.find();

        if (matchFound){
            System.out.println("Título introducido correcto");
            return true;
        }else {
            System.out.println("Título introducido incorrecto");
        }
        return false;
    }

    public double descuentoEspecial(String tipoCliente) {
        if (tipoCliente.equalsIgnoreCase("estudiante")) {
            return precio * 0.85; // Descuento del 15%
        } else if (tipoCliente.equalsIgnoreCase("miembro")) {
            return precio * 0.90; // Descuento del 10%
        } else {
            return precio; // Sin descuento
        }
    }
    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" +"["+ titulo+"]" + '\'' +
                ", autor='" +"["+ autor+"]" + '\'' +
                ", precio=" +"["+ precio+"]" +
                ", disponible=" +"["+ disponible + "]"+
                '}';
    }
}

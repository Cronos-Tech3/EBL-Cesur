package RA4_POO;

public class Alumno {

        public String nombre;
        public double nota1;
        public double nota2;

        public void calcularPromedio(){
            double media = (nota1 + nota2) / 2;
            System.out.println(media);
        }

        public void estaApribado(double media){
            if (media >= 6){
                System.out.println("Aprobado");
            } else {
                System.out.println("Suspenso. Mas suerta la proxima vez");
            }
        }
}

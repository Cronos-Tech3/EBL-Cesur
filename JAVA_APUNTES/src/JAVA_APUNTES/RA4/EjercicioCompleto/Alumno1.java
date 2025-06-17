package JAVA_APUNTES.RA4.EjercicioCompleto;

public class Alumno1 {

        public String nombre;
        public double nota1;
        public double nota2;

        public void calcularPromedio(){
            double media = (nota1 + nota2) / 2;
            System.out.println(media);
        }

        public void estaAprobado(double media){
            if (media >= 6){
                System.out.println("Aprobado");
            } else {
                System.out.println("Suspenso. Mas suerta la proxima vez");
            }
        }
}

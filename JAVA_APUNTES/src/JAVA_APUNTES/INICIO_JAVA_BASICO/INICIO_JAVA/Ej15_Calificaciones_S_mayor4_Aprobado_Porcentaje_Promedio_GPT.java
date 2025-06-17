package JAVA_APUNTES.INICIO_JAVA_BASICO.INICIO_JAVA;

    import java.util.Scanner;

    public class Ej15_Calificaciones_S_mayor4_Aprobado_Porcentaje_Promedio_GPT {
        public static void main(String[] args) {
            //ejercicio 15
            //Escribe un programa que pregunte al usuario si desea analizar calificaciones de
            // alumnos y, sólo si responde “S” comenzará el procesamiento de los datos, hasta que el
            // usuario ingrese algo diferente de “S”. Por cada alumno, permitir ingresar su calificación.
            // Si es mayor a 4 el alumno está aprobado. Finalmente, mostrar “Porcentaje de alumnos
            // aprobados: x %” (donde x es el porcentaje de aprobados sobre el total de calificaciones
            // procesadas). También se debe imprimir “Promedio de los aprobados: y” (donde y es la
            // calificación promedio, sólo de los alumnos aprobados).

            Scanner scanner = new Scanner(System.in);
            String respuesta;

            do {
                System.out.print("¿Desea analizar calificaciones de alumnos? (S/N): ");
                respuesta = scanner.nextLine().toUpperCase();

                if (respuesta.equals("S")) {
                    int totalAlumnos = 0;
                    int alumnosAprobados = 0;
                    double sumaAprobados = 0.0;

                    while (true) {
                        System.out.print("Ingrese la calificación del alumno (o 'fin' para terminar): ");
                        String entrada = scanner.nextLine();

                        if (entrada.equalsIgnoreCase("fin")) {
                            break;
                        }

                        try {
                            double calificacion = Double.parseDouble(entrada);
                            totalAlumnos++;

                            if (calificacion > 4) {
                                alumnosAprobados++;
                                sumaAprobados += calificacion;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Por favor, ingrese un número válido o 'fin' para terminar.");
                        }
                    }

                    if (totalAlumnos > 0) {
                        double porcentajeAprobados = (alumnosAprobados * 100.0) / totalAlumnos;
                        double promedioAprobados = (alumnosAprobados > 0) ? (sumaAprobados / alumnosAprobados) : 0.0;

                        System.out.printf("Porcentaje de alumnos aprobados: %.2f %%\n", porcentajeAprobados);
                        System.out.printf("Promedio de los aprobados: %.2f\n", promedioAprobados);
                    } else {
                        System.out.println("No se ingresaron calificaciones.");
                    }
                }
            } while (respuesta.equals("S"));

            System.out.println("Gracias por usar el analizador de calificaciones.");
            scanner.close();
        }
    }


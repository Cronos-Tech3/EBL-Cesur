package JAVA_APUNTES.RA7.Empleado_FULL;

public class Doc_Explicacion {

    // Aqui se va a Explicar clase por clase cada código en JAVADOC

    /**
     *Sigue el Orden de Esta estructura para la realización del ejercicio
     *
     *                  -- Empleado --
     *
     *Explicación detallada:
     * public class Empleado: Define una clase pública llamada Empleado.
     *
     * private int id: Variable privada para almacenar el ID del empleado.
     *
     * private String nombre: Variable privada para almacenar el nombre del empleado.
     *
     * private String puesto: Variable privada para almacenar el puesto del empleado.
     *
     * private int horasTrabajadas: Variable privada para almacenar las horas trabajadas por el empleado.
     *
     * private boolean asistencia: Variable privada para almacenar la asistencia del empleado.
     *
     * static int contadorIds = 0: Variable estática para contar y asignar IDs únicos a cada empleado. Esta variable es compartida por todas las instancias de la clase Empleado.
     *
     * public Empleado(String nombre, String puesto): Constructor de la clase Empleado que toma dos parámetros: nombre y puesto.
     *
     * this.id = contadorIds: Asigna el valor actual de contadorIds a la variable id.
     * this.nombre = nombre: Asigna el valor del parámetro nombre a la variable nombre.
     * this.puesto = puesto: Asigna el valor del parámetro puesto a la variable puesto.
     * contadorIds++: Incrementa contadorIds para el próximo empleado.
     * public void setHorasTrabajadas(int horasTrabajadas): Método para establecer las horas trabajadas.
     *
     * this.horasTrabajadas = horasTrabajadas: Asigna el valor del parámetro horasTrabajadas a la variable horasTrabajadas.
     * public int getId(): Método para obtener el ID del empleado.
     *
     * return id: Devuelve el valor de la variable id.
     * public int getHorasTrabajadas(): Método para obtener las horas trabajadas.
     *
     * return horasTrabajadas: Devuelve el valor de la variable horasTrabajadas.
     * public void setAsistencia(boolean asistencia): Método para establecer la asistencia.
     *
     * this.asistencia = asistencia: Asigna el valor del parámetro asistencia a la variable asistencia.
     * @Override public String toString(): Método para obtener una representación en cadena del objeto Empleado.
     *
     * return "Empleado{" + "id=" + id + ", nombre='" + nombre + '\'' + ", puesto='" + puesto + '\'' + ", horasTrabajadas=" + horasTrabajadas + ", asistencia=" + asistencia + '}': Devuelve una cadena con los valores de las variables del empleado.
     *
     *
     *
     *                         -- EmpleadoNoEncontradoException --
     * Explicación detallada:
     * public class EmpleadoNoEncontradoException extends Exception:
     *
     * public: La clase es accesible desde cualquier otra clase.
     * class EmpleadoNoEncontradoException: Define una nueva clase llamada EmpleadoNoEncontradoException.
     * extends Exception: Indica que EmpleadoNoEncontradoException es una subclase de Exception, lo que significa que es un tipo de excepción personalizada.
     * public EmpleadoNoEncontradoException():
     *
     * public: El constructor es accesible desde cualquier otra clase.
     * EmpleadoNoEncontradoException(): Define el constructor de la clase EmpleadoNoEncontradoException.
     * super("No se ha encontrado ese empleado."):
     *
     * super: Llama al constructor de la clase padre (Exception).
     * "No se ha encontrado ese empleado.": Pasa este mensaje al constructor de la clase Exception, que será el mensaje de error asociado con esta excepción.
     * En resumen, esta clase define una excepción personalizada llamada EmpleadoNoEncontradoException. Cuando se lanza esta excepción, se crea un objeto de esta clase con el mensaje "No se ha encontrado ese empleado.".
     *
     *
     *
     *                          -- IAsistencia --
     *
     *Explicación detallada:
     * public interface IAsistencia:
     *
     * public: La interfaz es accesible desde cualquier otra clase.
     * interface IAsistencia: Define una interfaz llamada IAsistencia. Las interfaces en Java se utilizan para definir un conjunto de métodos que deben ser implementados por cualquier clase que implemente la interfaz.
     * boolean marcarAsistencia(int idEmpleado) throws EmpleadoNoEncontradoException:
     *
     * boolean: El método devuelve un valor booleano (true o false).
     * marcarAsistencia: Nombre del método.
     * int idEmpleado: Parámetro que representa el ID del empleado cuya asistencia se quiere marcar.
     * throws EmpleadoNoEncontradoException: Indica que este método puede lanzar una excepción de tipo EmpleadoNoEncontradoException si no se encuentra el empleado.
     * int calcularHorasTrabajadas(int idEmpleado) throws EmpleadoNoEncontradoException:
     *
     * int: El método devuelve un valor de tipo entero.
     * calcularHorasTrabajadas: Nombre del método.
     * int idEmpleado: Parámetro que representa el ID del empleado cuyas horas trabajadas se quieren calcular.
     * throws EmpleadoNoEncontradoException: Indica que este método puede lanzar una excepción de tipo EmpleadoNoEncontradoException si no se encuentra el empleado.
     * boolean registrarAusencia(int idEmpleado) throws EmpleadoNoEncontradoException:
     *
     * boolean: El método devuelve un valor booleano (true o false).
     * registrarAusencia: Nombre del método.
     * int idEmpleado: Parámetro que representa el ID del empleado cuya ausencia se quiere registrar.
     * throws EmpleadoNoEncontradoException: Indica que este método puede lanzar una excepción de tipo EmpleadoNoEncontradoException si no se encuentra el empleado.
     * En resumen, esta interfaz IAsistencia define tres métodos relacionados con la asistencia de empleados: marcar asistencia, calcular horas trabajadas y registrar ausencias. Cada método puede lanzar una excepción EmpleadoNoEncontradoException si el empleado con el ID proporcionado no se encuentra.
     *
     *
     *
     *                          -- IEmpleadoManagement --
     *
     *Explicación detallada:
     * public interface IEmpleadoManagement:
     *
     * public: La interfaz es accesible desde cualquier otra clase.
     * interface IEmpleadoManagement: Define una interfaz llamada IEmpleadoManagement. Las interfaces en Java se utilizan para definir un conjunto de métodos que deben ser implementados por cualquier clase que implemente la interfaz.
     * void contratarEmpleado(String nombre, String puesto):
     *
     * void: El método no devuelve ningún valor.
     * contratarEmpleado: Nombre del método.
     * String nombre: Parámetro que representa el nombre del nuevo empleado.
     * String puesto: Parámetro que representa el puesto del nuevo empleado.
     * Este método se utiliza para contratar a un nuevo empleado, proporcionando su nombre y puesto.
     * double calcularSalario(int idEmpleado, int horasTrabajadas, double tarifaPorHora) throws EmpleadoNoEncontradoException:
     *
     * double: El método devuelve un valor de tipo doble (decimal).
     * calcularSalario: Nombre del método.
     * int idEmpleado: Parámetro que representa el ID del empleado cuyo salario se quiere calcular.
     * int horasTrabajadas: Parámetro que representa las horas trabajadas por el empleado.
     * double tarifaPorHora: Parámetro que representa la tarifa por hora del empleado.
     * throws EmpleadoNoEncontradoException: Indica que este método puede lanzar una excepción de tipo EmpleadoNoEncontradoException si no se encuentra el empleado.
     * Este método se utiliza para calcular el salario de un empleado basado en su ID, las horas trabajadas y la tarifa por hora.
     * void despedirEmpleado(int idEmpleado) throws EmpleadoNoEncontradoException:
     *
     * void: El método no devuelve ningún valor.
     * despedirEmpleado: Nombre del método.
     * int idEmpleado: Parámetro que representa el ID del empleado que se quiere despedir.
     * throws EmpleadoNoEncontradoException: Indica que este método puede lanzar una excepción de tipo EmpleadoNoEncontradoException si no se encuentra el empleado.
     * Este método se utiliza para despedir a un empleado basado en su ID.
     * En resumen, esta interfaz IEmpleadoManagement define tres métodos relacionados con la gestión de empleados: contratar empleados, calcular salarios y despedir empleados. Cada método proporciona la funcionalidad necesaria para gestionar empleados y puede lanzar una excepción EmpleadoNoEncontradoException si el empleado con el ID proporcionado no se encuentra.
     *
     *
     *
     *                           -- GestorEmpleado --
     *
     *Explicación detallada:
     * import java.util.ArrayList;: Importa la clase ArrayList de la biblioteca de utilidades de Java, que se utiliza para crear listas dinámicas.
     *
     * public class GestorEmpleado implements IEmpleadoManagement, IAsistencia: Define la clase GestorEmpleado que implementa las interfaces IEmpleadoManagement e IAsistencia. Esto significa que GestorEmpleado debe proporcionar implementaciones para todos los métodos definidos en estas interfaces.
     *
     * public ArrayList<Empleado> listaEmpleados;: Declara una lista pública de objetos Empleado llamada listaEmpleados.
     *
     * public GestorEmpleado(): Constructor de la clase GestorEmpleado que inicializa listaEmpleados como una nueva ArrayList.
     *
     * @Override public boolean marcarAsistencia(int idEmpleado) throws EmpleadoNoEncontradoException: Método para marcar la asistencia de un empleado. Itera sobre listaEmpleados para encontrar el empleado con el ID proporcionado. Si se encuentra, marca su asistencia como true y devuelve true. Si no se encuentra, lanza una excepción EmpleadoNoEncontradoException.
     *
     * @Override public int calcularHorasTrabajadas(int idEmpleado) throws EmpleadoNoEncontradoException: Método para calcular las horas trabajadas por un empleado. Itera sobre listaEmpleados para encontrar el empleado con el ID proporcionado. Si se encuentra, devuelve sus horas trabajadas. Si no se encuentra, lanza una excepción EmpleadoNoEncontradoException.
     *
     * @Override public boolean registrarAusencia(int idEmpleado) throws EmpleadoNoEncontradoException: Método para registrar la ausencia de un empleado. Itera sobre listaEmpleados para encontrar el empleado con el ID proporcionado. Si se encuentra, marca su asistencia como false y devuelve true. Si no se encuentra, lanza una excepción EmpleadoNoEncontradoException.
     *
     * @Override public void contratarEmpleado(String nombre, String puesto): Método para contratar a un nuevo empleado. Crea un nuevo objeto Empleado con el nombre y puesto proporcionados y lo añade a listaEmpleados.
     *
     * @Override public double calcularSalario(int idEmpleado, int horasTrabajadas, double tarifaPorHora) throws EmpleadoNoEncontradoException: Método para calcular el salario de un empleado. Itera sobre listaEmpleados para encontrar el empleado con el ID proporcionado. Si se encuentra, establece sus horas trabajadas y calcula su salario multiplicando las horas trabajadas por la tarifa por hora. Si no se encuentra, lanza una excepción EmpleadoNoEncontradoException.
     *
     * @Override public void despedirEmpleado(int idEmpleado) throws EmpleadoNoEncontradoException: Método para despedir a un empleado. Itera sobre listaEmpleados para encontrar el empleado con el ID proporcionado. Si se encuentra, lo elimina de la lista. Si no se encuentra, lanza una excepción EmpleadoNoEncontradoException.
     *
     *
     *
     *                      -- Main --
     *
     *Explicación detallada:
     * public class Main: Define una clase pública llamada Main.
     *
     * public static void main(String[] args): Método principal que se ejecuta al iniciar el programa.
     *
     * public: El método es accesible desde cualquier otra clase.
     * static: El método pertenece a la clase Main y no a una instancia específica.
     * void: El método no devuelve ningún valor.
     * main(String[] args): Método principal que toma un array de cadenas como argumento.
     * GestorEmpleado gestor = new GestorEmpleado(): Crea una instancia de GestorEmpleado.
     *
     * gestor.contratarEmpleado("Paloma", "Profesora"): Contrata a un empleado con nombre "Paloma" y puesto "Profesora".
     *
     * gestor.contratarEmpleado("Juan", "Administrativo"): Contrata a un empleado con nombre "Juan" y puesto "Administrativo".
     *
     * gestor.contratarEmpleado("Alonso", "Limpieza"): Contrata a un empleado con nombre "Alonso" y puesto "Limpieza".
     *
     * try { ... } catch (EmpleadoNoEncontradoException e) { ... }: Bloque try-catch para manejar excepciones de tipo EmpleadoNoEncontradoException.
     *
     * System.out.println(gestor.listaEmpleados): Imprime la lista de empleados.
     *
     * double salario = gestor.calcularSalario(0, 20, 20): Calcula el salario del empleado con ID 0, 20 horas trabajadas y tarifa por hora de 20.
     *
     * System.out.println(salario): Imprime el salario calculado.
     *
     * gestor.despedirEmpleado(2): Despide al empleado con ID 2.
     *
     * gestor.marcarAsistencia(1): Marca la asistencia del empleado con ID 1.
     *
     * gestor.registrarAusencia(0): Registra la ausencia del empleado con ID 0.
     *
     * System.out.println(gestor.calcularHorasTrabajadas(0)): Imprime las horas trabajadas del empleado con ID 0.
     *
     * System.out.println(gestor.listaEmpleados): Imprime la lista de empleados actualizada.
     *
     * catch (EmpleadoNoEncontradoException e): Captura la excepción EmpleadoNoEncontradoException.
     *
     * System.out.println(e.getMessage()): Imprime el mensaje de la excepción.
     *
     * Este código demuestra cómo gestionar empleados, incluyendo la contratación, cálculo de salarios, registro de asistencia y ausencias, y despido de empleados, utilizando la clase GestorEmpleado.
     *
     *
     *
     *
     *
     */






}

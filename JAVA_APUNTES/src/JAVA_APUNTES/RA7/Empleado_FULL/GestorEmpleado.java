package JAVA_APUNTES.RA7.Empleado_FULL;

import java.util.ArrayList; // Importa la clase ArrayList de la biblioteca de utilidades de Java

public class GestorEmpleado implements IEmpleadoManagement, IAsistencia {   // Define la clase GestorEmpleado que implementa las interfaces IEmpleadoManagement e IAsistencia
    public ArrayList<Empleado> listaEmpleados;  // Declara una lista pública de objetos Empleado

    public GestorEmpleado() {   // Constructor de la clase GestorEmpleado
        this.listaEmpleados = new ArrayList<>();    // Inicializa la lista de empleados como una nueva ArrayList
    }


    @Override
    public boolean marcarAsistencia(int idEmpleado) throws EmpleadoNoEncontradoException { // Método para marcar la asistencia de un empleado
        for (Empleado e : listaEmpleados){  // Itera sobre la lista de empleados for each
            if(e.getId()==idEmpleado){      // Comprueba si el ID del empleado actual coincide con el ID proporcionado
                e.setAsistencia(true);      // Marca la asistencia del empleado como verdadera
                return true;                // Devuelve true indicando que la asistencia se ha marcado correctamente
            }
        }
        throw new EmpleadoNoEncontradoException();  // Si no se encuentra el empleado, lanza una excepción
    }

    @Override
    public int calcularHorasTrabajadas(int idEmpleado) throws EmpleadoNoEncontradoException {   // Método para calcular las horas trabajadas por un empleado
        for (Empleado e : listaEmpleados){      // Itera sobre la lista de empleados
            if(e.getId()==idEmpleado){          // Comprueba si el ID del empleado actual coincide con el ID proporcionado
                return e.getHorasTrabajadas();  // Devuelve las horas trabajadas por ese empleado
            }
        }
        throw new EmpleadoNoEncontradoException();  // Si no se encuentra el empleado, lanza una excepción
    }

    @Override
    public boolean registrarAusencia(int idEmpleado) throws EmpleadoNoEncontradoException { // Método para registrar la ausencia de un empleado
        for (Empleado e : listaEmpleados){          // Itera sobre la lista de empleados
            if(e.getId()==idEmpleado){              // Comprueba si el ID del empleado actual coincide con el ID proporcionado
                e.setAsistencia(false);             // Marca la asistencia del empleado como falsa
                return true;                        // Devuelve true indicando que la ausencia se ha registrado correctamente
            }
        }
        throw new EmpleadoNoEncontradoException();  // Si no se encuentra el empleado, lanza una excepción
    }

    @Override
    public void contratarEmpleado(String nombre, String puesto) {   // Método para contratar a un nuevo empleado
        //añadir un elemento al arrayLiist
        Empleado e = new Empleado(nombre, puesto);      // Crea un nuevo objeto Empleado con el nombre y puesto proporcionados
        /*
        si sabemos que la lista puede estar vacia habria que comenzar con este if
        if(listaEmpleados.isEmpty()){
            e = new Empleado(1, nombre, puesto);
        }else{
            int id = listaEmpleados.get(listaEmpleados.size()-1).getId();
            e = new Empleado(id+1, nombre, puesto);
        }*/
        listaEmpleados.add(e);          // Añade el nuevo empleado a la lista de empleados
    }

    @Override
    public double calcularSalario(int idEmpleado, int horasTrabajadas, double tarifaPorHora) throws EmpleadoNoEncontradoException { // Método para calcular el salario de un empleado
        for (int i = 0; i < listaEmpleados.size(); i++) {   // Itera sobre la lista de empleados
            if(listaEmpleados.get(i).getId()==idEmpleado){  // Comprueba si el ID del empleado actual coincide con el ID proporcionado
                listaEmpleados.get(i).setHorasTrabajadas(horasTrabajadas);  // Establece las horas trabajadas del empleado
                return horasTrabajadas*tarifaPorHora;   // Calcula y devuelve el salario del empleado
            }
        }
        throw new EmpleadoNoEncontradoException();  // Si no se encuentra el empleado, lanza una excepción
    }

    @Override
    public void despedirEmpleado(int idEmpleado) throws EmpleadoNoEncontradoException { // Método para despedir a un empleado
        for (int i = 0; i < listaEmpleados.size(); i++) {   // Itera sobre la lista de empleados
            if(listaEmpleados.get(i).getId()==idEmpleado){  // Comprueba si el ID del empleado actual coincide con el ID proporcionado
                listaEmpleados.remove(i);                   // Elimina al empleado de la lista
                return;                                     // Termina el método
            }
        }
        throw new EmpleadoNoEncontradoException();          // Si no se encuentra el empleado, lanza una excepción
    }
}

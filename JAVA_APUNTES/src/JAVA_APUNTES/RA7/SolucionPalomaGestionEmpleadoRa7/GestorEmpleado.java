package JAVA_APUNTES.RA7.SolucionPalomaGestionEmpleadoRa7;

import java.util.ArrayList;

public class GestorEmpleado implements IEmpleadoManagement, IAsistencia {
    public ArrayList<Empleado> listaEmpleados;

    public GestorEmpleado() {
        this.listaEmpleados = new ArrayList<>();
    }


    @Override
    public boolean marcarAsistencia(int idEmpleado) throws EmpleadoNoEncontradoException {
        for (Empleado e : listaEmpleados){
            if(e.getId()==idEmpleado){
                e.setAsistencia(true);
                return true;
            }
        }
        throw new EmpleadoNoEncontradoException();
    }

    @Override
    public int calcularHorasTrabajadas(int idEmpleado) throws EmpleadoNoEncontradoException {
        for (Empleado e : listaEmpleados){
            if(e.getId()==idEmpleado){
                return e.getHorasTrabajadas();
            }
        }
        throw new EmpleadoNoEncontradoException();
    }

    @Override
    public boolean registrarAusencia(int idEmpleado) throws EmpleadoNoEncontradoException {
        for (Empleado e : listaEmpleados){
            if(e.getId()==idEmpleado){
                e.setAsistencia(false);
                return true;
            }
        }
        throw new EmpleadoNoEncontradoException();
    }

    @Override
    public void contratarEmpleado(String nombre, String puesto) {
        //añadir un elemento al arrayLiist
        Empleado e = new Empleado(nombre, puesto);
        /*
        if(listaEmpleados.isEmpty()){
            e = new Empleado(1, nombre, puesto);
        }else{
            int id = listaEmpleados.get(listaEmpleados.size()-1).getId();
            e = new Empleado(id+1, nombre, puesto);
        }*/
        listaEmpleados.add(e);
    }

    @Override
    public double calcularSalario(int idEmpleado, int horasTrabajadas, double tarifaPorHora) throws EmpleadoNoEncontradoException {
        for (int i = 0; i < listaEmpleados.size(); i++) {
            if(listaEmpleados.get(i).getId()==idEmpleado){
                listaEmpleados.get(i).setHorasTrabajadas(horasTrabajadas);
                return horasTrabajadas*tarifaPorHora;
            }
        }
        throw new EmpleadoNoEncontradoException();
    }

    @Override
    public void despedirEmpleado(int idEmpleado) throws EmpleadoNoEncontradoException {
        for (int i = 0; i < listaEmpleados.size(); i++) {
            if(listaEmpleados.get(i).getId()==idEmpleado){
                listaEmpleados.remove(i);
                return;
            }
        }
        throw new EmpleadoNoEncontradoException();
    }
}

package JAVA_APUNTES.RA7.Jedi_L;

import java.util.ArrayList;

public abstract class Personaje {
    private String Nombre;
    private int edad;
    private ArrayList<Habilidad> habilidades;

    public Personaje(String nombre, int edad) {
        Nombre = nombre;
        this.edad = edad;
        this.habilidades=new ArrayList<>();
    }

    public ArrayList<Habilidad> getHabilidades() {
        return habilidades;
    }



    public void agregarHabilidad(Habilidad hab){
        habilidades.add(hab);

    }
    public boolean eliminarHabilidad(String habilidad) throws SinHabilidadesException{
        if(!habilidades.isEmpty()){
            for (int i = 0; i < habilidades.size() ; i++) {
                if(habilidades.get(i).equals(habilidad)) {
habilidades.remove(i);
return true;
                }else{
                    return false;
                }
            }
        }
        throw new SinHabilidadesException("No hay habilidades en la lista de habilidades");
    }

    public void mostrarHabilidades() throws SinHabilidadesException {
        if (!habilidades.isEmpty()) {
            for (Habilidad habilidad : habilidades) {
                System.out.println(habilidad);
            }
        }
        throw new SinHabilidadesException("No hay habilidades en la lista de habilidades");
    }
    abstract void usarFuerza();
}

package JAVA_APUNTES.RA7.Jedi_L;

public class Jedi extends Personaje implements IFuerza {

    private int nivelFuerza;
    private String colorSableLaser;

    public Jedi(String nombre, int edad, int nivelFuerza, String colorSableLaser) {
        super(nombre, edad);
        this.nivelFuerza = nivelFuerza;
        this.colorSableLaser = colorSableLaser;
    }

    public int getNivelFuerza() {
        return nivelFuerza;
    }

    @Override
    public int calcularSumaPotenciaHabilidades() {
        int sumatorio = 0;
        for (Habilidad habilidad : getHabilidades()) {
            sumatorio += habilidad.getPotencia();
        }
        return sumatorio;

    }

    @Override
    public Habilidad obtenerHabilidadPotenciaMaxima() {
        Habilidad h1 = new Habilidad("", 0);
        for (Habilidad habilidad : getHabilidades()) {
            if (habilidad.getPotencia() > h1.getPotencia()) {
                h1 = habilidad;
            }
        }
        System.out.println("La habilidad que más potencia tiene es:" + h1);
        return h1;
    }


        @Override
        void usarFuerza ()throws PotenciaInsuficienteException {
            obtenerHabilidadPotenciaMaxima();
            if(getNivelFuerza()>obtenerHabilidadPotenciaMaxima().getPotencia()) {
                System.out.println(obtenerHabilidadPotenciaMaxima());
                calcularSumaPotenciaHabilidades();
                System.out.println(calcularSumaPotenciaHabilidades());
            }
            else{
                throw new PotenciaInsuficienteException("Potencia insuficiente");
            }

        }

}


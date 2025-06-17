package JAVA_APUNTES.RA6;

public class Auto extends Vehiculo{

    private int puertas;
    private boolean esElectrico;

    public Auto(String marca, String modelo, int anio, double precio, int puertas, boolean esElectrico) {
        super(marca, modelo, anio, precio);
        this.puertas = puertas;
        this.esElectrico = esElectrico;
    }

    public Auto(Vehiculo vehiculo, int puertas, boolean esElectrico) {
        super(vehiculo.getMarca(), vehiculo.getModelo(), vehiculo.getAnio(), vehiculo.getPrecio());
        this.puertas = puertas;
        this.esElectrico = esElectrico;
    }

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    public boolean isEsElectrico() {
        return esElectrico;
    }

    public void setEsElectrico(boolean esElectrico) {
        this.esElectrico = esElectrico;
    }

    public double calcularDescuento(){
        /*
        double resultado = 0;
        if(esElectrico){
            resultado = getPrecio()*0.2;
        }else{
            resultado = getPrecio()*0.1;
        }
        return resultado;
         */
        return (esElectrico)?getPrecio()*0.2:getPrecio()*0.1;
    }
}

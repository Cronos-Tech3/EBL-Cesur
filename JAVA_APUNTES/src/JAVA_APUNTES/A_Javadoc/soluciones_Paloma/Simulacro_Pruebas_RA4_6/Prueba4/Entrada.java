package JAVA_APUNTES.A_Javadoc.soluciones_Paloma.Simulacro_Pruebas_RA4_6.Prueba4;

public class Entrada {
    private String nombreCliente;
    private double precio;
    private String diaSemana;
    private boolean vip;

    public Entrada(String nombreCliente, double precio, String diaSemana, boolean vip) {
        this.nombreCliente = nombreCliente;
        this.precio = precio;
        this.diaSemana = diaSemana;
        this.vip = vip;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombreCliente='" + nombreCliente + '\'' +
                ", precio=" + precio +
                ", diaSemana='" + diaSemana + " precio final ," + calcularPrecioFinal() + '\'' +
                ", vip=" + vip +
                '}';
    }

    public double calcularPrecioFinal() {
        double precioFinal = precio;
        if (diaSemana.equalsIgnoreCase("miercoles")) {
            precioFinal= precio  * 0.7;
        }
        if (vip) {
            precioFinal = precio * 1.15;
        }


        return precioFinal;
    }
}

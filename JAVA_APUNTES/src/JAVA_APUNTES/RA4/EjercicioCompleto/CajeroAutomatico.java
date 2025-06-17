package RA4_POO.EjercicioPOO.POO_Ej1;

public class CajeroAutomatico {

    public double saldoDisponible;
    public String claveAcceso;

    public void validarClave(String claveIngresada){
        if(claveIngresada.equals("Alfa1")){
            System.out.println("Clave correcta. Acceso concedido");
        }else{
            System.out.println("Clave incorrecta");
        }
    }

    public void retirarDinero (double monto){

    }

}

package RA4_POO;

import java.util.Scanner;

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
        Scanner ingNum = new Scanner(System.in);

        System.out.println("¿Cuando desea retirar?");
        double ingreso = ingNum.nextDouble();


        if (ingreso > 0){
            monto--;
            saldoDisponible = saldoDisponible - monto;
        }
    }

    public void consultarSaldo (){
        System.out.println(saldoDisponible);
    }


}

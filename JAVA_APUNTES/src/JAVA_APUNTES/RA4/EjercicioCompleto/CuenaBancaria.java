package RA4_POO.EjercicioPOO.POO_Ej1;

import java.util.Scanner;

public class CuenaBancaria {

    public String numeroCuenta;
    public double saldo;
    public String titular;


    public void depositar(double monto){
        Scanner ingNum = new Scanner(System.in);

        System.out.println("¿Cuando desea depositar?");
        double ingreso = ingNum.nextDouble();

        if (ingreso > 0){
            monto++;
        }
    }

    public void retirar(double monto){
        Scanner ingNum = new Scanner(System.in);

        System.out.println("¿Cuando desea retirar?");
        double ingreso = ingNum.nextDouble();


        if (ingreso > 0){
            monto--;
        }
    }

}

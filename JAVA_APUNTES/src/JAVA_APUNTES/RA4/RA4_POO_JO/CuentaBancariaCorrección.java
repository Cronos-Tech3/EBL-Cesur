package RA4_POO;

public class CuentaBancariaCorrección {
    private String titular;
    private String numCuenta;
    private double saldo;

    public CuentaBancariaCorrección(String titular, String numCuenta, double saldo) {
        this.titular = titular;
        this.numCuenta = numCuenta;
        this.saldo = saldo;
    }

    public double depositar(double monto){
        saldo += monto;
        return monto;
    }

    public void retirar(double monto) {
        if (saldo >= monto) {
            saldo -= monto;
        } else {
            System.out.println("Fondos insuficientes");
        }
    }

    public double consultarSaldo(){
        return saldo;
    }
}

package U5.ActividadesInicio;

public class CuentaBancaria {
    private String numCuenta;
    private String titular;
    private double saldo;
    public CuentaBancaria(String titular, double saldo) {
        generarNumCuenta();
        this.setTitular(titular);
        this.saldo = saldo;
    }
    public void setTitular(String titular) {
        this.titular = titular;
    }
    public void restarSaldo(int cantidad) {
        if (cantidad > this.saldo || cantidad <= 0) {
            System.out.println("Saldo insuficiente");
        }
        else  {
            this.saldo -= cantidad;
        }
    }

    private void generarNumCuenta() {
        for (int i = 0; i <=12; i++) {
            int v = (int) (Math.random() * 10);
            this.numCuenta += v;
        }
    }
    public void datosBancarios() {
        System.out.println("Numero Cuenta: "+this.numCuenta+ ", Titular: "+this.titular+", Saldo: "+ this.saldo);
    }
}

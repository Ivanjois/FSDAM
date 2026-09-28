package U5.ActividadesInicio;

public class ElBancoSeguro {
    public static void main(String[] args) {
        CuentaBancaria hola = new CuentaBancaria("Ivan", 1000);
        hola.restarSaldo(2000);
        hola.datosBancarios();
        hola.restarSaldo(500);
        hola.datosBancarios();
    }
}
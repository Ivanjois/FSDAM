package Tema2.ej05;

public class Cliente implements Runnable {
    private final Tienda tienda;
    private final int cantidad;

    public Cliente(Tienda tienda, int cantidad) {
        this.tienda = tienda;
        this.cantidad = cantidad;
    }

    @Override
    public void run() {
        tienda.comprarProducto(cantidad);
    }
}

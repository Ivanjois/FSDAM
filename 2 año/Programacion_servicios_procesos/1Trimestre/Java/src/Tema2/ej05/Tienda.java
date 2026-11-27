package Tema2.ej05;

public class Tienda {
    private int stock;

    public Tienda(int stockInicial) {
        this.stock = stockInicial;
    }

    // Metodo sincronizado para garantizar exclusion mutua y evitar condiciones de carrera
    public synchronized void comprarProducto(int cantidad) {
        String cliente = Thread.currentThread().getName();
        if (cantidad <= stock) {
            stock -= cantidad;
            System.out.println(cliente + " compro " + cantidad + " productos. Stock disponible: " + stock);
        } else {
            System.out.println(cliente + " intento comprar " + cantidad + " productos, pero no hay suficiente stock.");
        }
    }

    public synchronized int getStock() {
        return stock;
    }
}

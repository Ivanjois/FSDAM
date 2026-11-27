package Tema2.ej05;

public class PrincipalTienda {
    public static void main(String[] args) {
        Tienda tienda = new Tienda(10);

        Thread cliente1 = new Thread(new Cliente(tienda, 5), "Cliente 1");
        Thread cliente2 = new Thread(new Cliente(tienda, 8), "Cliente 2");
        Thread cliente3 = new Thread(new Cliente(tienda, 3), "Cliente 3");
        Thread cliente4 = new Thread(new Cliente(tienda, 2), "Cliente 4");

        cliente1.start();
        cliente2.start();
        cliente3.start();
        cliente4.start();

        try {
            cliente1.join();
            cliente2.join();
            cliente3.join();
            cliente4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Simulacion finalizada. Stock final: " + tienda.getStock());
    }
}

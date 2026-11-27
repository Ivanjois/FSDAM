package Tema2.ej04;

public class HiloBloques implements Runnable {
    private final int idHilo;
    private final int inicio;
    private final int fin;

    public HiloBloques(int idHilo, int totalHilos, int totalTrabajo) {
        this.idHilo = idHilo;
        // Division equitativa incluso cuando N no es divisible por M:
        // los primeros 'resto' hilos reciben 1 elemento adicional.
        int base = totalTrabajo / totalHilos;
        int resto = totalTrabajo % totalHilos;
        this.inicio = idHilo * base + Math.min(idHilo, resto);
        this.fin = this.inicio + base + (idHilo < resto ? 1 : 0);
    }

    @Override
    public void run() {
        for (int i = inicio; i < fin; i++) {
            System.out.println("Soy el hilo " + idHilo + " digo el num " + i + " y el cuadrado es " + (i * i));
        }
    }
}

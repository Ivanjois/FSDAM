package Tema2.ej04;

public class HiloCiclico implements Runnable {
    private final int idHilo;
    private final int totalHilos;
    private final int totalTrabajo;

    public HiloCiclico(int idHilo, int totalHilos, int totalTrabajo) {
        this.idHilo = idHilo;
        this.totalHilos = totalHilos;
        this.totalTrabajo = totalTrabajo;
    }

    @Override
    public void run() {
        // Reparto ciclico: cada hilo empieza en su id y salta de M en M
        for (int i = idHilo; i < totalTrabajo; i += totalHilos) {
            System.out.println("Soy el hilo " + idHilo + " digo el num " + i + " y el cuadrado es " + (i * i));
        }
    }
}

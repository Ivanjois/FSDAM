package Tema2.ej03;

class HiloTexto extends Thread {
    private String texto;

    public HiloTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(texto);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class TicTacMain {
    public static void main(String[] args) {
        HiloTexto hiloTic = new HiloTexto("TIC");
        HiloTexto hiloTac = new HiloTexto("TAC");

        // Prioridad minima (1) para TIC y maxima (10) para TAC
        hiloTic.setPriority(Thread.MIN_PRIORITY);
        hiloTac.setPriority(Thread.MAX_PRIORITY);

        hiloTic.start();
        hiloTac.start();
    }
}

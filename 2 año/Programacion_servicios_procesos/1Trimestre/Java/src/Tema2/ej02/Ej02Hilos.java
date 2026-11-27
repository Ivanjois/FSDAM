package Tema2.ej02;

class MiTarea implements Runnable {
    private int inicio;
    private int fin;

    public MiTarea(int inicio, int fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    @Override
    public void run() {
        for (int i = inicio; i <= fin; i++) {
            if (Ej02Hilos.esPrimo(i)) {
                System.out.println("El numero " + i + " es primo.");
            } else {
                System.out.println("El numero " + i + " no es primo.");
            }
        }
    }
}

public class Ej02Hilos {

    public static boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i < numero; i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        long tiempoInicio = System.currentTimeMillis();

        Thread[] hilos = new Thread[4];
        hilos[0] = new Thread(new MiTarea(1, 100000));
        hilos[1] = new Thread(new MiTarea(100001, 200000));
        hilos[2] = new Thread(new MiTarea(200001, 300000));
        hilos[3] = new Thread(new MiTarea(300001, 400000));

        // 1. Lanzamos todos los hilos en paralelo
        for (int i = 0; i < hilos.length; i++) {
            hilos[i].start();
        }

        // 2. Esperamos a que los 4 hilos terminen antes de parar el cronometro
        for (int i = 0; i < hilos.length; i++) {
            try {
                hilos[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long tiempoFin = System.currentTimeMillis();
        long duracionMs = tiempoFin - tiempoInicio;
        System.out.println("Tiempo con 4 hilos: " + duracionMs + " ms (" + (duracionMs / 1000.0) + " s)");
    }
}

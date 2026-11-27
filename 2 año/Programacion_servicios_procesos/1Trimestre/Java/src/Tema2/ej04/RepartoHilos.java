package Tema2.ej04;

import java.util.Scanner;

public class RepartoHilos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce la cantidad total de trabajo (N): ");
        int n = scanner.nextInt();

        System.out.print("Introduce el numero de hilos (M): ");
        int m = scanner.nextInt();

        if (n <= 0 || m <= 0) {
            System.out.println("Error: Tanto N como M deben ser enteros positivos.");
            scanner.close();
            return;
        }

        // 1. Reparto por bloques
        System.out.println("COMIENZA LA IMPLEMENTACION POR BLOQUES");
        Thread[] hilosBloques = new Thread[m];
        for (int i = 0; i < m; i++) {
            hilosBloques[i] = new Thread(new HiloBloques(i, m, n));
            hilosBloques[i].start();
        }
        for (Thread hilo : hilosBloques) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 2. Reparto ciclico
        System.out.println("COMIENZA LA IMPLEMENTACION CICLICA");
        Thread[] hilosCiclicos = new Thread[m];
        for (int i = 0; i < m; i++) {
            hilosCiclicos[i] = new Thread(new HiloCiclico(i, m, n));
            hilosCiclicos[i].start();
        }
        for (Thread hilo : hilosCiclicos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("FIN DEL PROGRAMA");
        scanner.close();
    }
}

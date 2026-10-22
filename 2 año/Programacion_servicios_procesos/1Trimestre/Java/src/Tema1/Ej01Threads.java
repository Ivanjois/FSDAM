package Tema1;

// 1. Clase MiTarea extendiendo la clase Thread
class MiTarea extends Thread {
    @Override
    public void run() {
        // Al heredar de Thread, getId() es un método propio de la clase
        long threadId = getId();

        for (int i = 1; i <= 5; i++) {
            System.out.println("Hilo [ID: " + threadId + "] - Contador: " + i);
            try {
                // Simula que el hilo está realizando alguna tarea
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println("Hilo interrumpido: " + e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class Ej01Threads {
    public static void main(String[] args) {
        // 2. Crear 8 hilos que ejecuten MiTarea
        MiTarea[] hilos = new MiTarea[8];
        for (int i = 0; i < 8; i++) {
            hilos[i] = new MiTarea();
            hilos[i].start();
        }

        // 3. En el hilo principal (main):
        // a. Bucle que cuenta del 1 al 5 y muestra mensajes con el contador
        // b. Pausa de 1 segundo entre cada iteración
        for (int i = 1; i <= 5; i++) {
            System.out.println("Hilo Principal (main) - Contador: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println("Main interrumpido: " + e.getMessage());
            }
        }

        // 4. Utiliza join() para esperar a que los hilos terminen
        for (int i = 0; i < hilos.length; i++) {
            try {
                hilos[i].join();
            } catch (InterruptedException e) {
                System.err.println("Error esperando al hilo: " + e.getMessage());
            }
        }

        // 5. Mensaje indicando que el programa ha finalizado
        System.out.println("El programa Ej01Threads ha finalizado.");
    }
}

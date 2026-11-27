package Tema1.ej01_runnable;

// 1. Crea una clase MiTarea, en su metodo run() debe haber un bucle que cuente del 1 al 5,
// mostrando mensajes que incluyan el ID del hilo actual y el contador.
// Entre cada una de las iteraciones simula que el hilo esta realizando alguna tarea con Thread.sleep(1000);.
class MiTarea implements Runnable {
    @Override
    public void run() {
        long id = Thread.currentThread().getId();

        for (int i = 1; i <= 5; i++) {
            System.out.println("Hilo [ID: " + id + "] - Contador: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println("Hilo interrumpido: " + e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class Ej01Runnable {
    public static void main(String[] args) {
        // 2. En la clase principal, en el metodo main, crea 8 hilos que ejecuten MiTarea.
        int NUM_HILOS = 8;
        Thread[] hilos = new Thread[NUM_HILOS];

        for (int i = 0; i < NUM_HILOS; i++) {
            hilos[i] = new Thread(new MiTarea());
            hilos[i].start();
        }

        // 3. En el hilo principal (main):
        // a. Crea un bucle que cuente del 1 al 5 y muestre mensajes que incluyan el contador.
        // b. Agrega una pausa de 1 segundo entre cada iteracion.
        for (int i = 1; i <= 5; i++) {
            System.out.println("Hilo Principal (main) - Contador: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println("Main interrumpido: " + e.getMessage());
            }
        }

        // 4. Despues del bucle principal, utiliza join() para esperar a que los hilos terminen.
        for (int i = 0; i < hilos.length; i++) {
            try {
                hilos[i].join();
            } catch (InterruptedException e) {
                System.err.println("Error esperando al hilo: " + e.getMessage());
            }
        }

        // 5. Finalmente, muestra un mensaje indicando que el programa ha finalizado.
        System.out.println("El programa Ej01Runnable ha finalizado.");
    }
}

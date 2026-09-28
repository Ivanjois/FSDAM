import java.util.Scanner;
public class Ej9B2U2 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        final int NUM_ELEMENTOS = 5;
        int[] numerosLeidos=new int[NUM_ELEMENTOS];
        int productoMult;
        System.out.println("Introducza el producto para las multiplicaciones");
        productoMult = teclado.nextInt();
        System.out.println("--- FASE 1: Introducción de 5 números ---");
        for (int i = 0; i < NUM_ELEMENTOS; i++){
            System.out.print("Introduce el número " + (i + 1) + " de " + NUM_ELEMENTOS + ": ");
            numerosLeidos[i] = teclado.nextInt();
        }
        teclado.close();
        System.out.println("\n--- FASE 2: Cálculo y Muestra de Productos Parciales ---");
        for (int i = 0; i < NUM_ELEMENTOS; i++) {
            if (numerosLeidos[i] > 0) {
                int positivos = numerosLeidos[i];
              int  productoMultiplicado = productoMult * positivos;
              System.out.println("  -> Calculando: " + productoMult + " * " + numerosLeidos[i] + " = " + productoMultiplicado);
            } else {
                int negativos = numerosLeidos[i];
                System.out.println("  -> Número " + negativos + " ignorado (no positivo).");
            }
        }
    }
}
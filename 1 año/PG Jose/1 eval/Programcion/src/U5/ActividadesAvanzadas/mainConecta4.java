package U5.ActividadesAvanzadas;

import java.util.Scanner;

public class mainConecta4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] lista = new  int[8];
        lista[0] = 2;
        lista[1] = 3;
        lista[2] = 4;
        lista[3] = 5;
        lista[4] = 6;
        lista[5] = 7;
        lista[6] = 8;
        lista[7] = 9;
        lista[8] = 10;
        int si = lista[8];
        // Quitamos la bandera porque usaremos 'break' para salir
        Conecta4 juego = new Conecta4();

        System.out.println("--- Tablero Inicial ---");
        juego.mostrarTablero();

        // Bucle infinito que romperemos manualmente cuando alguien gane
        while (true) {

            // ---------------------------------------------------------
            // TURNO JUGADOR 1 (X)
            // ---------------------------------------------------------
            System.out.println("\nTURNO JUGADOR 1 (X)");
            boolean coordenadaValida = false;

            // Bucle para obligar a poner una ficha válida
            while (!coordenadaValida) {
                System.out.print("Fila: ");
                int fila = sc.nextInt();
                System.out.print("Columna: ");
                int columna = sc.nextInt();

                // Comprobamos rango y disponibilidad
                if (fila >= 0 && fila < 6 && columna >= 0 && columna < 7 && juego.estaDisponible(fila, columna)) {
                    juego.setFicha(fila, columna, 'X'); // ¡IMPORTANTE: 'X' Mayúscula!
                    coordenadaValida = true;
                } else {
                    System.out.println("Error: Posición ocupada o fuera del tablero. Intenta de nuevo.");
                }
            }

            juego.mostrarTablero();

            // COMPROBAR VICTORIA INMEDIATAMENTE
            if (juego.hayGanador()) {
                System.out.println("\n¡¡FELICIDADES JUGADOR 1!! HAS GANADO CON LAS X");
                break; // Rompe el bucle while(true) y termina el juego
            }

            // ---------------------------------------------------------
            // TURNO JUGADOR 2 (O)
            // ---------------------------------------------------------
            System.out.println("\nTURNO JUGADOR 2 (O)");
            coordenadaValida = false; // Reiniciamos para el jugador 2

            while (!coordenadaValida) {
                System.out.print("Fila: ");
                int fila2 = sc.nextInt();
                System.out.print("Columna: ");
                int columna2 = sc.nextInt();

                if (fila2 >= 0 && fila2 < 6 && columna2 >= 0 && columna2 < 7 && juego.estaDisponible(fila2, columna2)) {
                    juego.setFicha(fila2, columna2, 'O');
                    coordenadaValida = true;
                } else {
                    System.out.println("Error: Posición ocupada o fuera del tablero. Intenta de nuevo.");
                }
            }

            juego.mostrarTablero();

            // COMPROBAR VICTORIA INMEDIATAMENTE
            if (juego.hayGanador()) {
                System.out.println("\n¡¡FELICIDADES JUGADOR 2!! HAS GANADO CON LAS O");
                break; // Rompe el bucle y termina el juego
            }
        }
    }
}
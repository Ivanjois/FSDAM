package U5.ActividadesAvanzadas;

public class Conecta4 {
    private final int filas = 6;
    private final int columnas = 7;
    private char[][] tablero;

    Conecta4() {
        this.tablero = new char[filas][columnas];
        for (int i = 0; i < this.filas; i++) {
            for (int j = 0; j < this.columnas; j++) {
                this.tablero[i][j] = '.';
            }
        }
    }

    //Devuelve true si la posición está libre.
    boolean estaDisponible(int fila, int columna) {
        return this.tablero[fila][columna] == '.';
    }

    //Coloca una 'X' o una 'O' en la posición indicada.
    void setFicha(int fila, int columna, char ficha) {
        this.tablero[fila][columna] = ficha;
    }

    //Verifican qué ficha hay en la posición.
    boolean esO(int fila, int columna) {
        return this.tablero[fila][columna] == 'O';
    }

    boolean esX(int fila, int columna) {
        return this.tablero[fila][columna] == 'X';
    }

    //Imprime el tablero de forma legible en la consola.
    public void mostrarTablero() {
        System.out.print("  ");
        for (int j = 0; j < this.columnas; j++) {
            System.out.print(j + " ");
        }
        System.out.println();
        for (int i = 0; i < this.filas; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < this.columnas; j++) {
                System.out.print(this.tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean hayGanador() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {

                // 1. OPTIMIZACIÓN: Si la casilla está vacía (disponible), no hay ganador ahí.
                // Pasamos a la siguiente vuelta del bucle.
                if (estaDisponible(i, j)) {
                    continue;
                }

                // AHORA COMPROBAMOS LAS 4 DIRECCIONES
                // Usamos tus métodos esX() y esO() para ver si hay 4 iguales

                // --- HORIZONTAL (—) ---
                if (j + 3 < columnas) {
                    // Comprobar si hay 4 'X' seguidas
                    if (esX(i, j) && esX(i, j + 1) && esX(i, j + 2) && esX(i, j + 3)) return true;
                    // Comprobar si hay 4 'O' seguidas
                    if (esO(i, j) && esO(i, j + 1) && esO(i, j + 2) && esO(i, j + 3)) return true;
                }

                // --- VERTICAL (|) ---
                if (i + 3 < filas) {
                    if (esX(i, j) && esX(i + 1, j) && esX(i + 2, j) && esX(i + 3, j)) return true;
                    if (esO(i, j) && esO(i + 1, j) && esO(i + 2, j) && esO(i + 3, j)) return true;
                }

                // --- DIAGONAL DESCENDENTE (\) ---
                if (i + 3 < filas && j + 3 < columnas) {
                    if (esX(i, j) && esX(i + 1, j + 1) && esX(i + 2, j + 2) && esX(i + 3, j + 3)) return true;
                    if (esO(i, j) && esO(i + 1, j + 1) && esO(i + 2, j + 2) && esO(i + 3, j + 3)) return true;
                }

                // --- DIAGONAL ASCENDENTE (/) ---
                if (i >= 3 && j + 3 < columnas) {
                    if (esX(i, j) && esX(i - 1, j + 1) && esX(i - 2, j + 2) && esX(i - 3, j + 3)) return true;
                    if (esO(i, j) && esO(i - 1, j + 1) && esO(i - 2, j + 2) && esO(i - 3, j + 3)) return true;
                }
            }
        }
        return false;
    }
}

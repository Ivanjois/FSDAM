package U5.ActividadesAvanzadas;

public class Puzle15 {
    private int[][] tablero;
    private final int TAMANIO = 4;
    private int filaVacia;
    private int columnaVacia;

    public Puzle15() {
        this.tablero = new int[TAMANIO][TAMANIO];
        inicializarTablero();
    }
    private void inicializarTablero() {
        for (int i = 0; i < TAMANIO; i++) {
            int numeroAleatorio = (int) (Math.random() * 10);
            for (int j = 0; j < TAMANIO; j++) {
                tablero[i][j] = numeroAleatorio;
            }
            for (int y = 0; y <= 8; y++) {

            }
        }
    }
//    public Puzle15() {
//        tablero = new int[TAMANIO][TAMANIO];
//        inicializarTablero();
//    }
//
//    private void inicializarTablero() {
//        int contador = 1;
//        for (int i = 0; i < TAMANIO; i++) {
//            for (int j = 0; j < TAMANIO; j++) {
//                tablero[i][j] = contador++;
//            }
//        }
//        tablero[TAMANIO - 1][TAMANIO - 1] = 0; // Espacio vacío
//        filaVacia = TAMANIO - 1;
//        columnaVacia = TAMANIO - 1;
//    }
//
//    public void mostrarTablero() {
//        for (int i = 0; i < TAMANIO; i++) {
//            for (int j = 0; j < TAMANIO; j++) {
//                if (tablero[i][j] == 0) {
//                    System.out.print("   ");
//                } else {
//                    System.out.printf("%2d ", tablero[i][j]);
//                }
//            }
//            System.out.println();
//        }
//    }
//
//    public boolean mover(int fila, int columna) {
//        if (esAdyacenteAlVacio(fila, columna)) {
//            tablero[filaVacia][columnaVacia] = tablero[fila][columna];
//            tablero[fila][columna] = 0;
//            filaVacia = fila;
//            columnaVacia = columna;
//            return true;
//        }
//        return false;
//    }
//
//    private boolean esAdyacenteAlVacio(int fila, int columna) {
//        return (Math.abs(fila - filaVacia) == 1 && columna == columnaVacia) ||
//                (Math.abs(columna - columnaVacia) == 1 && fila == filaVacia);
//    }
//
//    public boolean estaResuelto() {
//        int contador = 1;
//        for (int i = 0; i < TAMANIO; i++) {
//            for (int j = 0; j < TAMANIO; j++) {
//                if (i == TAMANIO - 1 && j == TAMANIO - 1) {
//                    return tablero[i][j] == 0;
//                }
//                if (tablero[i][j] != contador++) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
}
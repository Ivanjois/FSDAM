package U5.repaso;

public class Conecta4 {
    private char [][] tablero = new char[6][7];
    boolean full;
    public Conecta4() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                this.tablero[i][j] = '.';
            }
        }
    }
    boolean estaDisponible(int fila, int columna){
        if (this.tablero[fila][columna] == '.') {
            return true;
        }else{
            return false;
        }
    }
    void setFicha(int columna, char ficha){
        this.full = true;
        for (int i = 5; i >= 0; i--) {
            if (estaDisponible(i, columna)) {
                tablero[i][columna] = ficha;
                this.full = false;
                return;
            }
        }
        System.out.println("La columna está llena, elige otra");
    }
    boolean esO(int fila, int columna){
        if (this.tablero[fila][columna] == 'O') {
            return true;
        }else{
            return false;
        }
    }
    boolean esX(int fila, int columna){
        if (this.tablero[fila][columna] == 'X') {
            return true;
        }else{
            return false;
        }
    }
    void mostrarTablero(){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(this.tablero[i][j] + " ");
            }
            System.out.println("");
        }
    }
    boolean esVictoriaX(){
        int contador = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (esX(i, j)) {
                    contador++;
                    if (contador == 4) {
                        return true;
                    }
                }else{
                 contador = 0;
                }
            }
        }
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                if (esX(j, i)) {
                    contador++;
                    if (contador == 4) {
                        return true;
                    }
                }else{
                    contador = 0;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (esX(i, j) &&
                esX(i+1,j+1)&&
                esX(i+2,j+2)&&
                esX(i+3,j+3)) {
                    return true;
                }
            }
        }
        for (int i = 3; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (esX(i, j) &&
                esX(i-1,j+1)&&
                esX(i-2,j+2)&&
                esX(i-3,j+3)) {
                    return true;
                }
            }
        }
        return false;
    }
    boolean esVictoriaO(){
        int contador = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (esO(i, j)) {
                    contador++;
                    if (contador == 4) {
                        return true;
                    }
                }else{
                    contador = 0;
                }
            }
        }
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                if (esO(j, i)) {
                    contador++;
                    if (contador == 4) {
                        return true;
                    }
                }else{
                    contador = 0;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (esO(i, j) &&
                esO(i+1,j+1)&&
                esO(i+2,j+2)&&
                esO(i+3,j+3)) {
                    return true;
                }
            }
        }
        for (int i = 3; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (esO(i, j) &&
                        esO(i-1,j+1)&&
                        esO(i-2,j+2)&&
                        esO(i-3,j+3)) {
                    return true;
                }
            }
        }
        return false;
    }
}

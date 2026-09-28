public class Puzle {
    int [][] matriz = new int [4][4];
    private int filaVacia;
    private int columnaVacia;

    public Puzle(){
        int fila0 = (int)(Math.random()*4);
        int columna0 = (int)(Math.random()*4);
        this.matriz[fila0][columna0] = 0;
        for(int fila = 0; fila < 4; fila++){
            for(int columna = 0; columna < 4; columna++){
                if(fila == fila0 && columna == columna0){
                    continue;
                }else {
                    int num = (int) (Math.random() * 15)+1;
                    while (estaRepetido(num)) {
                        num = (int) (Math.random() * 15)+1;
                    }
                    matriz[fila][columna] = num;
                }
            }
        }
    }
    public boolean estaRepetido(int num){
        for(int fila = 0; fila < 4; fila++){
            for(int columna = 0; columna < 4; columna++){
                if(num == matriz[fila][columna]){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean moverArriba(){
        int fila = fila0();
        int columna = columna0();
        if (fila == 0){
            System.out.println("No se puede mover hacia arriba");
            return false;
        }else{
            int aux = this.matriz[fila-1][columna];
            this.matriz[fila][columna] = aux;
            this.matriz[fila-1][columna] = 0;
            System.out.println("Moviendo hacia arriba...");
            return true;
        }
    }
    public boolean moverAbajo(){
        int fila = fila0();
        int columna = columna0();
        if (fila == 3){
            System.out.println("No se puede mover hacia abajo");
            return false;
        }else{
            int aux = this.matriz[fila+1][columna];
            this.matriz[fila][columna] = aux;
            this.matriz[fila+1][columna] = 0;
            System.out.println("Moviendo hacia abajo...");
            return true;
        }
    }
    public boolean moverDerecha(){
        int fila = fila0();
        int columna = columna0();
        if (columna == 3){
            System.out.println("No se puede mover hacia la derecha");
            return false;
        }else{
            int aux = this.matriz[fila][columna+1];
            this.matriz[fila][columna] = aux;
            this.matriz[fila][columna+1] = 0;
            System.out.println("Moviendo a la derecha...");
            return true;
        }
    }
    public boolean moverIzquierda(){
        int fila = fila0();
        int columna = columna0();
        if (columna == 0){
            System.out.println("No se puede mover hacia la izquierda");
            return false;
        }else{
            int aux = this.matriz[fila][columna-1];
            this.matriz[fila][columna] = aux;
            this.matriz[fila][columna-1] = 0;
            System.out.println("Moviendo a la izquierda...");
            return true;
        }
    }
    public void mostrar(){
        for(int fila = 0; fila < 4; fila++){
            for(int columna = 0; columna < 4; columna++){
                System.out.print(matriz[fila][columna] + " ");
            }
            System.out.println();
        }
    }
    int fila0(){
        for(int fila = 0; fila < 4; fila++){
            for(int columna = 0; columna < 4; columna++){
                if(matriz[fila][columna] == 0){
                    return fila;
                }
            }
        }
        return -1;
    }
    int columna0(){
        for(int fila = 0; fila < 4; fila++){
            for(int columna = 0; columna < 4; columna++){
                if(matriz[fila][columna] == 0){
                    return columna;
                }
            }
        }
        return -1;
    }
    public boolean estaResuelto(){
        int contador = 1;
        for(int fila = 0; fila < 4; fila++){
            for(int columna = 0; columna < 4; columna++){
                if(contador < 15) {
                    if (matriz[fila][columna] == contador) {
                        contador++;
                    }else{
                        break;
                    }
                }else{
                    if(this.matriz[fila][columna] == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

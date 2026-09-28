package U5.repaso;

import java.util.Scanner;
public class MainConecta4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Conecta4 c = new Conecta4();
        int opcion;
        boolean victoriaX = false;
        boolean victoriaO = false;
        do{
            c.mostrarTablero();
            System.out.println("Jugador 1 (X), elige columna (0-6): ");
            opcion = sc.nextInt();
            c.setFicha(opcion, 'X');
            while (c.full) {
                System.out.println("Columna llena, elige otra: ");
                opcion = sc.nextInt();
                c.setFicha(opcion, 'X');
            }
            c.mostrarTablero();
            victoriaX = c.esVictoriaX();
            if(victoriaX){
                break;
            }
            System.out.println("Jugador 2 (O), elige columna (0-6): ");
            opcion = sc.nextInt();
            c.setFicha(opcion, 'O');
            while (c.full) {
                System.out.println("Columna llena, elige otra: ");
                opcion = sc.nextInt();
                c.setFicha(opcion, 'O');
            }
            c.mostrarTablero();
            victoriaO = c.esVictoriaO();
        }while(!victoriaX && !victoriaO);
        if(victoriaX){
            System.out.println("Jugador 1 (X) ha ganado");
        }else if (victoriaO){
            System.out.println("Jugador 2 (O) ha ganado");
        }
    }
}
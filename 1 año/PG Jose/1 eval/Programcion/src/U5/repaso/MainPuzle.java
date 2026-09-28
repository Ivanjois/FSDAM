import java.util.Scanner;
public class MainPuzle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Puzle p = new Puzle();
        String opcion;
        System.out.println("¡Juego nuevo!");
        p.mostrar();
        do{
            System.out.println("- ¿Hacia dónde quieres mover? (arriba (A), abajo (B), izquierda (I), derecha (D)): ");
            opcion = sc.nextLine();
            opcion = opcion.toUpperCase();
            switch(opcion){
                case "A":
                    p.moverArriba();
                    break;
                case "B":
                    p.moverAbajo();
                    break;
                case "I":
                    p.moverIzquierda();
                    break;
                case "D":
                    p.moverDerecha();
                    break;
                default:
                    System.out.println("Opción incorrecta");
                    break;
            }
            p.mostrar();
        }while(!p.estaResuelto());
        System.out.println("¡Felicidades! El puzle está resuelto.");
    }
}
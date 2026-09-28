//package U5.ActividadesAvanzadas;
//
//public class mainPuzle15 {
//    public static void main(String[] args) {
//        java.util.Scanner sc = new java.util.Scanner(System.in);
//        Puzle15 juego = new Puzle15();
//        boolean terminado = false;
//
//        System.out.println("--- BIENVENIDO AL PUZLE 15 ---");
//        System.out.println("Instrucciones: Introduce la fila y columna de la pieza que quieras mover al espacio vacío.");
//
//        while (!terminado) {
//            System.out.println("\nTablero actual:");
//            juego.mostrarTablero();
//
//            if (juego.estaResuelto()) {
//                System.out.println("\n¡FELICIDADES! Has resuelto el puzle.");
//                terminado = true;
//            } else {
//                System.out.print("\nIntroduce fila (0-3): ");
//                int fila = sc.nextInt();
//                System.out.print("Introduce columna (0-3): ");
//                int columna = sc.nextInt();
//
//                if (fila >= 0 && fila < 4 && columna >= 0 && columna < 4) {
//                    if (!juego.mover(fila, columna)) {
//                        System.out.println("Movimiento no válido: La pieza debe estar adyacente al hueco.");
//                    }
//                } else {
//                    System.out.println("Coordenadas fuera de rango.");
//                }
//            }
//        }
//        sc.close();
//    }
//
//}

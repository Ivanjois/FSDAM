package U2.Actividades_Entregables;

import java.util.Scanner;

public class U2A4_Ivan_Poyda {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int CADENTRADA = 5;
        final int MATRIZ = 5;
        char[][] asientoD = new char[5][5];
        boolean salir = false, Si = false;
        String libre = "L", ocupado = "O";
        int opcion, fila = 0, columna = 0, entrada = 0, ocupadas = 0, libres = 25;
        for (int i = 0; i < MATRIZ; i++) {
            for (int j = 0; j < MATRIZ; j++) {
                asientoD[i][j] = 'L';
            }
        }
        do {
            System.out.println("---- CINE DAM ----");
            System.out.println("1. Mostrar butacas");
            System.out.println("2. Comprar entrada");
            System.out.println("3. Ver estadísticas");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Asientos: ");
                    System.out.print("  ");
                    for (int i = 0; i < MATRIZ; i++) {
                        System.out.print(i + " ");
                    }
                    System.out.println();
                    for (int i = 0; i < MATRIZ; i++) {
                        System.out.print(i + " ");
                        for (int j = 0; j < MATRIZ; j++) {
                            System.out.print(asientoD[i][j] + " ");
                        }
                        System.out.println();
                    }
                    break;

                case 2:
                    System.out.print("Introduce la fila (0-4): ");
                    fila = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Introduce columna (0-4): ");
                    columna = sc.nextInt();
                    sc.nextLine();
                    if (asientoD[fila][columna] == 'O') {
                        System.out.println("No se puede comprar esta ocupada");
                    } else if (asientoD[fila][columna] == 'L') {
                        asientoD[fila][columna] = 'O';
                        System.out.print("Compra con éxito");
                        entrada += CADENTRADA;
                        ocupadas += 1;
                        libres -= 1;
                    }
                    break;

                case 3:
                    System.out.println("--- ESTADÍSTICAS ---");
                    System.out.println("Butacas Ocupadas: "+ocupadas);
                    System.out.println("Butacas Libres: "+libres);
                    System.out.println("Total Recaudado: "+entrada);
                    break;

                case 4:
                    salir = true;
                    break;

                default:
                    System.out.println("Esta opción no es valida");
            }
        } while (!salir);
        {
        }
    }
}

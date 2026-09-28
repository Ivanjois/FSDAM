package U3;

import java.util.Scanner;

public class Ej6IU3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa el caracter para la piramide");
        char caracter = sc.next().charAt(0);
        sc.nextLine();
        System.out.println("Ingresa el numero de lineas para la piramide");
        int lineas = sc.nextInt();
        sc.nextLine();
        trianguloZetas(lineas, caracter);
    }
    public static void trianguloZetas(int numeroL, char caracter) {
        for (int i = 1; i <= numeroL; i++) {
            for (int j = i; j <= numeroL; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < (2*i-1); k++) {
                System.out.print(caracter);
            }
            System.out.println();
        }
    }
}

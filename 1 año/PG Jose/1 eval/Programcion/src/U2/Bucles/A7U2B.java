package U2.Bucles;

import java.util.Scanner;

public class A7U2B {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cuadrado = 0;
        System.out.println("Tamaño del cuadrado: ");
        cuadrado = input.nextInt();
        input.nextLine();
        char[][] formacuadrado = new char[cuadrado][cuadrado];
        for(int i = 0; i < cuadrado; i++){
            for(int j = 0; j < cuadrado; j++){
                formacuadrado[i][j] = '*';
            }
        }
        for (int i = 0; i < cuadrado; i++) {
            for (int j = 0; j < cuadrado; j++) {
                System.out.print(formacuadrado[i][j] + " ");
            }
            System.out.println();
        }
        }
}
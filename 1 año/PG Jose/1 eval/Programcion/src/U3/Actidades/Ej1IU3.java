package U3;

import java.util.Scanner;

public class Ej1IU3 {
    public static int minimo(int a, int b) {
        if (a>b){
            return a;
        }
        else {
            return b;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1, n2, n3, mayorTemp, mayorFinal;
        System.out.print("Ingrese el numero a a comparar: ");
        n1 = sc.nextInt();
        System.out.print("Ingrese el numero b a comparar: ");
        n2 = sc.nextInt();
        System.out.print("Ingrese el numero c a comparar: ");
        n3 = sc.nextInt();
        sc.nextLine();
        mayorTemp = minimo(n1, n2);
        mayorFinal = minimo(mayorTemp, n3);
        if(n1!=mayorTemp && n1!=mayorFinal){
            System.out.println("El mas alto es: " + mayorFinal);
        }
    }
}
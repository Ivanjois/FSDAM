package U3;

import java.util.Scanner;

public class Ej1U3 {
    public static double multiplicar(double a, double b){
        return a*b;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double numero1, numero2;
        System.out.println("Cual es el primer numero que quieres multiplicar");
        numero1 = sc.nextDouble();
        sc.nextLine();
        System.out.println("Cual es el segundo numero que quieres multiplicar");
        numero2 = sc.nextDouble();
        sc.nextLine();
        System.out.println("El resultado es: " + multiplicar(numero1, numero2));
    }
}

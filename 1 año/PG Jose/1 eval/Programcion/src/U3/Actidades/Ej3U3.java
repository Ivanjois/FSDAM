package U3;

import java.util.Scanner;

public class Ej3U3 {
    public static int minimo(int a, int b){
        int n1, n2;
        if(a>b){
            n1 = a;
            n2 = b;
        }else {
            n1 = b;
            n2 = a;
        }
        return n2;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1, num2;
        System.out.println("Ingrese el primer numero a saber si es menor: ");
        num1 = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingrese el segundo numero a saber si es menor: ");
        num2 = sc.nextInt();
        sc.nextLine();
        System.out.println("El numero menor es: "+minimo(num1,num2));
    }
}

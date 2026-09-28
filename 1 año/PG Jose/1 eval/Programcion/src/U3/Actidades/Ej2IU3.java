package U3;

import java.util.Scanner;

public class Ej2IU3 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero;
        System.out.print("Ingresa el valor que quieres su tabla de multiplicar: ");
        numero = sc.nextInt();
        sc.nextLine();
        tablaMultiplicar(numero);
    }
    public static void tablaMultiplicar(int a){
        int n1;
        System.out.println("La tabla de multiplicar del numero : "+a);
        for (int i=1;i<=10;i++){
            n1 = a*i;
            System.out.println(a+" por "+i+": "+n1);
        }
    }
}

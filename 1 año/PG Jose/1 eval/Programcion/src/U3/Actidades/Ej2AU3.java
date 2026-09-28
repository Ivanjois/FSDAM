package U3.Actidades;

import java.util.Scanner;

public class Ej2AU3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numerosDNI;
        System.out.println("Dime el numero de DNI y te devolverer el DNI + tu letra: ");
        numerosDNI = sc.nextInt();
        sc.nextLine();
        System.out.println("Tu DNI es: " + numerosDNI + letraDNI(numerosDNI));
    }

    public static String letraDNI(int numerosDNI) {
        int numeroletra = numerosDNI % 23;
        String[] letra = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
        return letra[numeroletra];
    }
}

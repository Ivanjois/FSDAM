import java.util.Scanner;

public class Ej21B2U2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1, n2, n3;
        System.out.println("Ingrese el numero del primer lado: ");
        n1 = sc.nextInt();
        System.out.println("Ingrese el numero del segundo lado: ");
        n2 = sc.nextInt();
        System.out.println("Ingrese el numero del tercer lado: ");
        n3 = sc.nextInt();
        if (n1 == n2 && n2 == n3) {
            System.out.println("El triángulo es: Equilátero (3 lados iguales).");
        } else if (n2 == n1 || n2 == n3 || n3 == n1) {
            System.out.println("El triángulo es: Isósceles (2 lados iguales).");
        } else {
            System.out.println("El triángulo es: Escaleno (Ningún lado igual).");
        }
    }
}
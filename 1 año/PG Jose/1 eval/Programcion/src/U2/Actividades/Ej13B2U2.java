import java.util.Scanner;

public class Ej13B2U2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa cuanto mide la base del rectángulo: ");
        double base = sc.nextDouble();
        System.out.println("Ingresa cuanto mide de alto: ");
        double alto = sc.nextDouble();
        double area = base * alto;
        System.out.println("El resultado es: " + area);
    }
}

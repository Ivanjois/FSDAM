import java.util.Scanner;

public class Ej10B2U2 {
    public static void main(String[] args) {
        double division, numeroalto, numerobajo;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el primero numero para la operacion: ");
        double numero1 = sc.nextInt();
        System.out.println("Introduce el segundo numero para la operacion: ");
        double numero2 = sc.nextInt();
        if (numero1 > numero2) {
            numeroalto = numero1;
            numerobajo = numero2;
            division = numeroalto / numerobajo;
            System.out.println("El primero numero es: " + division);

        } else {
            numeroalto = numero2;
            numerobajo = numero1;
            division = numeroalto / numerobajo;
            System.out.println("El primero numero es: " + division);
        }

    }
}

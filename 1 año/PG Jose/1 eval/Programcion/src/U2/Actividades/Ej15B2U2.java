import java.util.Scanner;

public class Ej15B2U2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a, b, c, d, e, f;
        double D, Dx, Dy;
        double x, y;

        System.out.println("--- Sistema de Ecuaciones Lineales (ax + by = c, dx + ey = f) ---");

        System.out.print("Introduce el coeficiente a: ");
        a = sc.nextDouble();

        System.out.print("Introduce el coeficiente b: ");
        b = sc.nextDouble();

        System.out.print("Introduce el coeficiente c: ");
        c = sc.nextDouble();

        System.out.print("Introduce el coeficiente d: ");
        d = sc.nextDouble();

        System.out.print("Introduce el coeficiente e: ");
        e = sc.nextDouble();

        System.out.print("Introduce el coeficiente f: ");
        f = sc.nextDouble();

        D = (a * e) - (d * b);
        Dx = (c * e) - (f * b);
        Dy = (a * f) - (d * c);

        if (D != 0) {
            x = Dx / D;
            y = Dy / D;

            System.out.println("\n--- Solución ---");
            System.out.println("Determinante D = " + D);
            System.out.println("x = " + x);
            System.out.println("y = " + y);
        } else {

            System.out.println("\nEl determinante del sistema es cero.");
            System.out.println("El sistema no tiene solución única (puede ser incompatible o indeterminado).");
        }

        sc.close();
    }
}
import java.util.Scanner;

public class Ej12B2U2 {
    public static void main(String[] args) {
        double n1, n2, suma, division, producto, primero, segundo;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el numero 1 de la operacion:");
        n1 = sc.nextInt();
        System.out.println("Ingrese el numero 2 de la operacion:");
        n2 = sc.nextInt();
        if (n1 > n2) {
            primero = n1;
            segundo = n2;
            if (n1 > 0 && n2 > 0) {
                suma = n1 + n2;
                division = primero / segundo;
                producto = n1 * n2;
                System.out.println("Resultado de la suma: " + suma + ".\nDe la division: " + division + ".\nDel producto: " + producto + ".");
            } else {
                System.out.println("Error no se puede realizar la operacion.");
            }
        }else {
            primero = n2;
            segundo = n1;
            if (n1 > 0 && n2 > 0) {
                suma = n1 + n2;
                division = primero / segundo;
                producto = n1 * n2;
                System.out.println("Resultado de la suma: " + suma + ".\nDe la division: " + division + ".\nDel producto: " + producto + ".");
            } else {
                System.out.println("Error no se puede realizar la operacion.");
            }
        }

    }
}

import java.util.Scanner;

public class Ej14B2U2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double numero;
        System.out.println("Ingrese el numero que quieras saber si es positivo o negativo: ");
        numero = sc.nextDouble();
        if (numero < 0) {
            System.out.println("El numero "+numero+" es negativo");
        } else if (numero > 0) {
            System.out.println("El numero "+numero+" es positivo");
        }
    }
}

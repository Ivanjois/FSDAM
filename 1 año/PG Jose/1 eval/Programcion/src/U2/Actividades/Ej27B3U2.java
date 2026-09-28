import java.util.Scanner;

public class Ej27B3U2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero = 0, suma = 0;
        do {
            System.out.println("Ingrese el numero (negativo para detener): ");
            numero = sc.nextInt();

            if (numero > 0) {
                suma += numero;
            }

        } while (numero >= 0);
        System.out.println("La suma de los números positivos introducidos es: " + suma);
    }
}
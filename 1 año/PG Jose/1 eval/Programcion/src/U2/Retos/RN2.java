import java.util.Scanner;

public class RN2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numeroUsuario = 0, numerointentos = 0, intentosrestantes, intentoshechos = 0, intentoreales;
        final int INTENTOS_MAXIMOS = 5;
        int numeroSecreto = (int) (Math.random() * 100) + 1;
        System.out.println("Veremos si aciertas el numero");
        while (numeroUsuario != numeroSecreto && numerointentos < INTENTOS_MAXIMOS) {
            numerointentos++;
            intentoreales = INTENTOS_MAXIMOS - numerointentos;
            intentosrestantes = (INTENTOS_MAXIMOS - numerointentos)+1;
            System.out.println("Este es tu intento " + numerointentos + " te quedan: " + intentosrestantes);
            System.out.println("Ingrese el numero secreto que crees usuario desconocido puedes intentarlo: " + intentosrestantes + " veces.");
            numeroUsuario = sc.nextInt();
            if (numeroUsuario == numeroSecreto) {
                System.out.println("Has ganado");
                System.out.println("Tu numero es el correcto " + numeroUsuario + " es el mismo que el numero secreto: " + numeroSecreto + " y los has conseguido en el inteto " + numerointentos + ".");
            } else if (numeroSecreto > numeroUsuario) {
                System.out.println("El numero secreto es mayor que el numero que me has puesto: " + numeroUsuario + "." + numeroSecreto);
            } else {
                System.out.println("El numero secreto es menor que el numero que me has puesto: " + numeroUsuario);
            }
        }if (numerointentos == INTENTOS_MAXIMOS) {
            System.out.println("Error el numero secreto era " + numeroSecreto);
            System.out.println("Te has quedado sin intentos has perdido");
        }
    }
}
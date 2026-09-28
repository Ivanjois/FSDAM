import java.util.Scanner;

public class RN1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numeroUsuario;
        int numeroSecreto = (int) (Math.random() * 100) + 1;
        System.out.println("Veremos si aciertas el numero");
        System.out.println("Ingrese el numero secreto que crees usuario desconocido tienes intentos infinitos");
        numeroUsuario = sc.nextInt();
        while (numeroUsuario != numeroSecreto) {
            if (numeroSecreto > numeroUsuario) {
                System.out.println("El numero secreto es mayor que el numero que me has puesto: " + numeroUsuario);
                System.out.println("Ingrese el numero secreto que crees usuario desconocido tienes intentos infinitos");
                numeroUsuario = sc.nextInt();
                sc.nextLine();
            } else {
                System.out.println("El numero secreto es menor que el numero que me has puesto: " + numeroUsuario);
                System.out.println("Ingrese el numero secreto que crees usuario desconocido tienes intentos infinitos");
                numeroUsuario = sc.nextInt();
                sc.nextLine();
            }
        }
        System.out.println("Tu numero es el correcto " + numeroUsuario + " \n es el mismo que el secreto: " + numeroSecreto);
    }
}


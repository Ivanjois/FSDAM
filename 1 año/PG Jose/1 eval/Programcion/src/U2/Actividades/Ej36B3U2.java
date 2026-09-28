import java.util.Scanner;

public class Ej36B3U2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] billetes = {500, 200, 100, 50, 20, 10, 5};
        int retirar;
        System.out.println("Ingrese el numero de a retirar: ");
        retirar = sc.nextInt();
        sc.nextLine();
        int billete = 0;
        for (int i = 0; i < billetes.length; i++) {
            billete = retirar / billetes[i];
            if (billete > 0) {
                System.out.println(billetes[i] + " " + billete);
                retirar = retirar - (billetes[i] * billete);
            }
        }
    }
}
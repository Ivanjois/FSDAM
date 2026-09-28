import java.util.Scanner;

public class Ej18B2U2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero;
        System.out.print("Ingrese el numero del 1 al 12: ");
        numero = sc.nextInt();
        sc.nextLine();
        switch (numero) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("Este mes tiene 31 días.");
                break;
            case 2:
                System.out.println("Este mes tiene 28 días.");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("Este mes tiene 30 días.");
                break;
            default:
                System.out.println("ERROR: El número introducido no corresponde a un mes válido (1-12).");
                break;
        }
        sc.close();
    }
}

import java.util.Scanner;

public class Ej20B2U2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double nota;
        char sexo;
        System.out.println("Di tu nota de 0-10: ");
        nota = sc.nextDouble();
        sc.nextLine();
        System.out.println("Di tu sexo (H/M): ");
        sexo = sc.next().charAt(0);
        switch ((int) nota) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
                if (sexo == 'H') {
                    System.out.println("Estas Suspenso porque tu nota es " + nota + ".");
                } else {
                    System.out.println("Estas Suspensa porque tu nota es " + nota + ".");
                }
                break;
            case 5:
            case 6:
                if (sexo == 'H') {
                    System.out.println("Estas Aprovado porque tu nota es " + nota + ".");
                } else {
                    System.out.println("Estas Aprovada porque tu nota es " + nota + ".");
                }
                break;
            case 7:
            case 8:
                System.out.println("Tienes un Notable porque tu nota es " + nota + ".");
                break;
            case 9:
            case 10:
                System.out.println("Tienes Sobresaliente porque tu nota es " + nota + ".");
                break;
            default:
                System.out.println("Esta opcion no es posible");
                break;
        }
    }
}

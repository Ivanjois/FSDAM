import java.util.Scanner;

public class Ej17B2U2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int año;
        System.out.println("Que año quieres ver si es bisiesto");
        año = input.nextInt();

        if ((año % 4 == 0 && año % 100 != 0) || año % 400 == 0) {
            System.out.println("Este año si que es bisiesto: " + año);
        } else {
            System.out.println("Este año no es bisiesto: " + año);
        }
    }
}


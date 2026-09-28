import java.util.Scanner;

public class Ej28B3U2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero, factorial = 1;
        System.out.println("Dime el numero que deseas saber su factorial");
        numero = sc.nextInt();
        sc.nextLine();
        for (int i = 1; i <= numero; i++) {
            factorial *= i;
        }
        System.out.println("factorial es: " + factorial);
    }
}

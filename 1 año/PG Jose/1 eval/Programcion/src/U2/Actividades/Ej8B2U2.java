import java.util.Scanner;

public class Ej8B2U2 {
    public static void main(String[] args) {
        int n1, n2, inicio, fin, i;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el primer número (n1):");
        n1 = sc.nextInt();
        System.out.println("Introduce el segundo número (n2):");
        n2 = sc.nextInt();
        if (n1 > n2) {
            int n3 = n1;
            n1 = n2;
            n2 = n3;
        }
        for (i = n1; i <= n2; i++) {
            if (i % 2 == 0) {
                System.out.println("Estos son pares " + i);
            }
        }
    }
}
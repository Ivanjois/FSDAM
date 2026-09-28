import java.util.Scanner;

public class A1U2B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int edad = 0;
        System.out.print("Ingrese el edad: ");
        edad = sc.nextInt();
        sc.nextLine();
        if (edad >= 18) {
            System.out.println("Puedes pasar");
        } else if ((edad <= 17) && (edad >= 16)) {
            System.out.println("light");
        } else if (edad < 16) {
            System.out.println("no puedes pasar");
        }
    }
}
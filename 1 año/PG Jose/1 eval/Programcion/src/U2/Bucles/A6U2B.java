import java.util.Scanner;

public class A6U2B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1, n2, suma;
        char respuesta;
        do {
            System.out.println("Dime el primer numero que quieres sumar: ");
            n1 = sc.nextInt();
            sc.nextLine();
            System.out.println("Dime el segundo numero que quieres sumar: ");
            n2 = sc.nextInt();
            sc.nextLine();
            suma = n1 + n2;
            System.out.println("La suma es: "+suma);
            System.out.println("¿Quieres volver a jugar (S o N)?");
            respuesta = sc.next().charAt(0);
        }while((!(respuesta == 'n')) && (!(respuesta == 'N')));
        System.out.println("!Hasta la proxima!");
    }
}

import java.util.Scanner;

public class U2A1_Ivan_Poyda {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float precio;
        int tamaño;
        char tipo;
        System.out.println("--- COOPERATIVA CASABLANCA: CALCULADORA DE PRECIOS ---");
        System.out.println("Introduce los siguientes datos: ");
        System.out.println("Ingrese el precio inicial: ");
        precio = sc.nextFloat();
        sc.nextLine();
        System.out.println("Ingrese el tipo: ");
        tipo = sc.nextLine().charAt(0);
        System.out.println("Ingrese el tamaño(1 o 2): ");
        tamaño = sc.nextInt();
        sc.nextLine();

        if (tipo == 'A') {
            if (tamaño == 1) {
                precio = (float) (precio + 0.1);
            } else if (tamaño == 2) {
                precio = (float) (precio + 0.25);
            } else {
                System.out.println("error");
            }
        } else if (tipo == 'B') {
            if (tamaño == 1) {
                precio = (float) (precio - 0.1);
            } else if (tamaño == 2) {
                precio = (float) (precio - 0.25);
            } else {
                System.out.println("error");

            }
        } else {
            System.out.println("error");
        }
        System.out.println("--- RESULTADO ---");
        System.out.println("El precio es: " + precio + "€/kg");
    }
}

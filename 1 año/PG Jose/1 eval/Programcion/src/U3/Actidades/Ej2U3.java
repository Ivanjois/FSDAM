package U3;

import java.util.Scanner;

public class Ej2U3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int edad;
        boolean mayorEdad;
        System.out.println("Ingrese el edad: ");
        edad = sc.nextInt();
        sc.nextLine();

        mayorEdad = esMayorEdad(edad);
        if (mayorEdad) {
            System.out.println("Mayor edad");
        }
    }

    public static boolean esMayorEdad(int a) {
        boolean mayor = false;
        if (a >= 18) {
            mayor = true;
        }
        return mayor;
    }


}

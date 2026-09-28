import java.util.Scanner;

public class A9U2B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int saldo = 1000, opcion = 0, ingreso = 0, retirar = 0, cantidadPendiente;
        boolean salir = false;
        do {
            System.out.println("---- MENÚ CAJERO AUTOMÁTICO ----");
            System.out.println("1. Consultar saldo ");
            System.out.println("2. Ingresar dinero ");
            System.out.println("3. Retirar dinero ");
            System.out.println("4. Salir");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Saldo actual: " + (float) saldo + " €");
                    break;
                case 2:
                    System.out.print("Cantidad a ingresar posible solo billetes:  ");
                    ingreso = sc.nextInt();
                    sc.nextLine();
                    if (ingreso % 5 == 0) {
                        saldo += ingreso;
                        System.out.println("Saldo actual: " + (float) saldo);
                    } else {
                        System.out.println("Cantidad no válida. Solo se pueden ingresar múltiplos de 5.");
                    }
                    break;
                case 3:
                    System.out.print("Cantidad a retirar:  ");
                    retirar = sc.nextInt();
                    sc.nextLine();
                    if (retirar < 5) {
                        System.out.println("Cantidad no válida.");
                    } else if (retirar > saldo) {
                        System.out.println("Saldo insuficiente. Saldo disponible: " + saldo + " €");
                    } else if (retirar % 5 != 0) {
                        System.out.println("Cantidad no válida. Solo se pueden retirar múltiplos de 5.");
                    }else {
                        saldo -= retirar;
                        System.out.println("Operación realizada con éxito.");
                        System.out.println("Saldo actual: " + (float) saldo + " €");
                    }
                    break;
                case 4:
                    salir = true;
                    System.out.println("Gracias por usar el cajero. ¡Adiós!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige entre 1 y 4.");
            }
        } while (!salir);
        sc.close();
    }
}
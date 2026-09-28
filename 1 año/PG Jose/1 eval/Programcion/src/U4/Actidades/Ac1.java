package U4.Actidades;

import java.util.ArrayList;
import java.util.Scanner;

public class Ac1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> clientes = new ArrayList<>();
        ArrayList<Double> deudas = new ArrayList<>();
        char opcion;
        do {
            Bienvenida();
            opcion = sc.next().toLowerCase().charAt(0);
            switch (opcion) {
                case 'a':
                    NuevoCliente(clientes, deudas, sc);
                    System.out.println("El cliente se ha añadido" + clientes);
                    break;
                case 'e':

                case 'd':
                case 'c':
                case 'm':
                case 's':

            }

        } while (true);
    }

    public static void Bienvenida() {
        System.out.println("Bienvenido");
        System.out
                .println("Añadir cliente (A): Pide nombre y deuda inicial. Si el cliente ya existe, muestra un error.");
        System.out.println("Eliminar cliente (E): Pide el nombre y, si existe, lo borra de ambas listas.");
        System.out.println(
                "Consultar listado (D): Muestra una tabla con todos los clientes y sus deudas, y el total global de deuda acumulada.");
        System.out.println("Consultar saldo cliente (C): Pide un nombre y muestra cuánto debe esa persona específica.");
        System.out.println(
                "Modificar deuda (M): Pide un nombre y la nueva cantidad. Actualiza el valor en la lista de deudas.");
        System.out.println(
                "Salir (S): Muestra un mensaje de despedida y vacía ambas listas antes de terminar (simulando una limpieza de memoria).");
        System.out.println("Que opcion eliges?");
    }

    private static void NuevoCliente(ArrayList<String> Clientes, ArrayList<Double> Deudas, Scanner sc) {
        String clienteNuevo;
        System.out.println("Ingresa el nombre del cliente que quieres añadir: ");
        clienteNuevo = sc.next();
        if (Clientes.contains(clienteNuevo)) {
            System.out.println("Error este ya existe");
        } else {
            Clientes.add(clienteNuevo);
        }
    }
}

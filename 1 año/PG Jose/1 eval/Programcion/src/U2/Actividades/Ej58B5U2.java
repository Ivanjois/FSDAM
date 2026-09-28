package U2.Actividades;

import java.util.Scanner;

public class Ej58B5U2 {
    public static void main(String[] args) {
        String[][] golosinas = {
                {"KitKat", "Chicles de fresa", "Lacasitos", "Palotes"},
                {"Kinder Bueno", "Bolsa variada Haribo", "Chetoos", "Twix"},
                {"Kinder Bueno", "M&M'S", "Papa Delta", "Chicles de menta"},
                {"Lacasitos", "Crunch", "Milkybar", "KitKat"}
        };
        double[][] precios = {
                {1.1, 0.8, 1.5, 0.9},
                {1.8, 1, 1.2, 1},
                {1.8, 1.3, 1.2, 0.8},
                {1.5, 1.1, 1.1, 1.1}
        };
        int[][] cantidades = new int[4][4];
        float dinero = 100;
        char opcion;
        boolean salir = false;
        int fila, columna;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Menú de opiciones");
            System.out.println("a.Pedir Golosina: El usuario introduce un código de dos dígitos (fila y columna). Si hay stock y tiene dinero suficiente, se realiza la venta.");
            System.out.println("b.Mostrar Golosinas: Muestra el código, nombre y precio de todos los productos.");
            System.out.println("c.Rellenar Golosinas (Técnico): Pide una contraseña. Si es correcta, permite aumentar el stock de una golosina.");
            System.out.println("d.Apagar Máquina: Muestra las ventas totales y termina el programa.");
            opcion = sc.next().charAt(0);
            switch (opcion) {
                case 'a':
                    System.out.println("Dime el numero de fila y luego la columna de la golosina que quieras: ");
                    fila = sc.nextInt();
                    sc.nextLine();
                    columna = sc.nextInt();
                    sc.nextLine();

                case 'b':
                case 'c':
                case 'd':
            }
        } while (salir);
        {
        }
    }
}

package U3;

import java.util.Scanner;
public class Ej5IU3 {
    /**
     * Función para calcular el porcentaje de descuento del precio.
     * @param numero número sin descuento
     * @param numeroDescu numero con descuento
     * @return 100-descuento A 100 le restamos el resultado de descuento para sacar el descuento en %.
     */
    public static double Descuento(double numero, double numeroDescu) {
       double descuento = ((numeroDescu*100)/numero);
        return 100-descuento;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el numero: ");
        double numero = sc.nextDouble();
        sc.nextLine();
        System.out.print("Ingrese el numero con descuento: ");
        double numeroDescu = sc.nextDouble();
        sc.nextLine();
        System.out.println("El descuento es de: "+(float)Descuento(numero, numeroDescu)+"%.");
        sc.close();
    }
}

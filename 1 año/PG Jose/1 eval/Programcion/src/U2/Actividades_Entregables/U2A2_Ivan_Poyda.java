import java.util.Scanner;

public class U2A2_Ivan_Poyda {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int FACTURAS = 4;
        int[] codigo = new int[FACTURAS];
        int[] litros = new int[FACTURAS];
        float[] precioL = new float[FACTURAS];
        float[] precioF = new float[FACTURAS];
        float preciot = 0;
        int litrosT = 0, m200 = 0, Articulo1 = 0;
        for (int i = 1; i < FACTURAS; i++) {
            System.out.println("Código de la factura: ");
            codigo[i] = sc.nextInt();
            sc.nextLine();
            System.out.println("Litros de la factura: ");
            litros[i] = sc.nextInt();
            sc.nextLine();
            System.out.println("Precio del L: ");
            precioL[i] = sc.nextFloat();
            sc.nextLine();
            precioF[i] = litros[i] * precioL[i];
            preciot += precioF[i];
            litrosT += litros[i];
            if (codigo[i] == 1) {
                Articulo1 += litros[i];
            }
            if (precioF[i] > 200) {
                m200 += 1;
            }
        }
        System.out.println("--- EJEMPLO DE ENTRADA ---");
        for (int i = 1; i < FACTURAS; i++) {
            System.out.println("Factura " + i + " - Código: " + codigo[i] + ", Litros: " + litros[i] + ", Precio/L: " + precioL[i] + ".");
        }
        System.out.println();
        System.out.println("--- RESUMEN DE VENTAS ---");
        System.out.println("* Facturación total: " + preciot + " €");
        System.out.println("* Cantidad de litros vendidos del artículo #1: "+Articulo1);
        System.out.println("* Número de facturas de más de 200 €: "+m200);
    }
}

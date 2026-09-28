import java.util.Scanner;

public class Ej34B3U2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int base = -1, altura = -1, superficie;
        boolean continuar = true;
        String respuesta = "";
        while (continuar) {
            do {
                System.out.println("Introduzca la base del triangulo(debe ser positivo): ");
                base = sc.nextInt();
                sc.nextLine();
                System.out.println("Introduzca la altura del triangulo(debe ser positivo): ");
                altura = sc.nextInt();
                sc.nextLine();
            }
            while (base < 0 || altura < 0); {}
            superficie = (base*altura)/2;
            System.out.println("Superficie: "+superficie);
            System.out.println("Deseas volver a calcular otra superficie? [Si/No]");
            respuesta = sc.nextLine();
            if (respuesta.equalsIgnoreCase("si")) {
                System.out.println("Vale perfecto volvamos a calcular otra superficie.");
            }
            else if (respuesta.equals("no")) {
                System.out.println("Hasta luego :)");
                continuar = false;
            }
        }
    }
}

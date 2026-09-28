package U3;

import java.util.Scanner;

public class Ej4U3 {
    public static int dimeSigno(int a) { // Declaración: public static int, Tipo de Retorno int, Nombre y Parámetro int a [14]

        if (a < 0) { // Si el número es menor que cero (negativo)
            return -1; // Devuelve -1 [7]
        } else if (a > 0) { // Si el número es mayor que cero (positivo) [9]
            return 1; // Devuelve 1 [7]
        } else { // Si no es ni negativo ni positivo, es cero [15]
            return 0; // Devuelve 0 [7]
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite um numero: ");
        int a = sc.nextInt();
        sc.nextLine();
        int resultado = dimeSigno(a);
        System.out.println(resultado);
    }
}

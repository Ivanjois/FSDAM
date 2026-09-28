import java.util.Scanner;
import java.lang.Math; // Incluimos la librería Math para usar pow

public class Ej38B3U2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num1, num2, inicio, fin;

        // 1. Petición de entrada al usuario
        System.out.print("Introduce el primer número entero del rango (p): ");
        num1 = sc.nextInt(); // Lee un número entero

        System.out.print("Introduce el segundo número entero del rango (j): ");
        num2 = sc.nextInt();

        // 2. Determinar el rango (asegurando que 'inicio' es el menor)
        if (num1 <= num2) {
            inicio = num1;
            fin = num2;
        } else {
            inicio = num2;
            fin = num1;
        }

        System.out.println("\n--- Calculando potencias de " + inicio + " a " + fin + " ---");

        // 3. Iteración y cálculo: Bucle for
        for (int i = inicio; i <= fin; i++) {

            // Calculamos el cuadrado y el cubo. Usamos Math.pow y hacemos casting a int:
            int cuadrado = (int) Math.pow(i, 2);
            int cubo = (int) Math.pow(i, 3);

            // Mostrar el resultado
            System.out.println("Número: " + i + " | Cuadrado: " + cuadrado + " | Cubo: " + cubo);
        }

        sc.close();
    }
}
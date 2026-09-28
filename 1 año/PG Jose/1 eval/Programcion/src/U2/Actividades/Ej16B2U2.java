import java.util.Scanner;

public class Ej16B2U2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double celsius, fahrenheit;

        System.out.print("Introduce la temperatura en grados Celsius: ");
        celsius = sc.nextDouble();

        fahrenheit = (celsius * 9.0/5.0) + 32;

        System.out.println("\n--- Resultado de la Conversión ---");
        System.out.println(celsius + "°C equivalen a " + fahrenheit + "°F.");

        sc.close();
    }
}
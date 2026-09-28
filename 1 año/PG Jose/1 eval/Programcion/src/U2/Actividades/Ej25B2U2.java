import java.util.Scanner;
// Necesario para la entrada por teclado [8, 11]

public class Ej25B2U2 {

    public static void main(String[] args) {

        // 1. Configuración de entrada
        Scanner teclado = new Scanner(System.in);

        System.out.println("--- Asignador de Colores ---");
        System.out.print("Introduce un carácter (r, v, a, n): ");

        // 2. Lectura y Procesamiento de la entrada
        // Leemos la entrada como String y extraemos el primer carácter [10]
        // Luego, convertimos ese carácter a minúscula (mediante el String) para asegurar que 'R' y 'r' funcionen igual [7]
        char letra = teclado.next().toLowerCase().charAt(0);

        // 3. Estructura de Control Condicional Múltiple (switch) [2]

        // Evaluamos el carácter en minúscula
        switch (letra) {

            // Caso 'r' o 'R'
            case 'r': // Las constantes de carácter van entre comillas simples [12]
                System.out.println("El color asignado es: ROJO");
                break; // El 'break' es crucial para salir del switch [13]

            // Caso 'v' o 'V'
            case 'v':
                System.out.println("El color asignado es: VERDE");
                break;

            // Caso 'a' o 'A'
            case 'a':
                System.out.println("El color asignado es: AZUL");
                break;

            // Caso 'n' o 'N'
            case 'n':
                System.out.println("El color asignado es: NEGRO");
                break;

            // Valor por defecto [2, 10]
            default:
                System.out.println("Carácter no asignado a un color conocido.");
                break;
        }

        teclado.close();
    }
}

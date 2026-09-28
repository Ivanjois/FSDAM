import java.util.Scanner; // Necesario para la entrada por teclado [2, 7, 11]
// La clase Math no requiere importación, ya que está en java.lang [8]

public class Ej24B2U2 {

    public static void main(String[] args) {

        // 1. Inicialización de Scanner y variables
        Scanner teclado = new Scanner(System.in);
        // Se utiliza 'double' para los números reales (coordenadas) [12]
        double x1, y1, x2, y2, distancia;

        System.out.println("--- Calculadora de Distancia Euclidiana ---");

        // 2. Solicitud de coordenadas del Punto 1 (P1) [13]
        System.out.print("Introduce la coordenada x1: ");
        x1 = teclado.nextDouble(); // Leer un número real [14, 15]

        System.out.print("Introduce la coordenada y1: ");
        y1 = teclado.nextDouble();

        // 3. Solicitud de coordenadas del Punto 2 (P2) [13]
        System.out.print("Introduce la coordenada x2: ");
        x2 = teclado.nextDouble();

        System.out.print("Introduce la coordenada y2: ");
        y2 = teclado.nextDouble();

        // 4. Cálculo de la distancia

        // Calculamos las diferencias
        double diffX = x2 - x1;
        double diffY = y2 - y1;

        // Calculamos el cuadrado de las diferencias y las sumamos
        // Math.pow(base, 2) calcula el cuadrado [9, 10, 16, 17]
        double sumaCuadrados = Math.pow(diffX, 2) + Math.pow(diffY, 2);

        // Aplicamos la raíz cuadrada (Math.sqrt()) [9, 10]
        distancia = Math.sqrt(sumaCuadrados);

        // 5. Salida del resultado
        System.out.println("\n--- Resultado ---");
        System.out.printf("La distancia euclidiana entre P1(%.2f, %.2f) y P2(%.2f, %.2f) es: %.4f\n",
                x1, y1, x2, y2, distancia);

        teclado.close();
    }
}
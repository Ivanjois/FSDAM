import java.util.Scanner;

public class ConversorTemperatura {


    private static final double AJUSTE_FAHRENHEIT = 32.0;
    private static final double FACTOR_MULTIPLICADOR = 9.0;
    private static final double FACTOR_DIVISOR = 5.0;

    public static void main(String[] args) {

        gestionarConversion();
    }

    private static void gestionarConversion() {
        Scanner scanner = new Scanner(System.in);

        char unidadSeleccionada = solicitarUnidad(scanner);

        switch (Character.toUpperCase(unidadSeleccionada)) {
            case 'C':
                procesarCelsius(scanner);
                break;
            case 'F':
                procesarFahrenheit(scanner);
                break;
            default:
                System.out.println("Unidad de temperatura no válida");
        }

        scanner.close();
    }

    private static char solicitarUnidad(Scanner scanner) {
        System.out.println("Seleccione la unidad de temperatura (C/F):");

        if (scanner.hasNext()) {
            return scanner.next().charAt(0);
        }
        return ' ';
    }

    private static void procesarCelsius(Scanner scanner) {
        System.out.println("Introduce la temperatura en Celsius:");
        double tempCelsius = scanner.nextDouble();


        double tempFahrenheit = convertirCelsiusAFahrenheit(tempCelsius);

        System.out.println("La temperatura en Fahrenheit es: " + tempFahrenheit);
    }

    private static void procesarFahrenheit(Scanner scanner) {
        System.out.println("Introduce la temperatura en Fahrenheit:");
        double tempFahrenheit = scanner.nextDouble();

        double tempCelsius = convertirFahrenheitACelsius(tempFahrenheit);

        System.out.println("La temperatura en Celsius es: " + tempCelsius);
    }

    private static double convertirCelsiusAFahrenheit(double celsius) {
        return (celsius * FACTOR_MULTIPLICADOR / FACTOR_DIVISOR) + AJUSTE_FAHRENHEIT;
    }

    private static double convertirFahrenheitACelsius(double fahrenheit) {
        return (fahrenheit - AJUSTE_FAHRENHEIT) * FACTOR_DIVISOR / FACTOR_MULTIPLICADOR;
    }
}
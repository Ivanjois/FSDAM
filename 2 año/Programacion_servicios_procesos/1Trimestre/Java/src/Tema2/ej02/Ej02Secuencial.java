package Tema2.ej02;

public class Ej02Secuencial {

    public static boolean esPrimo(int numero) {
        // Los numeros menores o iguales a 1 no son primos
        if (numero <= 1) {
            return false;
        }
        // Comprobamos si es divisible por algun numero desde 2 hasta numero - 1
        for (int i = 2; i < numero; i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        long tiempoInicio = System.currentTimeMillis();

        for (int i = 1; i <= 400000; i++) {
            if (esPrimo(i)) {
                System.out.println("El numero " + i + " es primo.");
            } else {
                System.out.println("El numero " + i + " no es primo.");
            }
        }

        long tiempoFin = System.currentTimeMillis();
        long duracionMs = tiempoFin - tiempoInicio;
        System.out.println("Tiempo secuencial: " + duracionMs + " ms (" + (duracionMs / 1000.0) + " s)");
    }
}

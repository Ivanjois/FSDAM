package U3.Retos;

import java.util.Scanner;

/**
 * Ejercicio práctico de la Unidad 3: Gestor Meteorológico
 * <p>
 * OBJETIVO: Implementar la lógica de las funciones marcadas con "TO-DO"
 * para que el programa principal (main) funcione correctamente.
 */
public class MiniRetoU3 {

    // ############### FUNCIÓN PRINCIPAL (main) ###############
    // ¡NO MODIFICAR ESTA FUNCIÓN!
    // Su único trabajo es coordinar las llamadas a las funciones.
    public static void main(String[] args) {

        mostrarBienvenida(); // Llamada a un procedimiento

        Scanner teclado = new Scanner(System.in);

        System.out.print("¿Cuántos pueblos vas a registrar? ");
        int numPueblos = teclado.nextInt();
        teclado.nextLine();

        // Creamos los arrays paralelos. Un índice 'i' se refiere
        // al mismo pueblo en ambos arrays.
        String[] pueblos = new String[numPueblos];
        double[] temperaturas = new double[numPueblos];

        // Llamamos a una herramienta para rellenar los arrays.
        // Pasamos los arrays por REFERENCIA.
        rellenarDatos(teclado, pueblos, temperaturas);

        // Llamamos a funciones que calculan y DEVUELVEN un resultado.
        double media = calcularTempMedia(temperaturas);
        System.out.println(+media);
        // Necesitamos el ÍNDICE (la posición) para saber
        // de qué pueblo es la temperatura.
        int indiceMax = encontrarIndiceTempMaxima(temperaturas);
        int indiceMin = encontrarIndiceTempMinima(temperaturas);

        // Finalmente, llamamos a un procedimiento para mostrar el informe.
        mostrarInforme(pueblos, temperaturas, media, indiceMax, indiceMin);

        teclado.close(); // Cerramos el Scanner al final de main

    }


    // ############### HERRAMIENTAS (Funciones y Procedimientos) ###############
    // TU TRABAJO COMIENZA AQUÍ: Completa las siguientes funciones.
    // Borra el código (temporal) que no hace nada.
    // #######################################################################

    /**
     * PROCEDIMIENTO: Muestra un mensaje de bienvenida.
     * No necesita datos (parámetros) y no devuelve nada (void).
     */
    public static void mostrarBienvenida() {
        System.out.println("--- Bienvenido al Gestor Meteorológico ---");
        System.out.println("---Esto tu tranquilo solo escribe lo que te pida y todo se hará solo....Vamos alla---");
    }

    /**
     * PROCEDIMIENTO: Pide al usuario los nombres y temperaturas.
     * Recibe el Scanner y los arrays paralelos.
     * Como los arrays se pasan por REFERENCIA, los cambios hechos aquí
     * afectarán a los arrays originales del main.
     */
    public static void rellenarDatos(Scanner teclado, String[] pueblos, double[] temps) {
        for (int i = 0; i < pueblos.length; i++) {
            System.out.println("Dime el nombre del pueblo " + (i + 1) + ":");
            pueblos[i] = teclado.nextLine();
            System.out.println("Dime la temperatura del pueblo " + pueblos[i] + ":");
            temps[i] = teclado.nextDouble();
            teclado.nextLine();
        }
        // Pista: Cuidado con nextLine() después de nextDouble().
        // Lo he puesto al revés asi que no pasa nada, pero por si acaso limpio el buffer.
    }

    /**
     * FUNCIÓN: Calcula la media de las temperaturas.
     * Recibe el array de temperaturas y DEVUELVE un double (la media).
     */
    public static double calcularTempMedia(double[] temps) {
        double sumaTemp = 0;
        double media = 0;
        for (double temp : temps) {
            sumaTemp += temp;
        }
        if (temps.length > 0) {
            media = sumaTemp / temps.length;
            return media;
        } else {
            System.out.println("No hay temperaturas para calcularTempMedia");
            return 0.0;
        }
        // TO-DO: Implementar un bucle 'for' que sume todas las temperaturas
        // y devuelva la media.
        // Pista: Cuidado con la división por cero si temps.length es 0.
        // Valor por defecto. Cámbialo si es necesario
    }

    /**
     * FUNCIÓN: Encuentra el ÍNDICE de la temperatura más alta.
     * Recibe el array de temperaturas y DEVUELVE un int (la posición).
     * Devuelve -1 si el array está vacío
     */
    public static int encontrarIndiceTempMaxima(double[] temps) {
        int posicion = 0;
        for (int i = 0; i < temps.length; i++) {
            if (temps[posicion] > temps[i]) {
                posicion = i;
            }
        }
        if (posicion > 0) {
            return posicion;
        }
        else {
            System.out.println("No hay temperaturas para encontrarIndiceTempMaxima");
            return -1; // Valor por defecto
        }
        // TO-DO: Implementar un algoritmo de búsqueda para encontrar el
        // ÍNDICE (la posición) de la temperatura más alta.


    }

    /**
     * FUNCIÓN: Encuentra el ÍNDICE de la temperatura más baja.
     * Recibe el array de temperaturas y DEVUELVE un int (la posición).
     * Devuelve -1 si el array está vacío
     */
    public static int encontrarIndiceTempMinima(double[] temps) {
        // TO-DO: Implementar un algoritmo de búsqueda para encontrar el
        // ÍNDICE (la posición) de la temperatura más baja.

        System.out.println("Función 'encontrarIndiceTempMinima' no implementada.");
        return -1; // Valor por defecto
    }

    /**
     * PROCEDIMIENTO: Muestra el informe meteorológico final.
     * Recibe los arrays y los datos calculados.
     * Los parámetros 'media', 'indiceMax' e 'indiceMin' se pasan por VALOR.
     */
    public static void mostrarInforme(String[] pueblos, double[] temps, double media, int indiceMax, int indiceMin) {
        // TO-DO: Implementar la salida final del programa.
        // Debe mostrar un listado de todos los pueblos con sus temperaturas.
        // Luego, mostrar la media (con 2 decimales).
        // Finalmente, usando los índices, mostrar el nombre y temp
        // del pueblo más caluroso y el más frío.

        System.out.println("\nFunción 'mostrarInforme' no implementada.");
    }
}

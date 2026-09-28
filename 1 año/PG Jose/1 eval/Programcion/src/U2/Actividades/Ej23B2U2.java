import java.util.Scanner;
import java.util.Random; // Necesaria para generar números aleatorios

public class Ej23B2U2 {

    public static void main(String[] args) {

        // 1. Inicialización y Entrada
        Scanner teclado = new Scanner(System.in); // Usamos la clase Scanner [13]
        Random aleatorio = new Random(); // Clase para generar números aleatorios

        int correctas = 0; // Contador de respuestas correctas [7]
        int totalPreguntas;

        System.out.println("--- Test de Sumas de Nivel ---");
        System.out.print("Introduce el total de preguntas que quieres hacer (Ej: 5): ");
        totalPreguntas = teclado.nextInt(); // Lee un número entero [16]

        // Consumir el salto de línea fantasma si fuese a leer texto después [17, 18]
        teclado.nextLine();

        // 2. Bucle de Preguntas (Estructura Repetitiva 'for') [2]
        for (int i = 1; i <= totalPreguntas; i++) {

            // Generamos dos números enteros aleatorios (ej.: entre 1 y 100)
            int num1 = aleatorio.nextInt(100) + 1;
            int num2 = aleatorio.nextInt(100) + 1;
            int respuestaCorrecta = num1 + num2;
            int respuestaUsuario;

            // Solicitud de entrada
            System.out.print("\nPregunta " + i + ": ¿Cuánto es " + num1 + " + " + num2 + "? ");
            respuestaUsuario = teclado.nextInt();

            // 3. Condicional para acierto
            if (respuestaUsuario == respuestaCorrecta) { // Estructura Condicional Simple [10]
                System.out.println("¡Correcto!");
                correctas++; // Incrementamos el contador [7, 19]
            } else {
                System.out.println("Incorrecto. La respuesta era: " + respuestaCorrecta);
            }
        }

        // 4. Cálculo y Evaluación (Estructura Secuencial y Condicional Anidada)

        // Cálculo del porcentaje. Se utiliza 'double' o casting para asegurar la división real [11, 20]
        double porcentaje = ( (double) correctas / totalPreguntas ) * 100;

        System.out.println("\n--- Resultados ---");
        System.out.println("Aciertos: " + correctas + " de " + totalPreguntas);
        System.out.printf("Porcentaje de aciertos: %.2f%%\n", porcentaje); // Formato para decimales

        String nivel;

        // Evaluación del nivel usando if-else if-else [4-6]
        if (porcentaje >= 90) {
            nivel = "Muy Bueno"; // >= 90% [5]
        } else if (porcentaje >= 70) {
            nivel = "Bueno"; // >= 70% y < 90% [5]
        } else if (porcentaje >= 50) {
            nivel = "Regular"; // >= 50% y < 70% [6]
        } else {
            nivel = "Malo"; // < 50% [6]
        }

        System.out.println("Nivel obtenido: " + nivel);
    }
}
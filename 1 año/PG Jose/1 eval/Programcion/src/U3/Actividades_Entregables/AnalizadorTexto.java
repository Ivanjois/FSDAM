package U3.Actividades_Entregables;

import java.util.Scanner;

public class AnalizadorTexto {

    // !. La función principal main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        mostrarBienvenida();

        // Pasamos el Scanner como parámetro, tal como pide el enunciado
        String textoUsuario = pedirTexto(sc);

        // Llamamos al orquestador que se encarga de todo el análisis
        analizarYMostrarResultados(textoUsuario);

        sc.close();
    }

    // --- /. Funciones a Implementar ---

    // A. Procedimiento: Mostrar Bienvenida
    public static void mostrarBienvenida() {
        System.out.println("!! BIENVENIDO AL ANALIZADOR DE TEXTO !!");
        System.out.println("Por favor, introduce el párrafo que deseas analizar.");
        System.out.println("El programa calculará el total de palabras, vocales,");
        System.out.println("la palabra más larga y cuántas veces aparece la letra 'a'.");
        System.out.println("--------------------------------------------------");
    }

    // B. Función: Pedir Texto
    public static String pedirTexto(Scanner teclado) {
        System.out.println("Introduce un texto para analizar:");
        // Usamos nextLine() porque el usuario va a introducir una frase completa con espacios
        return teclado.nextLine();
    }

    // C. Procedimiento: Coordinador (Analizar y Mostrar)
    public static void analizarYMostrarResultados(String texto) {
        // 1. Llamamos a las funciones auxiliares y guardamos sus resultados
        int totalPalabras = contarPalabras(texto);
        int totalVocales = contarVocales(texto);
        String palabraMasLarga = encontrarPalabraMasLarga(texto);

        // El enunciado pide contar la letra 'a' específicamente en el ejemplo de salida
        int ocurrenciasA = contarOcurrencias(texto, 'a');

        // 2. Imprimimos el informe final
        System.out.println("!! INFORME DEL TEXTO !!");
        System.out.println("Texto Analizado: " + texto );
        System.out.println("1. Total de Palabras: " + totalPalabras);
        System.out.println("2. Total de Vocales: " + totalVocales);
        // Si el texto estaba vacío o sin palabras, manejamos la salida estética
        if (palabraMasLarga.isEmpty()) {
            System.out.println("3. Palabra más Larga: (No hay palabras)");
        } else {
            System.out.println("3. Palabra más Larga: \"" + palabraMasLarga + "\"");
        }
        System.out.println("4. Ocurrencias de la letra 'a': " + ocurrenciasA);
        System.out.println("---------------------------");
    }

    // D. Función: Contar Palabras (Lógica manual sin split)
    public static int contarPalabras(String texto) {
        // Limpiamos espacios al inicio y final para evitar errores de borde
        String textoLimpio = texto.trim();

        if (textoLimpio.isEmpty()) {
            return 0;
        }

        int contador = 0;

        // Recorremos el texto carácter a carácter
        for (int i = 0; i < textoLimpio.length(); i++) {
            char actual = textoLimpio.charAt(i);

            // Lógica: Una palabra empieza si tenemos un carácter que NO es espacio...
            // ...y además: es el primer carácter (i==0) O el anterior ERA un espacio.
            if (actual != ' ' && (i == 0 || textoLimpio.charAt(i - 1) == ' ')) {
                contador++;
            }
        }
        return contador;
    }

    // E. Función: Contar Vocales
    public static int contarVocales(String texto) {
        int contador = 0;
        // Convertimos a minúsculas para hacer solo 5 comprobaciones en lugar de 10
        String textoMin = texto.toLowerCase();

        for (int i = 0; i < textoMin.length(); i++) {
            char c = textoMin.charAt(i);
            switch (c) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    contador++;
                    break;
            }
        }
        return contador;
    }

    // F. Función: Encontrar Palabra más Larga (Algorítmica de búsqueda)
    public static String encontrarPalabraMasLarga(String texto) {
        String palabraMasLarga = "";
        String palabraActual = "";

        // Añadimos un espacio al final "ficticio" para asegurar que la última palabra
        // se procese dentro del bucle (truco común en algorítmica de strings)
        String textoProcesar = texto.trim() + " ";

        for (int i = 0; i < textoProcesar.length(); i++) {
            char c = textoProcesar.charAt(i);

            if (c != ' ') {
                // Si no es espacio, seguimos construyendo la palabra actual
                palabraActual += c;
            } else {
                // Si ES espacio, la palabra ha terminado. Comparamos longitudes.
                if (palabraActual.length() > palabraMasLarga.length()) {
                    palabraMasLarga = palabraActual;
                }
                // Reiniciamos la palabra actual para la siguiente
                palabraActual = "";
            }
        }

        return palabraMasLarga;
    }

    // G. Función: Contar Ocurrencias de una letra específica
    public static int contarOcurrencias(String texto, char letra) {
        int contador = 0;
        String textoMin = texto.toLowerCase();
        // Convertimos también el char buscado a minúscula para asegurar coincidencia
        char letraMin = Character.toLowerCase(letra);

        for (int i = 0; i < textoMin.length(); i++) {
            if (textoMin.charAt(i) == letraMin) {
                contador++;
            }
        }
        return contador;
    }
}
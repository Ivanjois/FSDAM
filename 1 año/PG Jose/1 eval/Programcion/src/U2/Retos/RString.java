import java.util.Scanner;

public class RString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Vamos a probar con una frase más compleja
        String frase = "Dábale arroz a la zorra el abad"; // Un palíndromo clásico
        System.out.println("Frase original: " + frase);

        // --- PASO 1: LIMPIEZA ---

        // 1. Convertir a minúsculas
        String fraselimpia = frase.toLowerCase();

        // 2. Quitar acentos (opcional pero recomendable)
        fraselimpia = fraselimpia.replace('á', 'a');
        fraselimpia = fraselimpia.replace('é', 'e');
        fraselimpia = fraselimpia.replace('í', 'i');
        fraselimpia = fraselimpia.replace('ó', 'o');
        fraselimpia = fraselimpia.replace('ú', 'u');

        // 3. Quitar todo lo que NO sea una letra (espacios, comas, etc.)
        // La expresión regular [^a-z] significa "cualquier cosa que NO sea de la 'a' a la 'z'"
        fraselimpia = fraselimpia.replaceAll("[^a-z]", "");

        System.out.println("Frase limpia: " + fraselimpia);

        // --- PASO 2: COMPARACIÓN ---

        int tamaño = fraselimpia.length();
        // Solo necesitamos comprobar hasta la mitad
        int mitad = tamaño / 2;

        // Suponemos que SÍ es un palíndromo hasta que demostremos lo contrario
        boolean esPalindromo = true;

        // Este es el bucle que te faltaba
        for (int i = 0; i < mitad; i++) {

            // Comparamos el carácter en la posición 'i' (desde el principio)
            char charPrincipio = fraselimpia.charAt(i);

            // con el carácter en la posición 'tamaño - 1 - i' (desde el final)
            char charFinal = fraselimpia.charAt(tamaño - 1 - i);

            System.out.println("Comparando: " + charPrincipio + " y " + charFinal);

            // Si en algún momento NO coinciden...
            if (charPrincipio != charFinal) {
                esPalindromo = false; // Marcamos que no lo es
                break; // <-- ¡Importante! Salimos del bucle, no hace falta seguir
            }
        }

        // --- PASO 3: RESULTADO ---
        if (esPalindromo) {
            System.out.println("¡Es un palíndromo!");
        } else {
            System.out.println("No es un palíndromo.");
        }
    }
}
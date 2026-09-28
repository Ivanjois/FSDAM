package U4.EjemplosTema;

import java.util.Arrays;

public class ordenacion {
    public static void main(String[] args) {
        int[] numeros = {1, 3, 5, 4, 6, 7};

        // BUCLE 1 (EXTERNO): Repite el proceso n veces
        // En cada vuelta, nos aseguramos de que el final del array quede ordenado
        for (int i = 0; i < numeros.length - 1; i++) {

            // BUCLE 2 (INTERNO): La "Pasada"
            // Recorre y empuja el grande hacia la derecha
            // (numeros.length - 1 - i) es para no volver a revisar los que ya ordenamos al final
            for (int j = 0; j < numeros.length - 1 - i; j++) {

                if (numeros[j] > numeros[j + 1]) {
                    // Intercambio
                    int temp = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = temp;
                }
            }
        }
        System.out.println("Ordenado: " + Arrays.toString(numeros));
    }
}
//import java.util.Arrays;
//
//public class ordenacionRecursiva {
//
//    public static void main(String[] args) {
//        int[] numeros = {1, 3, 5, 4, 6, 7};
//        ordenar(numeros, numeros.length);
//        System.out.println("Ordenado Recursivo: " + Arrays.toString(numeros));
//    }
//
//    // --- SUSTITUTO DEL BUCLE EXTERNO (i) ---
//    // n representa cuántos elementos quedan por ordenar al final
//    public static void ordenar(int[] arr, int n) {
//        // CASO BASE: Si solo queda 1 o 0 elementos, ya acabamos.
//        if (n <= 1) {
//            return;
//        }
//
//        // LLAMADA A LA AYUDANTE (Sustituye al bucle interno)
//        // Le decimos: "Ordena hasta la posición n"
//        hacerUnaPasada(arr, 0, n);
//
//        // PASO RECURSIVO EXTERNO
//        // Una vez hecha la pasada, el número más grande ya está al final.
//        // Llamamos a ordenar de nuevo, pero con un elemento menos (n-1).
//        ordenar(arr, n - 1);
//    }
//
//    // --- SUSTITUTO DEL BUCLE INTERNO (j) ---
//    // j es el índice actual que estamos comparando
//    // n es el límite hasta donde debemos llegar
//    public static void hacerUnaPasada(int[] arr, int j, int n) {
//        // CASO BASE: Si llegamos al penúltimo elemento, paramos la pasada.
//        if (j == n - 1) {
//            return;
//        }
//
//        // ACCIÓN: Comparar e intercambiar si es necesario
//        if (arr[j] > arr[j + 1]) {
//            int temp = arr[j];
//            arr[j] = arr[j + 1];
//            arr[j + 1] = temp;
//        }
//
//        // PASO RECURSIVO INTERNO
//        // Saltamos al siguiente índice (j + 1)
//        hacerUnaPasada(arr, j + 1, n);
//    }
//}
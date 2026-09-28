public class Triangulo {

    public boolean EsTriangulo(int a, int b, int c) {
        // Teorema: La suma de dos lados debe ser mayor al tercero SIEMPRE [cite: 34]
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    public String TipoTriangulo(int a, int b, int c) {
        if (a == b && b == c) {
            return "Equilátero"; // 3 lados iguales [cite: 42]
        } else if (a != b && a != c && b != c) {
            return "Escaleno";   // 3 lados desiguales [cite: 44]
        } else {
            return "Isósceles";  // 2 lados iguales [cite: 43]
        }
    }
}
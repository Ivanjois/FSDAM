public class Mayor {
    // Devuelve el entero mayor de los dos
    public static int Mayor(int a, int b) {
        int mayor = a;
        if (b > a) mayor = b;
        return mayor;
    }
// Devuelve true si el primero es mayor que el segundo
    public static boolean EsMayor(int a, int b) {
        return a > b;
    }
}

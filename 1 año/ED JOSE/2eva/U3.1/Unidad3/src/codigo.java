public class codigo {
    public static void main(String[] args) {
        int[] numeros = {10, 20, 30};
        int sumaTotal = 0;
        int contador = numeros.length;
        int resultado = 0;

        // Bucle que suma todos los números
        for (int i = 0; i < numeros.length; i++) {
            sumaTotal += numeros[i];
        }

        // Aquí está el problema
        resultado = sumaTotal / contador;
        System.out.println("La media es " + resultado);
    }
}

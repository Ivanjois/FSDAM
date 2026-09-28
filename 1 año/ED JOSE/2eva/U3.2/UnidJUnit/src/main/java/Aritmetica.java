import java.util.ArrayList;
import java.util.List;

public class Aritmetica {

    // Metodo de división simple (devuelve float)
    public float Division(float dividendo, float divisor) {
        return dividendo / divisor; // [cite: 7]
    }

    // Metodo de los divisores (aquí usamos tu lógica de ArrayList)
    public int[] PrimerosTresDivisores(int num) {
        List<Integer> divisores = new ArrayList<>();

        // Buscamos divisores empezando desde el 1
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                divisores.add(i);
            }
            // Si ya tenemos 3, paramos de buscar para ahorrar tiempo
            if (divisores.size() == 3) {
                break;
            }
        }

        // Si no llegamos a 3 divisores, rellenamos con -1 hasta tener 3
        while (divisores.size() < 3) {
            divisores.add(-1); // [cite: 10]
        }

        // Convertimos el ArrayList a un array int[] básico que es lo que pide el ejercicio
        int[] resultado = new int[3];
        for (int i = 0; i < 3; i++) {
            resultado[i] = divisores.get(i);
        }

        return resultado;
    }
}
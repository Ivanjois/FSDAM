import java.util.Scanner;

public class Ej29B3U2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float[] numeros = new float[100];
        int bandera = 1, num = 0;
        float[] positivos = new float[100];
        do {
            for (int i = 0; i < numeros.length && bandera == 1; i++) {
                System.out.println("Ingresa el numero que quieres saber si es positivo: ");
                numeros[i] = sc.nextFloat();
                sc.nextLine();
                if (numeros[i] > 0) {
                    positivos[i] = numeros[i];
                } else if (numeros[i] == 0) {
                    bandera = 0;
                    num = i;
                }
            }
        } while (!(bandera == 0));
        {
            for (int i = 0; i < num; i++) {
                System.out.println(positivos[i]);
            }
        }
    }
}
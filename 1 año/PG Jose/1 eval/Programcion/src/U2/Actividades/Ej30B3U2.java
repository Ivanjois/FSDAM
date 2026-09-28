import java.util.Scanner;

public class Ej30B3U2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numeros = new int[10];
        int[] positivos = new int[10];
        int[] negativos = new int[10];
        for (int i = 0; i < 10; i++) {
            System.out.println("Dime el numero que quieras: ");
            numeros[i] = sc.nextInt();
            sc.nextLine();
            if (numeros[i] >= 0 && numeros[i] < 5) {
                positivos[i] = numeros[i];
            }
            if (numeros[i] < 0 && numeros[i] > -5) {
                negativos[i] = numeros[i];
            }
        }
        System.out.println("Lista: ");
        System.out.println("-Los números positivos menores que 5: ");
        for (int j = 0; j < positivos.length; j++) {
            System.out.println(positivos[j]);
        }
        System.out.println("-Los números negativos mayores que -5: ");
        for (int j = 0; j < negativos.length; j++) {
            System.out.println(negativos[j]);
        }
    }
}

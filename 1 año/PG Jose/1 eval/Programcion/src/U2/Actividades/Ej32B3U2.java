import java.util.Scanner;

public class Ej32B3U2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero = 1;
        for (int i = 1; i <= 10; i++) {
            numero += i;
            for (int j = 1; j <= 10; j++) {
                numero = i * j;
                System.out.println("Tabla de multiplicar de " + i + " * " + j + " : "+numero);
            }
        }
    }
}
import java.util.Scanner;

public class Ej31B3U2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero = 0;
        double producto = 1;
        for (int i = 2; i <= 200; i += 2) {
            numero += i;
            producto *= i;
        }
        System.out.println("Suma: "+numero);
        System.out.println("Producto: "+producto);
    }
}

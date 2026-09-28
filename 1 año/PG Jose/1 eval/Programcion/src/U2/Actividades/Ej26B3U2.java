import java.util.Scanner;

public class Ej26B3U2 {
    public  static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero;
        System.out.print("Ingrese el numero: ");
        numero = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i <= 10; i++) {
            System.out.println("Tabla de multiplicar de "+numero+" * "+i+" : "+numero * i);
        }
    }
}

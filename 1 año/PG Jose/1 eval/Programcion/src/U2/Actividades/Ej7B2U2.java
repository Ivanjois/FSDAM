import java.util.Scanner;

public class Ej7B2U2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un numero:");
        int numero = sc.nextInt();
        if ((numero % 2) == 0){
            System.out.println("Es un numero par");
        }
        else{System.out.println("Es un numero impar");}

    }
}

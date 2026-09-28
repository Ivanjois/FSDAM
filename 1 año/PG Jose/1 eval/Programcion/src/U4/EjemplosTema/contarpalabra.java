package U4.EjemplosTema;

import java.util.Scanner;

public class contarpalabra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pos = 0;
        System.out.println("Ingrese la palabra: ");
        String palabra = sc.nextLine();
        System.out.println("Letras: "+Palabra(palabra, pos));
    }

    public static int Palabra(String palabra, int pos) {
        int numeroltras = 0;
        if (pos==palabra.length()) {
            return 0;
        }
        return 1+Palabra(palabra, pos+1);
    }
}

package U3;

import java.util.Scanner;

public class Ej1AU3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero = 0;
        boolean continuar = true;
        do {
            System.out.println("Ingrese el numero entero mayor de 1: ");
            if (sc.hasNextInt()) {
                numero = sc.nextInt();
                if (numero > 1) {
                    Primos(numero);
                }
            } else {
                System.out.println("numero no valido");
                sc.next();
            }
        } while (numero != 0);
        {
sc.close();
        }

    }

    public static void Primos(int numero) {
        int contador = 0;
        if (numero > 1) {
            for (int i = 1; i <= numero; i++) {
                if (numero % i == 0) {
                    contador += 1;
                }
            }
        }
        if (contador == 2) {
            System.out.println("El numero es primo");
        } else {
            System.out.println("El numero no es primo");
        }
    }
}


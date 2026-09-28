package U4.EjemplosTema;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numeroFactorial;
        System.out.print("Ingrese el numero de factorial: ");
        numeroFactorial = sc.nextInt();
        sc.nextLine();
        System.out.println(getFactorial(numeroFactorial));

    }
    public static int getFactorial(int numero) {
        if (numero == 1){
            return 1;
        }
        else{
        return  numero * getFactorial(numero - 1);
        }
    }
}

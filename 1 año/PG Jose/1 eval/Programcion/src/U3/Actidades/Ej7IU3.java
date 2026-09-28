package U3;

import javax.print.attribute.standard.Media;
import java.util.Arrays;
import java.util.Scanner;

public class Ej7IU3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] numerosEnteros = new int [100];
        int sumaDeEnteros=0, longitudArrayEnteros=0;
        for (int i = 0; i < numerosEnteros.length; i++) {
            numerosEnteros[i] = i+1;
        }
        sumaDeEnteros = Suma(numerosEnteros);
        System.out.println("La suma de los numeros enteros: "+sumaDeEnteros);
        System.out.println("La media de los numeros enteros: "+Media(numerosEnteros,sumaDeEnteros));
    }
    public static int Suma (int [] numerosEnteros) {
        int suma = 0;
        for (int i = 0; i < numerosEnteros.length; i++) {
            suma = suma+numerosEnteros[i];
        }
        return suma;
    }
    public static int Media (int [] numerosEnteros, int sumaDeEnteros) {
        int media = 0;
            media = sumaDeEnteros/numerosEnteros.length;
        return media;
    }
}

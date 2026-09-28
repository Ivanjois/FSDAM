package U3;

import java.util.Arrays;
import java.util.Scanner;

public class Ej8IU3 {
    public static void main(String[] args) {
        int capacidad;
        Scanner sc = new Scanner(System.in);//solicitamos el número para determinar el tamaño del array.
        System.out.print("Introduce un valor para determinar el tamaño del array: ");
        capacidad = sc.nextInt();
        int[] valoresAleatorios = new int[capacidad];
        numerosAleatorios(valoresAleatorios); //Llamamos al procedimiento

    }
/*
Procedimiento para poder numeros enteros aleatorios en sus espacios.
 */
    public static void numerosAleatorios(int[] valores) {
        for (int i = 0; i < valores.length; i++) {
            valores[i] = (int) (Math.random() * 100); // genera números del 0 al 99
        }//Nos muestra los numeros guardados en valores.
        System.out.println("Números creados aleatorios: "+Arrays.toString(valores));
    }
}

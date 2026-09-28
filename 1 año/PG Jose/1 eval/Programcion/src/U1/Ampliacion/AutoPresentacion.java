package Apliacion;

import java.util.Scanner;

public class AutoPresentacion {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        String nombre, lugar, programa;
        int hora, minuto, numero;
        double promedio;
        System.out.println("Ingrese el nombre: ");
        nombre=teclado.nextLine();
        System.out.println("Ingrese lugar: ");
        lugar=teclado.nextLine();
        System.out.println("Ingrese programa: ");
        programa=teclado.nextLine();
        System.out.println("Ingrese hora: (entero max 00-12)");
        hora=teclado.nextInt();
        System.out.println("Ingrese minuto: (entero max 59)");
        minuto=teclado.nextInt();
        System.out.println("Ingrese numero: (entero)");
        numero=teclado.nextInt();
        System.out.println("Ingrese el promedio: (se permiten decimales con \",\")");
        promedio=teclado.nextDouble();
        System.out.println("Yo nací en "+lugar);
        System.out.println(" Mi programa favorito de televisión es:" + "\""  +programa + "\".");
        System.out.println("  Yo me levante a las "+hora+ ":" +minuto+ "hoy.");
        System.out.println("   Yo tengo "+numero+"libros");
        System.out.println("    Mi promedio de calificaciones es "+promedio);
    }
}

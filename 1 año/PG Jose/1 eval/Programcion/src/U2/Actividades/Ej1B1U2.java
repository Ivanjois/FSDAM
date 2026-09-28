package U2.Actividades;

import java.util.Scanner;

public class Ej1B1U2 {
    public  static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        final double pulgada = 2.54;
        String medidadPulgada= "cm";
        double pulgadas, cm;
        System.out.println("Ingrese el valor del pulgada (la , para decimales)");
        pulgadas=teclado.nextDouble();
        cm=pulgadas*pulgada;
        System.out.println("Las pulgas "+pulgadas+" en cm es "+cm+ " "+medidadPulgada+".");


    }
}

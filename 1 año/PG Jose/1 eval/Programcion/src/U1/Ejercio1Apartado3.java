import java.util.Scanner;

public class Ejercio1Apartado3{
    public static void main(String[] args) {
       double precio, impuestos;
       Scanner teclado = new Scanner(System.in);
       System.out.println("Ejercio1Apartado3");
       System.out.println("Introduce el precio");
       precio = teclado.nextDouble();
       System.out.println("Introduce los impuestos");
       impuestos = teclado.nextDouble();
       precio = precio + impuestos/100;
       System.out.println("El precio es: "+precio);
   }
}


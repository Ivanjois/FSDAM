import java.util.Scanner;

public class Ej2B1U2 {
    public  static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        double numero, cubo;
        System.out.println("Ingrese el valor que quieras al cubo");
        numero=teclado.nextDouble();
        cubo=numero*numero*numero;
        System.out.println("El numero "+numero+" al cubo es "+cubo);
    }
}

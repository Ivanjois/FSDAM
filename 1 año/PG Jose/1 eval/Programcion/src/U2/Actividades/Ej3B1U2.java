import java.util.Scanner;
import static java.lang.Math.*;

public class Ej3B1U2 {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        double radio, altura, volumen, area;
        System.out.println("Ingrese el radio");
        radio=teclado.nextDouble();
        System.out.println("Ingrese la altura");
        altura=teclado.nextDouble();
        volumen= PI*(radio*radio)*altura;
        area= PI*radio*altura*2*PI*(radio*radio);
        System.out.println("El volumen sera de " +volumen+" y el area sera de "+area);
    }
}

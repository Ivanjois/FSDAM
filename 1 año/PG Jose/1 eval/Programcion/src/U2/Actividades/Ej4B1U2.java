import java.util.Scanner;
import static java.lang.Math.*;
public class Ej4B1U2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double cateto1, cateto2, hipotenusa;
        System.out.println("Ingrese el numero del cateto1");
        cateto1=sc.nextDouble();
        System.out.println("Ingrese el numero del cateto2");
        cateto2=sc.nextDouble();
        hipotenusa = sqrt(pow(cateto1, 2) + pow(cateto2, 2));
        System.out.println("La hipotenusa es "+hipotenusa);
    }
}

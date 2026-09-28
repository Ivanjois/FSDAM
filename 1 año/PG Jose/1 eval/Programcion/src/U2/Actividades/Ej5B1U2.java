import java.util.Scanner;

public class Ej5B1U2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final float metro = 39.27F;
        String medidadPulgada= "pulgadas";
        final int pies = 12;
        float metros, pulgadas, pie;
        System.out.println("Introduce los metros que quieres convertir(decimales con ,)");
        metros=sc.nextFloat();
        pulgadas=metros*metro;
        pie=pulgadas*pies;
        System.out.println("Los metros "+metros+" en pulgadas y en pies es "+pulgadas+" pulgadas "+pie+" pies.");
    }
}

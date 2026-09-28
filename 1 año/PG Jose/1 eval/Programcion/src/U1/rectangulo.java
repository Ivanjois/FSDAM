import java.util.Scanner;
public class rectangulo {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int base, altura;
        System.out.println("Ingrese el valor de la altura");
        base = teclado.nextInt();
        System.out.println("Ingrese el valor de la base");
        altura = teclado.nextInt();
        int area = (base*altura);
        int perimetro = (base+altura)*2;
        System.out.println("El area del rectángulo es "+area+" Y el perimetro "+perimetro);
    }
}

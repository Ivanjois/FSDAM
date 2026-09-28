import java.util.Scanner;
public class IMC {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        double Peso, altura;
        System.out.print("Ingrese su altura en metros: ");
        Peso = teclado.nextDouble();
        System.out.print("Ingrese su peso en Kg: ");
        altura = teclado.nextDouble();
        double imc = Peso/(altura*altura);
        System.out.println("Su IMC es: " +imc) ;
    }
}

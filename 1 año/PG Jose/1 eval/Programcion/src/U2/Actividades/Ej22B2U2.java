import java.util.Scanner;

public class Ej22B2U2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double n1, n2, n3, n4;
        System.out.println("Ingresa las cuatro notas que has sacado: ");
        n1 = input.nextDouble();
        n2 = input.nextDouble();
        n3 = input.nextDouble();
        n4 = input.nextDouble();
        double promedio = (n1+n2+n3+n4)/4;
        if (promedio >= 4.5){
            System.out.println("Aprobado tu promedio es de: "+promedio);
        } else {
            System.out.println("Suspendido tu promedio es de: "+promedio);
        }
    }
}

import java.util.Scanner;

public class Ej19B2U2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int edad;
        System.out.println("Ingrese su edad: ");
        edad = sc.nextInt();
        sc.nextLine();
        if(edad>15){
            System.out.println("Tu entrada cuesta 3€");
        } else if(edad<=15&&edad>=5){
            System.out.println("Tu entrada cuesta 2€");
        }else if(edad<5){
            System.out.println("Tu entrada es gratis");
        }
    }
}

import java.util.Scanner;

public class A3U2B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String contcorrecta = "programacion101", contraseña = "";
        while(!contcorrecta.equals(contraseña)){
            System.out.print("Ingrese la contraseña correcta: ");
            contraseña = sc.nextLine();
        }
        System.out.println("Acceso concedido");
    }
}

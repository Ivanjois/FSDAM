import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite el DNI: ");
        int dni_solicitado = sc.nextInt();
        System.out.println("Digite el nombre: ");
        String nombre_solicitado = sc.next();
        Nif_calculator nif1 = new Nif_calculator(dni_solicitado, nombre_solicitado);
        String nombre1 = nif1.getNombre();
        char letra_nif = nif1.calcularLetra();
        int el_dni = nif1.getDni();
        System.out.println("El nif de " + nombre1 + " es " + "'" + el_dni + letra_nif + "'");
    }
}
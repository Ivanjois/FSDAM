import java.util.Scanner;

public class Ej35B3U2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int PI, R;
        boolean elegir=false;
        do {
            System.out.println("Ingrese la opcion que desea realizar a o b: ");
            System.out.println("a. Calcular el area de una circuferencia.");
            System.out.println("b. Calcular el area de una esfera.");
            char opcion = sc.next().charAt(0);
            sc.nextLine();
            switch (opcion) {
                case 'a':
                    System.out.println("A=PI*r^2");
                    System.out.println("PI");
                    PI = sc.nextInt();
                    sc.nextLine();
                    System.out.println("r");
                    R = sc.nextInt();
                    sc.nextLine();
                    final int A = PI * (R * R);
                    System.out.println("Resultado del area: A= " + A);
                    elegir=true;
                    break;
                case 'b':
                    System.out.println("V=(4*PI*r^2)/3");
                    System.out.println("PI");
                    PI = sc.nextInt();
                    sc.nextLine();
                    System.out.println("r");
                    R = sc.nextInt();
                    sc.nextLine();
                    final int V = (4 * PI * (R * R) / 3);
                    System.out.println("Resultado del volumen: A= " + V);
                    elegir=true;
                    break;
                default:
                    System.out.println("Esta opcion no es valida");
                    break;
            }
        }while(elegir);
    }
}

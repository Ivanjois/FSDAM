import java.util.Scanner;
public class Ej6B1U2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int A, B, C;
        int D ;
        System.out.println("Ingrese el valor de B: ");
        B=sc.nextInt();
        System.out.println("Ingrese el valor de C: ");
        C=sc.nextInt();
        System.out.println("Ingrese el valor de A: ");
        A=sc.nextInt();
        D = A;
        B = A;
        A = C;
        C = D;
        System.out.println("Ingrese el valor de A:"+B+" "+A+" "+C);
        }
}

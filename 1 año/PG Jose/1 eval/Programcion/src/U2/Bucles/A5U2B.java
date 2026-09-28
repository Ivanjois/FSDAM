import java.util.Scanner;

public class A5U2B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int alumnos = 0, nota, notas = 0;
        int [] nalumnos = new int[alumnos];
        float notamedia;
        System.out.println("Cuantos alumnos hay: ");
        alumnos = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < alumnos; i++) {
            System.out.println("Que nota tiene el numero "+(i+1)+": ");
            nota = sc.nextInt();
            notas += nota;
        }
        notamedia = (float) notas / alumnos;
        System.out.println("La media es de: "+notamedia);
    }
}

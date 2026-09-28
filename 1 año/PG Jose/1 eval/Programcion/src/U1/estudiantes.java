import java.util.Scanner;
public class estudiantes{
    public static void main(String[] args){
        Scanner teclado=new Scanner(System.in);
        System.out.println("Ingrese el numero de estudiantes");
        int estudiantes=teclado.nextInt();
        System.out.println("Ingrese el numero de personas en un grupo");
        int grupo=teclado.nextInt();
        int grupos=estudiantes/grupo;
        System.out.println("Equipos creados: " +grupos);
        int genteSinEquipo=estudiantes-(grupos*grupo);
        int gentesin=estudiantes%grupos;
        System.out.println("Personas sin equipo: " +genteSinEquipo);
        System.out.println("Personas sin equipo: " +gentesin);
    }
}
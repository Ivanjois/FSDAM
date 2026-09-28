import java.util.Scanner;
public class Ejercicio4 {
 public static void main(String[] args) {

 Scanner teclado = new Scanner(System.in);

 // Aquí empieza nuestro código
 int edad;

 System.out.println("Hola, bienvenido a mi programa de prueba");
 System.out.println("(pulsa ENTER para continuar)");
 teclado.nextLine();

 System.out.println("Dime cuál es tu edad (puedes mentirme, si quieres)");
 edad = teclado.nextInt();
 teclado.nextLine();
 if(edad < 18)
 System.out.println("Acceso denegado, eres menor de edad");
 else
 System.out.println("Felicidades, eres mayor de edad!"); }}

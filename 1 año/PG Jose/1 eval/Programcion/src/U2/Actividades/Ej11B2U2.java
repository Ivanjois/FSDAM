import java.util.Scanner;

public class Ej11B2U2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero1, numero2, numero3, primero, segundo, tercero;
        System.out.println("Ingrese el primero numero: ");
        numero1 = sc.nextInt();
        System.out.println("Ingrese el segundo numero: ");
        numero2 = sc.nextInt();
        System.out.println("Ingrese el tercero numero: ");
        numero3 = sc.nextInt();
        if (numero1 < numero2 && numero1 < numero3) {
            primero=numero1;
            if(numero2<numero3){
                segundo=numero2;
                tercero=numero3;
                System.out.println("Orden de menor a mayor: "+primero+", "+segundo+", "+tercero+".");
            }else {
                segundo=numero3;
                tercero=numero2;
                System.out.println("Orden de menor a mayor: "+primero+", "+segundo+", "+tercero+".");
            }
        }else if(numero2 < numero1 && numero2 < numero3) {
            primero=numero2;
            if(numero1<numero3){
                segundo=numero1;
                tercero=numero3;
                System.out.println("Orden de menor a mayor: "+primero+", "+segundo+", "+tercero+".");
            }else {
                segundo=numero3;
                tercero=numero1;
                System.out.println("Orden de menor a mayor: "+primero+", "+segundo+", "+tercero+".");
            }
        }else if(numero3 < numero1 && numero3 < numero2) {
            primero=numero3;
            if(numero1<numero2){
                segundo=numero1;
                tercero=numero2;
                System.out.println("Orden de menor a mayor: "+primero+", "+segundo+", "+tercero+".");
            }else {
                segundo=numero2;
                tercero=numero1;
                System.out.println("Orden de menor a mayor: "+primero+", "+segundo+", "+tercero+".");
            }
        }
    }
}

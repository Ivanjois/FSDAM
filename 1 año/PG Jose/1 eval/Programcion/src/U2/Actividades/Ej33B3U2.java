import java.util.Scanner;

public class Ej33B3U2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero=1, pares=0, impares=0;
        while(!(numero<=0)){
            System.out.print("Ingresa un numero: ");
            numero = sc.nextInt();
            sc.nextLine();
            if(numero%2==0){
                pares += numero;
            }
            if(numero%2==1){
                impares += numero;
            }
        }
        System.out.println("Pares: "+pares+" Impares: "+impares);
    }
}

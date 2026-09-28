import java.util.Scanner;

public class A2U2B {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        int cuentaatras = 10;
        System.out.println("------Cuenta atras------");
        for (int i = cuentaatras; i >= 1; i--) {
            System.out.println(i);
            Thread.sleep(1000);
        }
        System.out.println("¡Despegue!");

    }
}
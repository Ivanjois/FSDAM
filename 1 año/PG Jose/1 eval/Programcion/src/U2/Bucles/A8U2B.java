import java.util.Scanner;

public class A8U2B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        System.out.print("Digite um numero: ");
        num = sc.nextInt();
        sc.nextLine();
        String tres = "Fizz", cinco = "Buzz", trescinco = "FizzBuzz";
        for(int i=1;i<=num;i++){
            if(i%3==0&&i%5==0){
                System.out.print(trescinco);
            }else if(i%3==0){
                System.out.print(tres);
            }else if(i%5==0){
                System.out.print(cinco);
            }else {
                System.out.print(i);
            }
        }
    }
}

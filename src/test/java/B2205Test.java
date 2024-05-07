import java.util.Scanner;

public class B2205Test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long res = 1;
        for(long i = 1; i <= n;i++){
            res *= i;
        }
        System.out.println("求得的阶乘为: " + res);
        scan.close();
    }
}

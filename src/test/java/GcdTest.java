import java.util.Scanner;

public class GcdTest {
    public static void main(String[] args){
        long startTime = System.nanoTime();
        Scanner scan = new Scanner(System.in);
        long n = scan.nextLong();
        long a = (n + 1) * n / 2;
        long b = 1;
        for(long i = 1;i <= n;i++){
            b = (b * i) % a;  //450015000 //最小公倍数可以预处理？？？
//             b = (b * i);  //5759323001
        }
        long endTime = System.nanoTime();
        // 计算执行时间（以纳秒为单位）
        long duration = endTime - startTime;

        // 将纳秒转换为毫秒，并输出执行时间
//        System.out.println("Execution time: " + duration + " milliseconds");
//        System.out.println(gcd(a,b));

        System.out.println(gcd(6,3));
        System.out.println(3 % 6);


    }
    public static long gcd(long i,long j){
        if(j == 0){
            return i;
        }else{
            return gcd(j,i%j);
        }
    }
}
//450015000
//5759323001

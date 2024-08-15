package cn.dsxriiiii.lanQiao.answer.practice.C.A1708;


import java.util.Scanner;

/*
* 这道题用到了求最大公约数的算法
* public static int gcd(int a, int b) {
    if (b == 0) {
        return a;
    } else {
        return gcd(b, a % b);
    }
}

*
* 给出以下求出最小公倍数的算法
* public static int lcm(int c, int d) {
    // 使用最大公约数的关系求最小公倍数
    return Math.abs(c * d) / gcd(c, d);
}
* */
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int[] arr = new int[105];
        arr[1] = scan.nextInt();
        int d = arr[1];
        for(int i = 2;i <= num; i++){
            arr[i] = scan.nextInt();
            d = gcd(d,arr[i]);
        }
        if(d!=1){
            System.out.println("INF");
            return;
        }else{
            long[] dp = new long[10005];
            dp[0] = 1;
            for(int i = 1;i <= num;i++){
                for(int j = arr[i]; j <=10000;j++){
                    dp[j] += dp[j-arr[i]];
                }
            }
            int res = 0;
            for(int i = 0;i<= 10000;i++){
                if(dp[i] == 0){
                    res++;
                }
            }
            System.out.println(res);
        }

        scan.close();
    }
    public static int gcd(int a,int b){
        if(b ==0){
            return a;
        }else{
            return gcd(b,a%b);
        }
    }
}


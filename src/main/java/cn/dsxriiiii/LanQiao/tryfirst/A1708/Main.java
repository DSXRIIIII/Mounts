package cn.dsxriiiii.LanQiao.tryfirst.A1708;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        int[] arr = new int[105];
        arr[1] =s.nextInt();
        int d = arr[1];
        for(int i = 2;i < num; i++){
            arr[i] = s.nextInt();
            d = gcd(d,arr[i]);
        }
        if(d!=1){
            System.out.println("INF");
            return;
        }else{
            int[] dp = new int[10005];
            dp[0] = 1;
            for(int i = 0;i < num; i++){
                //arr[i]就是输入的数
                for (int j = arr[i]; j < 10000; j++) {
                    dp[i] += dp[j-arr[i]];
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
        s.close();
    }
    public static int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        else{
            return gcd(b,a%b);
        }
    }
}

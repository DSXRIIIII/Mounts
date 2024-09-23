package cn.dsxriiiii.coding.meituan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @PackageName: cn.dsxriiiii.coding.meituan
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/21 10:25
 * @Description: 1
 **/
public class code24092101 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] dp = new int[100];
        dp[0] = 0;dp[1] = 1;dp[2] = 2;dp[3] = 3;dp[4] = 4;
        while(n-->0){
            int num = scanner.nextInt();
            scanner.nextLine();
            for(int i = 5;i <= num;i++){
                if(i%2==0){
                    dp[i] = i/2;
                }else{
                    dp[i] = i/2 + 1;
                }
            }
            //System.out.println(Arrays.toString(dp));
            System.out.println(dp[num]);
        }
    }
}

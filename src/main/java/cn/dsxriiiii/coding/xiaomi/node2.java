package cn.dsxriiiii.coding.xiaomi;

import java.util.Scanner;

/**
 * @PackageName: cn.dsxriiiii.coding.xiaomi
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/19 17:08
 * @Description:
 **/
public class node2 {
    public static void main(String[] args){

//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int target = sc.nextInt();
//        int[][] dp = new int[target + 1][4];
//        dp[0][0] = 1;
//        dp[0][1] = 1;
//        dp[0][2] = 1;
//        dp[0][3] = 1;
        System.out.println(m2(123));
    }
    public static int m1(int n,int a){
        return n * a;
    }
    public static int m2(int n){
        int len = String.valueOf(n).length();
        StringBuilder sb = new StringBuilder();
        String substring = sb.substring(0, len - 2);
        String start = sb.substring(len - 1);
        sb.append(start).append(substring);
        return Integer.parseInt(sb.toString());
    }

}

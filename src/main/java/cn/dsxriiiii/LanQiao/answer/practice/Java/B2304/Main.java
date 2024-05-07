package cn.dsxriiiii.LanQiao.answer.practice.Java.B2304;

import java.util.Arrays;
import java.util.Scanner;

/*
* description:
* 这一题考察我要奇数和偶数的组合
* 奇数 + 奇数 = 偶数
* 偶数 + 偶数 = 偶数
* 奇数 + 偶数 = 奇数
*
* 那么分为两种情况 要么（奇数 + 奇数）与 偶数 组合
*               要么 偶数 与 偶数 组合
*
* 每一个数字有两个选择 要么去左边要么去右边 那么排列的方式就有 2 * n个
* 但是奇数排列需要考虑两两组合 那么此时就变成了 2 * n - 1 个选择
* 此时就是 奇数的二次幂 与 偶数 的二次幂 相乘即可
*
* */

public class Main {
    public static void main(String[] args) {
        Scanner scan  = new Scanner(System.in);
        int n = scan.nextInt();
        int[] result = new int[n];
        for (int k = 0; k < n; k++) {
            int len = scan.nextInt();
            int[] value = new int[len];
            int j = 0,o = 0;
            for(int i = 0;i < len;i++){
                value[i] = scan.nextInt();
                if(value[i] % 2 == 0){
                    o++;
                }else{
                    j++;
                }
                if(j % 2 == 1){
                    result[k] = 0;
                }else{
                    result[k] = (int)(Math.pow(2,o) * Math.pow(2,j == 0?0:j - 1) % 1000000007);
                }
            }
        }
        scan.close();
        for (int i = 0; i < n; i++) {
            System.out.println(result[i]);
        }
        System.out.println(Arrays.toString(result));
    }
}

package cn.dsxriiiii.coding.hundsun;

import java.util.Arrays;
import java.util.Scanner;
/**
 * @PackageName: cn.dsxriiiii.coding.hundsun
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/26 20:16
 * @Description: 2
 **/
public class code2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] num = new int[n];
        in.nextLine();
//        int index = 0;
//        int end = num.length - 1;
//        if(num.length % 2 != 0){
//
//        }
        long sum = 0;
        for(int i = 0;i < n;i++){
            num[i] = in.nextInt();
        }
//        if(num.length % 2 != 0){
//            n = n - 1;
//        }
//        for(int i = 0,j = i + 1;i < n;i+=2){
//            sum+= grd(num[i],num[j]);
//        }
//        System.out.println(sum = sum == 0 ? -1:sum);
        if(num.length == 1){
            System.out.println(-1);
        }else{
            System.out.println(0);
        }
    }
    public static int grd(int a,int b){
        if(b == 0){
            return a;
        }
        return grd(b,a % b);
    }
}

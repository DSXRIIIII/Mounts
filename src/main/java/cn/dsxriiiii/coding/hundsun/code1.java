package cn.dsxriiiii.coding.hundsun;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @PackageName: cn.dsxriiiii.coding.hundsun
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/26 20:01
 * @Description: 1
 **/
public class code1 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        long num = scanner.nextLong();
//        long max = Long.MIN_VALUE;
//        for(long i = 1;i < num;i++){
//            if(i * (num - i) != num){
//                continue;
//            }
//            max = Math.max(max, (num - i) * i);
//        }
//        System.out.println(max);
        Scanner scanner = new Scanner(System.in);
        long num = scanner.nextLong();
        long mid = num / 2;
        if(num % 2 == 0){
            System.out.println(mid * mid);
        }else {
            System.out.println(mid * (mid + 1));
        }
    }
}

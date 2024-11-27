package cn.dsxriiiii.coding.kedaxunfei;

import java.util.Scanner;

/**
 * @PackageName: cn.dsxriiiii.coding.kedaxunfei
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/11/12 20:35
 * @Description:
 **/
public class coding072702 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = Integer.MIN_VALUE;
        for (int i = 2; i <= 32; i++) {
            count = Math.max(getOne(n,i),count);
        }
        System.out.println(count);
    }

    private static int getOne(int n, int i) {
        int res = 0;
        while (n != 0){
            if (n % i == 1){
                res++;
            }
            n /= i;
        }
        return res;
    }

}

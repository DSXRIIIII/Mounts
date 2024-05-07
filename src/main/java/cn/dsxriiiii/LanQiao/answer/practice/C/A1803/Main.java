package cn.dsxriiiii.LanQiao.answer.practice.C.A1803;

import java.util.Scanner;
// 判断数字相乘有多少个0，就是判断相乘之后分解成质数相乘，最后在2 和 5 之间取个数最小的数。
// 在输入的数字之中有很多数是2的倍数也是5的倍数，所以需要用两个while循环不断相处得到结果

public class Main {
    public static void main(String[] args) {
        int n = 100;
        Scanner scanner = new Scanner(System.in);
        int cnt2 = 0;
        int cnt5 = 0;
        while(n > 0) {
            n--;
            int x = scanner.nextInt();
            if(x % 2 == 0) {
                x=x/2;
                cnt2++;
            }else if(x % 5 == 0) {
                x=x/5;
                cnt5++;
            }
        }
        System.out.print(Math.min(cnt2, cnt5));
    }
}

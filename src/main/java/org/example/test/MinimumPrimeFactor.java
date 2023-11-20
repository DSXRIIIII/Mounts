/*
你发现了一个有趣的数论函数。
对于任意一个数 x，
f(x) 会返回 x 的最小质因子。
如果这个数没有最小质因子，那么就返回0
现在给定任意一个 n ，小理想知道从i=1和i=n的f(i)的和值
输入一个整数
输出一个整数代表上面求和式的值
1 2 3 4 输入4
0 2 3 2 输出7

*/
package org.example.test;
import java.util.Scanner;

public class MinimumPrimeFactor {

    // 定义一个函数来找到给定数的最小质因子
    static int smallestPrimeFactor(int x) {
        if (x < 2) {
            return 0;
        }
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return i;
            }
        }
        return x; // 返回 x 本身，表示 x 是质数
    }

    // 计算从 i=1 到 i=n 的 f(i) 的总和
    static int sumOfSmallestPrimeFactors(int n) {
        int totalSum = 0;
        for (int i = 1; i <= n; i++) {
            totalSum += smallestPrimeFactor(i);
        }
        return totalSum;
    }

    public static void main(String[] args) {
        // 输入一个整数 n
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个整数 n：");
        int n = scanner.nextInt();

        // 调用函数计算从 i=1 到 i=n 的 f(i) 的总和
        int result = sumOfSmallestPrimeFactors(n);

        // 输出结果
        System.out.println("从 i=1 到 i=" + n + " 的 f(i) 的总和为：" + result);
    }
}


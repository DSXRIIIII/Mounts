package cn.dsxriiiii.coding.changting;

import java.util.Scanner;
public class coding1 {
    private static long[] pinks;
    private static long[] prefixSums;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        pinks = new long[n];
        prefixSums = new long[n];
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            pinks[i] = scanner.nextInt();
            if (i == 0) {
                prefixSums[i] = pinks[i];
            } else {
                prefixSums[i] = prefixSums[i - 1] + pinks[i];
            }
            scanner.nextLine();
        }
        int j = scanner.nextInt();
        scanner.nextLine();
        while (j-- > 0) {
            int switch_num = scanner.nextInt();
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();
            scanner.nextLine();
            if (switch_num == 0) {
                long sum;
                if (num1 == 0) {
                    sum = prefixSums[num2];
                } else {
                    sum = prefixSums[num2] - prefixSums[num1 - 1];
                }
                System.out.println(sum);
            } else if (switch_num == 1) {
                pinks[num1] += num2;
                for (int k = num1; k < n; k++) {
                    prefixSums[k] += num2;
                }
            } else if (switch_num == 2) {
                pinks[num1] -= num2;
                for (int k = num1; k < n; k++) {
                    prefixSums[k] -= num2;
                }
            }
        }
    }
}

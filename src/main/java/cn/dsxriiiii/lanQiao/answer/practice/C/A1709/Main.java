package cn.dsxriiiii.lanQiao.answer.practice.C.A1709;

import java.util.Scanner;

public class Main {
    private static int maxn = 100000;
    public static void main(String[] args) {
        int n,k;
        int[] h = new int[maxn];
        int[] w = new int[maxn];
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            h[i] = scanner.nextInt();
            w[i] = scanner.nextInt();
        }
        int ans = 0;
        int right = maxn + 1;
        int left = 1;
        while (left<=right){
            int mid = (left + right) >> 1;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                cnt += (h[i] / mid) * (w[i] / mid);// 计算当前 mid 长度下，可以放置的物品数量
                //5 / 5000 = 0因此right要减少
            }
            if (cnt >= k){
                left = mid + 1;
                ans = mid; // 及时记录结果!!!!!!
            }else
                right = mid - 1;
        }
        System.out.println(ans);
    }
}
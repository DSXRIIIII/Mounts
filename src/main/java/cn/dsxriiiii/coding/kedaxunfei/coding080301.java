package cn.dsxriiiii.coding.kedaxunfei;

import java.util.Scanner;

/**
 * @PackageName: cn.dsxriiiii.coding.kedaxunfei
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/11/19 16:21
 * @Description:
 **/
public class coding080301 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int[] arr = new int[n + 1];
        for(int i = 1;i <= n;i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.nextLine();
        for (int i = 1; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
        }
        int res = 0;
        for (int i = n; i >= 1; i--) {
            while (arr[i] != i) {
                res++;
                int temp = arr[i];
                arr[i] = arr[arr[i]];
                arr[temp] = temp;
            }
        }
        System.out.println(res);
        scanner.close();
    }
}

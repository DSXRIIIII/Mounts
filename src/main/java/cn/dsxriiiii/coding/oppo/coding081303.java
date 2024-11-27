package cn.dsxriiiii.coding.oppo;

/**
 * @PackageName: cn.dsxriiiii.coding.oppo
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/11/27 16:50
 * @Description:
 **/

import java.util.Arrays;
import java.util.Scanner;

/**
 * 5
 * 11145
 */
public class coding081303 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i) - '0';
        }
        int[] ans11 = new int[s.length()];
        int res11 = 0;
        for (int i = 1; i < s.length(); i++) {
            ans11[i] = res11;
            if (arr[i] == 1 && arr[i - 1] == 1){
                ans11[i] = ++res11;
            }
        }
        int[] ans5 = new int[s.length()];
        int res5 = 0;
        if (arr[s.length() - 1] == 5){
            res5 = 1;
            ans5[s.length() - 1] = 1;
        }
        for (int i = s.length() - 2; i >= 0 ; i--) {
            if (arr[i] == 5) {
                ans5[i] = ++res5;
            }else{
                ans5[i] = res5;
            }
        }
        long res = 0;
        long mod = 1000000007;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 4) {
                res = (res + (long) ans5[i] * ans11[i]) % mod;
            }
        }
        System.out.println(res);
    }

}

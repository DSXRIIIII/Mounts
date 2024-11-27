package cn.dsxriiiii.coding.oppo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @PackageName: cn.dsxriiiii.coding.oppo
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/11/16 17:49
 * @Description:
 **/
public class codeing0727 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] ss = scanner.nextLine().split(" ");
        int[] arr = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            arr[i] = Integer.parseInt(ss[i]);
        }
        int x = scanner.nextInt();
        int k = scanner.nextInt();
        int max = Arrays.stream(arr).max().orElse(Integer.MAX_VALUE);
        if (max > x - k + 1){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}

package cn.dsxriiiii.coding.kedaxunfei;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @PackageName: cn.dsxriiiii.coding.kedaxunfei
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/11/06 16:24
 * @Description:
 * 给定n个数字A1,A2,..An，请求出这些数字中出现次数小于等于k的最小的数。
 * /
 * 第一行正整数n,k，接下来一行n个正整数，第i个表示Ai 1<=k<=n<=10^5,1<=Ai<=10^9
 * /
 * 一行一个整数，表示答案。如果不存在出现次数少于等于k次的数字，输出-1
 * /
 * 5 2
 * 1 1 1 2 3
 * /
 * 2
 * /
 *
 **/
public class coding071302 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int k = scanner.nextInt();
        int[] values = new int[len];
        int res = Integer.MAX_VALUE;
        Map<Integer,Integer> m = new HashMap<>();
        for (int i = 0; i < len; i++) {
            values[i] = scanner.nextInt();
            m.put(values[i],m.getOrDefault(values[i],0) + 1);
        }
        for(int key : m.keySet()){
            if (m.get(key) <= k){
                res = Math.min(res,key);
            }
        }
        System.out.println(res == Integer.MAX_VALUE ? -1 : res);
    }
}

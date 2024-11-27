package cn.dsxriiiii.coding.mihayou;

import cn.dsxriiiii.PowerPointOffer.CourseNum;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @PackageName: cn.dsxriiiii.coding.mihayou
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/11/22 12:35
 * @Description:
 **/
public class coding080302 {
    private static Set<Integer>[] sets;
    private static int[][] stock;
    private static int res;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int p = Integer.parseInt(s[1]);
        int h = Integer.parseInt(s[2]);
        stock = new int[n][2];
        sets = new HashSet[n];
        res = 0;
        for (int i = 0; i < n; i++) {
            sets[i] = new HashSet<>();
        }
        for (int i = 0; i < n; i++) {
            stock[i][0] = scanner.nextInt();
            stock[i][1] = scanner.nextInt();
            scanner.nextLine();
        }
        for (int i = 0; i < h; i++) {
            int a = scanner.nextInt() - 1;
            int b = scanner.nextInt() - 1;
            sets[a].add(b);
            sets[b].add(a);
        }
        Set<Integer> vst = new HashSet<>();
        dfs(0,0,0,vst,n,p);
        System.out.println(res);
        scanner.close();
    }
    public static boolean judge(int a,Set<Integer> vst){
        for(int value : vst) {
            if (sets[a].contains(value)) {
                return true;
            }
        }
        return false;
    }

    private static void dfs(int index, int curValue, int curBag, Set<Integer> vst,int n,int m) {
        if(index > n){
            res = Math.max(res,curValue);
            return;
        }
        dfs(index + 1,curValue,curBag,vst,n,m);
        if(judge(index,vst) && curBag + stock[index][0] <= m) {
            vst.add(index);
            dfs(index + 1,curValue + stock[index][1],curBag + stock[index][0],vst,n,m);
            vst.remove(index);
        }
    }
}

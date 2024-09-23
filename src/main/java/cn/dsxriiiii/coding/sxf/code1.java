package cn.dsxriiiii.coding.sxf;

import java.util.*;
/**
 * @PackageName: cn.dsxriiiii.coding.sxf
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/20 21:02
 * @Description: 第一题
 **/
public class code1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        for(int i = 0;i < m;i++){
            String s = scanner.nextLine();
            String ns = build(s);
            int res = 1;
            if(ns.length() == 1){
                System.out.println(res);
                continue;
            }
            Map<Character,Integer> map = new HashMap<>();
            for(char c : ns.toCharArray()){
                map.put(c,map.getOrDefault(c,0) + 1);
            }
            for(char c : map.keySet()){
                if(map.get(c) >= n){
                    res++;
                }
            }
            System.out.println(res);
        }
    }
    public static String build(String s){
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        char a = s.charAt(0);
        for(int i = 1;i < s.length();i++){
            if(a == s.charAt(i)) continue;
            sb.append(s.charAt(i));
            a = s.charAt(i);
        }
        return sb.toString();
    }
}

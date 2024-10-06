package cn.dsxriiiii.LeetCode.LC100;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/01 13:06
 * @Description: LC76
 **/
public class LC76 {
    private static Map<Character,Integer> tar;
    private static Map<Character,Integer> cur;
    public String minWindow(String s, String t) {
        tar = new HashMap<>();
        cur = new HashMap<>();
        int min_l = -1;
        int min_r = -1;
        for(int i = 0;i < t.length(); i++){
            tar.put(t.charAt(i),tar.getOrDefault(t.charAt(i),0) + 1);
        }
        int r = -1,l = 0;
        int len = Integer.MAX_VALUE;
        while(r < s.length()){
            r++;
            if(r < s.length() && tar.containsKey(s.charAt(r))){
                cur.put(s.charAt(r),cur.getOrDefault(s.charAt(r),0) + 1);
            }
            while(check() && l <= r){
                if(r - l + 1 < len){
                    len = r - l + 1;
                    min_l = l;
                    min_r = l + len;
                }
                if(tar.containsKey(s.charAt(l))){
                    cur.put(s.charAt(l),cur.getOrDefault(s.charAt(l),0) - 1);
                }
                l++;
            }
        }
        return min_l == -1 ? "" : s.substring(min_l,min_r);
    }
    private static boolean check(){
        for (Map.Entry<Character, Integer> next : tar.entrySet()) {
            Character key = next.getKey();
            Integer value = next.getValue();
            if (cur.getOrDefault(key,0) < value) {
                return false;
            }
        }
        return true;
    }
}

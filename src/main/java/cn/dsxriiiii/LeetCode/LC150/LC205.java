package cn.dsxriiiii.LeetCode.LC150;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: Mounts
 * @Description: LC205 同构字符串
 * @Author: DSXRIIIII
 * @CreateDate: 2024/5/24 17:12
 * @Email: lihh53453@hundsun.com
 *
 * 思路一：两个HashMap
 **/
public class LC205 {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> mapS = new HashMap<>();
        Map<Character, Character> mapT = new HashMap<>();
        for (int index = 0; index < s.length(); index++) {
            char charS = s.charAt(index);
            char charT = t.charAt(index);
            if (!mapS.containsKey(charS)) {
                mapS.put(charS, charT);
            }
            if (!mapT.containsKey(charT)) {
                mapT.put(charT, charS);
            }
            if (mapS.get(charS) != charT || mapT.get(charT) != charS) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "paper";
        String t = "title";
        LC205 lc205 = new LC205();
        System.out.println(lc205.isIsomorphic(s, t));
    }
}

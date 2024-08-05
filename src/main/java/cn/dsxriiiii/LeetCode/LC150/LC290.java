package cn.dsxriiiii.LeetCode.LC150;


import java.util.*;

/**
 * example:输入:pattern = "abba", s = "dog cat cat fish"
 *
 * @ProjectName: Mounts
 * @Description: 单词规律
 * @Author: DSXRIIIII
 * @CreateDate: 2024/5/30 16:43
 * @Email: lihh53453@hundsun.com
 **/
public class LC290 {
    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        Map<Character,String> map =new HashMap<>();
        Map<String,Character> map2 =new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if(map.containsKey(pattern.charAt(i)) && !map.get(pattern.charAt(i)).equals(words[i])){
                return false;
            }
            if(map2.containsKey(words[i]) && !map2.get(words[i]).equals(pattern.charAt(i))){
                return false;
            }
            map.put(pattern.charAt(i),words[i]);
            map2.put(words[i],pattern.charAt(i));
        }
        return true;

    }

    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog cat cat dog";
        System.out.println(wordPattern(pattern, s));

    }
}

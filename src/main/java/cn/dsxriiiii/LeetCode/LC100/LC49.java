package cn.dsxriiiii.LeetCode.LC100;

import java.util.*;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/30 10:34
 * @Description: LC49
 **/
public class LC49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String s = new String(charArray);
            List<String> orDefault = map.getOrDefault(s, new ArrayList<>());
            orDefault.add(str);
            map.put(s,orDefault);
        }
        return new ArrayList<>(map.values());
    }
}

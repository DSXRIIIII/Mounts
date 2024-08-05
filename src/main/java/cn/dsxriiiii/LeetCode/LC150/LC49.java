package cn.dsxriiiii.LeetCode.LC150;

import java.util.*;

/**
 * @ProjectName: Mounts
 * @Description: 字母异位词分组
 * @Author: DSXRIIIII
 * @CreateDate: 2024/6/5 17:28
 * @Email: lihh53453@hundsun.com
 * 思路：哈希表
 *      1.将每个字符串排列之后得到的key是一样的
 *      2.依次放入map中的list
 *      3.最后return new ArrayList<List<String>>(map.values());将map转化为ArrayList
 **/
public class LC49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String str:strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            List<String> list = map.getOrDefault(key,new ArrayList<>());
            list.add(str);
            map.put(key,list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}

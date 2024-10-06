package cn.dsxriiiii.LeetCode.LC100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/30 13:30
 * @Description:
 **/
public class LC438 {
    public List<Integer> findAnagrams(String s, String p) {
        int len_s = s.length();
        int len_p = p.length();
        List<Integer> res = new ArrayList<>();
        int[] count_s = new int[26];
        int[] count_p = new int[26];
        for(int i = 0;i < len_p;i++){
            ++count_s[s.charAt(i) - 'a'];
            ++count_p[p.charAt(i) - 'a'];
        }
        if(Arrays.equals(count_s,count_p)){
            res.add(0);
        }
        for(int i = 0;i < len_s - len_p;i++){
            --count_s[s.charAt(i) - 'a'];
            ++count_s[s.charAt(i + len_p) - 'a'];
            if(Arrays.equals(count_s,count_p)){
                res.add(i+1);
            }
        }
        return res;
    }
}

package cn.dsxriiiii.LeetCode.LC100;

import java.util.HashSet;
import java.util.Set;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/30 13:06
 * @Description: LC3
 **/
public class LC3 {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int right = 0;
        Set<Character> set = new HashSet<>();
        for(int left = 0;left < s.length();left++){
            if(left != 0){
                set.remove(s.charAt(left - 1));
            }
            while(right < s.length() && !set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;
            }
            ans = Math.max(ans,right - left);
        }
        return ans;
    }
}

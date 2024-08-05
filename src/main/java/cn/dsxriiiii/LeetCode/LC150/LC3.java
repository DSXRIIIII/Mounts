package cn.dsxriiiii.LeetCode.LC150;

import java.util.HashSet;
import java.util.Set;

/**
 * @ProjectName: Mounts
 * @Description:
 * @Author: DSXRIIIII
 * @CreateDate: 2024/6/14 16:49
 * @Email: lihh53453@hundsun.com
 * Problem: 无重复字符的最长子串
 * Algorithm: 滑动窗口
 * 技巧 ： 1.right要从-1开始 如果从0开始走 当s=" "单个字符串时 right - left = 0;
 *        2.边界条件为right + 1 < s.length()
 *        3.right从0开始要考虑边界问题  假设字符串为"abca" right最后会走到index = 3  maxLength = 3 - 0 + 1 = 4 多走了一步
 */
public class LC3 {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 1){
            return 1;
        }
        int maxLength = 0;
        int right = -1;
        Set<Character> set = new HashSet<Character>();
        for(int left = 0; left < s.length() - 1;left++){
            if(left != 0){
                set.remove(s.charAt(left - 1));
            }
            while(right + 1 < s.length() && !set.contains(s.charAt(right + 1))){
                set.add(s.charAt(right + 1));
                right++;
            }
            maxLength = Math.max(maxLength,right - left + 1);
        }
        return maxLength;
    }

    public int lengthOfLongestSubstring2(String s) {
        if(s.length() == 1){
            return 1;
        }
        int maxLength = 0;
        int right = 0;
        Set<Character> set = new HashSet<Character>();
        for(int left = 0; left < s.length() - 1;left++){
            if(left != 0){
                set.remove(s.charAt(left - 1));
            }
            while(right < s.length() - 1 && !set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;
            }
            maxLength = Math.max(maxLength,right - left);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LC3 lc3 = new LC3();
        String s = "au";
        System.out.println(lc3.lengthOfLongestSubstring2(s));
    }
}

package cn.dsxriiiii.LeetCode.LC150;

/**
 * 题目：判断子序列
 * 算法：双指针
 * 思路：双指针一一比对然后移动
 */
public class LC392 {
    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";
        System.out.println(isSubsequence(s,t));
    }
    public static boolean isSubsequence(String s, String t) {
        if(s.length() == 0) return true;
        int index_s = 0;
        int index_t = 0;
        while(index_t != t.length()){
            if(s.charAt(index_s) == t.charAt(index_t)){
                if(index_s == s.length() - 1){
                    return true;
                }
                index_t++;
                index_s++;
                continue;
            }
            index_t++;
        }
        return false;
    }
}

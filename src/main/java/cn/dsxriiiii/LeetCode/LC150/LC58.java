package cn.dsxriiiii.LeetCode.LC150;

/**
 * 题目：最后一个单词的长度
 * 算法思路：遍历
 * 具体思路：1.去掉前后的空格 trim()方法
 *         2.遍历到‘ ’处停止
 */
public class LC58 {
    public static void main(String[] args) {
        String s = "a";
        System.out.println(lengthOfLastWord(s));
    }
    public static int lengthOfLastWord_old(String s) {
        s = s.trim();
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) != ' '){
                res++;
            }else{
                break;
            }
        }
        return res;
    }

    public static int lengthOfLastWord(String s) {
        s = s.trim();
        String[] s1 = s.split(" ");
        return s1[s1.length - 1].length();
    }
}

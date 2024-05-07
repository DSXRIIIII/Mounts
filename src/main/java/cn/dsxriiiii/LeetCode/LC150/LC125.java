package cn.dsxriiiii.LeetCode.LC150;

/**
 * 题目：验证回文串
 * 算法：双指针
 * 思路：双指针遇到不是字符或者数字就向前移动
 * 补充：Character方法 isLetterOrDigit() 判断字符是否是数字还是字母
 */
public class LC125 {
    public boolean isPalindrome_function(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length();i++){
            char c = s.charAt(i);
            if(Character.isLetterOrDigit(c)){
                sb.append(Character.toLowerCase(c));
            }
        }
        StringBuilder sb2 = new StringBuilder(sb).reverse();
        return sb2.toString().contentEquals(sb);
    }

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            while(left < right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            if(left < right){
                if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
}

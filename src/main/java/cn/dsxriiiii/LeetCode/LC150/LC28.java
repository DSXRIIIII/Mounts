package cn.dsxriiiii.LeetCode.LC150;

/**
 * 题目：找出字符串中第一个匹配项的下标
 * 算法：KMP
 * 思路：1.KMP算法计算出needle的具体数值
 *      2.利用next数组进行回退 当遇到字符不匹配时 j坐标回退 如果j == m说明此时已经匹配到了主串
 *      3.返回结果i - m + 1
 */
public class LC28 {
    public static void main(String[] args) {
        String haystack = "mississippi", needle = "issip";
        System.out.println(strStr_kmp(haystack,needle));
    }
    public static int strStr_kmp(String haystack, String needle) {
        int j = 0;
        int[] next = new int[needle.length()];
        for(int i = 1;i < needle.length();i++){
            while(j > 0 && needle.charAt(i) != needle.charAt(j)){
                j = next[j - 1];
            }
            if(needle.charAt(i) == needle.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        for(int i = 0,k = 0;i < haystack.length();i++){
            while(j > 0 && needle.charAt(j) != haystack.charAt(i)){
                j = next[j - 1];
            }
            if(needle.charAt(j) == haystack.charAt(i)){
                j++;
            }
            if(j == needle.length()){
                return i - needle.length() + 1;
            }
        }
        return -1;
    }


    @Deprecated
    public static int strStr_index(String haystack, String needle) {
        int targetLen = needle.length();
        int index = 0;
        for(int i = 0;i < haystack.length();i++){
            if(haystack.charAt(i) == needle.charAt(index)){
                index++;
            }else{
                index = 0;
            }
            if(index == targetLen){
                return i - targetLen + 1;
            }
        }
        return -1;
    }
}

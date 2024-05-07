package cn.dsxriiiii.LeetCode.LC150;

/**
 * 题目：最长公共前缀
 * 算法思路：遍历
 * 具体思路：1.字符数组的第一个字符串为比较串
 *         2.横向比较法 两两比较
 *         3.纵向比较法 全部比较
 *         4.时间复杂度都为O(mn) 空间复杂度为O(1) 常数
 */
public class LC14 {
    /**
     * 横向比较法 每一次取两个字符串比较 取得的相似值放到下一次比较中
     */
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if(len == 0) return "";
        String SameString = strs[0];
        for(int i = 1; i < len;i++){
            SameString = getSameString(SameString,strs[i]); //返回得到两个字符串的最长序列 在进入到下一次循环中
//            if(SameString == null){
//                break;
//            }
        }
        return SameString;
    }

    /**
     * 纵向比较法 将初始字符串的每一个字符与后续的所有字符串进行比较
     */
    public String longestCommonPrefix_2(String[] strs) {
        int len = strs[0].length();
        if(len == 0) return "";
        for(int i = 0; i < len;i++){
            char c = strs[0].charAt(i);
            for(int j = 1;j < strs.length;j++){
                if(i == strs[j].length() || strs[j].charAt(i) != c){
                    //i == strs[j].length() 此时短的字符串走完了
                    //strs[j].charAt(i) != c 与当前字符比较不相等 i为公共最长长度
                    //i 记录公共长度
                    strs[0] = strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }

    private String getSameString(String sameString, String str) {
        int index = 0;
        int length = Math.max(sameString.length(),str.length());
        while(index < length && sameString.charAt(index) == str.charAt(index)){
            index++;
        }
        return sameString.substring(0,index);
    }

}

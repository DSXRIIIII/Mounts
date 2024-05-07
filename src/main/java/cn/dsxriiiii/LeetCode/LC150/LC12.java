package cn.dsxriiiii.LeetCode.LC150;

/**
 * 题目：整数转罗马数字
 * 算法思路：遍历找特殊条件
 * 具体思路：1.列举特殊条件即可 使用StringBuilder拼接
 */
public class LC12 {
    public static void main(String[] args) {
        System.out.println(intToRoman(58));
    }
    public static String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while(num >= values[i]){
                num-=values[i];
                sb.append(symbols[i]);
            }
            if(num == 0){
                break;
            }

        }
        return sb.toString();
    }
}

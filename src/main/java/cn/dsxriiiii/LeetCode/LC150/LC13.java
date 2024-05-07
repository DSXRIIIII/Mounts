package cn.dsxriiiii.LeetCode.LC150;

import java.util.HashMap;
import java.util.Map;
/**
 * 题目：罗马数字转整数
 * 算法思路：遍历找特殊条件
 * 具体思路：1.列举特殊条件即可
 */
public class LC13 {
    public static void main(String[] args) {
        String s = "LLL";  //1000 + 900 + 90 + 4
        System.out.println(romanToInt(s));
    }
    public static int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int res = 0;
        res  += map.get(s.charAt(0));
        for(int i = 1;i < s.length();i++){
            if(
                    (s.charAt(i) == 'V' || s.charAt(i) == 'X') && s.charAt(i - 1) == 'I' ||
                    (s.charAt(i) == 'L' || s.charAt(i) == 'C') && s.charAt(i - 1) == 'X' ||
                    (s.charAt(i) == 'D' || s.charAt(i) == 'M') && s.charAt(i - 1) == 'C'
                    //记得加（）维持条件
            ){
                res -= map.get(s.charAt(i - 1));
                res += map.get(s.charAt(i)) - map.get(s.charAt(i - 1));
            }else{
                res  += map.get(s.charAt(i));
            }

        }
        return res;
    }
}

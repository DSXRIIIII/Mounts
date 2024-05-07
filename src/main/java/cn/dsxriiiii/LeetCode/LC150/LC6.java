package cn.dsxriiiii.LeetCode.LC150;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：Z字形变换
 * 算法思路：StringBuilder拼接字符串
 * 具体思路：1.flag 用于调转方向 比如 1,2,3 -> 3,2,1 -> 1,2,3
 */
public class LC6 {
    public String convert(String s, int numRows) {
        if (numRows < 2) return s;
        List<StringBuilder> res = new ArrayList<>();
        int index = 0,flag = 1;
        for(int i = 0; i < numRows;i++){
            res.add(new StringBuilder());
        }
        for(char c : s.toCharArray()){
            res.get(index).append(c);
            index+=flag;
            if(index == 0 || index == numRows - 1){
                flag = - flag;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder stringBuilder : res){
            sb.append(stringBuilder.toString());
        }
        return sb.toString();
    }
}

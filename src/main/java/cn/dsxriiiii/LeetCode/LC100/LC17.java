package cn.dsxriiiii.LeetCode.LC100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/04 13:52
 * @Description:
 **/
public class LC17 {
    private static Map<Character,String> map;;
    public List<String> letterCombinations(String digits) {
        map = new HashMap<>();
        if (digits.isEmpty()) return new ArrayList<>();
        List<String> list = new ArrayList<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        dfs(list,digits,map,0,new StringBuffer());
        return list;
    }

    private void dfs(List<String> list, String digits, Map<Character, String> map, int i, StringBuffer stringBuffer) {
        if(i == digits.length()){
            list.add(stringBuffer.toString());
        }else{
            String s = map.get(digits.charAt(i));
            if(!s.isEmpty()){
                for (int j = 0; j < s.length(); j++) {
                    stringBuffer.append(s.charAt(i));
                    dfs(list,digits,map,i + 1,stringBuffer);
                    stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                }
            }
        }
    }
}

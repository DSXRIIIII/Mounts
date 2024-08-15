package cn.dsxriiiii.LeetCode.LC150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/9 16:08
 * @Email: lihh53453@hundsun.com
 * @Description: 电话号码的字母组合
 * 1.回溯 确定dfs停止位置
 * 2.遍历要形成组合的集合
 * 3.每次递归index都会改变 当index为digits的长度时单词构建完毕将其添加到结果列表中
 */
public class LC17 {
    private Map<Character,String> map;
    public List<String> letterCombinations(String digits) {
        map = new HashMap<>();
        if(digits.isEmpty()) return new ArrayList<>();
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

    private void dfs(List<String> res, String digits, Map<Character, String> map, int index, StringBuffer stringBuffer) {
        if(index == digits.length()){
            res.add(stringBuffer.toString());
        }else{
            String s = map.get(digits.charAt(index));
            for (int i = 0; i < s.length(); i++) {
                stringBuffer.append(s.charAt(i));
                dfs(res, digits, map, index+1, stringBuffer);
                stringBuffer.deleteCharAt(index);
            }
        }
    }

}

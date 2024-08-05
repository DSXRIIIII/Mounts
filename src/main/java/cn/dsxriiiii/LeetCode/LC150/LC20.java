package cn.dsxriiiii.LeetCode.LC150;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @ProjectName: Mounts
 * @Description:
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/3 16:01
 * @Email: lihh53453@hundsun.com
 * 使用map保存括号 以右括号为键 当匹配到右括号时 正常情况一顶存在左括号
 */
public class LC20 {
    public boolean isValid(String s) {
        Map<Character,Character> map = new HashMap<Character,Character>(){{
            put(']','[');
            put('}','{');
            put(')','(');
        }};
        Deque<Character> queue = new LinkedList<>();
        for(char c:s.toCharArray()){
            if(map.containsKey(c)){
                if (queue.isEmpty() || queue.peek() != map.get(c)){
                    return false;
                }
                queue.pop();
            }else{
                /*
                [(]1722672830113
                [[, (]1722672830113
                 */
                queue.push(c); //添加到顶部
                //queue.add(c); 添加到末尾
                /*
                [(]1722672780704
                [(, []1722672780705
                [[]1722672780705
                []1722672780705
                 */
            }
            System.out.println(queue + String.valueOf(System.currentTimeMillis()));
        }
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        LC20 lc20 = new LC20();
        lc20.isValid("([)]");
    }
}

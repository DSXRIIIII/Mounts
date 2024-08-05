package cn.dsxriiiii.LeetCode.LC150;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @ProjectName: Mounts
 * @Description: LC150-逆波兰表达式求值LC150
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/3 17:38
 * @Email: lihh53453@hundsun.com
 */
public class LC150 {

    public int evalRPN(String[] tokens) {
        Set<String> set = new HashSet<>();
        set.add("*");
        set.add("-");
        set.add("+");
        set.add("/");
        Deque<Integer> queue = new LinkedList<>();
        for(String str:tokens){
            if(set.contains(str)){
                int num2 = queue.pop();
                int num1 = queue.pop();
                switch (str){
                    case "+":
                        queue.push(num1 + num2);
                        break;
                    case "-":
                        queue.push(num1 - num2);
                        break;
                    case "*":
                        queue.push(num1 * num2);
                        break;
                    case "/":
                        queue.push(num1 / num2);
                        break;
                }
            }else{
                queue.push(Integer.parseInt(str));
            }
        }
        return queue.pop();
    }
}
